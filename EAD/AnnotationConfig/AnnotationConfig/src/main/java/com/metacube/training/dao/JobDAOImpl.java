package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.metacube.training.model.JobTitle;

/**
 * @author Rahul Sharma
 *
 */
public class JobDAOImpl implements JobDAO{

    private static JobDAOImpl jobDaoObject = new JobDAOImpl();
    
    private static final String SQL_INSERT_JOB_TITLE = "INSERT INTO job_title(job_title) "
            + "VALUES(?)";    
    
    public static JobDAOImpl getInstance() {
        
        return jobDaoObject;
    }
    
    
    @Override
    public boolean createJobTitle(JobTitle jobTitle) {
        
        boolean inserted = false;
        
        try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SQL_INSERT_JOB_TITLE);
        ){
            stmt.setString(1, jobTitle.getJobTitle());
            
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
