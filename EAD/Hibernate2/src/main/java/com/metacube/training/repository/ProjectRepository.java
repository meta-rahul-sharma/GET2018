package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Project;

@Repository
public interface ProjectRepository<P> extends JpaRepository<Project, Integer> {

	public Project findByProjectId(Integer projectId);
}
