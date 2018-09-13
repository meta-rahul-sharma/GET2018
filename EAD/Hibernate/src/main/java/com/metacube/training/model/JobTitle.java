package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Rahul Sharma
 *
 */
@Entity
@Table(name = "Job_Title")
public class JobTitle {

	@Id
	@Column(name = "job_code")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobCode;
	
	@Column(name = "job_title")
    private String jobTitle;
    
    
    /**
     * @return the jobCode
     */
    public int getJobCode() {
        return jobCode;
    }
    
    
    /**
     * @param jobCode the jobCode to set
     */
    public void setJobCode(int jobCode) {
        this.jobCode = jobCode;
    }
    
    
    /**
     * @return the jobTitle
     */
    public String getJobTitle() {
        return jobTitle;
    }
    
    
    /**
     * @param jobTitle the jobTitle to set
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
 
}
