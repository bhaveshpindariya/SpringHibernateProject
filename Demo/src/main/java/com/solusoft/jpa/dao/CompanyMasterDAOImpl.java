package com.solusoft.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.solusoft.jpa.entity.CompanyMaster;



@Component("companyMasterDAO")
public class CompanyMasterDAOImpl implements CompanyMasterDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<CompanyMaster> findall()
	 {
		try{
			final String qu="select model from CompanyMaster model ";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public synchronized CompanyMaster save(CompanyMaster detail)
	 {
		try{
			CompanyMaster enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public CompanyMaster findId(Integer id)
	 {
		try{
			CompanyMaster sig= getEntityManager().find(CompanyMaster.class, id);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public CompanyMaster findName(String name)
	 {
		try{
			final String qu="select model from CompanyMaster model where model.companyName=:cname";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("cname", name);
			query.setHint("org.hibernate.cacheable", true);
			return (CompanyMaster) query.getSingleResult();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
}
