package com.solusoft.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import com.solusoft.jpa.entity.ProjectMaster;

@Component("projectDAO")
public class ProjectDAOImpl implements ProjectDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProjectMaster> findAll()
	 {
		try{
			final String qu="select model from ProjectMaster model";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public ProjectMaster findId(long id)
	 {
		try{
			ProjectMaster sig= getEntityManager().find(ProjectMaster.class, id);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public synchronized ProjectMaster save(ProjectMaster detail)
	 {
		try{
			ProjectMaster enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
}
