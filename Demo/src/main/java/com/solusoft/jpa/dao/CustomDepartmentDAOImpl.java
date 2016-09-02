package com.solusoft.jpa.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.solusoft.jpa.entity.CustomDepartment;


@Component("customDepartmentDAO")
public class CustomDepartmentDAOImpl implements CustomDepartmentDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<CustomDepartment> findAll()
	 {
		try{
			final String qu="select model from CustomDepartment model where model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<CustomDepartment> findAlls(Integer id)
	 {
		try{
			final String qu="select model from CustomDepartment model where model.isactive=0 AND model.companyMaster.companyCode=:cid";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("cid", id);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<CustomDepartment> findAllInactive()
	 {
		try{
			final String qu="select model from CustomDepartment model where model.isactive=1";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
		
	}
	
	public synchronized Boolean delete(long id,String user)
	{
			boolean data=false;
			try{
				final String qu="UPDATE CustomDepartment model SET model.isactive=1,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
	
	public synchronized Boolean activeId(long id,String user)
	{
			boolean data=false;
			try{
				final String qu="UPDATE CustomDepartment model SET model.isactive=0,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
	
	public synchronized CustomDepartment save(CustomDepartment detail)
	 {
		try{
			CustomDepartment enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<CustomDepartment> findNameInactive(long id,String dname,String abb,Integer cids)
	 {
		try{
			final String qu="select model from CustomDepartment model where model.deptcode=:ids AND UPPER(model.deptname)=:dnames OR UPPER(model.deptabbreviation)=:dabb AND model.companyMaster.companyCode=:cid AND model.isactive=1 ";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("ids", id);
			query.setParameter("dnames", dname);
			query.setParameter("dabb", abb);
			query.setParameter("cid", cids);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<CustomDepartment> findNameActive(long id,String dname,String abb,Integer cids)
	 {
		try{
			final String qu="select model from CustomDepartment model where model.deptcode=:ids AND UPPER(model.deptname)=:dnames OR UPPER(model.deptabbreviation)=:dabb AND model.companyMaster.companyCode=:cid AND model.isactive=0 ";
			Query query=getEntityManager().createQuery(qu);
			query.setParameter("ids", id);
			query.setParameter("dnames", dname);
			query.setParameter("dabb", abb);
			query.setParameter("cid", cids);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public CustomDepartment findId(long id)
	 {
		try{
			CustomDepartment sig= getEntityManager().find(CustomDepartment.class, id);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}
}
