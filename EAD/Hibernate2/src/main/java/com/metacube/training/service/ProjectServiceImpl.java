package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.model.Project;
import com.metacube.training.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository<Project> projectRepository;
	
	
	@Override
	public Project getProjectById(int id) {
		
		return projectRepository.findByProjectId(id);
	}

	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@Override
	public void deleteProject(int id) {
		Project project = projectRepository.findByProjectId(id);
		projectRepository.delete(project);
	}

	@Override
	public void updateProject(Project project) {
		projectRepository.save(project);
	}

	@Override
	public void createProject(Project project) {
		
		projectRepository.save(project);
	}

	@Override
	public void deleteProject(Project project) {
		projectRepository.delete(project);
	}
}
