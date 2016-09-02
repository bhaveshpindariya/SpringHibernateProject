package com.solusoft.services;


import java.util.List;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.CustomDepartment;


public interface CustomDepartmenServicer {

	public List<CustomDepartment> findAll();
	
	public List<CustomDepartment> findAlls(Integer id);
	
	public List<CustomDepartment> findAllInactive();
	
	public ReadList activeId(long id,String user);
	
	public ReadList delete(long id,String user);
	
	public ReadList updates(long id,String dname,String dabb,Integer cid,String user);
	
	public ReadList save(long id,String dname,String dabb,Integer cid,String user);
	
	public CustomDepartment save(CustomDepartment details);
	
	public List<CustomDepartment> findNameActive(long id,String dname,String abb,Integer cid);
	
	public List<CustomDepartment> findNameInactive(long id,String dname,String abb,Integer cid);
	
	public CustomDepartment findId(long id);
	
	public void saves(Auditrail de);
}