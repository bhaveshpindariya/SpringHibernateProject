package com.solusoft.jpa.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.entity.DocumentCompnydetail;


public interface DocumentCompnyDAO {

         public List<DocumentCompnydetail> findAll();
         
         public List<DocumentCompnydetail> findAllInactive();
    	 
         @ Transactional
    	 public Boolean activeId(Integer id,String user);
    	 
    	 @ Transactional
    	 public Boolean delete(Integer id,String user);
         
         @ Transactional
    	 public DocumentCompnydetail save(DocumentCompnydetail details);
         
         public DocumentCompnydetail findId(Integer id);
         
         public List<DocumentCompnydetail> findNameActive(Integer detail,Integer ccode);
         
         public List<DocumentCompnydetail> findNameInactive(Integer detail,Integer ccode);
}
