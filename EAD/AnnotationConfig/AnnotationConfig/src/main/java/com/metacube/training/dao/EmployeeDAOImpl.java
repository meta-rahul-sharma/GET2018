package com.metacube.training.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.metacube.training.dto.PreSignupTO;
import com.metacube.training.model.Employee;
import com.metacube.training.model.Skill;

/**
 * @author Rahul Sharma
 *
 */

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	
	
	private static final String SQL_INSERT_EMPLOYEE = "INSERT INTO employee(emp_code, first_name, middle_name, last_name, email, dob, gender) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?)";    
	
	private static final String SQL_INSERT_JOB_DETAILS = "INSERT INTO job_details(reporting_mgr, team_lead, date_of_joining, curr_proj_id, emp_code) "
			+ "VALUES(?, ?, ?, ?, ?)";
	
	private static final String SQL_GET_ALL = "SELECT * FROM employee";
	
	private static final String SQL_SEARCH_BY_NAME = "SELECT * FROM employee "
			+ "WHERE concat(first_name, ' ', middle_name, ' ', last_name) LIKE concat('%', ?, '%')";
	
	private static final String SQL_SEARCH_BY_PROJECT = "SELECT * "
			+ "FROM employee e INNER JOIN job_details j ON e.emp_code = j.emp_code "
			+ "INNER JOIN project p ON j.curr_proj_id = p.project_id "
			+ "WHERE p.project_id = ?";
	
	private static final String SQL_SEARCH_BY_SKILL = "SELECT * "
			+ "FROM employee e INNER JOIN Employee_Skills es ON e.emp_code = es.emp_code "
			+ "INNER JOIN Skills s ON es.skill_code = s.skill_id "
			+ "WHERE s.skill_name LIKE concat('%', ?, '%')";
	
	private static final String SQL_SEARCH_BY_EXPERIENCE = "SELECT * "
			+ "FROM employee e INNER JOIN job_details j ON e.emp_code = j.emp_code "
			+ "WHERE j.total_exp = ?";
	
	private static final String SQL_GET_BY_CODE = "SELECT * FROM employee WHERE emp_code = ?";
	
	private static final String SQL_UPDATE_EMPLOYEE = "UPDATE employee "
			+ "SET first_name = ?, middle_name = ?, last_name = ?, email = ?, dob = ?, gender = ?, "
			+ "primary_contact_no = ?, secondary_contact_no = ?, skype_id = ?, enabled = ?, password = ? "
			+ "WHERE emp_code = ?";
	
	private static final String SQL_GET_BY_EMAIL = "SELECT * FROM employee WHERE email = ?";
	
	private static final String SQL_ADD_SKILL = "INSERT INTO Employee_Skills(emp_code, skill_code) "
			+ "VALUES(?, ?)";

	@Override
	public boolean preSignup(PreSignupTO preSignupTO) {
		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> searchByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> searchByProject(int projectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> searchBySkills(String skill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> searchByExperience(double experience) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeByCode(String employeeCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addSkill(Skill skill, String employeeCode) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
