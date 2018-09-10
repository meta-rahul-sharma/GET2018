package com.metacube.training.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.training.model.Project;

/**
 * @author Rahul Sharma
 *
 */
public class ProjectDAOImpl implements ProjectDAO {

	private static ProjectDAOImpl projectDAOObject = new ProjectDAOImpl();
		
	private static final String SQL_GET_ALL = "SELECT * FROM project";
	
	private static final String SQL_INSERT_PROJECT = "INSERT INTO project(description, start_date, end_date, project_logo) "
									+ "VALUES(?,?,?,?)";
	
	public static ProjectDAOImpl getInstance() {
		
		return projectDAOObject;
	}
	

	@Override
	public List<Project> getAllProjects() {
		
		List<Project> listOfProjects = new ArrayList<>();
		
		try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SQL_GET_ALL);
        ){
			ResultSet result = stmt.executeQuery();
			
			while(result.next())
			{
				Project project = new Project();
				project.setProjectId(result.getInt("project_id"));
				project.setDescription(result.getString("description"));
				project.setStartDate(new java.util.Date(result.getDate("start_date").getTime()));
				project.setEndDate(new java.util.Date(result.getDate("end_date").getTime()));
				Blob logo = result.getBlob("project_logo");
				if(logo == null)
					project.setProjectLogo(null);
				else
					project.setProjectLogo(logo.getBinaryStream());
				
				listOfProjects.add(project);
			}
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
		return listOfProjects;
	}


	@Override
	public boolean createProject(Project project) {
		boolean inserted = false;
		
		try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SQL_INSERT_PROJECT);
        ){
            stmt.setString(1, project.getDescription());
            stmt.setDate(2, new Date(project.getStartDate().getTime()));
            stmt.setDate(3, new Date(project.getEndDate().getTime()));
            stmt.setBlob(4, project.getProjectLogo());
            
            if(stmt.executeUpdate() > 0)
            	inserted = true;

        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
		
		return inserted;
	}

}
