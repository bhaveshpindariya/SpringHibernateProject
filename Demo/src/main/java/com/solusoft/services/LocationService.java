package com.solusoft.services;


import java.util.List;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.LocationMaster;


public interface LocationService {

	public List<LocationMaster> findAll();
	
	public List<LocationMaster> findAllInactive();
	
	public ReadList activeId(Integer id,String user);
	
	public ReadList update(Integer id,String user);
	
	public ReadList updates(Integer id,String details,String user,String code);
		
	public ReadList save(String details,String user,String code);
		
	public List<LocationMaster> findNameActive(String detail,String code);
	
	public List<LocationMaster> findNameInactive(String detail,String code);

}