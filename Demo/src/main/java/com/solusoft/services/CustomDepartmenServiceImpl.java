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
import com.solusoft.jpa.dao.CustomDepartmentDAO;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.CompanyMaster;
import com.solusoft.jpa.entity.CustomDepartment;


@Service("customDepartmenServicer")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class CustomDepartmenServiceImpl implements CustomDepartmenServicer {

	@Autowired
	CustomDepartmentDAO customDepartmentDAO;
	
	@Autowired
	AudittrailDAO audittrailDAO;

	@Autowired
	CompanyMasterDAO companyMasterDAO;
	
	private static final String tabName="CUSTOM_DEPARTMENT";
	
	private static final int tabacticve=0;
	
	@Override
	public List<CustomDepartment> findAll() {
		return customDepartmentDAO.findAll();
	}
	
	@Override
	public List<CustomDepartment> findAlls(Integer id) {
		return customDepartmentDAO.findAlls(id);
	}
	
	@Override
	public List<CustomDepartment> findAllInactive() {
		return customDepartmentDAO.findAllInactive();
	}
	
	@Override
	public CustomDepartment findId(long id) {
		return customDepartmentDAO.findId(id);
	}
	
	@Override
	public ReadList delete(long id,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		CustomDepartment pr=customDepartmentDAO.findId(id);
		String dname=pr.getDeptname();
		String cname=pr.getCompanyMaster().getCompanyName();
		String abb=pr.getDeptabbreviation();
		String news="Comapny Name:-"+cname+", Custome Department Name:-"+dname+", Abbreviation:-"+abb;
		Boolean data=customDepartmentDAO.delete(id,user);
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
	public ReadList activeId(long id,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		CustomDepartment pr=customDepartmentDAO.findId(id);
		String dname=pr.getDeptname();
		String cname=pr.getCompanyMaster().getCompanyName();
		String abb=pr.getDeptabbreviation();
		String news="Comapny Name:-"+cname+", Custome Department Name:-"+dname+", Abbreviation:-"+abb;
		Boolean data=customDepartmentDAO.activeId(id,user);
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
	public ReadList updates(long id,String dname,String dabb,Integer cid,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		
		CustomDepartment pr=customDepartmentDAO.findId(id);
		String depname=pr.getDeptname();
		String deabb=pr.getDeptabbreviation();
		String cname=pr.getCompanyMaster().getCompanyName();
		Timestamp createdDate;
		String createdBy;
		createdBy=pr.getCreatedBy();
		createdDate=pr.getCreatedDate();
		
		CompanyMaster co=companyMasterDAO.findId(cid);
		String cnames=co.getCompanyName();
		
		String news="";
		String old="";
		
		if(!cname.equalsIgnoreCase(cnames))
		{
			news=news+"Comapany Name:-"+cnames;
			old=old+"Comapany Name:-"+cname;
		}
		
		if(!depname.equalsIgnoreCase(dname))
		{
			if(news !=""){
				news=news+", Custome Department Name:-"+dname;
				old=old+", Custome Department Name:-"+depname;
			}else{
				news=news+"Custome Department Name:-"+dname;
				old=old+"Custome Department Name:-"+depname;
			}
			
		}
		
		if(!deabb.equalsIgnoreCase(dabb))
		{
			if(news !=""){
				news=news+", Abbreviation:-"+dabb;
				old=old+", Abbreviation:-"+deabb;
			}else{
				news=news+"Abbreviation:-"+dabb;
				old=old+"Abbreviation:-"+deabb;
			}
			
		}
		
		CustomDepartment prs=new CustomDepartment();
		prs.setDeptcode(id);
		prs.setDeptname(dname);
		prs.setDeptabbreviation(dabb);
		prs.setCompanyMaster(co);
		prs.setCreatedDate(createdDate);
		prs.setCreatedBy(createdBy);
		prs.setModifyBy(user);
		prs.setModifyDate(new Timestamp(new Date().getTime()));
		prs.setIsactive(tabacticve);
		CustomDepartment data=customDepartmentDAO.save(prs);
		if(news!=""){
			if(data.getDeptcode()>0){
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
	public ReadList save(long id,String dname,String dabb,Integer cid,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		CompanyMaster co=companyMasterDAO.findId(cid);
		String cnames=co.getCompanyName();
		CustomDepartment prs=new CustomDepartment();
		prs.setDeptcode(id);
		prs.setDeptname(dname);
		prs.setDeptabbreviation(dabb);
		prs.setCompanyMaster(co);
		prs.setCreatedBy(user);
		prs.setCreatedDate(new Timestamp(new Date().getTime()));
		prs.setIsactive(tabacticve);
		String news="Comapny Name:-"+cnames+", Custome Department Name:-"+dname+", Abbreviation:-"+dabb;
		CustomDepartment data=customDepartmentDAO.save(prs);
		if(data.getDeptcode()>0){
			Auditrail de=new Auditrail();
			de.setOperation("Inserted");
			de.setRecord(""+data.getDeptcode());
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
	public List<CustomDepartment> findNameActive(long id,String dname,String abb,Integer cid) {
		return customDepartmentDAO.findNameActive(id,dname,abb,cid);
	}
	
	@Override
	public List<CustomDepartment> findNameInactive(long id,String dname,String abb,Integer cid) {
		return customDepartmentDAO.findNameInactive(id,dname,abb,cid);
	}
	
	public void saves(Auditrail de) {
		audittrailDAO.save(de);
	}
	
	@Override
	public CustomDepartment save(CustomDepartment obj) {
		return customDepartmentDAO.save(obj);
	}
	
}