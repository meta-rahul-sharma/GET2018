package com.metacube.training.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import com.metacube.training.dao.EmployeeDAO;
import com.metacube.training.dao.EmployeeDAOImpl;
import com.metacube.training.dto.PreSignupTO;
import com.metacube.training.model.Employee;
import com.metacube.training.model.Skill;

/**
 * @author Rahul Sharma
 *
 */
public class EmployeeServiceImpl implements EmployeeService {

	private static EmployeeServiceImpl employeeServiceObject = new EmployeeServiceImpl();
	private EmployeeDAO employeeDao = EmployeeDAOImpl.getInstance();
	
	public static EmployeeServiceImpl getInstance() {
		
		return employeeServiceObject;
	}
	
	
	@Override
	public boolean addEmployee(PreSignupTO preSignupTO) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(preSignupTO.getDoj());
		int year = calendar.get(Calendar.YEAR);
		
		preSignupTO.setEmployeeCode(generateEmployeeCode(year));
		
		return employeeDao.preSignup(preSignupTO);
	}


	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeDao.getAllEmployees();
	}


	@Override
	public List<Employee> searchEmployee(String criteria, String keyword) {
		
		List<Employee> listOfEmployees = null;
		
		switch (criteria) {
			
			case "name" : listOfEmployees = employeeDao.searchByName(keyword);
						  break;
						  
			case "project" : listOfEmployees = employeeDao.searchByProject(Integer.parseInt(keyword));
							 break;
							 
			case "skill" : listOfEmployees = employeeDao.searchBySkills(keyword);
						   break;
						   
			case "experience" : listOfEmployees = employeeDao.searchByExperience(Double.parseDouble(keyword));
								break;
		}
		
		return listOfEmployees;
	}
	

	@Override
	public Employee getEmployeeByCode(String employeeCode) {
		
		return employeeDao.getEmployeeByCode(employeeCode);
	}
	

	@Override
	public boolean updateEmployee(Employee employee) {
		
		return employeeDao.updateEmployee(employee);
	}


	@Override
	public boolean isValidLogin(String username, String password) {
		
		boolean valid = false;
		
		if(password.equals(getEmployeeByEmail(username).getPassword()))
			valid = true;
		
		return valid;
	}
	
	@Override
	public Employee getEmployeeByEmail(String email) {
		
		return employeeDao.getEmployeeByEmail(email);
	}

	
	@Override
	public void addSkills(String[] skills, String employeeCode) {
		
		SkillService skillService = SkillServiceImpl.getInstance();
		
		for(String skill: skills)
		{
			if(!"n/a".equals(skill))
			{
				employeeDao.addSkill(skillService.getSkillByName(skill), employeeCode);
			}
				
		}
		
	}
	
	private String generateEmployeeCode(int year) {
		
		List<Employee> listOfEmployee = getAllEmployees();
		int size = listOfEmployee.size();
		
		if(size == 0) {
			return "E" + year + "/" + 1;
		}
		
		int[] codes = new int[size];
		
		for(int i = 0; i < size; i++)
			codes[i] = Integer.parseInt(listOfEmployee.get(i).getEmployeeCode().split("/")[1]);
			
		Arrays.sort(codes);
		return "E" + year + "/" + (codes[size - 1] + 1);
	}

}
