
package com.solusoft.jpa.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.entity.EmpVerticalMaster;

public interface EmpVerDAO {

         public List<EmpVerticalMaster> findAll();
         
         public List<EmpVerticalMaster> findAllInactive();
    	 
         @ Transactional
    	 public Boolean activeId(Integer id,String user);
    	 
    	 @ Transactional
    	 public Boolean delete(Integer id,String user);
         
         @ Transactional
    	 public EmpVerticalMaster save(EmpVerticalMaster details);
         
         public EmpVerticalMaster findId(Integer id);
         
         public List<EmpVerticalMaster> findNameActive(long eid,Integer vid,Integer aid);
         
         public List<EmpVerticalMaster> findNameInactive(long eid,Integer vid,Integer aid);
         
         public EmpVerticalMaster finddata(long empId,Integer vId,Integer aId);
         
         public EmpVerticalMaster saves(EmpVerticalMaster obj);
}

