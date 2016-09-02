
package com.solusoft.jpa.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.solusoft.jpa.entity.VerticalCompanyMaster;

public interface VerticalCompanyMasterDAO {

         public List<VerticalCompanyMaster> findAll();
         
         public List<VerticalCompanyMaster> findAllInactive();
    	 
         @ Transactional
    	 public Boolean activeId(Integer id,String user);
    	 
    	 @ Transactional
    	 public Boolean delete(Integer id,String user);
         
         @ Transactional
    	 public VerticalCompanyMaster save(VerticalCompanyMaster details);
         
         public VerticalCompanyMaster findId(Integer id);
         
         public List<VerticalCompanyMaster> findNameActive(Integer vid,Integer cid);
         
         public List<VerticalCompanyMaster> findNameInactive(Integer vid,Integer cid);;
         
         public List<VerticalCompanyMaster> finddata(Integer vid,Integer cid);;
         
         public VerticalCompanyMaster saves(VerticalCompanyMaster obj);
}

