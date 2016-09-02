package com.solusoft.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.dao.AudittrailDAO;
import com.solusoft.jpa.dao.CompanyMasterDAO;
import com.solusoft.jpa.dao.CostCenterDAO;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.CostCenterMaster;



@Service("costCenterService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class CostCenterServiceImpl implements CostCenterService {

	@Autowired
	CostCenterDAO costCenterDAO;
	
	@Autowired
	CompanyMasterDAO companyMasterDAO;

	@Autowired
	AudittrailDAO audittrailDAO;

	@Override
	public List<CostCenterMaster> findAll() {
		return costCenterDAO.findAll();
	}
	
	@Override
	public CostCenterMaster save(CostCenterMaster obj) {
		return costCenterDAO.save(obj);
	}
	
	@Override
	public CostCenterMaster findId(String id) {
		return costCenterDAO.findId(id);
	}
	
	public void saves(Auditrail de) {
		audittrailDAO.save(de);
	}
}