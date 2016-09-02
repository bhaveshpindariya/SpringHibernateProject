package com.solusoft.services;


import java.util.List;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.CompanyMaster;
import com.solusoft.jpa.entity.SiteMaster;

public interface SiteService {

	public List<SiteMaster> findAll();
	
	public List<SiteMaster> findAlls(Integer ccode);
	
	public List<SiteMaster> findAllInactive();
	
	public ReadList activeId(Integer id,String user);
	
	public ReadList update(Integer id,String user);
	
	public ReadList updates(Integer id,String details,String user,String salias,String abbs,String sadd,Integer ccode);
		
	public ReadList save(String details,String user,String salias,String abbs,String sadd,Integer ccode);
		
	public List<SiteMaster> findNameActive(String detail,String salias,String sabb,String sadd,Integer ccode);
	
	public List<SiteMaster> findNameInactive(String detail,String salias,String sabb,String sadd,Integer ccode);
	
	public List<SiteMaster> finddetail(String sname,String salians,String sabbra,String sadd,CompanyMaster co);
	
	public SiteMaster finddetails(String sname,CompanyMaster co);
	
    public SiteMaster save(SiteMaster details);
    
    public SiteMaster findId(Integer id);
	
	public void saves(Auditrail de);
}