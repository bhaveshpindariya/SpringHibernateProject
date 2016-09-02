
package com.solusoft.jpa.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import com.solusoft.jpa.entity.VerticalFinanceManager;



@Component("verFinaManagerDAO")
public class VerFinaManagerDAOImpl implements VerFinaManagerDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<VerticalFinanceManager> findAll()
	 {
		try{
			final String qu="select model from VerticalFinanceManager model where model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public synchronized VerticalFinanceManager save(VerticalFinanceManager detail)
	 {
		try{
			VerticalFinanceManager enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public VerticalFinanceManager findId(Integer id)
	 {
		try{
			VerticalFinanceManager sig= getEntityManager().find(VerticalFinanceManager.class, id);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<VerticalFinanceManager> findNameInactive(long eid,Integer vid,Integer aid)
	 {
		try{
			final String qu="select model from VerticalFinanceManager model where model.verticalMaster.id=:verid AND model.employeeMaster.empid=:eids AND model.agreementTypeMaster.id=:ad AND model.isactive=1";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("eids", eid);
			query.setParameter("verid", vid);
			query.setParameter("ad", aid);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<VerticalFinanceManager> findNameActive(long eid,Integer vid,Integer aid)
	 {
		try{
			final String qu="select model from VerticalFinanceManager model where model.verticalMaster.id=:verid AND model.employeeMaster.empid=:eids AND model.agreementTypeMaster.id=:ad AND model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("eids", eid);
			query.setParameter("verid", vid);
			query.setParameter("ad", aid);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<VerticalFinanceManager> findAllInactive()
	 {
		try{
			final String qu="select model from VerticalFinanceManager model where model.isactive=1";
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
				final String qu="UPDATE VerticalFinanceManager model SET model.isactive=1,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
				final String qu="UPDATE VerticalFinanceManager model SET model.isactive=0,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
	
	public synchronized VerticalFinanceManager saves(VerticalFinanceManager detail)
	 {
		try{
			VerticalFinanceManager enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public VerticalFinanceManager finddata(long eid,Integer vid,Integer aid)
	 {
		try{
			final String qu="select model from VerticalFinanceManager model where model.verticalMaster.id=:verid AND model.employeeMaster.empid=:eids AND model.agreementTypeMaster.id=:ad";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("eids", eid);
			query.setParameter("verid", vid);
			query.setParameter("ad", aid);
			query.setHint("org.hibernate.cacheable", true);
			return (VerticalFinanceManager) query.getSingleResult();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
}

