package com.metacube.training.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.EmployeeDAO;
import com.metacube.training.dao.ProjectDAO;
import com.metacube.training.dao.SkillDAO;
import com.metacube.training.dto.PreSignupTO;
import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeSkills;
import com.metacube.training.model.JobDetails;
import com.metacube.training.model.Skill;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDao;
	
	@Autowired
	private SkillDAO skillDao;
	
	@Autowired
	private ProjectDAO projectDao;
	
	@Autowired
	private SkillService skillService;
	
	
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
		jobDetails.setReportingMgr(employeeDao.getEmployeeByCode(preSignupTO.getReportingMgr()));
		} else {
			jobDetails.setReportingMgr(null);
		}
		
		if(preSignupTO.getTeamLead() != null) {
			jobDetails.setTeamLead(employeeDao.getEmployeeByCode(preSignupTO.getTeamLead()));
		} else {
				jobDetails.setTeamLead(null);
		}
		
		jobDetails.setDateOfJoining(preSignupTO.getDoj());
		
		if(preSignupTO.getProjectId() != 0) {
			jobDetails.setProjectId(projectDao.getProjectById(preSignupTO.getProjectId()));
		} else {
			jobDetails.setProjectId(null);
		}
		
		jobDetails.setEmployeeCode(employee);
        
		employeeDao.preSignup(employee, jobDetails);
	}

	/**
	 * To get all employees in the table
	 */
	public List<Employee> getAllEmployees() {
		
		return employeeDao.getAllEmployees();
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
			
			case "NAME" : listOfEmployees = employeeDao.searchByName(keyword);
						  break;
						  
			case "PROJECT" : listOfEmployees = employeeDao.searchByProject((int)Integer.parseInt(keyword));
							 break;
							 
			case "SKILL" : listOfEmployees = employeeDao.searchBySkills(keyword);
						   break;
						   
			case "EXPERIENCE" : listOfEmployees = employeeDao.searchByExperience(Double.parseDouble(keyword));
								break;
		}
		
		return listOfEmployees;
	}
	

	/**
	 * To get employee of it's code
	 */
	public Employee getEmployeeByCode(String employeeCode) {
		
		return employeeDao.getEmployeeByCode(employeeCode);
	}
	

	/**
	 * To update Employee Details
	 */
	public void updateEmployee(Employee employee) {
		
		employeeDao.updateEmployee(employee);
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
		
		return employeeDao.getEmployeeByEmail(email);
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
			    employeeSkill.setSkillCode(skillService.getSkillById(skill.getId()));
				employeeDao.addSkills(employeeSkill);
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
