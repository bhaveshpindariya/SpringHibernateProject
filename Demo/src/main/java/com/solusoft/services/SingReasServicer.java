package com.solusoft.services;


import java.util.List;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.SingReasMaster;



public interface SingReasServicer {

	public List<SingReasMaster> findAll();
	
	public List<SingReasMaster> findAllInactive();
	
	public ReadList activeId(Integer id,String user);
	
	public ReadList update(Integer id,String user);
	
	public ReadList updates(Integer id,String details,String user,Integer role);
	
	public ReadList save(String details,String user,Integer role);
	
	public List<SingReasMaster> findNameActive(String detail,Integer srole);
	
	public List<SingReasMaster> findNameInactive(String detail,Integer srole);
}