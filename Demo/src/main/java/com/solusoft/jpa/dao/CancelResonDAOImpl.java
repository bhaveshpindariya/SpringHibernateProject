package com.solusoft.jpa.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.solusoft.jpa.entity.CancelResonMaster;

@Component("cancelResonDAO")
public class CancelResonDAOImpl implements CancelResonDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<CancelResonMaster> findAllPM()
	 {
		try{
			final String qu="select model from CancelResonMaster model where model.module='PM' AND model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<CancelResonMaster> findAllLRF()
	 {
		try{
			final String qu="select model from CancelResonMaster model where model.module='LRF' AND model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<CancelResonMaster> findAllInactivePM()
	 {
		try{
			final String qu="select model from CancelResonMaster model where model.module='PM' AND model.isactive=1";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<CancelResonMaster> findAllInactiveLRF()
	 {
		try{
			final String qu="select model from CancelResonMaster model where model.module='LRF' AND model.isactive=1";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
		
	}
	
	public synchronized Boolean delete(Integer id,String user)
	{
			boolean data=false;
			try{
				final String qu="UPDATE CancelResonMaster model SET model.isactive=1,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
				Query query=getEntityManager().createQuery(qu);
				query.setParameter("prid", id);
				query.setParameter("username", user);
				query.setParameter("date", new Timestamp(new Date().getTime()));
				int updateCount = query.executeUpdate();
				if (updateCount > 0) {
					data=true;
					return data;
				}else{
					return data;
				}
			}catch(RuntimeException e){
				throw e;
			}
    } 
	
	public synchronized Boolean activeId(Integer id,String user)
	{
			boolean data=false;
			try{
				final String qu="UPDATE CancelResonMaster model SET model.isactive=0,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
				Query query=getEntityManager().createQuery(qu);
				query.setParameter("prid", id);
				query.setParameter("username", user);
				query.setParameter("date", new Timestamp(new Date().getTime()));
				int updateCount = query.executeUpdate();
				if (updateCount > 0) {
					data=true;
					return data;
				}else{
					return data;
				}
			}catch(RuntimeException e){
				throw e;
			}
    }
	
	public synchronized CancelResonMaster save(CancelResonMaster detail)
	 {
		try{
			CancelResonMaster enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<CancelResonMaster> findNameActive(String detail,String mod)
	 {
		try{
			final String qu="select model from CancelResonMaster model where UPPER(model.detais)=:doName AND model.module=:mode AND model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("doName", detail);
			query.setParameter("mode", mod);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<CancelResonMaster> findNameInactive(String detail,String mod)
	 {
		try{
			final String qu="select model from CancelResonMaster model where UPPER(model.detais)=:doName AND model.module=:mode AND model.isactive=1";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("doName", detail);
			query.setParameter("mode", mod);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public CancelResonMaster findId(Integer id)
	 {
		try{
			CancelResonMaster sig= getEntityManager().find(CancelResonMaster.class, id);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}
}
