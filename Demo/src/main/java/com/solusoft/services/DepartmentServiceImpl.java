package com.solusoft.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.dao.AudittrailDAO;
import com.solusoft.jpa.dao.CompanyMasterDAO;
import com.solusoft.jpa.dao.DepartmentDAO;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.DepartmentMaster;


@Service("departmentService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentDAO departmentDAO;
	
	@Autowired
	CompanyMasterDAO companyMasterDAO;
	
	@Autowired
	AudittrailDAO audittrailDAO;

	@Override
	public List<DepartmentMaster> findAll() {
		return departmentDAO.findAll();
	}
	
	@Override
	public List<DepartmentMaster> findAllCompany(Integer id) {
		return departmentDAO.findAllCompany(id);
	}
	
	@Override
	public DepartmentMaster save(DepartmentMaster obj) {
		return departmentDAO.save(obj);
	}
	
	@Override
	public DepartmentMaster findId(long id) {
		return departmentDAO.findId(id);
	}
	
	public void saves(Auditrail de) {
		audittrailDAO.save(de);
	}
}