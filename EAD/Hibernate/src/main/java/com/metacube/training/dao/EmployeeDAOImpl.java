package com.metacube.training.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dto.PreSignupTO;
import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeSkills;
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
	
	@Autowired
	private ProjectDAO projectDao;

	public void preSignup(Employee employee, JobDetails jobDetails) {
		 sessionFactory.getCurrentSession().save(employee);
		 System.out.println("employee added"+jobDetails);
		 sessionFactory.getCurrentSession().save(jobDetails);
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
		List<Employee> listOfEmployee = new ArrayList<Employee>();
	    Criteria c = sessionFactory.getCurrentSession().createCriteria(JobDetails.class, "jobDetail");
	    c.createAlias("jobDetail.employeeCode", "employee");
	    c.add(Restrictions.eq("jobDetail.projectId", projectDao.getProjectById(projectId)));
	    c = c.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
	    for(Object jobDetail: c.list())
	    {
	        JobDetails j = (JobDetails)jobDetail;
	        listOfEmployee.add(j.getEmployeeCode());
	    }
	    return listOfEmployee;
	}


	public List<Employee> searchBySkills(String skill) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee e join EmployeeSkill es join Skill s "
                + "where s.skill_name LIKE concat('%', :skill, '%')");
        query.setParameter("skill", skill);
        return query.getResultList();
	}


	public List<Employee> searchByExperience(double experience) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee where ");
		return query.getResultList();
	}


	public Employee getEmployeeByCode(String employeeCode) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee where emp_code = :employeeCode");
		query.setParameter("employeeCode", employeeCode);
		return query.getSingleResult();
	}


	public void updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
	}


	public Employee getEmployeeByEmail(String employeeEmail) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee where email = :employeeEmail");
		query.setParameter("employeeEmail", employeeEmail);
		return query.getSingleResult();
	}


	public void addSkill(Skill skill, String employeeCode) {
		sessionFactory.getCurrentSession().save(skill);
	}


	@Override
	public void addSkills(EmployeeSkills skill) {
		sessionFactory.getCurrentSession().save(skill);
	}


	@Override
	public void deleteEmployee(Employee employee) {
		sessionFactory.getCurrentSession().delete(employee);
	}
}
