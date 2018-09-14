package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;

/**
 * @author Rahul Sharma
 *
 */
@Repository
@Transactional
public class ProjectDAOImpl implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;

	/*@Autowired
	public ProjectDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}*/

	@Autowired
	private SessionFactory sessionFactory;
	
	private final String SQL_FIND_PROJECT = "select * from project where id = ?";
	private final String SQL_DELETE_PROJECT = "delete from project where id = ?";
	private final String SQL_UPDATE_PROJECT = "update project set name = ?, description = ?, start_date  = ?, end_date  = ? where id = ?";
	private final String SQL_GET_ALL = "select * from project";
	private final String SQL_INSERT_PROJECT = "insert into project(name, description, start_date, end_date) values(?,?,?,?)";

	public Project getProjectById(int id) {
		@SuppressWarnings("deprecation")
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Project.class);
		criteria.add(Restrictions.eq("projectId", id));
		return (Project) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Project> getAllProjects() {
		@SuppressWarnings("deprecation")
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Project.class);
		return (List<Project>)criteria.list();
	}

	public void deleteProject(Project person) {
		sessionFactory.getCurrentSession().delete(person);
	}

	public void updateProject(Project person) {
		sessionFactory.getCurrentSession().update(person);
	}

	public boolean createProject(Project person) {
		boolean created = false;
		 Session session = sessionFactory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = (Transaction) session.beginTransaction();
	         if((Integer) session.save(person) != 0) {
	        	 created = true;
	         } 
	         	tx.commit();
			 } catch (HibernateException e) {
		        if (tx!=null) tx.rollback();
		        e.printStackTrace(); 
		     } finally {
		        session.close(); 
		     }
	      return created;
	}
}
