package com.solusoft.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.dao.LegalProcessHistoryDAO;
import com.solusoft.jpa.dao.ProcessAuditDAO;
import com.solusoft.jpa.entity.LegalProcessHistory;
import com.solusoft.jpa.entity.ProcessAuditMaster;

@Service("processAuditService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class ProcessAuditServiceImpl implements ProcessAuditService {

	@Autowired
	ProcessAuditDAO processAuditDAO;
	
	@Autowired
	LegalProcessHistoryDAO legalProcessHistoryDAO;
	
	@Override
	public List<ProcessAuditMaster> findall() {
		return processAuditDAO.findall();
	}
	
	@Override
	public List<LegalProcessHistory> findalls() {
		return legalProcessHistoryDAO.findAll();
	}
	
}