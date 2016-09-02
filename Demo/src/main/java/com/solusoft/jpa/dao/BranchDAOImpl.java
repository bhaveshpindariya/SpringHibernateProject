package com.solusoft.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.solusoft.jpa.entity.BranchMaster;


@Component("branchDAO")
public class BranchDAOImpl implements BranchDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<BranchMaster> findAll()
	 {
		try{
			final String qu="select model from BranchMaster model";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public BranchMaster findId(Integer id)
	 {
		try{
			BranchMaster sig= getEntityManager().find(BranchMaster.class, id);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public synchronized BranchMaster save(BranchMaster detail)
	 {
		try{
			BranchMaster enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
}
