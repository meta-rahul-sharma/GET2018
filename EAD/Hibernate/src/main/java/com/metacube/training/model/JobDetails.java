package com.metacube.training.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Job_Details")
public class JobDetails {
	
	@Id
	@Column(name = "job_detail_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "emp_code")
	private String employeeCode;
	
	@Column(name = "date_of_joining")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date doj;
	
	@Column(name = "total_exp")
	private double experience;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private JobTitle jobCode;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Employee reportingMgr;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Employee teamLead;
	
	@Column(name = "curr_proj_id")
	private int projectId;

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
	public String getEmployeeCode() {
		return employeeCode;
	}

	/**
	 * @param employeeCode the employeeCode to set
	 */
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	/**
	 * @return the doj
	 */
	public Date getDoj() {
		return doj;
	}

	/**
	 * @param doj the doj to set
	 */
	public void setDoj(Date doj) {
		this.doj = doj;
	}

	/**
	 * @return the experience
	 */
	public double getExperience() {
		return experience;
	}

	/**
	 * @param experience the experience to set
	 */
	public void setExperience(double experience) {
		this.experience = experience;
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
	public int getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
}
