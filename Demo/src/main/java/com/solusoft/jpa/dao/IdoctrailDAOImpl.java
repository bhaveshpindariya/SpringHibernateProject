package com.solusoft.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import com.solusoft.jpa.entity.Idoctrail;


@Component("idoctrailDAO")
public class IdoctrailDAOImpl implements IdoctrailDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<Idoctrail> findAll()
	 {
		try{
			final String qu="select model from Idoctrail model ";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public Idoctrail findId(long id)
	 {
		try{
			Idoctrail sig= getEntityManager().find(Idoctrail.class, id);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public synchronized Idoctrail save(Idoctrail detail)
	 {
		try{
			Idoctrail enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public synchronized void delete(Idoctrail detail)
	 {
		try{
			detail=getEntityManager().getReference(Idoctrail.class, detail.getId());
			getEntityManager().remove(detail);
			getEntityManager().flush();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	
}
