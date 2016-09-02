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
import com.solusoft.jpa.dao.DocumentDAO;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.DocTypeMaster;




@Service("documentServicer")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class DocumentServiceImpl implements DocumentServicer {

	@Autowired
	DocumentDAO documentDAO;
	
	@Autowired
	AudittrailDAO audittrailDAO;

	private static final String tabName="DOC_TYPE_MASTER";
	
	private static final int tabacticve=0;
	
	@Override
	public List<DocTypeMaster> findAll() {
		return documentDAO.findAll();
	}
	
	@Override
	public List<DocTypeMaster> findAllInactive() {
		return documentDAO.findAllInactive();
	}
	
	@Override
	public ReadList activeId(Integer id,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		DocTypeMaster dd=documentDAO.findId(id);
		String name=dd.getDetais();
		String full=dd.getDoname();
		Boolean data=documentDAO.activeId(id,user);
		String news="Document Full Name:-"+full+", Document Type:-"+name;
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
	public ReadList update(Integer id,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		DocTypeMaster dd=documentDAO.findId(id);
		String name=dd.getDetais();
		String full=dd.getDoname();
		Boolean data=documentDAO.delete(id,user);
		String news="Document Full Name:-"+full+", Document Type:-"+name;
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
	public ReadList updates(Integer id,String details,String user,String docname){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		DocTypeMaster dd=documentDAO.findId(id);
		String name=dd.getDetais();
		String full=dd.getDoname();
		Timestamp createdDate;
		String createdBy;
		createdBy=dd.getCreatedBy();
		createdDate=dd.getCreatedDate();
		
		String news="";
		String old="";
		
		if(!full.equalsIgnoreCase(docname))
		{
			news=news+"Document Full Name:-"+docname;
			old=old+"Document Full Name:-"+full;
		}
		
		if(!name.equalsIgnoreCase(details))
		{
			if(news !=""){
				news=news+", Document Type:-"+details;
				old=old+", Document Type:-"+name;
			}else{
				news=news+"Document Type:-"+details;
				old=old+"Document Type:-"+name;
			}
		}
		
		DocTypeMaster datas=new DocTypeMaster();
		datas.setId(id);
		datas.setDetais(details);
		datas.setDoname(docname);
		datas.setCreatedDate(createdDate);
		datas.setCreatedBy(createdBy);
		datas.setModifyBy(user);
		datas.setModifyDate(new Timestamp(new Date().getTime()));
		datas.setIsactive(tabacticve);
		DocTypeMaster data=documentDAO.save(datas);
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
	public ReadList save(String details,String user,String docname){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		DocTypeMaster ss=new DocTypeMaster();
		ss.setDetais(details);
		ss.setDoname(docname);
		ss.setCreatedBy(user);
		ss.setCreatedDate(new Timestamp(new Date().getTime()));
		ss.setIsactive(tabacticve);
		String news="Document Full Name:-"+docname+", Document Type:-"+details;
		DocTypeMaster data=documentDAO.save(ss);
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
	public List<DocTypeMaster> findNameActive(String detail,String docnames) {
		return documentDAO.findNameActive(detail,docnames);
	}
	
	@Override
	public List<DocTypeMaster> findNameInactive(String detail,String docnames) {
		return documentDAO.findNameInactive(detail,docnames);
	}
	
}