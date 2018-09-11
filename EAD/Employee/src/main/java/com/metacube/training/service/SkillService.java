package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Skill;

/**
 * @author Rahul Sharma
 *
 */
public interface SkillService {

    public boolean addSkill(Skill skill);
    
    public List<Skill> getAllSkills();
    
    public Skill getSkillByName(String skill);
}
