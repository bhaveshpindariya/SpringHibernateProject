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
import com.solusoft.jpa.dao.SiteMasterDAO;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.CompanyMaster;
import com.solusoft.jpa.entity.SiteMaster;


@Service("siteService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class SiteServiceImpl implements SiteService {

	@Autowired
	SiteMasterDAO siteMasterDAO;

	@Autowired
	CompanyMasterDAO companyMasterDAO;
	
	@Autowired
	AudittrailDAO audittrailDAO;
	
	private static final String tabName="SITE_MASTER";
	
	private static final int tabacticve=0;
	
	@Override
	public List<SiteMaster> findAll() {
		return siteMasterDAO.findAll();
	}
	
	@Override
	public List<SiteMaster> findAlls(Integer ccode) {
		return siteMasterDAO.findAlls(ccode);
	}
	
	@Override
	public List<SiteMaster> findNameInactive(String detail,String salias,String sabb,String sadd,Integer ccode){
		return siteMasterDAO.findNameInactive(detail,salias,sabb,sadd,ccode);
	}
	
	@Override
	public List<SiteMaster> findNameActive(String detail,String salias,String sabb,String sadd,Integer ccode){
		return siteMasterDAO.findNameActive(detail,salias,sabb,sadd,ccode);
	}
	
	@Override
	public List<SiteMaster> finddetail(String sname,String salians,String sabbra,String sadd,CompanyMaster co){
		return siteMasterDAO.finddetail(sname,salians,sabbra,sadd,co);
	}
	
	@Override
	public SiteMaster finddetails(String sname,CompanyMaster co){
		return siteMasterDAO.finddetails(sname,co);
	}
	
	@Override
	public List<SiteMaster> findAllInactive() {
		return siteMasterDAO.findAllInactive();
	}
	
	@Override
	public ReadList update(Integer id,String user){
		SiteMaster ss=siteMasterDAO.findId(id);
		String ab=ss.getSabbra();
		String na=ss.getSname();
		String al=ss.getSaliens();
		String ad=ss.getSaddress();
		String coname=ss.getCompanyMaster().getCompanyName();
		String news="Site Name:-"+na+", Site Alias:-"+al+", Abbrevitaion:-"+ab+", Address:-"+ad+", Company Name:-"+coname;
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		Boolean data=siteMasterDAO.delete(id,user);
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
		SiteMaster ss=siteMasterDAO.findId(id);
		String ab=ss.getSabbra();
		String na=ss.getSname();
		String al=ss.getSaliens();
		String ad=ss.getSaddress();
		String coname=ss.getCompanyMaster().getCompanyName();
		String news="Site Name:-"+na+", Site Alias:-"+al+", Abbrevitaion:-"+ab+", Address:-"+ad+", Company Name:-"+coname;
		
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		Boolean data=siteMasterDAO.activeId(id,user);
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
	public ReadList updates(Integer id,String details,String user,String salias,String abbs,String sadd,Integer ccode){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		
		SiteMaster ss=siteMasterDAO.findId(id);
		String ab=ss.getSabbra();
		String na=ss.getSname();
		String al=ss.getSaliens();
		String ad=ss.getSaddress();
		String coname=ss.getCompanyMaster().getCompanyName();
		Timestamp createdDate;
		String createdBy;
		createdBy=ss.getCreatedBy();
		createdDate=ss.getCreatedDate();
		
		CompanyMaster com=companyMasterDAO.findId(ccode);
		String cnamenew=com.getCompanyName();
		String news="";
		String old="";
		if(!na.equalsIgnoreCase(details))
		{
			news=news+"Site Name:-"+details;
			old=old+"Site Name:-"+na;
		}
		if(!al.equalsIgnoreCase(salias))
		{
			if(news !=""){
				news=news+", Site Alias:-"+salias;
				old=old+", Site Alias:-"+al;
			}else{
				news=news+"Site Alias:-"+salias;
				old=old+"Site Alias:-"+al;
			}
		}
		if(!ab.equalsIgnoreCase(abbs)){
			if(news !=""){
				news=news+", Abbrevitaion:-"+abbs;
				old=old+", Abbrevitaion:-"+ab;
			}else{
				news=news+"Abbrevitaion:-"+abbs;
				old=old+"Abbrevitaion:-"+ab;
			}
		}
		if(!ad.equalsIgnoreCase(sadd))
		{
			if(news !=""){
				news=news+", Address:-"+sadd;
				old=old+", Address:-"+ad;
			}else{
				news=news+"Address:-"+sadd;
				old=old+"Address:-"+ad;
			}
			
		}
		if(!coname.equalsIgnoreCase(cnamenew))
		{
			if(news !=""){
				news=news+", Company Name:-"+cnamenew;
				old=old+", Company Name:-"+coname;
			}else{
				news=news+"Company Name:-"+cnamenew;
				old=old+"Company Name:-"+coname;
			}
			
		}
		SiteMaster ssd=new SiteMaster();
		ssd.setId(id);
		ssd.setSname(details);
		ssd.setSaliens(salias);
		ssd.setsabbra(abbs);
		ssd.setsaddress(sadd);
		ssd.setCompanyMaster(com);
		ssd.setCreatedDate(createdDate);
		ssd.setCreatedBy(createdBy);
		ssd.setModifyBy(user);
		ssd.setModifyDate(new Timestamp(new Date().getTime()));
		ssd.setIsactive(tabacticve);
		SiteMaster data=siteMasterDAO.save(ssd);
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
	public ReadList save(String details,String user,String salias,String abbs,String sadd,Integer ccode){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		CompanyMaster com=companyMasterDAO.findId(ccode);
		String cnamenew=com.getCompanyName();
		SiteMaster ss=new SiteMaster();
		ss.setSname(details);
		ss.setSaliens(salias);
		ss.setsabbra(abbs);
		ss.setsaddress(sadd);
		ss.setCompanyMaster(com);
		ss.setCreatedBy(user);
		ss.setCreatedDate(new Timestamp(new Date().getTime()));
		ss.setIsactive(tabacticve);
		String news="Site Name:-"+details+", Site Alias:-"+salias+", Abbrevitaion:-"+abbs+", Address:-"+sadd+", Company Name:-"+cnamenew;
		SiteMaster data=siteMasterDAO.save(ss);
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
	
	public void saves(Auditrail de) {
		audittrailDAO.save(de);
	}
	
	@Override
	public SiteMaster save(SiteMaster obj) {
		return siteMasterDAO.save(obj);
	}
	
	@Override
	public SiteMaster findId(Integer id) {
		return siteMasterDAO.findId(id);
	}
}