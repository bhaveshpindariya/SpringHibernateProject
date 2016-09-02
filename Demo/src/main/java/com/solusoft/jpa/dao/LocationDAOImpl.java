package com.solusoft.jpa.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.solusoft.jpa.entity.LocationMaster;


@Component("locationDAO")
public class LocationDAOImpl implements LocationDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<LocationMaster> findAll()
	 {
		try{
			final String qu="select model from LocationMaster model where model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public synchronized LocationMaster save(LocationMaster detail)
	 {
		try{
			LocationMaster enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<LocationMaster> findNameActive(String detail,String code)
	 {
		try{
			final String qu="select model from LocationMaster model where UPPER(model.name)=:nam OR UPPER(model.code)=:cod AND model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("nam", detail);
			query.setParameter("cod", code);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<LocationMaster> findNameInactive(String detail,String code)
	 {
		try{
			final String qu="select model from LocationMaster model where UPPER(model.name)=:nam OR UPPER(model.code)=:cod AND model.isactive=1";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("nam", detail);
			query.setParameter("cod", code);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
		
	public LocationMaster findId(Integer id)
	 {
		try{
			LocationMaster sig= getEntityManager().find(LocationMaster.class, id);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<LocationMaster> findAllInactive()
	 {
		try{
			final String qu="select model from LocationMaster model where model.isactive=1";
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
				final String qu="UPDATE LocationMaster model SET model.isactive=1,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
				final String qu="UPDATE LocationMaster model SET model.isactive=0,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
	
}
