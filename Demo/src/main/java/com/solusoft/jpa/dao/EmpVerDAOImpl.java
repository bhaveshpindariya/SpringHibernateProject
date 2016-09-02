package com.solusoft.jpa.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.solusoft.jpa.entity.EmpVerticalMaster;



@Component("empVerDAO")
public class EmpVerDAOImpl implements EmpVerDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<EmpVerticalMaster> findAll()
	 {
		try{
			final String qu="select model from EmpVerticalMaster model where model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public synchronized EmpVerticalMaster save(EmpVerticalMaster detail)
	 {
		try{
			EmpVerticalMaster enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public EmpVerticalMaster findId(Integer id)
	 {
		try{
			EmpVerticalMaster sig= getEntityManager().find(EmpVerticalMaster.class, id);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<EmpVerticalMaster> findNameActive(long eid,Integer vid,Integer aid)
	 {
		try{
			final String qu="select model from EmpVerticalMaster model where model.verticalMaster.id=:verid AND model.agreementTypeMaster.id=:ad AND model.employeeMaster.empid=:eids AND model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("ad", aid);
			query.setParameter("verid", vid);
			query.setParameter("eids", eid);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<EmpVerticalMaster> findNameInactive(long eid,Integer vid,Integer aid)
	 {
		try{
			final String qu="select model from EmpVerticalMaster model where model.verticalMaster.id=:verid AND model.agreementTypeMaster.id=:ad AND model.employeeMaster.empid=:eids AND model.isactive=1";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("ad", aid);
			query.setParameter("verid", vid);
			query.setParameter("eids", eid);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<EmpVerticalMaster> findAllInactive()
	 {
		try{
			final String qu="select model from EmpVerticalMaster model where model.isactive=1";
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
				final String qu="UPDATE EmpVerticalMaster model SET model.isactive=1,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
				final String qu="UPDATE EmpVerticalMaster model SET model.isactive=0,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
	
	public synchronized EmpVerticalMaster saves(EmpVerticalMaster detail)
	 {
		try{
			EmpVerticalMaster enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public EmpVerticalMaster finddata(long eid,Integer vid,Integer aid)
	 {
		try{
			final String qu="select model from EmpVerticalMaster model where model.verticalMaster.id=:verid AND model.agreementTypeMaster.id=:ad AND model.employeeMaster.empid=:eids";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("eids", eid);
			query.setParameter("verid", vid);
			query.setParameter("ad", aid);
			query.setHint("org.hibernate.cacheable", true);
			return (EmpVerticalMaster) query.getSingleResult();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	
}

