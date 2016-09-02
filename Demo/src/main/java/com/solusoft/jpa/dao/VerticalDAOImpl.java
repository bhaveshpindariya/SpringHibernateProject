package com.solusoft.jpa.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.solusoft.jpa.entity.VerticalMaster;

@Component("verticalDAO")
public class VerticalDAOImpl implements VerticalDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<VerticalMaster> findAll()
	 {
		try{
			final String qu="select model from VerticalMaster model where model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public synchronized VerticalMaster saveVer(VerticalMaster detail)
	 {
		try{
			VerticalMaster enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<VerticalMaster> findNameInactive(String detail,String ab)
	 {
		try{
			final String qu="select model from VerticalMaster model where UPPER(model.vname)=:doName OR UPPER(model.verabbreviation)=:abber AND model.isactive=1";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("doName", detail);
			query.setParameter("abber", ab);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<VerticalMaster> findNameActive(String detail,String ab)
	 {
		try{
			final String qu="select model from VerticalMaster model where UPPER(model.vname)=:doName OR UPPER(model.verabbreviation)=:abber AND model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("doName", detail);
			query.setParameter("abber", ab);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public VerticalMaster findId(Integer id)
	 {
		try{
			VerticalMaster sig= getEntityManager().find(VerticalMaster.class, id);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public synchronized VerticalMaster save(VerticalMaster detail)
	 {
		try{
			VerticalMaster enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<VerticalMaster> findAllInactive()
	 {
		try{
			final String qu="select model from VerticalMaster model where model.isactive=1";
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
				final String qu="UPDATE VerticalMaster model SET model.isactive=1,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
				final String qu="UPDATE VerticalMaster model SET model.isactive=0,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
	
	public VerticalMaster findName(String name)
	 {
		try{
			final String qu="select model from VerticalMaster model where UPPER(model.vname)=:names";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("names", name);
			query.setHint("org.hibernate.cacheable", true);
			return (VerticalMaster) query.getSingleResult();
		}catch(RuntimeException e){
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<VerticalMaster> findNames(String name,String abs)
	 {
		try{
			final String qu="select model from VerticalMaster model where UPPER(model.vname)=:names AND UPPER(model.verabbreviation)=:ab";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("names", name);
			query.setParameter("ab", abs);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
}
