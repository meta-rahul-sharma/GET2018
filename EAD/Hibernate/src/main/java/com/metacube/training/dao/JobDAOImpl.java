package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
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

/**
 * @author Rahul Sharma
 *
 */
@Repository
@Transactional
public class JobDAOImpl implements JobDAO{
    
	@Autowired
	private SessionFactory sessionFactory;
	
	private final String SQL_FIND_JOB = "select * from job_title where job_code = ?";
	private final String SQL_DELETE_JOB = "delete from job_title where job_code = ?";
	private final String SQL_UPDATE_JOB = "update job_title set job_title = ? where job_code = ?";
	private final String SQL_GET_ALL = "select * from Job_Title";
	private final String SQL_INSERT_JOB = "insert into Job_Title(job_title) values(?)";

	@Override
	public JobTitle getJobByCode(int code) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(JobTitle.class);
		criteria.add(Restrictions.eq("jobCode",code));
		return (JobTitle) criteria.uniqueResult();
	}

	@Override
	public void deleteJobTitle(JobTitle id) {
		 JobTitle jobTitle = (JobTitle ) sessionFactory.getCurrentSession().createCriteria(JobTitle.class)
                 .add(Restrictions.eq("classId", id)).uniqueResult();
		 sessionFactory.getCurrentSession().delete(jobTitle);
	}

	@Override
	public void updateJobTitle(JobTitle job) {
		CriteriaBuilder cb=sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaUpdate<JobTitle> update=cb.createCriteriaUpdate(JobTitle.class);
		Root root=update.from(JobTitle.class);
		update.set("jobTitle",job.getJobTitle());
		update.where(cb.equal(root.get("jobCode"), job.getJobCode()));
		sessionFactory.getCurrentSession().createQuery(update);
	}

	@Override
	public boolean createJobTitle(JobTitle job) {
		boolean created = false;
		 Session session = sessionFactory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = (Transaction) session.beginTransaction();
	         if((Integer) session.save(job) != 0) {
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

	@Override
	public List<JobTitle> getAllJobTitle() {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(JobTitle.class);
		return (List<JobTitle>)criteria.list();
	}
}
