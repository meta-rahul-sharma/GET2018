package com.metacube.training.SpringSecurity.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "emp_code")
    private Employee employeeCode;
    
	@ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "skill_code")
    private Skill skillCode;

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
	 * @return the skillCode
	 */
	public Skill getSkillCode() {
		return skillCode;
	}

	/**
	 * @param skillCode the skillCode to set
	 */
	public void setSkillCode(Skill skillCode) {
		this.skillCode = skillCode;
	}
}
