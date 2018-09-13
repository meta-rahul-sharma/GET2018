package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dto.PreSignupTO;
import com.metacube.training.mapper.EmployeeMapper;
import com.metacube.training.model.Employee;
import com.metacube.training.model.Skill;

/**
 * @author Rahul Sharma
 *
 */

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/*@Autowired
	public EmployeeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}*/
	
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

public boolean preSignup(PreSignupTO preSignupTO) {
		
		int result1 = jdbcTemplate.update(SQL_INSERT_EMPLOYEE, preSignupTO.getEmployeeCode(), preSignupTO.getFirstName(), preSignupTO.getMiddleName(), 
				preSignupTO.getLastName(), preSignupTO.getEmail(), preSignupTO.getDob(), String.valueOf(preSignupTO.getGender()));
		
		int result2 = jdbcTemplate.update(SQL_INSERT_JOB_DETAILS, preSignupTO.getReportingMgr(), preSignupTO.getTeamLead(), 
				preSignupTO.getDoj(), preSignupTO.getProjectId(), preSignupTO.getEmployeeCode());
		return result1 > 0 && result2 > 0;
	}


	public List<Employee> getAllEmployees() {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee");
		return query.getResultList();
	}


	public List<Employee> searchByName(String name) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee where ");
		return query.getResultList();
	}


	public List<Employee> searchByProject(int projectId) {
		return jdbcTemplate.query(SQL_SEARCH_BY_PROJECT, new Object[] { projectId }, new EmployeeMapper());
	}


	public List<Employee> searchBySkills(String skill) {
		return jdbcTemplate.query(SQL_SEARCH_BY_SKILL, new Object[] { skill }, new EmployeeMapper());
	}


	public List<Employee> searchByExperience(double experience) {
		return jdbcTemplate.query(SQL_SEARCH_BY_EXPERIENCE, new  Object[] { experience }, new EmployeeMapper());
	}


	public Employee getEmployeeByCode(String employeeCode) {
		return jdbcTemplate.queryForObject(SQL_GET_BY_CODE, new Object[] { employeeCode }, new EmployeeMapper());
	}


	public boolean updateEmployee(Employee employee) {
		int result = jdbcTemplate.update(SQL_UPDATE_EMPLOYEE, employee.getFirstName(), employee.getMiddleName(), employee.getLastName(),
				employee.getEmail(), employee.getDob(), String.valueOf(employee.getGender()), employee.getPrimaryContact(), 
				employee.getSecondaryContact(), employee.getSkypeId(), employee.isEnabled(), employee.getPassword(), employee.getEmployeeCode());
		
		return  result > 0;
	}


	public Employee getEmployeeByEmail(String email) {
		return jdbcTemplate.queryForObject(SQL_GET_BY_EMAIL, new Object[] { email }, new EmployeeMapper());
	}


	public boolean addSkill(Skill skill, String employeeCode) {
		return jdbcTemplate.update(SQL_ADD_SKILL, employeeCode, skill.getId()) > 0;
	}
}
