package com.metacube.training.SpringSecurity.dao;

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

import com.metacube.training.SpringSecurity.model.Employee;
import com.metacube.training.SpringSecurity.model.EmployeeSkills;
import com.metacube.training.SpringSecurity.model.JobDetails;


/**
 * @author Rahul Sharma
 * Employee dao
 */

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ProjectDAO projectDao;

	/**
	 * To get data in employee and jobDetails table
	 */
	public void preSignup(Employee employee, JobDetails jobDetails) {
		 sessionFactory.getCurrentSession().save(employee);
		 sessionFactory.getCurrentSession().save(jobDetails);
	}


	/**
	 * To get all employees
	 */
	public List<Employee> getAllEmployees() {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Employee.class);
		return (List<Employee>)criteria.list();
	}


	/**
	 * to search employees by name
	 */
	public List<Employee> searchByName(String name) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee "
		           + "where concat(firstName, ' ', middleName, ' ', lastName) like concat('%', :name, '%')");
		       query.setParameter("name", name);
		return query.getResultList();
	}


	/**
	 * To get employee by project id
	 */
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


	/**
	 * To get employee by skill name
	 */
	public List<Employee> searchBySkills(String skill) {
	  List<Employee> listOfEmployee = new ArrayList<Employee>();
       Criteria c = sessionFactory.getCurrentSession().createCriteria(EmployeeSkills.class, "employee");
       c.createAlias("employee.skillCode", "skill");
       c.add(Restrictions.like("skill.name", skill + "%"));

       for(Object empSkill: c.list())
       {
           EmployeeSkills es = (EmployeeSkills) empSkill;
           listOfEmployee.add(es.getEmployeeCode());
       }
       return listOfEmployee;
	}


	/**
	 * To get employee by experience
	 */
	public List<Employee> searchByExperience(double experience) {
		List<Employee> listOfEmployee = new ArrayList<Employee>();
        Criteria c = sessionFactory.getCurrentSession().createCriteria(JobDetails.class, "jobDetail");
        c.createAlias("jobDetail.employeeCode", "employee");
        c.add(Restrictions.eq("jobDetail.totalExperience", experience));
        c = c.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        for(Object jobDetail: c.list())
        {
            JobDetails j = (JobDetails)jobDetail;
            listOfEmployee.add(j.getEmployeeCode());
        }
       return listOfEmployee;
	}


	/**
	 * To get employee by employee code
	 */
	public Employee getEmployeeByCode(String employeeCode) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee where emp_code = :employeeCode");
		query.setParameter("employeeCode", employeeCode);
		return query.getSingleResult();
	}


	/**
	 * to update employee details
	 */
	public void updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
	}


	/**
	 * To get employee by email
	 */
	public Employee getEmployeeByEmail(String employeeEmail) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee where email = :employeeEmail");
		query.setParameter("employeeEmail", employeeEmail);
		return query.getSingleResult();
	}

	/**
	 * To add employee skills
	 */
	public void addSkills(EmployeeSkills skill) {
		sessionFactory.getCurrentSession().save(skill);
	}


	/**
	 * to delete employee
	 */
	@Override
	public void deleteEmployee(Employee employee) {
		sessionFactory.getCurrentSession().delete(employee);
	}
}
