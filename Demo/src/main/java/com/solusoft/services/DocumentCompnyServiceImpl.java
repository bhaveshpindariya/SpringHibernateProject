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
import com.solusoft.jpa.dao.CompanyMasterDAO;
import com.solusoft.jpa.dao.DocumentCompnyDAO;
import com.solusoft.jpa.dao.DocumentDAO;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.CompanyMaster;
import com.solusoft.jpa.entity.DocTypeMaster;
import com.solusoft.jpa.entity.DocumentCompnydetail;


@Service("documentCompnyService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class DocumentCompnyServiceImpl implements DocumentCompnyService {

	@Autowired
	AudittrailDAO audittrailDAO;
	
	@Autowired
	DocumentCompnyDAO documentCompnyDAO;
	
	@Autowired
	DocumentDAO documentDAO;
	
	@Autowired
	CompanyMasterDAO companyMasterDAO;
	
	private static final String tabName="DOC_COMPANYDETAIL";
	
	private static final int tabacticve=0;
	
	@Override
	public List<DocumentCompnydetail> findAll() {
		return documentCompnyDAO.findAll();
	}
	
	@Override
	public List<DocumentCompnydetail> findAllInactive() {
		return documentCompnyDAO.findAllInactive();
	}
	
	@Override
	public ReadList update(Integer id,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		DocumentCompnydetail dd=documentCompnyDAO.findId(id);
		String docName=dd.getDocumentid().getDoname();
		String conName=dd.getCompanyMaster().getCompanyName();
		String news="Comapny Name:-"+conName+", Document Name:-"+docName;
		Boolean data=documentCompnyDAO.delete(id,user);
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
		DocumentCompnydetail dd=documentCompnyDAO.findId(id);
		String docName=dd.getDocumentid().getDoname();
		String conName=dd.getCompanyMaster().getCompanyName();
		String news="Comapny Name:-"+conName+", Document Name:-"+docName;
		Boolean data=documentCompnyDAO.activeId(id,user);
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
	public ReadList updates(Integer id,Integer comId,Integer docId,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		
		DocumentCompnydetail dds=documentCompnyDAO.findId(id);
		String cname=dds.getCompanyMaster().getCompanyName();
		String docname=dds.getDocumentid().getDetais();
		Timestamp createdDate;
		String createdBy;
		createdBy=dds.getCreatedBy();
		createdDate=dds.getCreatedDate();
		
		CompanyMaster dos=companyMasterDAO.findId(comId);
		String cnames=dos.getCompanyName();
		
		DocTypeMaster dd =documentDAO.findId(docId);
		String docnames=dd.getDetais();
		
		String news="";
		String old="";
		
		if(!cname.equalsIgnoreCase(cnames))
		{
			news=news+"Comapany Name:-"+cnames;
			old=old+"Comapany Name:-"+cname;
		}
		if(!docname.equalsIgnoreCase(docnames))
		{
			if(news !=""){
				news=news+", Document Name:-"+docnames;
				old=old+", Document Name:-"+docname;
			}else{
				news=news+"Document Name:-"+docnames;
				old=old+"Document Name:-"+docname;
			}
			
		}
		
		DocumentCompnydetail ss=new DocumentCompnydetail();
		ss.setId(id);
		ss.setCompanyMaster(dos);
		ss.setDocumentid(dd);
		ss.setCreatedDate(createdDate);
		ss.setCreatedBy(createdBy);
		ss.setModifyBy(user);
		ss.setModifyDate(new Timestamp(new Date().getTime()));
		ss.setIsactive(tabacticve);
		DocumentCompnydetail data=documentCompnyDAO.save(ss);
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
	public ReadList save(Integer comId,Integer docId,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		CompanyMaster dos=companyMasterDAO.findId(comId);
		String conName=dos.getCompanyName();
		
		DocTypeMaster dd =documentDAO.findId(docId);
		String docName=dd.getDetais();
		
		String news="Comapny Name:-"+conName+", Document Name:-"+docName;
		
		DocumentCompnydetail ss=new DocumentCompnydetail();
		ss.setCompanyMaster(dos);
		ss.setDocumentid(dd);
		ss.setCreatedBy(user);
		ss.setCreatedDate(new Timestamp(new Date().getTime()));
		ss.setIsactive(tabacticve);
		DocumentCompnydetail data=documentCompnyDAO.save(ss);
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
	public List<DocumentCompnydetail> findNameActive(Integer detail,Integer ccode) {
		return documentCompnyDAO.findNameActive(detail,ccode);
	}
	
	@Override
	public List<DocumentCompnydetail> findNameInactive(Integer detail,Integer ccode) {
		return documentCompnyDAO.findNameInactive(detail,ccode);
	}
}