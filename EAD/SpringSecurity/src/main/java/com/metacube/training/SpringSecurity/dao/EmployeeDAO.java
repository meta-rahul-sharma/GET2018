package com.metacube.training.SpringSecurity.dao;

import java.util.List;

import com.metacube.training.SpringSecurity.model.Employee;
import com.metacube.training.SpringSecurity.model.EmployeeSkills;
import com.metacube.training.SpringSecurity.model.JobDetails;

/**
 * @author Rahul Sharma
 *
 */
public interface EmployeeDAO {

	public void preSignup(Employee employee, JobDetails jobDetails);
	
	public List<Employee> getAllEmployees();
	
	public List<Employee> searchByName(String name);
	
	public List<Employee> searchByProject(int projectId);
	
	public List<Employee> searchBySkills(String skill);
	
	public List<Employee> searchByExperience(double experience);
	
	public Employee getEmployeeByCode(String employeeCode);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployee(Employee employee);
	
	public Employee getEmployeeByEmail(String email);
	
	public void addSkills(EmployeeSkills skill);
}
