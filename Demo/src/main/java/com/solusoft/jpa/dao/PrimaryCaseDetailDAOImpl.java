package com.solusoft.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.solusoft.jpa.entity.PrimaryCaseDetail;


@Component("primaryCaseDetailDAO")
public class PrimaryCaseDetailDAOImpl implements PrimaryCaseDetailDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	public PrimaryCaseDetail findCaseId(String caseId){
		try{
			final String qu="select model from PrimaryCaseDetail model where model.caseId=:case";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("case", caseId);
			query.setHint("org.hibernate.cacheable", true);
			@SuppressWarnings("unchecked")
			List<PrimaryCaseDetail> userRecord =  query.getResultList();
			if(userRecord.size()>0){
				return userRecord.get(0);
			}else{
				return null;
			}
		}catch(RuntimeException e){
			throw e;
		}
    }
	
	public PrimaryCaseDetail save(PrimaryCaseDetail ss){
		try{
			PrimaryCaseDetail enti=getEntityManager().merge(ss);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
}
