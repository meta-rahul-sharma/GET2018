package com.metacube.training.SpringSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.SpringSecurity.dao.SkillDAO;
import com.metacube.training.SpringSecurity.model.Skill;

/**
 * @author Rahul Sharma
 *
 */
@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillDAO skillDao;
	
	@Override
	public Skill getSkillById(int id) {
		return skillDao.getSkillById(id);
	}

	@Override
	public List<Skill> getAllSkills() {
		return skillDao.getAllSkills();
	}

	@Override
	public void updateSkill(Skill skill) {
		skillDao.updateSkill(skill);
	}

	@Override
	public void createSkill(Skill skill) {
		skillDao.createSkill(skill);
	}

	public void deleteSkill(Skill skill) {
		skillDao.deleteSkill(skill);
	}

	public Skill getSkillByName(String skill) {
		return skillDao.getSkillByName(skill);
	}

}
