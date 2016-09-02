package com.solusoft.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import com.solusoft.jpa.entity.CostCenterMaster;



@Component("costCenterDAO")
public class CostCenterDAOImpl implements CostCenterDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<CostCenterMaster> findAll()
	 {
		try{
			final String qu="select model from CostCenterMaster model ";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	 }
	
	public synchronized CostCenterMaster save(CostCenterMaster detail)
	 {
		try{
			CostCenterMaster enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public CostCenterMaster findId(String costCenterCode)
	 {
		try{
			CostCenterMaster sig= getEntityManager().find(CostCenterMaster.class, costCenterCode);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}
}
