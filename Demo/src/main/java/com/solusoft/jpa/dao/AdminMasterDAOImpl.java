package com.solusoft.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.solusoft.jpa.entity.AdminMaster;

@Component("adminMasterDAO")
public class AdminMasterDAOImpl implements AdminMasterDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<AdminMaster> findByPropertys(String username,String pass){
			
		try{
			final String qu="select model from AdminMaster model where model.username=:use and model.password=:par";
			 Query query=getEntityManager().createQuery(qu);
			 query.setParameter("use", username);
			 query.setParameter("par", pass);
			 query.setHint("org.hibernate.cacheable", true);
			 return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AdminMaster> findByProperty(String propertyName){
		try{	
			final String qu="select model from AdminMaster model where UPPER(model.username)=:use";
			 Query query=getEntityManager().createQuery(qu);
			 query.setParameter("use", propertyName);
			 query.setHint("org.hibernate.cacheable", true);
			 return query.getResultList();
		}catch(RuntimeException e){
			e.printStackTrace();
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AdminMaster> findalls(String role){
		try{
			final String qu="select model from AdminMaster model where model.roleManagement.rolename=:rolesname";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("rolesname", role);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AdminMaster> findall(){
		try{
			final String qu="select model from AdminMaster model";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AdminMaster> finddata(Integer role,String user){
		try{
			final String qu="select model from AdminMaster model where model.roleManagement.id=:rolesnames OR UPPER(model.username)=:userNa";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("rolesnames", role);
			query.setParameter("userNa", user);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AdminMaster> validateuser(AdminMaster entity){
		
		try{
			 final String qu="select model from AdminMaster model where model.username=:use and model.password=:pas";
			 Query query=getEntityManager().createQuery(qu);
			 query.setParameter("use", entity.getUsername());
			 query.setParameter("pas", entity.getPassword());
			 query.setHint("org.hibernate.cacheable", true);
			 return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public AdminMaster findId(Integer id)
	 {
		try{
			AdminMaster sig= getEntityManager().find(AdminMaster.class, id);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	 public synchronized boolean delete(AdminMaster entity){
		 try{
			 entity=getEntityManager().getReference(AdminMaster.class, entity.getId());
			 getEntityManager().remove(entity);
			 getEntityManager().flush();
			 return true;
		 }catch(RuntimeException e){
				throw e;
		}
	 }
	 
	 public synchronized AdminMaster save(AdminMaster detail)
	 {
		try{
			AdminMaster enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
}
