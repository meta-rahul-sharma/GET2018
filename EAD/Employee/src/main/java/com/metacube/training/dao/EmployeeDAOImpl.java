package com.metacube.training.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.training.dto.PreSignupTO;
import com.metacube.training.model.Employee;
import com.metacube.training.model.Skill;

/**
 * @author Rahul Sharma
 *
 */
public class EmployeeDAOImpl implements EmployeeDAO {

	private static EmployeeDAOImpl employeeDaoObject = new EmployeeDAOImpl();
	
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
	
	public static EmployeeDAOImpl getInstance() {
		
		return employeeDaoObject;
	}
	
	
	@Override
	public boolean preSignup(PreSignupTO preSignupTO) {
		
		boolean successful = false;
		
		try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt1 = connection.prepareStatement(SQL_INSERT_EMPLOYEE);
			PreparedStatement stmt2 = connection.prepareStatement(SQL_INSERT_JOB_DETAILS);
        ){
			stmt1.setString(1, preSignupTO.getEmployeeCode());
			stmt1.setString(2, preSignupTO.getFirstName());
			stmt1.setString(3, preSignupTO.getMiddleName());
			stmt1.setString(4, preSignupTO.getLastName());
			stmt1.setString(5, preSignupTO.getEmail());
			stmt1.setDate(6, new Date(preSignupTO.getDob().getTime()));
			stmt1.setString(7, String.valueOf(preSignupTO.getGender()));
			
			stmt2.setString(1, preSignupTO.getReportingMgr());
			stmt2.setString(2, preSignupTO.getTeamLead());
			stmt2.setDate(3, new Date(preSignupTO.getDoj().getTime()));
			stmt2.setInt(4, preSignupTO.getProjectId());
			stmt2.setString(5, preSignupTO.getEmployeeCode());
            
            if(stmt1.executeUpdate() > 0 && stmt2.executeUpdate() > 0)
            	successful = true;

        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
		
		return successful;
	}


