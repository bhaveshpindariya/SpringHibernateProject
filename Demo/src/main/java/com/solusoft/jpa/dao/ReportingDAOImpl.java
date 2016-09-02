package com.solusoft.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.solusoft.jpa.entity.ReportingMaster;

@Component("reportingDAO")
public class ReportingDAOImpl implements ReportingDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<ReportingMaster> findAll()
	 {
		try{
			final String qu="select model from ReportingMaster model";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<ReportingMaster> findId(long id)
	 {
		
		try{
			final String qu="select model from ReportingMaster model where model.employeeMaster.empid=:eid";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			query.setParameter("eid", id);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public synchronized ReportingMaster save(ReportingMaster detail)
	 {
		try{
			ReportingMaster enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
}
