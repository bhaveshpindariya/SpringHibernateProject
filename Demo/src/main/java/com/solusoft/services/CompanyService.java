package com.solusoft.services;


import java.util.List;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.CompanyMaster;
public interface CompanyService {

	public List<CompanyMaster> findall();
	
	public CompanyMaster save(CompanyMaster obj);
	 
	public CompanyMaster findId(Integer id);
	
	public CompanyMaster findName(String name);
	
	public void saves(Auditrail de);
	
}