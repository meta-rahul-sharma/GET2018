package com.metacube.training.SpringSecurity.service;

import java.util.List;

import com.metacube.training.SpringSecurity.dto.PreSignupTO;
import com.metacube.training.SpringSecurity.model.Employee;


public interface EmployeeService {

	public void addEmployee(PreSignupTO preSignupTO);
	
	public List<Employee> getAllEmployees();
	
	public List<Employee> searchEmployee(String criteria, String keyword);
	
	public Employee getEmployeeByCode(String employeeCode);
	
	public void updateEmployee(Employee employee);
	
	public boolean isValidLogin(String username, String password);
	
	public Employee getEmployeeByEmail(String email);
	
	public void addSkills(String[] skills, Employee employee);
}
