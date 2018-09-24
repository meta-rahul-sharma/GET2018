package com.metacube.training.SpringSecurity.service;

import java.util.List;

import com.metacube.training.SpringSecurity.model.Project;


public interface ProjectService {

	
	Project getProjectById(int id);

	List<Project> getAllProjects();

	void deleteProject(Project project);

	void updateProject(Project project);

	boolean createProject(Project project);

	void deleteProject(int id);

}
