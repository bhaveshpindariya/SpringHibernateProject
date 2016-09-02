package com.solusoft.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.solusoft.jpa.dao.AudittrailDAO;
import com.solusoft.jpa.dao.CompanyMasterDAO;
import com.solusoft.jpa.dao.EmployeeDAO;
import com.solusoft.jpa.dao.ReportingDAO;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.ReportingMaster;


@Service("reportingService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class ReportingServiceImpl implements ReportingService {

	@Autowired
	ReportingDAO reportingDAO;
	
	@Autowired
	CompanyMasterDAO companyMasterDAO;
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	@Autowired
	AudittrailDAO audittrailDAO;

	@Override
	public List<ReportingMaster> findAll() {
		return reportingDAO.findAll();
	}
	
	@Override
	public ReportingMaster save(ReportingMaster obj) {
		return reportingDAO.save(obj);
	}
	
	@Override
	public List<ReportingMaster> findId(long id) {
		return reportingDAO.findId(id);
	}
	
	public void saves(Auditrail de) {
		audittrailDAO.save(de);
	}
}