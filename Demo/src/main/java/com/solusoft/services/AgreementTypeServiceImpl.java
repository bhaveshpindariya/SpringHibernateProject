package com.solusoft.services;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.dao.AgreementTypeDAO;
import com.solusoft.jpa.dao.AudittrailDAO;
import com.solusoft.jpa.dao.CompanyMasterDAO;
import com.solusoft.jpa.entity.AgreementTypeMaster;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.CompanyMaster;


@Service("agreementTypeServicer")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class AgreementTypeServiceImpl implements AgreementTypeServicer {

	@Autowired
	AgreementTypeDAO agreementTypeDAO;
	
	@Autowired
	AudittrailDAO audittrailDAO;

	@Autowired
	CompanyMasterDAO companyMasterDAO;
	
	private static final String tabName="AGREEMENT_TYPE";
	
	private static final int tabacticve=0;
	
	@Override
	public List<AgreementTypeMaster> findAgreementType(String agtype) {
		return agreementTypeDAO.findAgreementType(agtype);
	}
	
	@Override
	public List<AgreementTypeMaster> findAll() {
		return agreementTypeDAO.findAll();
	}
	
	@Override
	public List<AgreementTypeMaster> findAllByCompany(Integer name) {
		return agreementTypeDAO.findAllByCompany(name);
	}
	
	@Override
	public List<AgreementTypeMaster> findAllInactive() {
		return agreementTypeDAO.findAllInactive();
	}
	
	@Override
	public ReadList activeId(Integer id,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		AgreementTypeMaster ss=agreementTypeDAO.findId(id);
		String aname=ss.getAgreementtype();
		String cname=ss.getCompanyMaster().getCompanyName();
		String news="Comapany Name:-"+cname+", Agreement type:-"+aname;
		Boolean data=agreementTypeDAO.activeId(id,user);
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
	public ReadList delete(Integer id,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		AgreementTypeMaster pr=agreementTypeDAO.findId(id);
		String aname=pr.getAgreementtype();
		String cname=pr.getCompanyMaster().getCompanyName();
		String news="Comapany Name:-"+cname+", Agreement type:-"+aname;
		Boolean data=agreementTypeDAO.delete(id,user);
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
	public ReadList updates(Integer id,String anamenew,Integer cid,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		
		AgreementTypeMaster pr=agreementTypeDAO.findId(id);
		String aname=pr.getAgreementtype();
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
		if(!aname.equalsIgnoreCase(anamenew))
		{
			if(news !=""){
				news=news+", Agreement type:-"+anamenew;
				old=old+", Agreement type:-"+aname;
			}else{
				news=news+"Agreement type:-"+anamenew;
				old=old+"Agreement type:-"+aname;
			}
			
		}
		
		AgreementTypeMaster prs=new AgreementTypeMaster();
		prs.setId(id);
		prs.setAgreementtype(anamenew);
		prs.setModifyBy(user);
		prs.setModifyDate(new Timestamp(new Date().getTime()));
		prs.setCompanyMaster(co);
		prs.setCreatedDate(createdDate);
		prs.setCreatedBy(createdBy);
		prs.setIsactive(tabacticve);
		AgreementTypeMaster data=agreementTypeDAO.save(prs);
		if(news!=""){
			if(data.getId()>0){
				Auditrail de=new Auditrail();
				de.setOperation("Update");
				de.setRecord(""+data.getId());
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
	public ReadList save(String name,Integer cid,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		CompanyMaster co=companyMasterDAO.findId(cid);
		String cnames=co.getCompanyName();
		AgreementTypeMaster prs=new AgreementTypeMaster();
		prs.setAgreementtype(name);
		prs.setCompanyMaster(co);
		prs.setCreatedBy(user);
		prs.setCreatedDate(new Timestamp(new Date().getTime()));
		prs.setIsactive(tabacticve);
		String news="Comapany Name:-"+cnames+", Agreement type:-"+name;
		AgreementTypeMaster data=agreementTypeDAO.save(prs);
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
	public AgreementTypeMaster finddetail(CompanyMaster cname,String name) {
		return agreementTypeDAO.finddetail(cname,name);
	}
	
	@Override
	public List<AgreementTypeMaster> findNameActive(String name,Integer cid) {
		return agreementTypeDAO.findNameActive(name,cid);
	}
	
	@Override
	public List<AgreementTypeMaster> findNameInactive(String name,Integer cid) {
		return agreementTypeDAO.findNameInactive(name,cid);
	}
	
	@Override
	public AgreementTypeMaster saves(AgreementTypeMaster obj) {
		return agreementTypeDAO.saves(obj);
	}
	
	public void intse(Auditrail de) {
		audittrailDAO.save(de);
	}
}