package com.metacube.training.service;

import com.metacube.training.dao.JobDAO;
import com.metacube.training.dao.JobDAOImpl;
import com.metacube.training.model.JobTitle;

/**
 * @author Rahul Sharma
 *
 */
public class JobServiceImpl implements JobService {

    private static JobServiceImpl jobServiceObject = new JobServiceImpl();
    
    public static JobServiceImpl getInstance() {
        
        return jobServiceObject;
    }
    
    @Override
    public boolean addJobTitle(JobTitle jobTitle) {
        
        JobDAO jobDao = JobDAOImpl.getInstance();
        
        return jobDao.createJobTitle(jobTitle);
    }

}
