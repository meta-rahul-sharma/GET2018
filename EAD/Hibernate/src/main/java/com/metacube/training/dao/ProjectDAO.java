package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Project;

/**
 * 
 * @author Rahul Sharma
 *
 */
public interface ProjectDAO {
	
	
	Project getProjectById(int id);

	List<Project> getAllProjects();

	void deleteProject(Project project);

	void updateProject(Project project);

	boolean createProject(Project project);
}
