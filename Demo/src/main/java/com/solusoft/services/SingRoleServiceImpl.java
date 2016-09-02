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
import com.solusoft.jpa.dao.SingRoleDAO;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.SingRole;

@Service("singRoleServicer")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class SingRoleServiceImpl implements SingRoleServicer {

	@Autowired
	SingRoleDAO singRoleDAO;
	
	@Autowired
	AudittrailDAO audittrailDAO;

	private static final String tabName="SIGNATURE_ROLE";
	
	private static final int tabacticve=0;
	
	@Override
	public List<SingRole> findAll() {
		return singRoleDAO.findAll();
	}
	
	@Override
	public List<SingRole> findAllInactive() {
		return singRoleDAO.findAllInactive();
	}
	
	@Override
	public ReadList updateRole(Integer id,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		SingRole dd=singRoleDAO.findId(id);
		String rol=dd.getSrole();
		String news="Signature Role:-"+rol;
		Boolean data=singRoleDAO.delete(id,user);
		if(data==true){
			Auditrail de=new Auditrail();
			de.setOperation("Inactive");
			de.setRecord(""+id);
			de.setOvalue(news);
			de.setNvalue(news);
			de.setModifyBy(user);
			de.setModifyDate(new Timestamp(new Date().getTime()));
			de.setTableName(tabName);
			audittrailDAO.save(de);
			rs.setSuccess(data);
		}
		return rs;
	}
	
	@Override
	public ReadList activeId(Integer id,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		SingRole dd=singRoleDAO.findId(id);
		String rol=dd.getSrole();
		String news="Signature Role:-"+rol;
		Boolean data=singRoleDAO.activeId(id,user);
		if(data==true){
			Auditrail de=new Auditrail();
			de.setOperation("Activation");
			de.setRecord(""+id);
			de.setOvalue(news);
			de.setNvalue(news);
			de.setModifyBy(user);
			de.setModifyDate(new Timestamp(new Date().getTime()));
			de.setTableName(tabName);
			audittrailDAO.save(de);
			rs.setSuccess(data);
		}
		return rs;
	}
	
	@Override
	public ReadList updatesRole(Integer id,String srole,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		
		SingRole dd=singRoleDAO.findId(id);
		String rol=dd.getSrole();
		Timestamp createdDate;
		String createdBy;
		createdBy=dd.getCreatedBy();
		createdDate=dd.getCreatedDate();
		
		String news="";
		String old="";
		if(!rol.equalsIgnoreCase(srole))
		{
			news=news+"Signature Role:-"+srole;
			old=old+"Signature Role:-"+rol;
		}
		SingRole ss=new SingRole();
		ss.setId(id);
		ss.setSrole(srole);
		ss.setCreatedDate(createdDate);
		ss.setCreatedBy(createdBy);
		ss.setModifyBy(user);
		ss.setModifyDate(new Timestamp(new Date().getTime()));
		ss.setIsactive(tabacticve);
		SingRole data=singRoleDAO.saveRole(ss);
		if(news!=""){
			if(data.getId()>0){
				Auditrail de=new Auditrail();
				de.setOperation("Update");
				de.setRecord(""+id);
				de.setNvalue(news);
				de.setOvalue(old);
				de.setModifyBy(user);
				de.setModifyDate(new Timestamp(new Date().getTime()));
				de.setTableName(tabName);
				audittrailDAO.save(de);
				rs.setSuccess(true);
			}
		}else{
			rs.setSuccess(true);
		}
		return rs;
	}
	
	@Override
	public ReadList saveRole(String srole,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		SingRole ss=new SingRole();
		ss.setSrole(srole);
		ss.setCreatedBy(user);
		ss.setCreatedDate(new Timestamp(new Date().getTime()));
		ss.setIsactive(tabacticve);
		String news="Signature Role:-"+srole;
		SingRole data=singRoleDAO.saveRole(ss);
		if(data.getId()>0){
			Auditrail de=new Auditrail();
			de.setOperation("Inserted");
			de.setRecord(""+data.getId());
			de.setOvalue("");
			de.setNvalue(news);
			de.setCreatedBy(user);
			de.setCreatedDate(new Timestamp(new Date().getTime()));
			de.setTableName(tabName);
			audittrailDAO.save(de);
			rs.setSuccess(true);
		}
		return rs;
	}
	
	@Override
	public List<SingRole> findNameActive(String srole) {
		return singRoleDAO.findNameActive(srole);
	}
	
	@Override
	public List<SingRole> findNameInactive(String srole) {
		return singRoleDAO.findNameInactive(srole);
	}
}