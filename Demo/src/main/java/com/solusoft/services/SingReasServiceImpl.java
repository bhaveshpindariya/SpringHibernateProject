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
import com.solusoft.jpa.dao.SingReasDAO;
import com.solusoft.jpa.dao.SingRoleDAO;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.SingReasMaster;
import com.solusoft.jpa.entity.SingRole;

@Service("singReasServicer")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class SingReasServiceImpl implements SingReasServicer {

	@Autowired
	SingReasDAO singReasDAO;
	
	@Autowired
	SingRoleDAO singRoleDAO;
	
	@Autowired
	AudittrailDAO audittrailDAO;

	private static final String tabName="SIGNATURE_REASON_MASTER";
	
	private static final int tabacticve=0;
	
	@Override
	public List<SingReasMaster> findAll() {
		return singReasDAO.findAll();
	}
	
	@Override
	public List<SingReasMaster> findAllInactive() {
		return singReasDAO.findAllInactive();
	}
	
	@Override
	public ReadList update(Integer id,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		SingReasMaster ss=singReasDAO.findId(id);
		String reason=ss.getDetais();
		String role=ss.getSingRole().getSrole();
		String news="Signature Reason:-"+reason+", Signature Role:-"+role;
		Boolean data=singReasDAO.delete(id,user);
		if(data==true){
			Auditrail de=new Auditrail();
			de.setOperation("Inactive");
			de.setRecord(""+id);
			de.setNvalue(news);
			de.setOvalue(news);
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
		SingReasMaster ss=singReasDAO.findId(id);
		String reason=ss.getDetais();
		String role=ss.getSingRole().getSrole();
		String news="Signature Reason:-"+reason+", Signature Role:-"+role;
		Boolean data=singReasDAO.activeId(id,user);
		if(data==true){
			Auditrail de=new Auditrail();
			de.setOperation("Activation");
			de.setRecord(""+id);
			de.setNvalue(news);
			de.setOvalue(news);
			de.setModifyBy(user);
			de.setModifyDate(new Timestamp(new Date().getTime()));
			de.setTableName(tabName);
			audittrailDAO.save(de);
			rs.setSuccess(data);
		}
		return rs;
	}
	
	@Override
	public ReadList updates(Integer id,String details,String user,Integer role){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		
		SingReasMaster sss=singReasDAO.findId(id);
		String reason=sss.getDetais();
		String roles=sss.getSingRole().getSrole();
		Timestamp createdDate;
		String createdBy;
		createdBy=sss.getCreatedBy();
		createdDate=sss.getCreatedDate();
		
		SingRole sig=singRoleDAO.findId(role);
		String roless=sig.getSrole();
		
		
		String news="";
		String old="";
		if(!reason.equalsIgnoreCase(details))
		{
			news=news+"Signature Reason:-"+details;
			old=old+"Signature Reason:-"+reason;
		}
		if(!roles.equalsIgnoreCase(roless))
		{
			if(news !=""){
				news=news+", Signature Role:-"+roless;
				old=old+", Signature Role:-"+roles;
			}else{
				news=news+"Signature Role:-"+roless;
				old=old+"Signature Role:-"+roles;
			}
		}
		SingReasMaster ss=new SingReasMaster();
		ss.setId(id);
		ss.setDetais(details);
		ss.setSingRole(sig);
		ss.setCreatedDate(createdDate);
		ss.setCreatedBy(createdBy);
		ss.setModifyBy(user);
		ss.setModifyDate(new Timestamp(new Date().getTime()));
		ss.setIsactive(tabacticve);
		SingReasMaster data=singReasDAO.save(ss);
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
	public ReadList save(String details,String user,Integer role){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		SingRole sig=singRoleDAO.findId(role);
		String roles=sig.getSrole();
		SingReasMaster ss=new SingReasMaster();
		ss.setDetais(details);
		ss.setSingRole(sig);
		ss.setCreatedBy(user);
		ss.setCreatedDate(new Timestamp(new Date().getTime()));
		ss.setIsactive(tabacticve);
		String news="Signature Reason:-"+details+", Signature Role:-"+roles;
		SingReasMaster data=singReasDAO.save(ss);
		
		if(data.getId()>0){
			Auditrail de=new Auditrail();
			de.setOperation("Inserted");
			de.setRecord(""+data.getId());
			de.setNvalue(news);
			de.setOvalue("");
			de.setCreatedBy(user);
			de.setCreatedDate(new Timestamp(new Date().getTime()));
			de.setTableName(tabName);
			audittrailDAO.save(de);
			rs.setSuccess(true);
		}
		return rs;
	}
	
	@Override
	public List<SingReasMaster> findNameActive(String detail,Integer srole) {
		return singReasDAO.findNameActive(detail,srole);
	}
	
	@Override
	public List<SingReasMaster> findNameInactive(String detail,Integer srole) {
		return singReasDAO.findNameInactive(detail,srole);
	}
	

}