package com.solusoft.services;


import java.util.List;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.SingRole;


public interface SingRoleServicer {

	public List<SingRole> findAll();
	
	public List<SingRole> findAllInactive();
	
	public ReadList activeId(Integer id,String user);
	
	public ReadList updateRole(Integer id,String user);
	
	public ReadList updatesRole(Integer id,String srole,String user);
	
	public ReadList saveRole(String srole,String user);
	
	public List<SingRole> findNameActive(String srole);
	
	public List<SingRole> findNameInactive(String srole);
	
}