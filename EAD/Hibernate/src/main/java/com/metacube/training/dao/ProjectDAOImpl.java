package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Project;

/**
 * @author Rahul Sharma
 *
 */
@Repository
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
		TypedQuery<Project> query = sessionFactory.getCurrentSession().createQuery("from Project where project_id = : id");
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	public List<Project> getAllProjects() {
		TypedQuery<Project> query = sessionFactory.getCurrentSession().createQuery("from Project");
		return query.getResultList();
	}

	public void deleteProject(Project person) {
		sessionFactory.getCurrentSession().delete(person);
	}

	public void updateProject(Project person) {
		sessionFactory.getCurrentSession().update(person);
	}

	public void createProject(Project person) {
		sessionFactory.getCurrentSession().save(person);
	}
}
