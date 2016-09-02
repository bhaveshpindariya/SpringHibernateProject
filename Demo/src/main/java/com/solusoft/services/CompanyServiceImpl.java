package com.solusoft.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.solusoft.jpa.dao.AudittrailDAO;
import com.solusoft.jpa.dao.CompanyMasterDAO;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.CompanyMaster;

@Service("companyService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyMasterDAO companyMasterDAO;
	
	@Autowired
	AudittrailDAO audittrailDAO;

	public static String SERVER_URI = null;
	
	@Override
	public List<CompanyMaster> findall() {
		return companyMasterDAO.findall();
	}
	
	@Override
	public CompanyMaster save(CompanyMaster obj) {
		return companyMasterDAO.save(obj);
	}
	
	@Override
	public CompanyMaster findId(Integer id) {
		return companyMasterDAO.findId(id);
	}
	
	@Override
	public CompanyMaster findName(String name) {
		return companyMasterDAO.findName(name);
	}
	
	public void saves(Auditrail de) {
		audittrailDAO.save(de);
	}
}