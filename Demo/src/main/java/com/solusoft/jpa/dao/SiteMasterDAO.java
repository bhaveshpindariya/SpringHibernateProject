package com.solusoft.jpa.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.entity.CompanyMaster;
import com.solusoft.jpa.entity.SiteMaster;

public interface SiteMasterDAO {

	 public List<SiteMaster> findAll();
	 
	 public List<SiteMaster> findAlls(Integer ccode);
	 
	 public List<SiteMaster> findAllInactive();
	 
	 @ Transactional
	 public Boolean activeId(Integer id,String user);
	 
	 @ Transactional
	 public Boolean delete(Integer id,String user);
	 
	 @ Transactional
	 public SiteMaster save(SiteMaster details);
	 
	 public SiteMaster findId(Integer id);
	 
	 public List<SiteMaster> findNameActive(String detail,String salias,String sabb,String sadd,Integer ccode);
		
	 public List<SiteMaster> findNameInactive(String detail,String salias,String sabb,String sadd,Integer ccode);
		
	 public List<SiteMaster> finddetail(String sname,String salians,String sabbra,String sadd,CompanyMaster co);
	 
	 public SiteMaster finddetails(String sname,CompanyMaster co);
}
