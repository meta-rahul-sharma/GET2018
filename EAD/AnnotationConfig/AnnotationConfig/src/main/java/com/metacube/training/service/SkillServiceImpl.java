package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.SkillDAO;
import com.metacube.training.model.Skill;

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
	public boolean updateSkill(Skill skill) {
		return skillDao.updateSkill(skill);
	}

	@Override
	public boolean createSkill(Skill skill) {
		return skillDao.createSkill(skill);
	}

	public boolean deleteSkill(Skill skill) {
		return skillDao.deleteSkill(skill);
	}

	public Skill getSkillByName(String skill) {
		return skillDao.getSkillByName(skill);
	}

}
