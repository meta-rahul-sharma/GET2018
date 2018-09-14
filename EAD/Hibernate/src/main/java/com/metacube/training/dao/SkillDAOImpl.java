package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.JobTitle;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;


@Repository
@Transactional
public class SkillDAOImpl  implements SkillDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	/*@Autowired
	public SkillDAOImpl(DataSource dataSource)
	{
		jdbcTemplate=new JdbcTemplate(dataSource);
	}*/
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/*private final String SQL_FIND_SKILL = "select * from Skills where skill_id = ?";
	private final String SQL_FIND_SKILL_BY_NAME = "select * from Skills where skill_name = ?";
	private final String SQL_DELETE_SKILL = "delete from Skills where skill_id = ?";
	private final String SQL_UPDATE_SKILL = "update Skills set skill_name=? WHERE skill_id=?";
	private final String SQL_GET_ALL = "select * from Skills";
	private final String SQL_INSERT_SKILL = "insert into Skills(skill_name) values(?)";*/
    
	/**
	 * To get Skill by Id
	 */
	public Skill getSkillById(int id) {
		@SuppressWarnings("deprecation")
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Skill.class);
		criteria.add(Restrictions.eq("id", id));
		return (Skill) criteria.uniqueResult();
	}

	/**
	 * To get all Skills from table
	 */
	@SuppressWarnings("unchecked")
	public List<Skill> getAllSkills() {
		@SuppressWarnings("deprecation")
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Skill.class);
		return (List<Skill>)criteria.list();
	}

	/**
	 * To create a new Skill
	 */
    public boolean createSkill(Skill skill)
    {
    	boolean created = false;
		 Session session = sessionFactory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = (Transaction) session.beginTransaction();
	         if((Integer) session.save(skill) != 0) {
	        	 created = true;
	         } 
	         	tx.commit();
			 } catch (HibernateException e) {
		        if (tx!=null) tx.rollback();
		        e.printStackTrace(); 
		     } finally {
		        session.close(); 
		     }
	      return created;
    }
    
    /**
     * To update value of a skill
     */
    public void updateSkill(Skill skill)
    {
    	sessionFactory.getCurrentSession().update(skill);
    }

    /**
     * To delete a particular skill
     */
	public void deleteSkill(Skill skill) {
		sessionFactory.getCurrentSession().delete(skill);
	}

	public Skill getSkillByName(String skill) {
		@SuppressWarnings("unchecked")
		TypedQuery<Skill> query = sessionFactory.getCurrentSession().createQuery("from Skills where skill_name = : skill");
		query.setParameter("skill", skill);
		return query.getSingleResult();
	}



}
