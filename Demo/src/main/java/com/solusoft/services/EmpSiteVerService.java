package com.solusoft.services;


import java.util.List;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.EmpSiteVer;

public interface EmpSiteVerService {

	public List<EmpSiteVer> findAll();
	
	public List<EmpSiteVer> findAllInactive();
	
	public ReadList activeId(Integer id,String user);
	
	public ReadList update(Integer id,String user);
	
	public ReadList updates(Integer id,long empId,Integer sitId,Integer verId,String user);
	
	public ReadList save(long empId,Integer sitId,Integer verId,String user);
	
	public List<EmpSiteVer> findNameActive(Integer sitId,long empId,Integer verId);
	
	public List<EmpSiteVer> findNameInactive(Integer sitId,long empId,Integer verId);
}
