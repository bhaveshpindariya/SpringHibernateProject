package com.solusoft.jpa.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.solusoft.jpa.entity.VerticalCompanyMaster;



@Component("verticalCompanyMasterDAO")
public class VerticalCompanyMasterDAOImpl implements VerticalCompanyMasterDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<VerticalCompanyMaster> findAll()
	 {
		try{
			final String qu="select model from VerticalCompanyMaster model where model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public synchronized VerticalCompanyMaster save(VerticalCompanyMaster detail)
	 {
		try{
			VerticalCompanyMaster enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public VerticalCompanyMaster findId(Integer id)
	 {
		try{
			VerticalCompanyMaster sig= getEntityManager().find(VerticalCompanyMaster.class, id);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<VerticalCompanyMaster> findNameActive(Integer vid,Integer cid)
	 {
		try{
			final String qu="select model from VerticalCompanyMaster model where model.verticalMaster.id=:verid AND model.companyMaster.companyCode=:ccode AND model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("verid", vid);
			query.setParameter("ccode", cid);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<VerticalCompanyMaster> findNameInactive(Integer vid,Integer cid)
	 {
		try{
			final String qu="select model from VerticalCompanyMaster model where model.verticalMaster.id=:verid AND model.companyMaster.companyCode=:ccode AND model.isactive=1";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("verid", vid);
			query.setParameter("ccode", cid);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<VerticalCompanyMaster> findAllInactive()
	 {
		try{
			final String qu="select model from VerticalCompanyMaster model where model.isactive=1";
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
				final String qu="UPDATE VerticalCompanyMaster model SET model.isactive=1,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
				final String qu="UPDATE VerticalCompanyMaster model SET model.isactive=0,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
	
	public synchronized VerticalCompanyMaster saves(VerticalCompanyMaster detail)
	 {
		try{
			VerticalCompanyMaster enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<VerticalCompanyMaster> finddata(Integer vid,Integer cid)
	 {
		try{
			final String qu="select model from VerticalCompanyMaster model where model.verticalMaster.id=:verid AND model.companyMaster.companyCode=:ccode";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("verid", vid);
			query.setParameter("ccode", cid);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	
}

