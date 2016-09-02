package com.solusoft.jpa.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.solusoft.jpa.entity.AgreementTypeMaster;
import com.solusoft.jpa.entity.CompanyMaster;

@Component("agreementTypeDAO")
public class AgreementTypeDAOImpl implements AgreementTypeDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<AgreementTypeMaster> findAgreementType(String agtype)
	 {
		try{
			final String qu="select model from AgreementTypeMaster model where UPPER(model.agreementtype)=:anames";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("anames", agtype);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<AgreementTypeMaster> findAll()
	 {
		try{
			final String qu="select model from AgreementTypeMaster model";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<AgreementTypeMaster> findAllByCompany(Integer name)
	 {
		try{
			final String qu="select model from AgreementTypeMaster model where model.isactive=0 and model.companyMaster.companyCode=:code";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("code", name);
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
				final String qu="UPDATE AgreementTypeMaster model SET model.isactive=1,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
	
     public synchronized AgreementTypeMaster save(AgreementTypeMaster detail)
	 {
		try{
			AgreementTypeMaster enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	 }
	
	@SuppressWarnings("unchecked")
	public List<AgreementTypeMaster> findNameActive(String name,Integer cid)
	 {
		try{
			final String qu="select model from AgreementTypeMaster model where UPPER(model.agreementtype)=:anames AND model.companyMaster.companyCode=:cids AND model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("anames", name);
			query.setParameter("cids", cid);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AgreementTypeMaster> findNameInactive(String name,Integer cid)
	 {
		try{
			final String qu="select model from AgreementTypeMaster model where UPPER(model.agreementtype)=:anames AND model.companyMaster.companyCode=:cids AND model.isactive=1";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("anames", name);
			query.setParameter("cids", cid);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public AgreementTypeMaster findId(Integer id)
	 {
		try{
			AgreementTypeMaster sig= getEntityManager().find(AgreementTypeMaster.class, id);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<AgreementTypeMaster> findAllInactive()
	 {
		try{
			final String qu="select model from AgreementTypeMaster model where model.isactive=1";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
		
	}
	
	public synchronized Boolean activeId(Integer id,String user)
	{
			boolean data=false;
			try{
				final String qu="UPDATE AgreementTypeMaster model SET model.isactive=0,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
	
	public AgreementTypeMaster finddetail(CompanyMaster cname,String name)
	 {
		try{
			final String qu="select model from AgreementTypeMaster model where model.agreementtype=:anames AND model.companyMaster=:coname";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("anames", name);
			query.setParameter("coname", cname);
			query.setHint("org.hibernate.cacheable", true);
			return (AgreementTypeMaster) query.getSingleResult();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public synchronized AgreementTypeMaster saves(AgreementTypeMaster detail)
	 {
		try{
			AgreementTypeMaster enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
}
