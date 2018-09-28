package com.metacube.training.SpringSecurity.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author Rahul Sharma
 * Pojo for JobDetails in database
 *
 */
@Entity
@Table(name = "Job_Details")
public class JobDetails {
	
    @Id
    @Column(name = "job_detail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_code")
    private Employee employeeCode;
    
    @Column(name = "date_of_joining")
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateOfJoining;
    
    @Column(name = "total_exp")
    private double totalExperience;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_code")
    private JobTitle jobCode;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reporting_mgr")
    private Employee reportingMgr;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_lead")
    private Employee teamLead; 
        
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="curr_proj_id")
    private Project projectId;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the employeeCode
	 */
	public Employee getEmployeeCode() {
		return employeeCode;
	}

	/**
	 * @param employeeCode the employeeCode to set
	 */
	public void setEmployeeCode(Employee employeeCode) {
		this.employeeCode = employeeCode;
	}

	/**
	 * @return the dateOfJoining
	 */
	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * @param dateOfJoining the dateOfJoining to set
	 */
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	/**
	 * @return the totalExperience
	 */
	public double getTotalExperience() {
		return totalExperience;
	}

	/**
	 * @param totalExperience the totalExperience to set
	 */
	public void setTotalExperience(double totalExperience) {
		this.totalExperience = totalExperience;
	}

	/**
	 * @return the jobCode
	 */
	public JobTitle getJobCode() {
		return jobCode;
	}

	/**
	 * @param jobCode the jobCode to set
	 */
	public void setJobCode(JobTitle jobCode) {
		this.jobCode = jobCode;
	}

	/**
	 * @return the reportingMgr
	 */
	public Employee getReportingMgr() {
		return reportingMgr;
	}

	/**
	 * @param reportingMgr the reportingMgr to set
	 */
	public void setReportingMgr(Employee reportingMgr) {
		this.reportingMgr = reportingMgr;
	}

	/**
	 * @return the teamLead
	 */
	public Employee getTeamLead() {
		return teamLead;
	}

	/**
	 * @param teamLead the teamLead to set
	 */
	public void setTeamLead(Employee teamLead) {
		this.teamLead = teamLead;
	}

	/**
	 * @return the projectId
	 */
	public Project getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Project projectId) {
		this.projectId = projectId;
	}
}
