package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.EmployeeSkills;

@Repository
public interface EmployeeSkillsRepository<E> extends JpaRepository<EmployeeSkills, Integer> {

}
