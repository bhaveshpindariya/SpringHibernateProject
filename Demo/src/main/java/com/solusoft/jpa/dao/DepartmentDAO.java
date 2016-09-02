package com.solusoft.jpa.dao;

import java.util.List;

import com.solusoft.jpa.entity.DepartmentMaster;


public interface DepartmentDAO {

	 public List<DepartmentMaster> findAll();
	 
	 public List<DepartmentMaster> findAllCompany(Integer id);
	 
	 public DepartmentMaster findId(long id);
	 
	 public DepartmentMaster save(DepartmentMaster obj);
}
