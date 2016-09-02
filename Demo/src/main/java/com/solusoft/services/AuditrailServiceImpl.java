package com.solusoft.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.dao.AudittrailDAO;
import com.solusoft.jpa.entity.Auditrail;


@Service("audittrailService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class AuditrailServiceImpl implements AudittrailService {

	@Autowired
	AudittrailDAO audittrailDAO;

	@Override
	public List<Auditrail> findall() {
		return audittrailDAO.findAll();
	}
	
	@Override
	public List<String> findName() {
		return audittrailDAO.findName();
	}
	
	@Override
	public List<Auditrail> findByTable(String tname) {
		return audittrailDAO.findByTable(tname);
	}
	
}