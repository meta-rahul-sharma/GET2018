package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.model.JobTitle;
import com.metacube.training.repository.JobDetailsRepository;
import com.metacube.training.repository.JobTitleRepository;

/**
 * @author Rahul Sharma
 *
 */
@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobTitleRepository<JobTitle> jobRepository;

	@Override
	public JobTitle getJobByCode(int id) {
		return jobRepository.findByJobCode(id);
	}

	@Override
	public List<JobTitle> getAllJobTitle() {
		return jobRepository.findAll();
	}

	@Override
	public void deleteJobTitle(JobTitle job) {
		jobRepository.delete(job);
	}

	@Override
	public void updateJobTitle(JobTitle job) {
		jobRepository.save(job);
	}

	@Override
	public void createJobTitle(JobTitle job) {
		jobRepository.save(job);
	}

}
