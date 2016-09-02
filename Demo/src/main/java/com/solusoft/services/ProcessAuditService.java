package com.solusoft.services;

import java.util.List;

import com.solusoft.jpa.entity.LegalProcessHistory;
import com.solusoft.jpa.entity.ProcessAuditMaster;

public interface ProcessAuditService {

	public List<ProcessAuditMaster> findall();
	
	public List<LegalProcessHistory> findalls();
	
}