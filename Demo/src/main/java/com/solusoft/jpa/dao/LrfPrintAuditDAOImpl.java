package com.solusoft.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import com.solusoft.jpa.entity.LrfPrintAuditMaster;

@Component("lrfPrintAuditDAO")
public class LrfPrintAuditDAOImpl implements LrfPrintAuditDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<LrfPrintAuditMaster> findAll()
	 {
		try{
			final String qu="select model from LrfPrintAuditMaster model ";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
		
	}
	
		
}
