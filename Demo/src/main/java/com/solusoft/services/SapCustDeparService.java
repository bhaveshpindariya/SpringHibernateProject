package com.solusoft.services;


import java.util.List;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.SapCustDepartMapping;

public interface SapCustDeparService {

	public List<SapCustDepartMapping> findAll();
	
	public List<SapCustDepartMapping> findAllInactive();
	
	public ReadList activeId(Integer id,String user);
	
	public ReadList update(Integer id,String user);
	
	public ReadList updates(Integer id,long department,long custDepartment,String user,Integer vid,Integer sid);
	
	public ReadList save(long department,long custDepartment,String user,Integer vid,Integer sid);
	
	public List<SapCustDepartMapping> findNameActive(long department,long custDepartment,Integer vid,Integer sid);
	
	public SapCustDepartMapping finddetail(long department,long custDepartment,Integer vid,Integer sid);
	
	public List<SapCustDepartMapping> findNameInactive(long department,long custDepartment,Integer vid,Integer sid);
	
	public void saves(Auditrail de);
	
	public SapCustDepartMapping save(SapCustDepartMapping obj);
}
