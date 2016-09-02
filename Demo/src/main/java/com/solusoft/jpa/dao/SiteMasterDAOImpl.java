package com.solusoft.jpa.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.solusoft.jpa.entity.CompanyMaster;
import com.solusoft.jpa.entity.SiteMaster;

@Component("siteMasterDAO")
public class SiteMasterDAOImpl implements SiteMasterDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<SiteMaster> findAll()
	 {
		try{
			final String qu="select model from SiteMaster model where model.isactive=0 ";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SiteMaster> findAlls(Integer ccode)
	 {
		try{
			final String qu="select model from SiteMaster model where model.companyMaster.companyCode=:com AND model.isactive=0 ";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("com", ccode);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public synchronized SiteMaster save(SiteMaster detail)
	 {
		try{
			SiteMaster enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SiteMaster> findNameActive(String detail,String salias,String sabb,String sadd,Integer ccode)
	 {
		try{
			final String qu="select model from SiteMaster model where UPPER(model.saliens)=:alias AND model.companyMaster.companyCode=:comcode AND UPPER(model.sname)=:name AND UPPER(model.sabbra)=:abree AND UPPER(model.saddress)=:sadds AND model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("name", detail);
			query.setParameter("alias", salias);
			query.setParameter("abree", sabb);
			query.setParameter("sadds", sadd);
			query.setParameter("comcode", ccode);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SiteMaster> findNameInactive(String detail,String salias,String sabb,String sadd,Integer ccode)
	 {
		try{
			final String qu="select model from SiteMaster model where UPPER(model.saliens)=:alias AND model.companyMaster.companyCode=:comcode AND UPPER(model.sname)=:name AND UPPER(model.sabbra)=:abree AND UPPER(model.saddress)=:sadds AND model.isactive=1";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("name", detail);
			query.setParameter("alias", salias);
			query.setParameter("abree", sabb);
			query.setParameter("sadds", sadd);
			query.setParameter("comcode", ccode);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SiteMaster> finddetail(String sname,String salians,String sabbra,String sadd,CompanyMaster co)
	 {
		try{
			final String qu="select model from SiteMaster model where UPPER(model.saliens)=:alias AND model.companyMaster=:comcode AND UPPER(model.sname)=:name AND UPPER(model.sabbra)=:abree AND UPPER(model.saddress)=:sadds";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("name", sname);
			query.setParameter("alias", salians);
			query.setParameter("abree", sabbra);
			query.setParameter("sadds", sadd);
			query.setParameter("comcode", co);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public SiteMaster finddetails(String sname,CompanyMaster co)
	 {
		try{
			final String qu="select model from SiteMaster model where model.companyMaster=:comcode AND UPPER(model.sname)=:name ";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("name", sname);
			query.setParameter("comcode", co);
			query.setHint("org.hibernate.cacheable", true);
			return (SiteMaster) query.getSingleResult();
		}catch(RuntimeException e){
			throw e;
		}
	}
	public SiteMaster findId(Integer id)
	 {
		try{
			SiteMaster sig= getEntityManager().find(SiteMaster.class, id);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SiteMaster> findAllInactive()
	 {
		try{
			final String qu="select model from SiteMaster model where model.isactive=1";
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
				final String qu="UPDATE SiteMaster model SET model.isactive=1,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
				final String qu="UPDATE SiteMaster model SET model.isactive=0,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
