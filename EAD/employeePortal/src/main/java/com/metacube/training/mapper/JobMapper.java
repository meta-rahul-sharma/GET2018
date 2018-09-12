package com.metacube.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.JobTitle;

public class JobMapper implements RowMapper<JobTitle> {

	public JobTitle mapRow(ResultSet resultSet, int i) throws SQLException {

		JobTitle job = new JobTitle();
		job.setJobCode(resultSet.getInt("job_code"));
		job.setJobTitle(resultSet.getString("job_title"));
		return job;
	}
}