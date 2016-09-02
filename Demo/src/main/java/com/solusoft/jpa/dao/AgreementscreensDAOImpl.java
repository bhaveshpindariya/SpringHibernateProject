package com.solusoft.jpa.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import com.solusoft.jpa.entity.AgreementScreens;



@Component("agreementscreensDAO")
public class AgreementscreensDAOImpl implements AgreementscreensDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<AgreementScreens> findalldata()
	 {
		try{
			final String qu="select model from AgreementScreens model";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public synchronized void delete(AgreementScreens entity){
		 try{
			 entity=getEntityManager().getReference(AgreementScreens.class, entity.getId());
			 getEntityManager().remove(entity);
			 getEntityManager().flush();
		}catch(RuntimeException e){
				throw e;
		}
	 }
	
	@SuppressWarnings("unchecked")
	public List<AgreementScreens> findactive()
	 {
		try{
			final String qu="select model from AgreementScreens model where model.isactive=0 ";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public AgreementScreens findId(Integer id)
	 {
		try{
			AgreementScreens sig= getEntityManager().find(AgreementScreens.class, id);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public synchronized Boolean activeId(Integer id,String user)
	{
			boolean data=false;
			try{
				final String qu="UPDATE AgreementScreens model SET model.isactive=0,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
	
	public synchronized Boolean delete(Integer id,String user)
	{
			boolean data=false;
			try{
				final String qu="UPDATE AgreementScreens model SET model.isactive=1,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
	
	@SuppressWarnings("unchecked")
	public List<AgreementScreens> findAllInactive()
	 {
		try{
			final String qu="select model from AgreementScreens model where model.isactive=1";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
		
	}
	
	public synchronized AgreementScreens savedata(AgreementScreens detail)
	 {
		try{
			AgreementScreens enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AgreementScreens> findNameActive(Integer aid,String vid,String viewname,String scrfor)
	 {
		try{
			final String qu="select model from AgreementScreens model where model.agreementTypeMaster.id=:agid AND UPPER(model.viewid)=:viewId AND UPPER(model.viewname)=:viewName AND UPPER(model.screenfor)=:scfor AND model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("agid", aid);
			query.setParameter("viewId", vid);
			query.setParameter("viewName", viewname);
			query.setParameter("scfor", scrfor);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AgreementScreens> findNameInactive(Integer aid,String vid,String viewname,String scrfor)
	 {
		try{
			final String qu="select model from AgreementScreens model where model.agreementTypeMaster.id=:agid AND UPPER(model.viewid)=:viewId AND UPPER(model.viewname)=:viewName AND UPPER(model.screenfor)=:scfor AND model.isactive=1";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("agid", aid);
			query.setParameter("viewId", vid);
			query.setParameter("viewName", viewname);
			query.setParameter("scfor", scrfor);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public synchronized AgreementScreens save(AgreementScreens detail)
	 {
		try{
			AgreementScreens enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	 }
	
}
