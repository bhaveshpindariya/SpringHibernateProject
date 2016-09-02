package com.solusoft.jpa.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.solusoft.jpa.entity.SingReasMaster;

@Component("singReasDAO")
public class SingReasDAOImpl implements SingReasDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<SingReasMaster> findAll()
	 {
		try{
			final String qu="select model from SingReasMaster model where model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public synchronized SingReasMaster save(SingReasMaster detail)
	 {
		try{
			SingReasMaster enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SingReasMaster> findNameActive(String detail,Integer srole)
	 {
		try{
			final String qu="select model from SingReasMaster model where UPPER(model.detais)=:doName and model.singRole.id=:srId AND model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("doName", detail);
			query.setParameter("srId", srole);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SingReasMaster> findNameInactive(String detail,Integer srole)
	 {
		try{
			final String qu="select model from SingReasMaster model where UPPER(model.detais)=:doName and model.singRole.id=:srId AND model.isactive=1";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("doName", detail);
			query.setParameter("srId", srole);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public SingReasMaster findId(Integer id)
	 {
		try{
			SingReasMaster sig= getEntityManager().find(SingReasMaster.class, id);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SingReasMaster> findAllInactive()
	 {
		try{
			final String qu="select model from SingReasMaster model where model.isactive=1";
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
				final String qu="UPDATE SingReasMaster model SET model.isactive=1,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
				final String qu="UPDATE SingReasMaster model SET model.isactive=0,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
