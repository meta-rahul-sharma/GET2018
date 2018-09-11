package com.metacube.training.service;

import java.util.List;

import com.metacube.training.dao.SkillDAO;
import com.metacube.training.dao.SkillDAOImpl;
import com.metacube.training.model.Skill;

/**
 * @author Rahul Sharma
 *
 */
public class SkillServiceImpl implements SkillService {

    private static SkillServiceImpl SkillServiceImpl = new SkillServiceImpl();
    private SkillDAO skillDao = SkillDAOImpl.getInstance();
    
    public static SkillServiceImpl getInstance() {
        
        return SkillServiceImpl;
    }
    
    
    @Override
    public boolean addSkill(Skill skill) {
               
        return skillDao.createSkill(skill);
    }


	@Override
	public List<Skill> getAllSkills() {
		
		return skillDao.getAllSkills();
	}


	@Override
	public Skill getSkillByName(String skill) {

		return skillDao.getSkillByName(skill);
	}

}
