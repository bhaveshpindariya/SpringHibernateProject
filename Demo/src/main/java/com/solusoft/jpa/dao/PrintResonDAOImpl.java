package com.solusoft.jpa.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.solusoft.jpa.entity.PrintResonMaster;

@Component("printResonDAO")
public class PrintResonDAOImpl implements PrintResonDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<PrintResonMaster> findAllPM()
	 {
		try{
			final String qu="select model from PrintResonMaster model where model.module='PM' AND model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<PrintResonMaster> findAllLRF()
	 {
		try{
			final String qu="select model from PrintResonMaster model where model.module='LRF' AND model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<PrintResonMaster> findAllInactivePM()
	 {
		try{
			final String qu="select model from PrintResonMaster model where model.module='PM' AND model.isactive=1";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<PrintResonMaster> findAllInactiveLRF()
	 {
		try{
			final String qu="select model from PrintResonMaster model where model.module='LRF' AND model.isactive=1";
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
				final String qu="UPDATE PrintResonMaster model SET model.isactive=1,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
				final String qu="UPDATE PrintResonMaster model SET model.isactive=0,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
	
	public synchronized PrintResonMaster save(PrintResonMaster detail)
	 {
		try{
			PrintResonMaster enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<PrintResonMaster> findNameActive(String detail,String module)
	 {
		try{
			final String qu="select model from PrintResonMaster model where UPPER(model.detais)=:doName AND UPPER(model.module)=:mod AND model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("doName", detail);
			query.setParameter("mod", module);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<PrintResonMaster> findNameInactive(String detail,String module)
	 {
		try{
			final String qu="select model from PrintResonMaster model where UPPER(model.detais)=:doName AND UPPER(model.module)=:mod AND model.isactive=1";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("doName", detail);
			query.setParameter("mod", module);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public PrintResonMaster findId(Integer id)
	 {
		try{
			PrintResonMaster sig= getEntityManager().find(PrintResonMaster.class, id);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}
}
