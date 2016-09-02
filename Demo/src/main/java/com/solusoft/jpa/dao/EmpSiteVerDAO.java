
package com.solusoft.jpa.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.entity.EmpSiteVer;

public interface EmpSiteVerDAO {

         public List<EmpSiteVer> findAll();
         
         public List<EmpSiteVer> findAllInactive();
    	 
         @ Transactional
    	 public Boolean activeId(Integer id,String user);
    	 
    	 @ Transactional
    	 public Boolean delete(Integer id,String user);
         
         @ Transactional
    	 public EmpSiteVer save(EmpSiteVer details);
         
         public EmpSiteVer findId(Integer id);
         
         public List<EmpSiteVer> findNameActive(Integer sitId,long empId,Integer verId);
     	
     	 public List<EmpSiteVer> findNameInactive(Integer sitId,long empId,Integer verId);
}

