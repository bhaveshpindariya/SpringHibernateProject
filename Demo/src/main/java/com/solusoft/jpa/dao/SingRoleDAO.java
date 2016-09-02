package com.solusoft.jpa.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.entity.SingRole;


public interface SingRoleDAO {

	 public List<SingRole> findAll();
	 
	 public List<SingRole> findAllInactive();
	 
	 @ Transactional
	 public Boolean activeId(Integer id,String user);
	 
	 @ Transactional
	 public Boolean delete(Integer id,String user);
	 
	 @ Transactional
	 public SingRole saveRole(SingRole detail);
	 
	 public List<SingRole> findNameActive(String srole);
	 
	 public List<SingRole> findNameInactive(String srole);
	 
	 public SingRole findId(Integer id);
}