	@Override
	public List<Employee> getAllEmployees() {
		
		List<Employee> listOfEmployees = new ArrayList<>();
		
		try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SQL_GET_ALL);
        ){
			ResultSet result = stmt.executeQuery();
			
			while(result.next())
			{
				Employee employee = new Employee();
				employee.setEmployeeCode(result.getString("emp_code"));
				employee.setFirstName(result.getString("first_name"));
				employee.setMiddleName(result.getString("middle_name"));
				employee.setLastName(result.getString("last_name"));
				employee.setDob(new java.util.Date(result.getDate("dob").getTime()));
				employee.setGender(result.getString("gender").charAt(0));
				employee.setPrimaryContact(result.getString("primary_contact_no"));
				employee.setSecondaryContact(result.getString("secondary_contact_no"));
				employee.setEmail(result.getString("email"));
				employee.setSkypeId(result.getString("skype_id"));
				Blob profilePicture = result.getBlob("profile_picture");
				
				if(profilePicture == null)
					employee.setProfilePicture(null);
				else
					employee.setProfilePicture(profilePicture.getBinaryStream());
				
				employee.setPassword(result.getString("password"));
				employee.setEnabled(result.getBoolean("enabled"));
				
				listOfEmployees.add(employee);
			}
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
		
		return listOfEmployees;
	}


	@Override
	public List<Employee> searchByName(String name) {
		
		List<Employee> listOfEmployees = new ArrayList<>();
		
		try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SQL_SEARCH_BY_NAME);
        ){
			stmt.setString(1, name);
			ResultSet result = stmt.executeQuery();
			
			while(result.next())
			{
				Employee employee = new Employee();
				employee.setEmployeeCode(result.getString("emp_code"));
				employee.setFirstName(result.getString("first_name"));
				employee.setMiddleName(result.getString("middle_name"));
				employee.setLastName(result.getString("last_name"));
				employee.setDob(new java.util.Date(result.getDate("dob").getTime()));
				employee.setGender(result.getString("gender").charAt(0));
				employee.setPrimaryContact(result.getString("primary_contact_no"));
				employee.setSecondaryContact(result.getString("secondary_contact_no"));
				employee.setEmail(result.getString("email"));
				employee.setSkypeId(result.getString("skype_id"));
				Blob profilePicture = result.getBlob("profile_picture");
				
				if(profilePicture == null)
					employee.setProfilePicture(null);
				else
					employee.setProfilePicture(profilePicture.getBinaryStream());
				
				employee.setPassword(result.getString("password"));
				employee.setEnabled(result.getBoolean("enabled"));
				
				listOfEmployees.add(employee);
			}
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
		
		return listOfEmployees;
	}


	@Override
	public List<Employee> searchByProject(int projectId) {

		List<Employee> listOfEmployees = new ArrayList<>();
		
		try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SQL_SEARCH_BY_PROJECT);
        ){
			stmt.setInt(1, projectId);
			ResultSet result = stmt.executeQuery();
			
			while(result.next())
			{
				Employee employee = new Employee();
				employee.setEmployeeCode(result.getString("emp_code"));
				employee.setFirstName(result.getString("first_name"));
				employee.setMiddleName(result.getString("middle_name"));
				employee.setLastName(result.getString("last_name"));
				employee.setDob(new java.util.Date(result.getDate("dob").getTime()));
				employee.setGender(result.getString("gender").charAt(0));
				employee.setPrimaryContact(result.getString("primary_contact_no"));
				employee.setSecondaryContact(result.getString("secondary_contact_no"));
				employee.setEmail(result.getString("email"));
				employee.setSkypeId(result.getString("skype_id"));
				Blob profilePicture = result.getBlob("profile_picture");
				
				if(profilePicture == null)
					employee.setProfilePicture(null);
				else
					employee.setProfilePicture(profilePicture.getBinaryStream());
				
				employee.setPassword(result.getString("password"));
				employee.setEnabled(result.getBoolean("enabled"));
				
				listOfEmployees.add(employee);
			}
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
		
		return listOfEmployees;
	}


	@Override
	public List<Employee> searchBySkills(String skill) {

		List<Employee> listOfEmployees = new ArrayList<>();
		
		try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SQL_SEARCH_BY_SKILL);
        ){
			stmt.setString(1, skill);
			ResultSet result = stmt.executeQuery();
			
			while(result.next())
			{
				Employee employee = new Employee();
				employee.setEmployeeCode(result.getString("emp_code"));
				employee.setFirstName(result.getString("first_name"));
				employee.setMiddleName(result.getString("middle_name"));
				employee.setLastName(result.getString("last_name"));
				employee.setDob(new java.util.Date(result.getDate("dob").getTime()));
				employee.setGender(result.getString("gender").charAt(0));
				employee.setPrimaryContact(result.getString("primary_contact_no"));
				employee.setSecondaryContact(result.getString("secondary_contact_no"));
				employee.setEmail(result.getString("email"));
				employee.setSkypeId(result.getString("skype_id"));
				Blob profilePicture = result.getBlob("profile_picture");
				
				if(profilePicture == null)
					employee.setProfilePicture(null);
				else
					employee.setProfilePicture(profilePicture.getBinaryStream());
				
				employee.setPassword(result.getString("password"));
				employee.setEnabled(result.getBoolean("enabled"));
				
				listOfEmployees.add(employee);
			}
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
		
		return listOfEmployees;
	}


	@Override
	public List<Employee> searchByExperience(double experience) {

		List<Employee> listOfEmployees = new ArrayList<>();
		
		try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SQL_SEARCH_BY_EXPERIENCE);
        ){
			stmt.setDouble(1, experience);
			ResultSet result = stmt.executeQuery();
			
			while(result.next())
			{
				Employee employee = new Employee();
				employee.setEmployeeCode(result.getString("emp_code"));
				employee.setFirstName(result.getString("first_name"));
				employee.setMiddleName(result.getString("middle_name"));
				employee.setLastName(result.getString("last_name"));
				employee.setDob(new java.util.Date(result.getDate("dob").getTime()));
				employee.setGender(result.getString("gender").charAt(0));
				employee.setPrimaryContact(result.getString("primary_contact_no"));
				employee.setSecondaryContact(result.getString("secondary_contact_no"));
				employee.setEmail(result.getString("email"));
				employee.setSkypeId(result.getString("skype_id"));
				Blob profilePicture = result.getBlob("profile_picture");
				
				if(profilePicture == null)
					employee.setProfilePicture(null);
				else
					employee.setProfilePicture(profilePicture.getBinaryStream());
				
				employee.setPassword(result.getString("password"));
				employee.setEnabled(result.getBoolean("enabled"));
				
				listOfEmployees.add(employee);
			}
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
		
		return listOfEmployees;
	}


	@Override
	public Employee getEmployeeByCode(String employeeCode) {

		Employee employee = new Employee();
		
		try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SQL_GET_BY_CODE);
        ){
			stmt.setString(1, employeeCode);
			ResultSet result = stmt.executeQuery();
			
			result.next();
			
			employee.setEmployeeCode(result.getString("emp_code"));
			employee.setFirstName(result.getString("first_name"));
			employee.setMiddleName(result.getString("middle_name"));
			employee.setLastName(result.getString("last_name"));
			employee.setDob(new java.util.Date(result.getDate("dob").getTime()));
			employee.setGender(result.getString("gender").charAt(0));
			employee.setPrimaryContact(result.getString("primary_contact_no"));
			employee.setSecondaryContact(result.getString("secondary_contact_no"));
			employee.setEmail(result.getString("email"));
			employee.setSkypeId(result.getString("skype_id"));
			Blob profilePicture = result.getBlob("profile_picture");
			
			if(profilePicture == null)
				employee.setProfilePicture(null);
			else
				employee.setProfilePicture(profilePicture.getBinaryStream());
			
			employee.setPassword(result.getString("password"));
			employee.setEnabled(result.getBoolean("enabled"));
			
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
		
		return employee;
	}


	@Override
	public boolean updateEmployee(Employee employee) {
		
		boolean successful = false;
		
		try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE_EMPLOYEE);
        ){
			stmt.setString(1, employee.getFirstName());
			stmt.setString(2, employee.getMiddleName());
			stmt.setString(3, employee.getLastName());
			stmt.setString(4, employee.getEmail());
			stmt.setDate(5, new Date(employee.getDob().getTime()));
			stmt.setString(6, String.valueOf(employee.getGender()));
			stmt.setString(7, employee.getPrimaryContact());
			stmt.setString(8, employee.getSecondaryContact());
			stmt.setString(9, employee.getSkypeId());
			stmt.setBoolean(10, employee.isEnabled());
			stmt.setString(11, employee.getPassword());
			stmt.setString(12, employee.getEmployeeCode());
            
            if(stmt.executeUpdate() > 0)
            	successful = true;

        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
		
		return successful;
	}


	@Override
	public Employee getEmployeeByEmail(String email) {
		
		Employee employee = new Employee();
		
		try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SQL_GET_BY_EMAIL);
        ){
			stmt.setString(1, email);
			ResultSet result = stmt.executeQuery();
			
			result.next();
			
			employee.setEmployeeCode(result.getString("emp_code"));
			employee.setFirstName(result.getString("first_name"));
			employee.setMiddleName(result.getString("middle_name"));
			employee.setLastName(result.getString("last_name"));
			employee.setDob(new java.util.Date(result.getDate("dob").getTime()));
			employee.setGender(result.getString("gender").charAt(0));
			employee.setPrimaryContact(result.getString("primary_contact_no"));
			employee.setSecondaryContact(result.getString("secondary_contact_no"));
			employee.setEmail(result.getString("email"));
			employee.setSkypeId(result.getString("skype_id"));
			Blob profilePicture = result.getBlob("profile_picture");
			
			if(profilePicture == null)
				employee.setProfilePicture(null);
			else
				employee.setProfilePicture(profilePicture.getBinaryStream());
			
			employee.setPassword(result.getString("password"));
			employee.setEnabled(result.getBoolean("enabled"));
			
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
		
		return employee;
	}


	@Override
	public boolean addSkill(Skill skill, String employeeCode) {
		
		boolean successful = false;
		
		try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SQL_ADD_SKILL);
        ){
			stmt.setString(1, employeeCode);
			stmt.setInt(2, skill.getId());
            
			if(stmt.executeUpdate() > 0)
            	successful = true;

        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
		
		return successful;
	}

}
