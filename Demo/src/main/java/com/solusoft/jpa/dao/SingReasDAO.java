package com.solusoft.jpa.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.entity.SingReasMaster;

public interface SingReasDAO {

	 public List<SingReasMaster> findAll();
	 
	 public List<SingReasMaster> findAllInactive();
	 
	 @ Transactional
	 public Boolean activeId(Integer id,String user);
	 
	 @ Transactional
	 public Boolean delete(Integer id,String user);
	 
	 @ Transactional
	 public SingReasMaster save(SingReasMaster details);
	 
	 public List<SingReasMaster> findNameInactive(String detail,Integer srole);
	 
	 public List<SingReasMaster> findNameActive(String detail,Integer srole);
	 
	 public SingReasMaster findId(Integer id);
	  
	 
}
