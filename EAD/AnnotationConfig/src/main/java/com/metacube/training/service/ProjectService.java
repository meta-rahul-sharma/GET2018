package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.ProjectMaster;


public interface ProjectService {

	
	ProjectMaster getProjectById(Long id);

	List<ProjectMaster> getAllProjects();

	boolean deleteProject(Long id);

	boolean updateProject(ProjectMaster project);

	boolean createProject(ProjectMaster project);

}
