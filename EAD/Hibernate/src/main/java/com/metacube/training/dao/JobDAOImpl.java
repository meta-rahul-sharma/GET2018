package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mapper.JobMapper;
import com.metacube.training.model.JobTitle;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;

/**
 * @author Rahul Sharma
 *
 */
@Repository
public class JobDAOImpl implements JobDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	/*@Autowired
	public JobDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}*/
    
	@Autowired
	private SessionFactory sessionFactory;
	
	private final String SQL_FIND_JOB = "select * from job_title where job_code = ?";
	private final String SQL_DELETE_JOB = "delete from job_title where job_code = ?";
	private final String SQL_UPDATE_JOB = "update job_title set job_title = ? where job_code = ?";
	private final String SQL_GET_ALL = "select * from Job_Title";
	private final String SQL_INSERT_JOB = "insert into Job_Title(job_title) values(?)";

	@Override
	public JobTitle getJobByCode(int code) {
		TypedQuery<JobTitle> query = sessionFactory.getCurrentSession().createQuery("from Job_Title where job_code = : code");
		query.setParameter("code", code);
		return query.getSingleResult();
	}

	@Override
	public void deleteJobTitle(JobTitle job) {
		sessionFactory.getCurrentSession().delete(job);
	}

	@Override
	public void updateJobTitle(JobTitle job) {
		sessionFactory.getCurrentSession().update(job);
	}

	@Override
	public void createJobTitle(JobTitle job) {
		sessionFactory.getCurrentSession().save(job);
	}

	@Override
	public List<JobTitle> getAllJobTitle() {
		TypedQuery<JobTitle> query = sessionFactory.getCurrentSession().createQuery("from Job_Title");
		return query.getResultList();	}
}
