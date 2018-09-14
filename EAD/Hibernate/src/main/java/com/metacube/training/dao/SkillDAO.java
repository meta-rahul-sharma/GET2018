package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Skill;

public interface SkillDAO {
	
	Skill getSkillById(int id);

	List<Skill> getAllSkills();

	void updateSkill(Skill skill);

	boolean createSkill(Skill skill);
	
	void deleteSkill(Skill skill);
	
	Skill getSkillByName(String skill);

}
