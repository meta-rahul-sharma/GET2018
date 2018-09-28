package com.metacube.training.SpringSecurity.service;

import java.util.List;

import com.metacube.training.SpringSecurity.model.Skill;

/**
 * @author Rahul Sharma
 *
 */
public interface SkillService {

	Skill getSkillById(int id);

	List<Skill> getAllSkills();

	void updateSkill(Skill skill);

	void createSkill(Skill skill);
	
	void deleteSkill(Skill skill);

	Skill getSkillByName(String skill);
}
