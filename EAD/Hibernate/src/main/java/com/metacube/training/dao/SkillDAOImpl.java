package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mapper.SkillMapper;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;


@Repository
public class SkillDAOImpl  implements SkillDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	/*@Autowired
	public SkillDAOImpl(DataSource dataSource)
	{
		jdbcTemplate=new JdbcTemplate(dataSource);
	}*/
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private final String SQL_FIND_SKILL = "select * from Skills where skill_id = ?";
	private final String SQL_FIND_SKILL_BY_NAME = "select * from Skills where skill_name = ?";
	private final String SQL_DELETE_SKILL = "delete from Skills where skill_id = ?";
	private final String SQL_UPDATE_SKILL = "update Skills set skill_name=? WHERE skill_id=?";
	private final String SQL_GET_ALL = "select * from Skills";
	private final String SQL_INSERT_SKILL = "insert into Skills(skill_name) values(?)";
    
	
	public Skill getSkillById(int id) {
		TypedQuery<Skill> query = sessionFactory.getCurrentSession().createQuery("from Skills where skill_id = : id");
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	public List<Skill> getAllSkills() {
		TypedQuery<Skill> query = sessionFactory.getCurrentSession().createQuery("from Skills");
		return query.getResultList();
	}

    public void createSkill(Skill skill)
    {
    	sessionFactory.getCurrentSession().save(skill);
    }
    
    public void updateSkill(Skill skill)
    {
    	sessionFactory.getCurrentSession().update(skill);
    }

	public void deleteSkill(Skill skill) {
		sessionFactory.getCurrentSession().delete(skill);
	}

	public Skill getSkillByName(String skill) {
		TypedQuery<Skill> query = sessionFactory.getCurrentSession().createQuery("from Skills where skill_name = : skill");
		query.setParameter("skill", skill);
		return query.getSingleResult();
	}



}
