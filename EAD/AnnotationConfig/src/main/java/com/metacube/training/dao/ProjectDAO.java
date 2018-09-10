package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.ProjectMaster;

public interface ProjectDAO {
	
	
	ProjectMaster getProjectById(Long id);

	List<ProjectMaster> getAllProjects();

	boolean deleteProject(ProjectMaster project);

	boolean updateProject(ProjectMaster project);

	boolean createProject(ProjectMaster project);
}
