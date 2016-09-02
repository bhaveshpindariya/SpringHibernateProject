package com.solusoft.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import com.solusoft.jpa.entity.RoleManagement;



@Component("roleDAO")
public class RoleDAOImpl implements RoleDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<RoleManagement> findall()
	 {
		try{
			final String qu="select model from RoleManagement model";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	 public List<RoleManagement> findRole(String role){
		{
			try{
				final String qu="select model from RoleManagement model where model.rolename=:roledata";
				Query query=getEntityManager().createQuery(qu);
				query.setParameter("roledata", role);
				query.setHint("org.hibernate.cacheable", true);
				return query.getResultList();
			}catch(RuntimeException e){
				throw e;
			}
			
		} 
	 }
	
	public synchronized RoleManagement save(RoleManagement detail)
	 {
		try{
			RoleManagement enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public RoleManagement findid(Integer id)
	 {
		try{
			RoleManagement sig= getEntityManager().find(RoleManagement.class, id);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
}
