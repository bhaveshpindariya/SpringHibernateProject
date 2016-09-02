
package com.solusoft.jpa.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import com.solusoft.jpa.entity.EmpSiteVer;



@Component("empSiteVerDAO")
public class EmpSiteVerDAOImpl implements EmpSiteVerDAO { 

    @PersistenceContext
	private EntityManager entityManager;
	
	private EntityManager getEntityManager(){
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<EmpSiteVer> findAll()
	 {
		try{
			final String qu="select model from EmpSiteVer model where model.isactive=0";
			Query query=getEntityManager().createQuery(qu);
			query.setHint("org.hibernate.cacheable", true);
			return query.getResultList();
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public synchronized EmpSiteVer save(EmpSiteVer detail)
	 {
		try{
			EmpSiteVer enti=getEntityManager().merge(detail);
			getEntityManager().flush();
			return enti;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public EmpSiteVer findId(Integer id)
	 {
		try{
			EmpSiteVer sig= getEntityManager().find(EmpSiteVer.class, id);
			return sig;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<EmpSiteVer> findNameInactive(Integer sitId,long empId,Integer verId)
	 {
		try{
			if(verId !=0){
				final String qu="select model from EmpSiteVer model where model.employeeMaster.empid=:eid OR model.siteMaster.id=:sid AND model.verticalMaster.id=:vid AND model.isactive=1";
				Query query=getEntityManager().createQuery(qu);
				query.setParameter("sid", sitId);
				query.setParameter("eid", empId);
				query.setParameter("vid", verId);
				query.setHint("org.hibernate.cacheable", true);
				return query.getResultList();
			}else{
				final String qu="select model from EmpSiteVer model where model.employeeMaster.empid=:eid OR model.siteMaster.id=:sid AND model.verticalMaster IS NULL AND model.isactive=1";
				Query query=getEntityManager().createQuery(qu);
				query.setParameter("sid", sitId);
				query.setParameter("eid", empId);
				query.setHint("org.hibernate.cacheable", true);
				return query.getResultList();
			}
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<EmpSiteVer> findNameActive(Integer sitId,long empId,Integer verId)
	 {
		try{
			if(verId !=0){
				final String qu="select model from EmpSiteVer model where model.employeeMaster.empid=:eid OR model.siteMaster.id=:sid AND model.verticalMaster.id=:vid AND model.isactive=0";
				Query query=getEntityManager().createQuery(qu);
				query.setParameter("sid", sitId);
				query.setParameter("eid", empId);
				query.setParameter("vid", verId);
				query.setHint("org.hibernate.cacheable", true);
				return query.getResultList();
			}else{
				final String qu="select model from EmpSiteVer model where model.employeeMaster.empid=:eid OR model.siteMaster.id=:sid AND model.verticalMaster IS NULL AND model.isactive=0";
				Query query=getEntityManager().createQuery(qu);
				query.setParameter("sid", sitId);
				query.setParameter("eid", empId);
				query.setHint("org.hibernate.cacheable", true);
				return query.getResultList();
			}
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<EmpSiteVer> findAllInactive()
	 {
		try{
			final String qu="select model from EmpSiteVer model where model.isactive=1";
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
				final String qu="UPDATE EmpSiteVer model SET model.isactive=1,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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
				final String qu="UPDATE EmpSiteVer model SET model.isactive=0,model.modifyDate=:date,model.modifyBy=:username WHERE model.id=:prid";
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

