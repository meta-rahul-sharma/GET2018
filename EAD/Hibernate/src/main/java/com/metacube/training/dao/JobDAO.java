package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.JobTitle;
import com.metacube.training.model.Project;

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