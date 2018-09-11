package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mapper.SkillMapper;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;


@Repository
public class SkillDAOImpl  implements SkillDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public SkillDAOImpl(DataSource dataSource)
	{
		jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	private final String SQL_FIND_SKILL = "select * from Skills where skill_id = ?";
	private final String SQL_FIND_SKILL_BY_NAME = "select * from Skills where skill_name = ?";
	private final String SQL_DELETE_SKILL = "delete from Skills where skill_id = ?";
	private final String SQL_UPDATE_SKILL = "update Skills set skill_name=? WHERE skill_id=?";
	private final String SQL_GET_ALL = "select * from Skills";
	private final String SQL_INSERT_SKILL = "insert into Skills(skill_name) values(?)";
    
	
	public Skill getSkillById(int id) {
		return jdbcTemplate.queryForObject(SQL_FIND_SKILL, new Object[] { id }, new SkillMapper());
	}

	public List<Skill> getAllSkills() {
		return jdbcTemplate.query(SQL_GET_ALL, new SkillMapper());
	}

    public boolean createSkill(Skill skill)
    {
    	return jdbcTemplate.update(SQL_INSERT_SKILL, skill.getName())>0;
    }
    
    public boolean updateSkill(Skill skill)
    {
    	return jdbcTemplate.update(SQL_UPDATE_SKILL, skill.getName(), skill.getId())>0;
    }

	@Override
	public boolean deleteSkill(Skill skill) {
		return jdbcTemplate.update(SQL_DELETE_SKILL, skill.getName(), skill.getId())>0;
	}

	@Override
	public Skill getSkillByName(String skill) {
		return jdbcTemplate.queryForObject(SQL_FIND_SKILL_BY_NAME, new Object[] { skill }, new SkillMapper());
	}



}
