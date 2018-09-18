package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Skill;

@Repository
public interface SkillRepository<S> extends JpaRepository<Skill, Integer> {
	public Skill findByName(String name);
}
