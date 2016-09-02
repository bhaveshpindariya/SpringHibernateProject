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
import com.solusoft.jpa.dao.CancelAuditDAO;
import com.solusoft.jpa.dao.CancelResonDAO;
import com.solusoft.jpa.dao.LrfCancelAuditDAO;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.CancelAuditMaster;
import com.solusoft.jpa.entity.CancelResonMaster;
import com.solusoft.jpa.entity.LrfCancelAuditMaster;



@Service("cancelResonServicer")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class CancelResonServicerImpl implements CancelResonServicer {

	@Autowired
	CancelResonDAO cancelResonDAO;
	
	@Autowired
	CancelAuditDAO cancelAuditDAO;
	
	@Autowired
	LrfCancelAuditDAO lrfcancelAuditDAO;

	@Autowired
	AudittrailDAO audittrailDAO;
	
	private static final String tabName="CANCEL_REASON";
	
	private static final int tabacticve=0;
	
	@Override
	public List<CancelResonMaster> findAllPM() {
		return cancelResonDAO.findAllPM();
	}
	
	@Override
	public List<CancelResonMaster> findAllLRF() {
		return cancelResonDAO.findAllLRF();
	}
	
	@Override
	public List<CancelResonMaster> findAllInactivePM() {
		return cancelResonDAO.findAllInactivePM();
	}
	
	@Override
	public List<CancelResonMaster> findAllInactiveLRF() {
		return cancelResonDAO.findAllInactiveLRF();
	}
	
	@Override
	public ReadList delete(Integer id,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		CancelResonMaster pr=cancelResonDAO.findId(id);
		String reson=pr.getDetais();
		String news="Cancel reason name:-"+reson;
		Boolean data=cancelResonDAO.delete(id,user);
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
		CancelResonMaster pr=cancelResonDAO.findId(id);
		String reson=pr.getDetais();
		String news="Cancel reason name:-"+reson;
		Boolean data=cancelResonDAO.activeId(id,user);
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
	public ReadList updates(Integer id,String details,String user,String mod){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		
		CancelResonMaster pr=cancelResonDAO.findId(id);
		String reson=pr.getDetais();
		String mo=pr.getModule();
		Timestamp createdDate;
		String createdBy;
		createdBy=pr.getCreatedBy();
		createdDate=pr.getCreatedDate();
		
		String news="";
		String old="";
		if(!reson.equalsIgnoreCase(details))
		{
			news=news+"Cancel reason name:-"+details;
			old=old+"Cancel reason name:-"+reson;
		}
		if(!mo.equalsIgnoreCase(mod))
		{
			news=news+"Cancel reason module:-"+mod;
			old=old+"Cancel reason module:-"+mo;
		}
		
		CancelResonMaster prs=new CancelResonMaster();
		prs.setId(id);
		prs.setDetais(details);
		prs.setModule(mod);
		prs.setCreatedDate(createdDate);
		prs.setCreatedBy(createdBy);
		prs.setModifyBy(user);
		prs.setModifyDate(new Timestamp(new Date().getTime()));
		prs.setIsactive(tabacticve);
		CancelResonMaster data=cancelResonDAO.save(prs);
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
	public ReadList save(String details,String user,String mod){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		CancelResonMaster ss=new CancelResonMaster();
		ss.setDetais(details);
		ss.setModule(mod);
		ss.setCreatedBy(user);
		ss.setCreatedDate(new Timestamp(new Date().getTime()));
		ss.setIsactive(tabacticve);
		String news="Cancel reason name:-"+details+", Cancel reason module:-"+mod;
		CancelResonMaster data=cancelResonDAO.save(ss);
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
	public List<CancelResonMaster> findNameActive(String detail,String mod) {
		return cancelResonDAO.findNameActive(detail,mod);
	}
	
	@Override
	public List<CancelResonMaster> findNameInactive(String detail,String mod) {
		return cancelResonDAO.findNameInactive(detail,mod);
	}
	
	@Override
	public List<CancelAuditMaster> findAlls() {
		return cancelAuditDAO.findall();
	}
	
	@Override
	public List<LrfCancelAuditMaster> finddata() {
		return lrfcancelAuditDAO.finddata();
	}
	
	
}