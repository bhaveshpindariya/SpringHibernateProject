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
import com.solusoft.jpa.dao.LrfPrintAuditDAO;
import com.solusoft.jpa.dao.PrintAuditDAO;
import com.solusoft.jpa.dao.PrintResonDAO;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.LrfPrintAuditMaster;
import com.solusoft.jpa.entity.PrintAuditMaster;
import com.solusoft.jpa.entity.PrintResonMaster;



@Service("printResonServicer")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class PrintResonServiceImpl implements PrintResonServicer {

	@Autowired
	PrintResonDAO printResonDAO;
	
	@Autowired
	PrintAuditDAO printAuditDAO;
	
	@Autowired
	LrfPrintAuditDAO lrfPrintAuditDAO;

	@Autowired
	AudittrailDAO audittrailDAO;
	
	private static final String tabName="PRINT_REASON";
	
	private static final int tabacticve=0;
	
	@Override
	public List<PrintResonMaster> findAllLRF() {
		return printResonDAO.findAllLRF();
	}
	
	@Override
	public List<PrintResonMaster> findAllPM() {
		return printResonDAO.findAllPM();
	}
	
	@Override
	public List<PrintResonMaster> findAllInactivePM() {
		return printResonDAO.findAllInactivePM();
	}
	
	@Override
	public List<PrintResonMaster> findAllInactiveLRF() {
		return printResonDAO.findAllInactiveLRF();
	}
	
	@Override
	public ReadList delete(Integer id,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		PrintResonMaster pr=printResonDAO.findId(id);
		String reson=pr.getDetais();
		String news="Print reason name:-"+reson;
		Boolean data=printResonDAO.delete(id,user);
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
		PrintResonMaster pr=printResonDAO.findId(id);
		String reson=pr.getDetais();
		String news="Print reason name:-"+reson;
		Boolean data=printResonDAO.activeId(id,user);
		if(data==true){
			Auditrail de=new Auditrail();
			de.setOperation("activation");
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
	public ReadList updates(Integer id,String details,String module,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		
		PrintResonMaster pr=printResonDAO.findId(id);
		String reson=pr.getDetais();
		String modu=pr.getModule();
		Timestamp createdDate;
		String createdBy;
		createdBy=pr.getCreatedBy();
		createdDate=pr.getCreatedDate();
		
		String news="";
		String old="";
		if(!reson.equalsIgnoreCase(details))
		{
			news=news+"Print reason name:-"+details;
			old=old+"Print reason name:-"+reson;
		}
		
		if(!modu.equalsIgnoreCase(module))
		{
			news=news+"Print reason name:-"+module;
			old=old+"Print reason name:-"+modu;
		}
		
		PrintResonMaster prs=new PrintResonMaster();
		prs.setId(id);
		prs.setDetais(details);
		prs.setModule(module); 
		prs.setCreatedDate(createdDate);
		prs.setCreatedBy(createdBy);
		prs.setModifyBy(user);
		prs.setModifyDate(new Timestamp(new Date().getTime()));
		prs.setIsactive(tabacticve);
		PrintResonMaster data=printResonDAO.save(prs);
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
	public ReadList save(String details,String module,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		PrintResonMaster ss=new PrintResonMaster();
		ss.setDetais(details);
		ss.setCreatedBy(user);
		ss.setModule(module);
		ss.setCreatedDate(new Timestamp(new Date().getTime()));
		ss.setIsactive(tabacticve);
		String news="Print reason name:-"+details;
		PrintResonMaster data=printResonDAO.save(ss);
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
	public List<PrintResonMaster> findNameActive(String detail,String module) {
		return printResonDAO.findNameActive(detail,module);
	}
	
	@Override
	public List<PrintResonMaster> findNameInactive(String detail,String module) {
		return printResonDAO.findNameInactive(detail,module);
	}
	
	@Override
	public List<PrintAuditMaster> findAllPMAudit() {
		return printAuditDAO.findAll();
	}
	
	@Override
	public List<LrfPrintAuditMaster> findAllLRFAudit() {
		return lrfPrintAuditDAO.findAll();
	}
	
	
}