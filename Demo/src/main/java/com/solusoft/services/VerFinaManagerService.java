
package com.solusoft.services;


import java.util.List;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.VerticalFinanceManager;

public interface VerFinaManagerService {

	public List<VerticalFinanceManager> findAll();
	
	public List<VerticalFinanceManager> findAllInactive();
	
	public ReadList activeId(Integer id,String user);
	
	public ReadList update(Integer id,String user);
	
	public ReadList updates(Integer id,long empId,Integer vid,Integer aid,String user);
	
	public ReadList save(long empId,Integer vId,Integer aid,String user);
	
	public List<VerticalFinanceManager> findNameActive(long empId,Integer vId,Integer aId);
	
	public List<VerticalFinanceManager> findNameInactive(long empId,Integer vId,Integer aId);
	
	public VerticalFinanceManager saves(VerticalFinanceManager aa);
	
	public VerticalFinanceManager finddata(long empId,Integer vId,Integer aId);
}
