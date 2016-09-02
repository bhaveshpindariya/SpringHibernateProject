package com.solusoft.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.dao.AudittrailDAO;
import com.solusoft.jpa.dao.BranchDAO;
import com.solusoft.jpa.dao.CompanyMasterDAO;
import com.solusoft.jpa.dao.DepartmentDAO;
import com.solusoft.jpa.dao.EmployeeDAO;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.EmployeeMaster;


@Service("employeeService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;
	
	@Autowired
	DepartmentDAO departmentDAO;
	
	@Autowired
	CompanyMasterDAO companyMasterDAO;
	
	@Autowired
	AudittrailDAO audittrailDAO;
	
	@Autowired
	BranchDAO branchDAO;
	
	@Override
	public List<EmployeeMaster> findAll() {
		return employeeDAO.findAll();
	}
	
	@Override
	public List<EmployeeMaster> findAlls(Integer ccode) {
		return employeeDAO.findAlls(ccode);
	}
	
	@Override
	public EmployeeMaster save(EmployeeMaster obj) {
		return employeeDAO.save(obj);
	}
	
	@Override
	public EmployeeMaster findId(long id) {
		return employeeDAO.findId(id);
	}
	
	public void saves(Auditrail de) {
		audittrailDAO.save(de);
	}
	
	@Override
	public EmployeeMaster findName(String name) {
		return employeeDAO.findName(name);
	}
}