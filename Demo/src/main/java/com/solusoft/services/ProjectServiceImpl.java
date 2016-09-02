package com.solusoft.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.solusoft.jpa.dao.AudittrailDAO;
import com.solusoft.jpa.dao.CompanyMasterDAO;
import com.solusoft.jpa.dao.ProjectDAO;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.ProjectMaster;


@Service("projectService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectDAO projectDAO;
	
	@Autowired
	CompanyMasterDAO companyMasterDAO;
	
	@Autowired
	AudittrailDAO audittrailDAO;

	@Override
	public List<ProjectMaster> findAll() {
		return projectDAO.findAll();
	}
	
	@Override
	public ProjectMaster save(ProjectMaster obj) {
		return projectDAO.save(obj);
	}
	
	@Override
	public ProjectMaster findId(long id) {
		return projectDAO.findId(id);
	}
	
	public void saves(Auditrail de) {
		audittrailDAO.save(de);
	}
}