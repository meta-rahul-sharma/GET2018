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

	boolean deleteJobTitle(JobTitle job);

	boolean updateJobTitle(JobTitle job);

	boolean createJobTitle(JobTitle job);
}