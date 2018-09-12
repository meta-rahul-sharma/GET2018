package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mapper.JobMapper;
import com.metacube.training.model.JobTitle;

/**
 * @author Rahul Sharma
 *
 */
@Repository
public class JobDAOImpl implements JobDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JobDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
    
	private final String SQL_FIND_JOB = "select * from job_title where job_code = ?";
	private final String SQL_DELETE_JOB = "delete from job_title where job_code = ?";
	private final String SQL_UPDATE_JOB = "update job_title set job_title = ? where job_code = ?";
	private final String SQL_GET_ALL = "select * from Job_Title";
	private final String SQL_INSERT_JOB = "insert into Job_Title(job_title) values(?)";

	@Override
	public JobTitle getJobByCode(int id) {
		return jdbcTemplate.queryForObject(SQL_FIND_JOB, new Object[] { id }, new JobMapper());
	}

	@Override
	public boolean deleteJobTitle(JobTitle job) {
		return jdbcTemplate.update(SQL_DELETE_JOB, job.getJobCode()) > 0;
	}

	@Override
	public boolean updateJobTitle(JobTitle job) {
		return jdbcTemplate.update(SQL_UPDATE_JOB, job.getJobTitle(), job.getJobCode()) > 0;
	}

	@Override
	public boolean createJobTitle(JobTitle job) {
		return jdbcTemplate.update(SQL_INSERT_JOB, job.getJobTitle()) > 0;
	}

	@Override
	public List<JobTitle> getAllJobTitle() {
		return jdbcTemplate.query(SQL_GET_ALL, new JobMapper());
	}
}
