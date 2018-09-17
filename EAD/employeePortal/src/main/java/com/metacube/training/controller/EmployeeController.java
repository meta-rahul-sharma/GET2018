package com.metacube.training.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.Employee;
import com.metacube.training.service.EmailService;
import com.metacube.training.service.EmployeeService;
import com.metacube.training.service.SkillService;

/**
 * @author Rahul Sharma
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	SkillService skillService;
	
	@Autowired
	EmailService emailService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		
		return "employee/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username, 
			@RequestParam("password") String password){
		
		String view;
		
		if(employeeService.isValidLogin(username, password)) {
			view = "employee/dashboard";
		}
		else {
			view = "employee/login";
		}
		
		return new ModelAndView(view, "email", username);
	}

	@RequestMapping(value = "/editProfile", method = RequestMethod.GET)
	public ModelAndView addEmployee(@RequestParam String email, Model model){
		
		model.addAttribute("listOfSkills", skillService.getAllSkills());
		return new ModelAndView("employee/editProfile", "employee", employeeService.getEmployeeByEmail(email));
	}
	
	@RequestMapping(value = "/editProfile", method = RequestMethod.POST)
	public ModelAndView addEmployee(@RequestParam("employeeCode") String employeeCode, @RequestParam("firstName") String firstName, @RequestParam("middleName") String middleName, 
			@RequestParam("lastName") String lastName, @RequestParam("email") String email, @RequestParam("dob") java.sql.Date dob, 
			@RequestParam("gender") char gender, @RequestParam("primaryContact") String primaryContact, @RequestParam("secondaryContact") String secondaryContact,
			@RequestParam("skypeId") String skypeId, @RequestParam("skills") String[] skills,@RequestParam("oldPassword") String oldPassword,
			@RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword, @RequestParam("enabled") boolean enabled) throws ParseException{
		
		Employee employee = new Employee();
		employee.setEmployeeCode(employeeCode);
		employee.setFirstName(firstName);
		employee.setMiddleName(middleName);
		employee.setLastName(lastName);
		employee.setEmail(email);
		employee.setDob(dob);
		employee.setGender(gender);
		employee.setPrimaryContact(primaryContact);
		employee.setSecondaryContact(secondaryContact);
		employee.setSkypeId(skypeId);
		employee.setEnabled(enabled);
		
		if(!"".equals(password) && password.equals(confirmPassword)) {
			employee.setPassword(password);
		}
		else {
			employee.setPassword(oldPassword);
		}
		
		employeeService.addSkills(skills, employeeCode);
		employeeService.updateEmployee(employee);
		
		return new ModelAndView("employee/dashboard", "email", email);
	}
	
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.GET)
	public ModelAndView searchEmployee(){
		
		return new ModelAndView("employee/searchEmployee");
	}
	
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.POST)
	public ModelAndView searchEmployee(@RequestParam("criteria") String criteria, @RequestParam("keyword") String keyword){
		if(!keyword.isEmpty() && keyword != null) {
			List<Employee> employees = employeeService.searchEmployee(criteria.toUpperCase(), keyword);
			return new ModelAndView("employee/searchedEmployee", "result", employees);
		} else {
			return new ModelAndView("employee/searchedEmployee");
		}
	}
	
	@RequestMapping(value = "/viewEmployee", method = RequestMethod.GET)
	public ModelAndView viewEmployee(@RequestParam String employeeCode){
		
		return new ModelAndView("viewEmployee", "employee", employeeService.getEmployeeByCode(employeeCode));
	}
	
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
	public ModelAndView forgotPassword(){
		return new ModelAndView("employee/forgotPassword");
	}
	
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public ModelAndView forgotPassword(@RequestParam("username") String username){
		Employee employee = employeeService.getEmployeeByEmail(username);
		emailService.generateForgottenPassword(username, "forgot Password", "your password is: " + employee.getPassword());
		return new ModelAndView("employee/login");
	}
}
