package com.solusoft.jpa.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.entity.VerticalMaster;


public interface VerticalDAO {
	
	public List<VerticalMaster> findAllInactive();
	 
	 @ Transactional
	 public Boolean activeId(Integer id,String user);
	 
	 @ Transactional
	 public Boolean delete(Integer id,String user);
	 
	 @ Transactional
	 public VerticalMaster saveVer(VerticalMaster details);
	 
	 public List<VerticalMaster> findNameActive(String detail,String ab);
		
	 public List<VerticalMaster> findNameInactive(String detail,String ab);
	 
	 public VerticalMaster findId(Integer id);
 
	 public VerticalMaster save(VerticalMaster obj);
	 
	 public List<VerticalMaster> findAll();
	 
	 public VerticalMaster findName(String detail);
	 
	 public List<VerticalMaster> findNames(String name,String abs);
                 
}
