package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.JobTitle;

@Repository
public interface JobTitleRepository<J> extends JpaRepository<JobTitle, Integer> {
	public JobTitle findByJobCode(int jobCode);
}
