package com.solusoft.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.solusoft.jpa.entity.Auditrail;


@Component("audittrailDAO")
public class AudittrailDAOImpl implements AudittrailDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<Auditrail> findAll()
	 {
		try{
			final String qu="select model from Auditrail model ";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Auditrail> findByTable(String tname)
	 {
		try{
			final String qu="select model from Auditrail model where UPPER(model.tableName)=:TableName";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("TableName", tname);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<String> findName()
	 {
		try{
			final String qu="select DISTINCT model.tableName from Auditrail model ";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public synchronized Auditrail save(Auditrail detail)
	 {
		try{
			Auditrail enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	
}
