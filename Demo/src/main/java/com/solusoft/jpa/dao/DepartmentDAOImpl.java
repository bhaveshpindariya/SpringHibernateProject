package com.solusoft.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.solusoft.jpa.entity.DepartmentMaster;

@Component("departmentDAO")
public class DepartmentDAOImpl implements DepartmentDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<DepartmentMaster> findAll()
	 {
		try{
			final String qu="select model from DepartmentMaster model";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<DepartmentMaster> findAllCompany(Integer id)
	 {
		try{
			final String qu="select model from DepartmentMaster model WHERE model.companyMaster.companyCode=:cCode";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("cCode", id);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public DepartmentMaster findId(long id)
	 {
		try{
			DepartmentMaster sig= getEntityManager().find(DepartmentMaster.class, id);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public synchronized DepartmentMaster save(DepartmentMaster detail)
	 {
		try{
			DepartmentMaster enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
}
