package com.solusoft.jpa.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.solusoft.jpa.entity.BRLGroup;


@Component("bRLGroupDAO")
public class BRLGroupDAOImpl implements BRLGroupDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<BRLGroup> findAll()
	 {
		try{
			final String qu="select model from BRLGroup model where model.isactive=0 ";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<BRLGroup> findAllInactive()
	 {
		try{
			final String qu="select model from BRLGroup model where model.isactive=1";
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
				final String qu="UPDATE BRLGroup model SET model.isactive=1,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
				final String qu="UPDATE BRLGroup model SET model.isactive=0,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
	
	public synchronized BRLGroup save(BRLGroup detail)
	 {
		
		try{
			BRLGroup enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
		
	public BRLGroup findId(Integer id)
	 {
		try{
			BRLGroup sig= getEntityManager().find(BRLGroup.class, id);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}
		
	@SuppressWarnings("unchecked")
	public List<BRLGroup> findNameInactive(String name,String abbreva)
	 {
		try{
			final String qu="select model from BRLGroup model where UPPER(model.groupname)=:brlname OR UPPER(model.abbreviation)=:brlabbre AND model.isactive=1";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("brlname", name);
			query.setParameter("brlabbre", abbreva);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<BRLGroup> findNameActive(String name,String abbreva)
	 {
		try{
			final String qu="select model from BRLGroup model where UPPER(model.groupname)=:brlname OR UPPER(model.abbreviation)=:brlabbre AND model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("brlname", name);
			query.setParameter("brlabbre", abbreva);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
}
