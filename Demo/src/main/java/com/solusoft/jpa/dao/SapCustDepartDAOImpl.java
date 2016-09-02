
package com.solusoft.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.solusoft.jpa.entity.SapCustDepartMapping;



@Component("sapCustDepartDAO")
public class SapCustDepartDAOImpl implements SapCustDepartDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<SapCustDepartMapping> findAll()
	 {
		try{
			final String qu="select model from SapCustDepartMapping model where model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public synchronized Boolean update(Integer id)
	{
			boolean data=false;
			try{
				final String qu="UPDATE SapCustDepartMapping model SET model.isactive=1 WHERE model.id=:prid";
				Query query=getEntityManager().createQuery(qu);
				query.setParameter("prid", id);
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
	
	public synchronized SapCustDepartMapping save(SapCustDepartMapping detail)
	 {
		try{
			SapCustDepartMapping enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public SapCustDepartMapping findId(Integer id)
	 {
		try{
			SapCustDepartMapping sig= getEntityManager().find(SapCustDepartMapping.class, id);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SapCustDepartMapping> findNameActive(long department,long custDepartment,Integer vid,Integer sid)
	 {
		
		try{
			if(vid !=0){
				final String qu="select model from SapCustDepartMapping model where model.departmentMaster.deptcode=:depart AND"+
	                    " model.customDepartment.deptcode=:custdepart AND model.verticalMaster.id=:vcode AND model.siteMaster.id=:scode AND model.isactive=0";
				Query query=getEntityManager().createQuery(qu);
				query.setParameter("depart", department);
				query.setParameter("custdepart", custDepartment);
				query.setParameter("vcode", vid);
				query.setParameter("scode", sid);
				query.setHint("org.hibernate.cacheable", true);
				return query.getResultList();
			}else{
				final String qu="select model from SapCustDepartMapping model where model.departmentMaster.deptcode=:depart AND"+
	                    " model.customDepartment.deptcode=:custdepart AND model.siteMaster.id=:scode AND model.verticalMaster IS NULL AND model.isactive=0";
				Query query=getEntityManager().createQuery(qu);
				query.setParameter("depart", department);
				query.setParameter("custdepart", custDepartment);
				query.setParameter("scode", sid);
				query.setHint("org.hibernate.cacheable", true);
				return query.getResultList();
			}
			
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public SapCustDepartMapping finddetail(long department,long custDepartment,Integer vid,Integer sid)
	 {
		
		try{
			if(vid !=0){
				final String qu="select model from SapCustDepartMapping model where model.departmentMaster.deptcode=:depart AND"+
	                    " model.customDepartment.deptcode=:custdepart AND model.verticalMaster.id=:vcode AND model.siteMaster.id=:scode AND model.isactive=0";
				Query query=getEntityManager().createQuery(qu);
				query.setParameter("depart", department);
				query.setParameter("custdepart", custDepartment);
				query.setParameter("vcode", vid);
				query.setParameter("scode", sid);
				query.setHint("org.hibernate.cacheable", true);
				return (SapCustDepartMapping) query.getSingleResult();
			}else{
				final String qu="select model from SapCustDepartMapping model where model.departmentMaster.deptcode=:depart AND"+
	                    " model.customDepartment.deptcode=:custdepart AND model.siteMaster.id=:scode AND model.verticalMaster IS NULL AND model.isactive=0";
				Query query=getEntityManager().createQuery(qu);
				query.setParameter("depart", department);
				query.setParameter("custdepart", custDepartment);
				query.setParameter("scode", sid);
				return (SapCustDepartMapping) query.getSingleResult();
			}
			
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SapCustDepartMapping> findNameInactive(long department,long custDepartment,Integer vid,Integer sid)
	 {
		
		try{
			if(vid !=0){
				final String qu="select model from SapCustDepartMapping model where model.departmentMaster.deptcode=:depart AND"+
	                    " model.customDepartment.deptcode=:custdepart AND model.verticalMaster.id=:vcode AND model.siteMaster.id=:scode AND model.isactive=1";
				Query query=getEntityManager().createQuery(qu);
				query.setParameter("depart", department);
				query.setParameter("custdepart", custDepartment);
				query.setParameter("vcode", vid);
				query.setParameter("scode", sid);
				query.setHint("org.hibernate.cacheable", true);
				return query.getResultList();
			}else{
				final String qu="select model from SapCustDepartMapping model where model.departmentMaster.deptcode=:depart AND"+
	                    " model.customDepartment.deptcode=:custdepart AND model.siteMaster.id=:scode AND model.verticalMaster IS NULL AND model.isactive=1";
				Query query=getEntityManager().createQuery(qu);
				query.setParameter("depart", department);
				query.setParameter("custdepart", custDepartment);
				query.setParameter("scode", sid);
				query.setHint("org.hibernate.cacheable", true);
				return query.getResultList();
			}
			
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SapCustDepartMapping> findAllInactive()
	 {
		try{
			final String qu="select model from SapCustDepartMapping model where model.isactive=1";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
		
	}
	
	public synchronized Boolean activeId(Integer id)
	{
			boolean data=false;
			try{
				final String qu="UPDATE SapCustDepartMapping model SET model.isactive=0 WHERE model.id=:prid";
				Query query=getEntityManager().createQuery(qu);
				query.setParameter("prid", id);
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

