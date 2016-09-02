package com.solusoft.services;


import java.util.List;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.DepartmentMaster;


public interface DepartmentService {

	public List<DepartmentMaster> findAll();
	
	public List<DepartmentMaster> findAllCompany(Integer id);
	
	public DepartmentMaster save(DepartmentMaster obj);
	 
	public DepartmentMaster findId(long id);
	
	public void saves(Auditrail de);
}