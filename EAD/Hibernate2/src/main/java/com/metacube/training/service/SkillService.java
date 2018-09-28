package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Skill;

/**
 * @author Rahul Sharma
 *
 */
public interface SkillService {

	List<Skill> getAllSkills();

	void updateSkill(Skill skill);

	void createSkill(Skill skill);
	
	void deleteSkill(Skill skill);

	Skill getSkillByName(String skill);
}
