package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Employee;
import com.metacube.training.model.Project;

@Repository
public interface EmployeeRepository<E> extends JpaRepository<Employee, String> {

	public Employee findByEmployeeCode(String employeeCode);
	
	public Employee findByEmail(String email);
	
	@Query("SELECT emp FROM Employee emp WHERE concat(emp.firstName, ' ', emp.middleName, ' ', emp.lastName) like concat('%', :name, '%')")
	public List<Employee> searchByName(@Param("name") String name);
	
	@Query("SELECT e "
			+ "FROM JobDetails j INNER JOIN j.employeeCode e "
			+ "WHERE j.projectId = :project")
	public List<Employee> searchByProjectId(@Param("project") Project project);
	
	@Query("SELECT e "
			+ "FROM EmployeeSkills es INNER JOIN es.employeeCode e "
			+ "INNER JOIN es.skillCode s "
			+ "WHERE s.name LIKE concat('%', :skill, '%')")
	public List<Employee> searchBySkills(@Param("skill") String skill);
	
	@Query("SELECT e "
			+ "FROM JobDetails j INNER JOIN j.employeeCode e "
			+ "WHERE j.totalExperience = :experience")
	public List<Employee> searchByExperience(@Param("experience") double experience);
	
	@Query("SELECT emp FROM Employee emp "
	        + "WHERE concat(emp.firstName, ' ', emp.middleName, ' ', emp.lastName) like concat('%', :name, '%') "
	        + "AND emp.enabled = true")
    public List<Employee> searchByNameEnabledTrue(@Param("name") String name);
    
    @Query("SELECT e "
            + "FROM JobDetails j INNER JOIN j.employeeCode e "
            + "WHERE j.projectId = :project AND e.enabled = true")
    public List<Employee> searchByProjectIdEnabledTrue(@Param("project") Project project);
    
    @Query("SELECT e "
            + "FROM EmployeeSkills es INNER JOIN es.employeeCode e "
            + "INNER JOIN es.skillCode s "
            + "WHERE s.name LIKE concat('%', :skill, '%') AND e.enabled = true")
    public List<Employee> searchBySkillsEnabledTrue(@Param("skill") String skill);
    
    @Query("SELECT e "
            + "FROM JobDetails j INNER JOIN j.employeeCode e "
            + "WHERE j.totalExperience = :experience AND e.enabled = true")
    public List<Employee> searchByExperienceEnabledTrue(@Param("experience") double experience);
	
}
