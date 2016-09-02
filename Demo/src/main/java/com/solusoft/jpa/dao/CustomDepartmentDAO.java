package com.solusoft.jpa.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.entity.CustomDepartment;

public interface CustomDepartmentDAO {

	 public List<CustomDepartment> findAll();
	 
	 public List<CustomDepartment> findAlls(Integer id);
	 
	 public List<CustomDepartment> findAllInactive();
	 
	 @ Transactional
	 public Boolean activeId(long id,String user);
	 
	 @ Transactional
	 public Boolean delete(long id,String user);
	 
	 @ Transactional
	 public CustomDepartment save(CustomDepartment details);
	 
	 public List<CustomDepartment> findNameActive(long id,String dname,String abb,Integer cid);
		
	 public List<CustomDepartment> findNameInactive(long id,String dname,String abb,Integer cid);
	 
	 public CustomDepartment findId(long id);
}
