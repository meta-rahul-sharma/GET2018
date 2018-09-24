package com.metacube.training.SpringSecurity.dao;

import java.util.List;

import com.metacube.training.SpringSecurity.model.JobTitle;


/**
 * @author Rahul Sharma
 *
 */
public interface JobDAO {
	
	
	JobTitle getJobByCode(int id);

	List<JobTitle> getAllJobTitle();

	void deleteJobTitle(JobTitle id);

	void updateJobTitle(JobTitle job);

	boolean createJobTitle(JobTitle job);
}