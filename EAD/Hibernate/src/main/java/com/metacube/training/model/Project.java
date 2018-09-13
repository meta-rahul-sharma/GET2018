package com.metacube.training.model;

import java.io.InputStream;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * @author Rahul Sharma
 *
 */

@Entity
@Table(name = "Project")
public class Project {

	@Id
	@Column(name = "project_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int projectId;
	
	@Column(name = "description")
	String description;
	
	@Column(name = "start_date")
	Date startDate;
	
	@Column(name = "end_date")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	Date endDate;
	
	@Column(name = "name")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	String projectLogo;
	
	
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
	
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	
	
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	
	
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	/**
	 * @return the projectLogo
	 */
	public String getProjectLogo() {
		return projectLogo;
	}
	
	
	/**
	 * @param projectLogo the projectLogo to set
	 */
	public void setProjectLogo(String projectLogo) {
		this.projectLogo = projectLogo;
	}
	
	

}
