package com.metacube.training.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.Enum.SearchBy;
import com.metacube.training.model.Employee;
import com.metacube.training.service.EmployeeService;
import com.metacube.training.service.EmployeeServiceImpl;

/**
 * @author Rahul Sharma
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		
		return "employee/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username, 
			@RequestParam("password") String password){
		
		String view;
		
		if(employeeService.isValidLogin(username, password))
			view = "employee/dashboard";
		else
			view = "employee/login";
		
		return new ModelAndView(view, "email", username);
	}

	@RequestMapping(value = "/editProfile", method = RequestMethod.GET)
	public ModelAndView addEmployee(@RequestParam String email){
		
		
		return new ModelAndView("employee/editProfile", "employee", employeeService.getEmployeeByEmail(email));
	}
	
	@RequestMapping(value = "/editProfile", method = RequestMethod.POST)
	public ModelAndView addEmployee(@RequestParam("employeeCode") String employeeCode, @RequestParam("firstName") String firstName, @RequestParam("middleName") String middleName, 
			@RequestParam("lastName") String lastName, @RequestParam("email") String email, @RequestParam("dob") String dob, 
			@RequestParam("gender") char gender, @RequestParam("primaryContact") String primaryContact, @RequestParam("secondaryContact") String secondaryContact,
			@RequestParam("skypeId") String skypeId, @RequestParam("skills") String[] skills,@RequestParam("oldPassword") String oldPassword,
			@RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword, @RequestParam("enabled") boolean enabled) throws ParseException{
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOfBirth = format.parse(dob);
		
		Employee employee = new Employee();
		employee.setEmployeeCode(employeeCode);
		employee.setFirstName(firstName);
		employee.setMiddleName(middleName);
		employee.setLastName(lastName);
		employee.setEmail(email);
		employee.setDob((java.sql.Date) dateOfBirth);
		employee.setGender(gender);
		employee.setPrimaryContact(primaryContact);
		employee.setSecondaryContact(secondaryContact);
		employee.setSkypeId(skypeId);
		employee.setEnabled(enabled);
		
		if(!"".equals(password) && password.equals(confirmPassword))
			employee.setPassword(password);
		else
			employee.setPassword(oldPassword);
		
		employeeService.addSkills(skills, employeeCode);
		employeeService.updateEmployee(employee);
		
		return new ModelAndView("employee/dashboard", "email", email);
	}
	
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.GET)
	public ModelAndView searchEmployee(){
		
		return new ModelAndView("employee/searchEmployee");
	}
	
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.POST)
	public ModelAndView searchEmployee(@RequestParam("criteria") SearchBy criteria, @RequestParam("keyword") String keyword){
		
		List<Employee> searchResult = employeeService.searchEmployee(criteria, keyword);
		
		return new ModelAndView("employee/searchResults", "result", searchResult);
	}
	
	@RequestMapping(value = "/viewEmployee", method = RequestMethod.GET)
	public ModelAndView viewEmployee(@RequestParam String employeeCode){
		
		return new ModelAndView("viewEmployee", "employee", employeeService.getEmployeeByCode(employeeCode));
	}
}
