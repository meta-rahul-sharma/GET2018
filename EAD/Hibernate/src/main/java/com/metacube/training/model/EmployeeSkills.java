package com.metacube.training.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 
 * @author Rahul Sharma
 * Pojo for Employee Services
 *
 */
@Entity
@Table(name = "Employee_Skills")
public class EmployeeSkills {
	
	@Id
	@Column(name = "emp_skill_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    @Column(name = "emp_code")
    private String employeeCode;
    
    @Column(name = "skill_code")
    private int skillCode;

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
	 * @return the skillCode
	 */
	public int getSkillCode() {
		return skillCode;
	}

	/**
	 * @param skillCode the skillCode to set
	 */
	public void setSkillCode(int skillCode) {
		this.skillCode = skillCode;
	}
}
