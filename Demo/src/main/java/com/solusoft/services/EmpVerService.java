

package com.solusoft.services;


import java.util.List;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.EmpVerticalMaster;

public interface EmpVerService {

	public List<EmpVerticalMaster> findAll();
	
	public List<EmpVerticalMaster> findAllInactive();
	
	public ReadList activeId(Integer id,String user);
	
	public ReadList update(Integer id,String user);
	
	public ReadList updates(Integer id,long empId,Integer vid,Integer aid,String user);
	
	public ReadList save(long empId,Integer vId,Integer aid,String user);
	
	public List<EmpVerticalMaster> findNameActive(long empId,Integer vId,Integer aid);
	
	public List<EmpVerticalMaster> findNameInactive(long empId,Integer vId,Integer aid);
	
	public EmpVerticalMaster finddata(long empId,Integer vId,Integer aId);
	
	public EmpVerticalMaster saves(EmpVerticalMaster aa);
}
