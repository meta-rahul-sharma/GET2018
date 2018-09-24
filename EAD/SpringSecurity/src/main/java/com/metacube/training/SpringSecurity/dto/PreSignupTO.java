package com.metacube.training.SpringSecurity.dto;

import java.util.Date;

/**
 * @author Rahul Sharma
 * Used as data transfer object
 */
public class PreSignupTO {

	private String employeeCode, firstName, middleName, lastName, email, reportingMgr, TeamLead;
	private Date dob, doj;
	
	private char gender;
	private Integer projectId;
	
	
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	
	
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	/**
	 * @return the reportingMgr
	 */
	public String getReportingMgr() {
		return reportingMgr;
	}
	
	
	/**
	 * @param reportingMgr the reportingMgr to set
	 */
	public void setReportingMgr(String reportingMgr) {
		this.reportingMgr = reportingMgr;
	}
	
	
	/**
	 * @return the teamLead
	 */
	public String getTeamLead() {
		return TeamLead;
	}
	
	
	/**
	 * @param teamLead the teamLead to set
	 */
	public void setTeamLead(String teamLead) {
		TeamLead = teamLead;
	}
	
	
	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}
	
	
	/**
	 * @param date of birth to set here
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
	/**
	 * @return the date of joining
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
	 * @return the gender
	 */
	public char getGender() {
		return gender;
	}
	
	
	/**
	 * @param gender the gender to set
	 */
	public void setGender(char gender) {
		this.gender = gender;
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


