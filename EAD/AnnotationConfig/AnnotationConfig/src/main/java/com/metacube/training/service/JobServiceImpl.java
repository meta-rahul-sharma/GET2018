package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.JobDAO;
import com.metacube.training.dao.JobDAOImpl;
import com.metacube.training.dao.ProjectDAO;
import com.metacube.training.model.JobTitle;

/**
 * @author Rahul Sharma
 *
 */
@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobDAO jobDao;

	@Override
	public JobTitle getJobByCode(int id) {
		return jobDao.getJobByCode(id);
	}

	@Override
	public List<JobTitle> getAllJobTitle() {
		return jobDao.getAllJobTitle();
	}

	@Override
	public boolean deleteJobTitle(JobTitle job) {
		return jobDao.deleteJobTitle(job);
	}

	@Override
	public boolean updateJobTitle(JobTitle job) {
		return jobDao.updateJobTitle(job);
	}

	@Override
	public boolean createJobTitle(JobTitle job) {
		return jobDao.createJobTitle(job);
	}

}
