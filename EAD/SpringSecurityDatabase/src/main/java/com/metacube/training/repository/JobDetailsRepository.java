package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.JobDetails;

@Repository
public interface JobDetailsRepository<J> extends JpaRepository<JobDetails, Integer> {

}
