package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Skill;
import com.metacube.training.repository.SkillRepository;

/**
 * @author Rahul Sharma
 *
 */
@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillRepository<Skill> skillRepository;

	@Override
	public List<Skill> getAllSkills() {
		return skillRepository.findAll();
	}

	@Override
	public void updateSkill(Skill skill) {
		skillRepository.save(skill);
	}

	@Override
	public void createSkill(Skill skill) {
		skillRepository.save(skill);
	}

	public void deleteSkill(Skill skill) {
		skillRepository.delete(skill);
	}
	
	public Skill getSkillByName(String skill) {
		return skillRepository.findByName(skill);
	}

}
