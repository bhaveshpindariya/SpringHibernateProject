package com.solusoft.jpa.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.solusoft.jpa.entity.AgreementAttachments;



@Component("agreementAttachmentsDAO")
public class AgreementAttachmentsDAOImpl implements AgreementAttachmentsDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<AgreementAttachments> findactive()
	 {
		try{
			final String qu="select model from AgreementAttachments model where model.isactive=0 ";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public synchronized void delete(AgreementAttachments entity){
		 try{
			 entity=getEntityManager().getReference(AgreementAttachments.class, entity.getId());
			 getEntityManager().remove(entity);
			 getEntityManager().flush();
		 }catch(RuntimeException e){
				throw e;
		}
	 }
	
	@SuppressWarnings("unchecked")
	public List<AgreementAttachments> findalldata()
	 {
		try{
			final String qu="select model from AgreementAttachments model";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public AgreementAttachments findId(Integer id)
	 {
		try{
			AgreementAttachments sig= getEntityManager().find(AgreementAttachments.class, id);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AgreementAttachments> findAllInactive()
	 {
		try{
			final String qu="select model from AgreementAttachments model where model.isactive=1";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
		
	}
	
	public synchronized AgreementAttachments savedata(AgreementAttachments detail)
	 {
		try{
			AgreementAttachments enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public synchronized Boolean activeId(Integer id,String user)
	{
			boolean data=false;
			try{
				final String qu="UPDATE AgreementAttachments model SET model.isactive=0,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
				final String qu="UPDATE AgreementAttachments model SET model.isactive=1,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
	public List<AgreementAttachments> findNameActive(Integer aid,String docc,String doct,Boolean iatc,Boolean im,Boolean imd)
	 {
		try{
			if(doct !=null && doct!=""){
				final String qu="select model from AgreementAttachments model where model.agreementTypeMaster.id=:agid AND UPPER(model.docclass)=:doccla AND UPPER(model.doctype)=:doctypes AND model.mandadory=:ismand AND model.mandadorydom=:ismandd AND model.atclass=:agtc AND model.isactive=0";
				Query query=getEntityManager().createQuery(qu);
				query.setParameter("agid", aid);
				query.setParameter("doccla", docc);
				query.setParameter("doctypes", doct);
				query.setParameter("agtc", iatc);
				query.setParameter("ismand", im);
				query.setParameter("ismandd", imd);
				query.setHint("org.hibernate.cacheable", true);
				return query.getResultList();
			}else{
				final String qu="select model from AgreementAttachments model where model.agreementTypeMaster.id=:agid AND UPPER(model.docclass)=:doccla AND model.doctype IS NULL AND model.mandadory=:ismand AND model.mandadorydom=:ismandd AND model.atclass=:agtc AND model.isactive=0";
				Query query=getEntityManager().createQuery(qu);
				query.setParameter("agid", aid);
				query.setParameter("doccla", docc);
				query.setParameter("agtc", iatc);
				query.setParameter("ismand", im);
				query.setParameter("ismandd", imd);
				query.setHint("org.hibernate.cacheable", true);
				return query.getResultList();
			}
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AgreementAttachments> findNameInactive(Integer aid,String docc,String doct,Boolean iatc,Boolean im,Boolean imd)
	 {
		try{
			if(doct !=null && doct!=""){
				final String qu="select model from AgreementAttachments model where model.agreementTypeMaster.id=:agid AND UPPER(model.docclass)=:doccla AND UPPER(model.doctype)=:doctypes AND model.mandadory=:ismand AND model.mandadorydom=:ismandd AND model.atclass=:agtc AND model.isactive=1";
				Query query=getEntityManager().createQuery(qu);
				query.setParameter("agid", aid);
				query.setParameter("doccla", docc);
				query.setParameter("doctypes", doct);
				query.setParameter("agtc", iatc);
				query.setParameter("ismand", im);
				query.setParameter("ismandd", imd);
				query.setHint("org.hibernate.cacheable", true);
				return query.getResultList();
			}else{
				final String qu="select model from AgreementAttachments model where model.agreementTypeMaster.id=:agid AND UPPER(model.docclass)=:doccla AND model.doctype IS NULL AND model.mandadory=:ismand AND model.mandadorydom=:ismandd AND model.atclass=:agtc AND model.isactive=1";
				Query query=getEntityManager().createQuery(qu);
				query.setParameter("agid", aid);
				query.setParameter("doccla", docc);
				query.setParameter("agtc", iatc);
				query.setParameter("ismand", im);
				query.setParameter("ismandd", imd);
				query.setHint("org.hibernate.cacheable", true);
				return query.getResultList();
			}
		}catch(RuntimeException e){
			throw e;
		}
	}
	
}
