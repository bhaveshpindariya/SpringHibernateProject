package com.solusoft.services;


import java.util.List;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.CancelAuditMaster;
import com.solusoft.jpa.entity.CancelResonMaster;
import com.solusoft.jpa.entity.LrfCancelAuditMaster;

public interface CancelResonServicer {

	public List<CancelResonMaster> findAllPM();
	
	public List<CancelResonMaster> findAllLRF();
	
	public List<CancelResonMaster> findAllInactivePM();
	
	public List<CancelResonMaster> findAllInactiveLRF();
	
	public ReadList delete(Integer id,String user);
	
	public ReadList activeId(Integer id,String user);
	
	public ReadList updates(Integer id,String details,String user,String mod);
	
	public ReadList save(String details,String user,String mod);
	
	public List<CancelResonMaster> findNameActive(String detail,String mod);
	
	public List<CancelResonMaster> findNameInactive(String detail,String mod);
		
	public List<CancelAuditMaster> findAlls();
	
	public List<LrfCancelAuditMaster> finddata();
	
}