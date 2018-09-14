package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.JobTitle;

/**
 * @author Rahul Sharma
 *
 */
public interface JobService {

	JobTitle getJobByCode(int id);

	List<JobTitle> getAllJobTitle();

	void deleteJobTitle(JobTitle job);

	void updateJobTitle(JobTitle job);

	void createJobTitle(JobTitle job);
}
