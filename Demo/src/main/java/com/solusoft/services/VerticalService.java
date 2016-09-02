package com.solusoft.services;


import java.util.List;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.VerticalMaster;

public interface VerticalService {

	public List<VerticalMaster> findAll();
	
	public List<VerticalMaster> findAllInactive();
	
	public ReadList activeId(Integer id,String user);
	
	public ReadList updateVer(Integer id,String user);
	
	public ReadList updatesVer(Integer id,String details,String user,String vabb);
	
	public ReadList saveVer(String details,String user,String vabb);
	
	public List<VerticalMaster> findNameActive(String detail,String ab);
	
	public List<VerticalMaster> findNameInactive(String detail,String ab);
	
	public VerticalMaster save(VerticalMaster ve);
	
	public VerticalMaster findId(Integer id);
	
	public VerticalMaster findName(String detail);
	
	public List<VerticalMaster> findNames(String name,String abs);
	
	public void saves(Auditrail de);
	
}