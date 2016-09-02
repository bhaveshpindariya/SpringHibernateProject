package com.solusoft.jpa.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.solusoft.jpa.entity.DocumentCompnydetail;

@Component("documentCompnyDAO")
public class DocumentCompnyDAOImpl implements DocumentCompnyDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<DocumentCompnydetail> findAll()
	 {
		try{
			final String qu="select model from DocumentCompnydetail model where model.isactive=0";
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
				final String qu="UPDATE DocumentCompnydetail model SET model.isactive=1,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
				final String qu="UPDATE DocumentCompnydetail model SET model.isactive=0,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
	
	public synchronized DocumentCompnydetail save(DocumentCompnydetail detail)
	 {
		try{
			DocumentCompnydetail enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public DocumentCompnydetail findId(Integer id)
	 {
		try{
			DocumentCompnydetail sig= getEntityManager().find(DocumentCompnydetail.class, id);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<DocumentCompnydetail> findNameActive(Integer detail,Integer ccode)
	 {
		try{
			final String qu="select model from DocumentCompnydetail model where model.documentid.id=:doName AND model.companyMaster.companyCode=:cid AND model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("doName", detail);
			query.setParameter("cid", ccode);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<DocumentCompnydetail> findNameInactive(Integer detail,Integer ccode)
	 {
		try{
			final String qu="select model from DocumentCompnydetail model where model.documentid.id=:doName AND model.companyMaster.companyCode=:cid AND model.isactive=1";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("doName", detail);
			query.setParameter("cid", ccode);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<DocumentCompnydetail> findAllInactive()
	 {
		try{
			final String qu="select model from DocumentCompnydetail model where model.isactive=1";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
		
	}
	
}
