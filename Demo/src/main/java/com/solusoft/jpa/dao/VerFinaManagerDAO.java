
package com.solusoft.jpa.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.entity.VerticalFinanceManager;

public interface VerFinaManagerDAO {

         public List<VerticalFinanceManager> findAll();
         
         public List<VerticalFinanceManager> findAllInactive();
    	 
         @ Transactional
    	 public Boolean activeId(Integer id,String user);
    	 
    	 @ Transactional
    	 public Boolean delete(Integer id,String user);
         
         @ Transactional
    	 public VerticalFinanceManager save(VerticalFinanceManager details);
         
         public VerticalFinanceManager findId(Integer id);
         
         public List<VerticalFinanceManager> findNameActive(long eid,Integer vid,Integer aid);
         
         public List<VerticalFinanceManager> findNameInactive(long eid,Integer vid,Integer aid);
         
         public VerticalFinanceManager saves(VerticalFinanceManager obj);
         
         public VerticalFinanceManager finddata(long empId,Integer vId,Integer aId);
}

