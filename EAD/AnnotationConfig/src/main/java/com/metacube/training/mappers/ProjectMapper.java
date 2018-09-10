package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.ProjectMaster;

public class ProjectMapper implements RowMapper<ProjectMaster> {

	public ProjectMaster mapRow(ResultSet resultSet, int i) throws SQLException {

		ProjectMaster project = new ProjectMaster(resultSet.getLong("project_id"), resultSet.getString("description"), resultSet.getDate("start_date"), resultSet.getDate("end_date"), resultSet.getString("project_logo"));
		return project;
	}
}
