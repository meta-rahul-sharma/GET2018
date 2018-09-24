package com.metacube.training.SpringSecurity.dao;

import java.util.List;

import com.metacube.training.SpringSecurity.model.Skill;

/**
 * 
 * @author Rahul Sharma
 *
 */
public interface SkillDAO {
	
	Skill getSkillById(int id);

	List<Skill> getAllSkills();

	void updateSkill(Skill skill);

	boolean createSkill(Skill skill);
	
	void deleteSkill(Skill skill);
	
	Skill getSkillByName(String skill);

}
