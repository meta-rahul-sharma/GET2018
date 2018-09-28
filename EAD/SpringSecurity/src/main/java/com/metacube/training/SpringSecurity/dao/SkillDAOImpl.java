package com.metacube.training.SpringSecurity.dao;

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

import com.metacube.training.SpringSecurity.model.Skill;

@Repository
@Transactional
public class SkillDAOImpl  implements SkillDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
    
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

	/**
	 * To get skil by it's name
	 */
	public Skill getSkillByName(String skill) {
		@SuppressWarnings("unchecked")
		TypedQuery<Skill> query = sessionFactory.getCurrentSession().createQuery("from Skill where skill_name = :skill");
		query.setParameter("skill", skill);
		return query.getSingleResult();
	}



}
