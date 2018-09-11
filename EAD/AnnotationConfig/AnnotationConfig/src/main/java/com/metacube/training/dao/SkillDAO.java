package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Skill;

public interface SkillDAO {
	
	Skill getSkillById(int id);

	List<Skill> getAllSkills();

	boolean updateSkill(Skill skill);

	boolean createSkill(Skill skill);
	
	boolean deleteSkill(Skill skill);
	
	Skill getSkillByName(String skill);

}
