package com.solusoft.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.dao.AudittrailDAO;
import com.solusoft.jpa.dao.IdocDAO;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.IdocsUser;


@Service("idocService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class IdocServiceImpl implements IdocService {

	@Autowired
	IdocDAO idocDAO;
	
	@Autowired
	AudittrailDAO audittrailDAO;

	@Override
	public List<IdocsUser> findall() {
		return idocDAO.findall();
	}
	
	public IdocsUser findId(Integer id) {
		return idocDAO.findId(id);
	}
	
	@Override
	public IdocsUser save(IdocsUser cc) {
		return idocDAO.save(cc);
	}
	
	public void saves(Auditrail de) {
		audittrailDAO.save(de);
	}
}