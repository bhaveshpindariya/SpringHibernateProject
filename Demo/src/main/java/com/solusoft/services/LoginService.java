package com.solusoft.services;

import java.util.List;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.AdminMaster;

public interface LoginService {
	
	public AdminMaster findByUsernames(String username,String pass);
	
	public AdminMaster findByUsername(String username);
	
	public List<AdminMaster> findByAppicationAdmin();
	
	public List<AdminMaster> findalls(String role);
	
	public List<AdminMaster> findall();
	
	public List<AdminMaster> finddata(Integer role,String username);
	
	public ReadList validateUser(AdminMaster master);
	
	public ReadList delete(Integer id,String name);
	
	public ReadList save(String name,String pass,String email,Integer role,String user);
	
	public ReadList updates(Integer id,String name,String pass,String email,Integer role,String user);
	
}