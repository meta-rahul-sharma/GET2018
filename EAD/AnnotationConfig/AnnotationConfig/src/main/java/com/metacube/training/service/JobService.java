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

	boolean deleteJobTitle(JobTitle job);

	boolean updateJobTitle(JobTitle job);

	boolean createJobTitle(JobTitle job);
}
