package com.metacube.training.SpringSecurity.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.SpringSecurity.dto.PreSignupTO;
import com.metacube.training.SpringSecurity.model.Employee;
import com.metacube.training.SpringSecurity.model.JobTitle;
import com.metacube.training.SpringSecurity.model.Project;
import com.metacube.training.SpringSecurity.model.Skill;
import com.metacube.training.SpringSecurity.service.AdminService;
import com.metacube.training.SpringSecurity.service.EmployeeService;
import com.metacube.training.SpringSecurity.service.JobService;
import com.metacube.training.SpringSecurity.service.ProjectService;
import com.metacube.training.SpringSecurity.service.SkillService;
/**
 * @author Rahul Sharma
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private SkillService skillService;
    
    @Autowired
    private AdminService adminService;
    
    @Autowired
    private ProjectService projectService;
    
    @Autowired
    private JobService jobService;
    
    @Autowired
    private EmployeeService employeeService;
    
    /**
     * @return login page
     */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		
		return "admin/login";
	}
	
	/**
	 * @param username
	 * @param password
	 * @return admin dashboard if valid
	 */
	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username, 
			@RequestParam("password") String password){
		
		String view;
		
		if(adminService.isValidLogin(username, password)) {
			view = "redirect:/admin/dashboard";
		}
		else {
			view = "admin/login";
		}
		
		return new ModelAndView(view);
	}*/
	
	/**
	 * @return dashboard page
	 */
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(){
           return "admin/dashboard";
    }
	
    /**
     * @param model
     * @return add project page
     */
    @RequestMapping(path = "/project", method = RequestMethod.GET)
	public String addProject(Model model) {
		model.addAttribute("project", new Project());
		return "admin/project";
	}

    /**
     * @param project
     * @param bindingResult
     * @return add project page if have error else to dashboard
     * @throws IOException
     * @throws ParseException
     */
	@RequestMapping(path = "/project", method = RequestMethod.POST)
	public String addProject(@Valid @ModelAttribute("project") Project project, BindingResult bindingResult)
			throws IOException, ParseException {
		
		if (bindingResult.hasErrors()) {
			return "admin/project";
		}
		
		if (project != null && project.getProjectId() == 0) {
			projectService.createProject(project);
		} else {
			projectService.updateProject(project);
		}
		return "admin/dashboard";
	}
	
	/**
	 * @param model
	 * @return skill page
	 */
	@RequestMapping(value = "/skills", method = RequestMethod.GET)
	public String addSkill(Model model) {
		model.addAttribute("skill", new Skill());
		return "admin/skill";
	}

	/**
	 * @param skill
	 * @param bindingResult
	 * @return return to skill page if error else to dashboard
	 */
	@RequestMapping(value = "/skills", method = RequestMethod.POST)
	public ModelAndView addSkill(@Valid @ModelAttribute("skill") Skill skill, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return new ModelAndView("admin/skill");
		}
		
		skillService.createSkill(skill);
		return new ModelAndView("admin/dashboard");
	}
	
	/**
	 * @param model
	 * @return jobtitle page
	 */
	@RequestMapping(value = "/jobTitle", method = RequestMethod.GET)
	public String addJobTitle(Model model) {
		model.addAttribute("job", new JobTitle());
		return "admin/jobtitle";
	}

	/**
	 * @param job
	 * @param bindingResult
	 * @return job title page if have errors else to dashboard page
	 */
	@RequestMapping(value = "/jobTitle", method = RequestMethod.POST)
	public ModelAndView addJobTitle(@Valid @ModelAttribute("job") JobTitle job,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return new ModelAndView("admin/jobtitle");
		}

		jobService.createJobTitle(job);

		return new ModelAndView("admin/dashboard");
	}
	
	/**
	 * @return add Employee page
	 */
	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public ModelAndView addEmployee(){
		
        List<Employee> listOfEmployees = employeeService.getAllEmployees();
        
        List<Project> listOfProjects = projectService.getAllProjects();
        
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("listOfEmployees", listOfEmployees);
        model.put("listOfProjects", listOfProjects);
        
		return new ModelAndView("admin/addEmployee", model);
	}
	
	/**
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param email
	 * @param dob
	 * @param gender
	 * @param doj
	 * @param reportingMgr
	 * @param teamLead
	 * @param projectId
	 * @return edit employee in database and redirect to add employee page
	 * @throws ParseException
	 */
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(@RequestParam("fname") String firstName, @RequestParam("mname") String middleName, 
			@RequestParam("lname") String lastName, @RequestParam("email") String email, @RequestParam("dob") String dob, 
			@RequestParam("gender") char gender, @RequestParam("doj") String doj, @RequestParam("reportingMgr") String reportingMgr, 
			@RequestParam("teamLead") String teamLead, @RequestParam("projectId") Integer projectId) throws ParseException{
		
		if("n/a".equals(reportingMgr))
			reportingMgr = null;
		
		if("n/a".equals(teamLead))
			teamLead = null;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOfBirth = format.parse(dob);
		Date dateOfJoining = format.parse(doj);
		
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
		
		return new ModelAndView("redirect:/admin/addEmployee");
	}
	
	/**
	 * @return search employee page
	 */
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.GET)
	public String searchEmployee(){	
		return "admin/searchEmployee";
	}
	
	/**
	 * @param criteria
	 * @param keyword
	 * @return to searchedEmployee page
	 */
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.POST)
	public ModelAndView searchEmployee(@RequestParam("criteria") String criteria, @RequestParam("keyword") String keyword){
		List<Employee> searchResult = employeeService.searchEmployee(criteria.toUpperCase(), keyword);	
		return new ModelAndView("admin/searchedEmployee", "result", searchResult);
	}
	
	
	@RequestMapping(value = "/viewEmployee", method = RequestMethod.GET)
	public ModelAndView viewEmployee(@RequestParam String employeeCode){
		
		
		return new ModelAndView("viewEmployee", "employee", employeeService.getEmployeeByCode(employeeCode));
	}
	
	
	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editEmployee(@RequestParam String employeeCode){
		
		
		return new ModelAndView("admin/editEmployee", "employee", employeeService.getEmployeeByCode("E2018/1"));
	}
	
	
	@RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
	public ModelAndView editEmployee(@RequestParam String employeeCode, @RequestParam String firstName, @RequestParam String middleName, 
			@RequestParam String lastName, @RequestParam("email") String email, @RequestParam("dob") String dob, 
			@RequestParam char gender, @RequestParam String primaryContact, @RequestParam String secondaryContact,
			@RequestParam String skypeId, @RequestParam boolean enabled, @RequestParam String password) throws ParseException{
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOfBirth = format.parse(dob);
		
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
	
	/**
	 * To get all projects
	 * @param model
	 * @return projects page
	 */
	@RequestMapping(value = "/allProjects", method = RequestMethod.GET)
	public ModelAndView allProjects(Model model){
		List<Project> projects = projectService.getAllProjects();
		model.addAttribute("projects", projects);
		return new ModelAndView("admin/projects");
	}
	
	/**
	 * To get all skills
	 * @param model
	 * @return skills page
	 */
	@RequestMapping(value = "/allSkills", method = RequestMethod.GET)
	public ModelAndView allSkills(Model model){
		List<Skill> skills = skillService.getAllSkills();
		model.addAttribute("skills", skills);
		return new ModelAndView("admin/skills");
	}
	
	/**
	 * to get all jobs
	 * @param model
	 * @return jobs page
	 */
	@RequestMapping(value = "/allJobs", method = RequestMethod.GET)
	public ModelAndView allJobs(Model model){
		List<JobTitle> jobs = jobService.getAllJobTitle();
		model.addAttribute("jobs", jobs);
		return new ModelAndView("admin/jobTitles");
	}

}
