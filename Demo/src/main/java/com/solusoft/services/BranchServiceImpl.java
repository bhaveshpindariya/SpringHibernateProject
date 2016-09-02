package com.solusoft.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.dao.AudittrailDAO;
import com.solusoft.jpa.dao.BranchDAO;
import com.solusoft.jpa.dao.CompanyMasterDAO;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.BranchMaster;



@Service("branchService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class BranchServiceImpl implements BranchService {

	@Autowired
	BranchDAO branchDAO;
	
	@Autowired
	CompanyMasterDAO companyMasterDAO;
	
	@Autowired
	AudittrailDAO audittrailDAO;

	@Override
	public List<BranchMaster> findAll() {
		return branchDAO.findAll();
	}
	
	@Override
	public BranchMaster save(BranchMaster obj) {
		return branchDAO.save(obj);
	}
	
	@Override
	public BranchMaster findId(Integer id) {
		return branchDAO.findId(id);
	}
	
	public void saves(Auditrail de) {
		audittrailDAO.save(de);
	}
}