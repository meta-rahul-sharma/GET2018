package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dto.PreSignupTO;
import com.metacube.training.model.Employee;
import com.metacube.training.model.JobDetails;
import com.metacube.training.model.JobTitle;
import com.metacube.training.model.Skill;

/**
 * @author Rahul Sharma
 *
 */

@Repository
@Transactional
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
	boolean created = false;
	 Session session = sessionFactory.openSession();
     Transaction tx = null;
     Employee employee = new Employee();
     employee.setEmployeeCode(preSignupTO.getEmployeeCode());
     employee.setFirstName(preSignupTO.getFirstName());
     employee.setLastName(preSignupTO.getLastName());
     employee.setEmail(preSignupTO.getEmail());
     employee.setDob(preSignupTO.getDob());
     employee.setGender(preSignupTO.getGender());
     
     JobDetails jobDetail = new JobDetails();
     jobDetail.setReportingMgr(preSignupTO.getReportingMgr());
     jobDetail.setTeamLead(preSignupTO.getTeamLead());
     jobDetail.setDoj(preSignupTO.getDoj());
     jobDetail.setProjectId(preSignupTO.getProjectId());
     jobDetail.setEmployeeCode(preSignupTO.getEmployeeCode());
     try {
        tx = (Transaction) session.beginTransaction();
        session.save(employee);
        session.save(jobDetail);
       	created = true;
         
       	tx.commit();
	 } catch (HibernateException e) {
        if (tx!=null) tx.rollback();
        e.printStackTrace(); 
	 } finally {
        session.close(); 
     }
     return created;
	}


	public List<Employee> getAllEmployees() {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Employee.class);
		return (List<Employee>)criteria.list();
	}


	public List<Employee> searchByName(String name) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("FROM Employee "
			+ "WHERE concat(first_name, ' ', middle_name, ' ', last_name) LIKE concat('%', ?1, '%')");
		query.setParameter(1, name);
		return query.getResultList();
	}


	public List<Employee> searchByProject(int projectId) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee where ");
		return query.getResultList();
	}


	public List<Employee> searchBySkills(String skill) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee where ");
		return query.getResultList();
	}


	public List<Employee> searchByExperience(double experience) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee where ");
		return query.getResultList();
	}


	public Employee getEmployeeByCode(String employeeCode) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee where emp_code = : employeeCode");
		query.setParameter("employeeCode", employeeCode);
		return query.getSingleResult();
	}


	public void updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
	}


	public Employee getEmployeeByEmail(String employeeEmail) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee where email = : employeeEmail");
		query.setParameter("employeeEmail", employeeEmail);
		return query.getSingleResult();
	}


	public void addSkill(Skill skill, String employeeCode) {
		/*sessionFactory.getCurrentSession().save(employee);*/
	}


	@Override
	public void deleteEmployee(Employee employee) {
		sessionFactory.getCurrentSession().delete(employee);
	}
}
