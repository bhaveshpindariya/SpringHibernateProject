
package com.solusoft.jpa.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.entity.SapCustDepartMapping;

public interface SapCustDepartDAO {

         public List<SapCustDepartMapping> findAll();
         
         public List<SapCustDepartMapping> findAllInactive();
    	 
    	 @ Transactional
    	 public Boolean activeId(Integer id);
         
         @ Transactional
    	 public Boolean update(Integer id);
         
         @ Transactional
    	 public SapCustDepartMapping save(SapCustDepartMapping details);
         
         public SapCustDepartMapping findId(Integer id);
         
         public List<SapCustDepartMapping> findNameActive(long department,long custDepartment,Integer vid,Integer sid);
         
         public SapCustDepartMapping finddetail(long department,long custDepartment,Integer vid,Integer sid);
     	
     	 public List<SapCustDepartMapping> findNameInactive(long department,long custDepartment,Integer vid,Integer sid);
}

