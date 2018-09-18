package com.metacube.training.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dto.PreSignupTO;
import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeSkills;
import com.metacube.training.model.JobDetails;
import com.metacube.training.model.JobTitle;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;
import com.metacube.training.repository.EmployeeRepository;
import com.metacube.training.repository.EmployeeSkillsRepository;
import com.metacube.training.repository.JobDetailsRepository;
import com.metacube.training.repository.ProjectRepository;
import com.metacube.training.repository.SkillRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository<Employee> employeeRepository;
	
	@Autowired
	private SkillRepository<Skill> skillRepository;
	
	@Autowired
	private ProjectRepository<Project> projectRepository;
	
	@Autowired
	private SkillService skillService;
	
	@Autowired
	private JobDetailsRepository<JobTitle> jobDetailsRepository;
	
	@Autowired
	private EmployeeSkillsRepository<EmployeeSkills> employeeSkillsRepository;
	
	
/**
 * To add a employee	
 */
public void addEmployee(PreSignupTO preSignupTO) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(preSignupTO.getDoj());
		int year = calendar.get(Calendar.YEAR);
		
		preSignupTO.setEmployeeCode(generateEmployeeCode(year));
		Employee employee = new Employee();
		employee.setEmployeeCode(preSignupTO.getEmployeeCode());
		employee.setFirstName(preSignupTO.getFirstName());
		employee.setMiddleName(preSignupTO.getMiddleName());
		employee.setLastName(preSignupTO.getLastName());
		employee.setEmail(preSignupTO.getEmail());
		employee.setDob(preSignupTO.getDob());
		employee.setGender(preSignupTO.getGender());
		employee.setPassword("12345");
		employee.setEnabled(true);
		
		JobDetails jobDetails = new JobDetails();
		
		if(preSignupTO.getReportingMgr() != null) {
		jobDetails.setReportingMgr(employeeRepository.findByEmployeeCode(preSignupTO.getReportingMgr()));
		} else {
			jobDetails.setReportingMgr(null);
		}
		
		if(preSignupTO.getTeamLead() != null) {
			jobDetails.setTeamLead(employeeRepository.findByEmployeeCode(preSignupTO.getTeamLead()));
		} else {
				jobDetails.setTeamLead(null);
		}
		
		jobDetails.setDateOfJoining(preSignupTO.getDoj());
		
		if(preSignupTO.getProjectId() != 0) {
			jobDetails.setProjectId(projectRepository.findByProjectId(preSignupTO.getProjectId()));
		} else {
			jobDetails.setProjectId(null);
		}
		
		jobDetails.setEmployeeCode(employee);
        
		employeeRepository.save(employee);
		jobDetailsRepository.save(jobDetails);
	}

	/**
	 * To get all employees in the table
	 */
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}


	/**
	 * To search employee by different criteria like:
	 * 1. name
	 * 2. skill
	 * 3. project
	 * 4. experience 
	 */
	public List<Employee> searchEmployee(String criteria, String keyword) {
		
		List<Employee> listOfEmployees = null;
		
		switch (criteria) {
			
			case "NAME" : listOfEmployees = employeeRepository.searchByName(keyword);
						  break;
						  
			case "PROJECT" : listOfEmployees = employeeRepository.searchByProjectId(projectRepository.findByProjectId((int)Integer.parseInt(keyword)));
							 break;
							 
			case "SKILL" : listOfEmployees = employeeRepository.searchBySkills(keyword);
						   break;
						   
			case "EXPERIENCE" : listOfEmployees = employeeRepository.searchByExperience(Double.parseDouble(keyword));
								break;
		}
		
		return listOfEmployees;
	}
	

	/**
	 * To get employee of it's code
	 */
	public Employee getEmployeeByCode(String employeeCode) {
		
		return employeeRepository.findByEmployeeCode(employeeCode);
	}
	

	/**
	 * To update Employee Details
	 */
	public void updateEmployee(Employee employee) {
		
		employeeRepository.save(employee);
	}


	/**
	 * To check if login is valid or not
	 */
	public boolean isValidLogin(String username, String password) {
		
		boolean valid = false;
		
		if(password.equals(getEmployeeByEmail(username).getPassword()))
			valid = true;
		
		return valid;
	}
	
	/**
	 * To get employee details by it's email address
	 */
	public Employee getEmployeeByEmail(String email) {
		
		return employeeRepository.findByEmail(email);
	}

	/**
	 * To add multiple skills of a employee
	 */
	public void addSkills(String[] skills, Employee employeeCode) {
				
		for(String skillName: skills)
		{
			if(!"n/a".equals(skillName))
			{
			    Skill skill = skillService.getSkillByName(skillName);
			    EmployeeSkills employeeSkill = new EmployeeSkills();
			    employeeSkill.setEmployeeCode(employeeCode);
			    employeeSkill.setSkillCode(skill);
				employeeSkillsRepository.save(employeeSkill);
			}
				
		}
		
	}
	
	/**
	 * To generate employee code
	 * @param year
	 * @return employee code
	 */
	private String generateEmployeeCode(int year) {
		
	    String employeeCode;
		List<Employee> listOfEmployee = getAllEmployees();
		int size = listOfEmployee.size();
		if(size > 0)
		{
		    int[] codes = new int[size];
	        
	        for(int i = 0; i < size; i++)
	            codes[i] = Integer.parseInt(listOfEmployee.get(i).getEmployeeCode().split("/")[1]);
	            
	        Arrays.sort(codes);
	        employeeCode = "E" + year + "/" + (codes[size - 1] + 1);
		}
		else
		    employeeCode = "E" + year + "/" + 1;
		return employeeCode;
	}

}
