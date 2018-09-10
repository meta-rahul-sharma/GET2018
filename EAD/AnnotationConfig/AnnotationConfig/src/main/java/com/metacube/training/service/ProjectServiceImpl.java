package com.metacube.training.service;

import java.util.List;

import com.metacube.training.dao.ProjectDAO;
import com.metacube.training.dao.ProjectDAOImpl;
import com.metacube.training.model.Project;

/**
 * @author Rahul Sharma
 *
 */
public class ProjectServiceImpl implements ProjectService {

	private static ProjectServiceImpl ProjectServiceObject = new ProjectServiceImpl();
	private ProjectDAO projectDAO = ProjectDAOImpl.getInstance();
	
	public static ProjectServiceImpl getInstance() {
		
		return ProjectServiceObject;
	}
	
	
	@Override
	public boolean addProject(Project project) {
				
		return projectDAO.createProject(project);
	}


	@Override
	public List<Project> getAllProjects() {
		
		return projectDAO.getAllProjects();
	}

}
