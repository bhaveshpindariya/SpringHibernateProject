package com.solusoft.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import com.solusoft.jpa.entity.EmployeeMaster;

@Component("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<EmployeeMaster> findAll()
	 {
		try{
			final String qu="select model from EmployeeMaster model";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<EmployeeMaster> findAlls(Integer ccode)
	 {
		try{
			final String qu="select model from EmployeeMaster model where model.companycode.companyCode=:cId";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			query.setParameter("cId", ccode);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public EmployeeMaster findId(long id)
	 {
		try{
			EmployeeMaster sig= getEntityManager().find(EmployeeMaster.class, id);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public synchronized EmployeeMaster save(EmployeeMaster detail)
	 {
		try{
			EmployeeMaster enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public EmployeeMaster findName(String name)
	 {
		try{
			final String qu="select model from EmployeeMaster model where UPPER(model.alias)=:names";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("names", name);
			query.setHint("org.hibernate.cacheable", true);
			return (EmployeeMaster) query.getSingleResult();
		}catch(RuntimeException e){
			throw e;
		}
	}
}
