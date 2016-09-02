package com.solusoft.services;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.dao.AudittrailDAO;
import com.solusoft.jpa.dao.RoleDAO;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.RoleManagement;

@Service("roleService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDAO roleDAO;
	
	@Autowired
	AudittrailDAO audittrailDAO;

	private static final String tabName="ROLE_MASTER";
	
	@Override
	public List<RoleManagement> findall() {
		return roleDAO.findall();
	}
	
	@Override
	public List<RoleManagement> findRole(String role) {
		return roleDAO.findRole(role);
	}
	
	public ReadList save(String role,String username){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		RoleManagement prs=new RoleManagement();
		prs.setRolename(role);
		prs.setCreatedBy(username);
		prs.setCreatedDate(new Timestamp(new Date().getTime()));
		String news="Role Name:-"+role;
		RoleManagement data=roleDAO.save(prs);
		if(data.getId()>0){
			Auditrail de=new Auditrail();
			de.setOperation("Inserted");
			de.setRecord(""+data.getId());
			de.setNvalue(news);
			de.setOvalue("");
			de.setCreatedBy(username);
			de.setCreatedDate(new Timestamp(new Date().getTime()));
			de.setTableName(tabName);
			audittrailDAO.save(de);
			rs.setSuccess(true);
		}
		return rs;
	}
	
	public RoleManagement merge(String role,String username){
		RoleManagement prs=new RoleManagement();
		prs.setRolename(role);
		prs.setCreatedBy(username);
		prs.setCreatedDate(new Timestamp(new Date().getTime()));
		String news="Role Name:-"+role;
		RoleManagement data=roleDAO.save(prs);
		if(data.getId()>0){
			Auditrail de=new Auditrail();
			de.setOperation("Inserted");
			de.setRecord(""+data.getId());
			de.setNvalue(news);
			de.setOvalue("");
			de.setCreatedBy(username);
			de.setCreatedDate(new Timestamp(new Date().getTime()));
			de.setTableName(tabName);
			audittrailDAO.save(de);
			
		}
		return data;
	}
	
}