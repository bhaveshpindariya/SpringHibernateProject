package com.solusoft.jpa.dao;

import java.util.List;

import com.solusoft.jpa.entity.EmployeeMaster;


public interface EmployeeDAO {

	 public List<EmployeeMaster> findAll();
	 
	 public List<EmployeeMaster> findAlls(Integer ccode);
	 
	 public EmployeeMaster findId(long id);
	 
	 public EmployeeMaster save(EmployeeMaster obj);
	 
	 public EmployeeMaster findName(String name);
}
