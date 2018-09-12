package com.metacube.training.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.Enum.SearchBy;
import com.metacube.training.dto.PreSignupTO;
import com.metacube.training.model.Employee;
import com.metacube.training.model.JobTitle;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;
import com.metacube.training.service.AdminService;
import com.metacube.training.service.AdminServiceImpl;
import com.metacube.training.service.EmployeeService;
import com.metacube.training.service.EmployeeServiceImpl;
import com.metacube.training.service.JobService;
import com.metacube.training.service.JobServiceImpl;
import com.metacube.training.service.ProjectService;
import com.metacube.training.service.ProjectServiceImpl;
import com.metacube.training.service.SkillService;
import com.metacube.training.service.SkillServiceImpl;

/**
 * @author Rahul Sharma
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private SkillService skillService;
	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login() {
		
		return "admin/login";
	}
	
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username, 
			@RequestParam("password") String password){
		
		String view;
		AdminService adminService = AdminServiceImpl.getInstance();
		
		if(adminService.isValidLogin(username, password)) {
			view = "admin/dashboard";
		} else {
			view = "admin/login";
		}
		
		return new ModelAndView(view);
	}
	
	
	@RequestMapping(path = "/project", method = RequestMethod.GET)
	public String addProject(Model model){
		model.addAttribute("project", new Project());
		return "admin/project";
	}
	
	@RequestMapping(path = "/project", method = RequestMethod.POST)
	public String addProject(@ModelAttribute("project") Project project) throws IOException, ParseException{
		if(project!= null && project.getProjectId() == 0) {
			projectService.createProject(project);	
		}else {
			projectService.updateProject(project);
		}
		return "admin/dashboard";
	}
	
	
	@RequestMapping(value = "/skills", method = RequestMethod.GET)
	public String addSkill(Model model){
		model.addAttribute("skill", new Skill());
		return "admin/skill";
	}
	
	
	@RequestMapping(value = "/skills", method = RequestMethod.POST)
	public ModelAndView addSkill(@ModelAttribute("skill") Skill skill) {
	    skillService.createSkill(skill);
		return new ModelAndView("admin/dashboard");
	}
	
	
	@RequestMapping(value = "/jobTitle", method = RequestMethod.GET)
	public String addJobTitle(Model model){
		model.addAttribute("job", new JobTitle());
		return "admin/jobtitle";
	}
	
	
	@RequestMapping(value = "/jobTitle", method = RequestMethod.POST)
	public ModelAndView addJobTitle(@ModelAttribute("job") JobTitle job){
		
	    jobService.createJobTitle(job);
	    
		return new ModelAndView("admin/dashboard");
	}
	
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String addEmployee(Model model){
		model.addAttribute("signup", new PreSignupTO());
		return "admin/addEmployee";
	}
	
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(@RequestParam("fname") String firstName, @RequestParam("mname") String middleName, 
			@RequestParam("lname") String lastName, @RequestParam("email") String email, @RequestParam("dob") String dob, 
			@RequestParam("gender") char gender, @RequestParam("doj") String doj, @RequestParam("reportingMgr") String reportingMgr, 
			@RequestParam("teamLead") String teamLead, @RequestParam("projectId") Integer projectId) throws ParseException{
		
		if("n/a".equals(reportingMgr))
			reportingMgr = null;
		
		if("n/a".equals(teamLead))
			teamLead = null;
		
		if(projectId == 0)
			projectId = null;
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOfBirth = (Date) format.parse(dob);
		Date dateOfJoining = (Date) format.parse(doj);
		
		PreSignupTO preSignupTO = new PreSignupTO();
		preSignupTO.setFirstName(firstName);
		preSignupTO.setMiddleName(middleName);
		preSignupTO.setLastName(lastName);
		preSignupTO.setEmail(email);
		preSignupTO.setDob(dateOfBirth);
		preSignupTO.setGender(gender);
		preSignupTO.setDoj(dateOfJoining);
		preSignupTO.setReportingMgr(reportingMgr);
		preSignupTO.setTeamLead(teamLead);
		preSignupTO.setProjectId(projectId);
		
		employeeService.addEmployee(preSignupTO);
		
		return new ModelAndView("admin/dashboard");
	}
	
	
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.GET)
	public String searchEmployee(){
		
		return "admin/searchEmployee";
	}
	
	
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.POST)
	public ModelAndView searchEmployee(@RequestParam("criteria") SearchBy criteria, @RequestParam("keyword") String keyword){
		List<Employee> searchResult = employeeService.searchEmployee(criteria, keyword);
		
		return new ModelAndView("admin/searchResults", "result", searchResult);
	}
	
	
	@RequestMapping(value = "/viewEmployee", method = RequestMethod.GET)
	public ModelAndView viewEmployee(@RequestParam String employeeCode){
		
		return new ModelAndView("viewEmployee", "employee", employeeService.getEmployeeByCode(employeeCode));
	}
	
	
	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editEmployee(@RequestParam String employeeCode){
		
		return new ModelAndView("admin/editEmployee", "employee", employeeService.getEmployeeByCode(employeeCode));
	}
	
	
	@RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
	public ModelAndView editEmployee(@RequestParam String employeeCode, @RequestParam String firstName, @RequestParam String middleName, 
			@RequestParam String lastName, @RequestParam("email") String email, @RequestParam("dob") String dob, 
			@RequestParam char gender, @RequestParam String primaryContact, @RequestParam String secondaryContact,
			@RequestParam String skypeId, @RequestParam boolean enabled, @RequestParam String password) throws ParseException{
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOfBirth = (Date) format.parse(dob);
		
		Employee employee = new Employee();
		employee.setEmployeeCode(employeeCode);
		employee.setFirstName(firstName);
		employee.setMiddleName(middleName);
		employee.setLastName(lastName);
		employee.setEmail(email);
		employee.setDob(dateOfBirth);
		employee.setGender(gender);
		employee.setPrimaryContact(primaryContact);
		employee.setSecondaryContact(secondaryContact);
		employee.setSkypeId(skypeId);
		employee.setEnabled(enabled);
		employee.setPassword(password);
		
		employeeService.updateEmployee(employee);
		
		return new ModelAndView("admin/dashboard");
	}

}
