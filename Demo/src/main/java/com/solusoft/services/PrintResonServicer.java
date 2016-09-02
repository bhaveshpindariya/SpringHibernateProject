package com.solusoft.services;


import java.util.List;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.LrfPrintAuditMaster;
import com.solusoft.jpa.entity.PrintAuditMaster;
import com.solusoft.jpa.entity.PrintResonMaster;

public interface PrintResonServicer {

	public List<PrintResonMaster> findAllPM();
	 
	public List<PrintResonMaster> findAllLRF();
	 
	public List<PrintResonMaster> findAllInactivePM();
	
	public List<PrintResonMaster> findAllInactiveLRF();
	
	public ReadList delete(Integer id,String user);
	
	public ReadList activeId(Integer id,String user);
	
	public ReadList updates(Integer id,String details,String module,String user);
	
	public ReadList save(String details,String module,String user);
	
	public List<PrintResonMaster> findNameActive(String detail,String module);
	
	public List<PrintResonMaster> findNameInactive(String detail,String module);
		
	public List<PrintAuditMaster> findAllPMAudit();
	
	public List<LrfPrintAuditMaster> findAllLRFAudit();
	
}