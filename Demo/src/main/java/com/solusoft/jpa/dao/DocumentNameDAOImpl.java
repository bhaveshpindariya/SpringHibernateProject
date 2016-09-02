package com.solusoft.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.solusoft.jpa.entity.DocumentNameForBL;
import com.solusoft.jpa.entity.DocumentNameForBM;
import com.solusoft.jpa.entity.DocumentNameForBRL;

@Component("documentNameDAO")
public class DocumentNameDAOImpl implements DocumentNameDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<DocumentNameForBL> findAllBl()
	 {
		try{
			final String qu="select model from DocumentNameForBL model";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<DocumentNameForBRL> findAllBrl()
	 {
		try{
			final String qu="select model from DocumentNameForBRL model";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<DocumentNameForBM> findAllBm()
	 {
		try{
			final String qu="select model from DocumentNameForBM model";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
}
