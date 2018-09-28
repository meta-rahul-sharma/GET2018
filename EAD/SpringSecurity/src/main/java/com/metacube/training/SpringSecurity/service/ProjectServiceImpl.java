package com.metacube.training.SpringSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.SpringSecurity.dao.ProjectDAO;
import com.metacube.training.SpringSecurity.model.Project;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDAO projectDAO;
	
	
	@Override
	public Project getProjectById(int id) {
		
		return projectDAO.getProjectById(id);
	}

	@Override
	public List<Project> getAllProjects() {
		return projectDAO.getAllProjects();
	}

	@Override
	public void deleteProject(int id) {
		Project project = projectDAO.getProjectById(id);
		projectDAO.deleteProject(project);
	}

	@Override
	public void updateProject(Project project) {
		projectDAO.updateProject(project);
	}

	@Override
	public boolean createProject(Project project) {
		
		return projectDAO.createProject(project);
	}

	@Override
	public void deleteProject(Project project) {
		projectDAO.deleteProject(project);
	}
}
