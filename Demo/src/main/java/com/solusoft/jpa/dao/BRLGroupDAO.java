package com.solusoft.jpa.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.entity.BRLGroup;

public interface BRLGroupDAO {

	 public List<BRLGroup> findAll();
	 
	 public List<BRLGroup> findAllInactive();
	 
	 @ Transactional
	 public Boolean activeId(Integer id,String user);
	 
	 @ Transactional
	 public Boolean delete(Integer id,String user);
	 
	 @ Transactional
	 public BRLGroup save(BRLGroup details);
	 
	 public BRLGroup findId(Integer id);
	 
	 public List<BRLGroup> findNameActive(String name,String abbreva);
	 
	 public List<BRLGroup> findNameInactive(String name,String abbreva);
}
