package com.solusoft.services;


import java.util.List;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.RoleManagement;
public interface RoleService {

	public List<RoleManagement> findall();
	
	public List<RoleManagement> findRole(String role);
	
	public ReadList save(String role,String username);
	
	public RoleManagement merge(String role,String username);
	
	
}