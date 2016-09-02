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
import com.solusoft.jpa.dao.BRLGroupDAO;
import com.solusoft.jpa.dao.CompanyMasterDAO;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.BRLGroup;
import com.solusoft.jpa.entity.CompanyMaster;

@Service("bRLGroupService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class BRLGroupServiceImpl implements BRLGroupService {

	@Autowired
	BRLGroupDAO bRLGroupDAO;

	@Autowired
	CompanyMasterDAO companyMasterDAO;
	
	@Autowired
	AudittrailDAO audittrailDAO;
	
	private static final String tabName="BRL_GROUP";
	
	private static final int tabacticve=0;
	
	@Override
	public List<BRLGroup> findAll() {
		return bRLGroupDAO.findAll();
	}
	
	@Override
	public List<BRLGroup> findAllInactive() {
		return bRLGroupDAO.findAllInactive();
	}
	
	@Override
	public ReadList update(Integer id,String user){
		BRLGroup ss=bRLGroupDAO.findId(id);
		String gname=ss.getGroupname();
		String abbre=ss.getAbbreviation();
		String coname=ss.getCompanyMaster().getCompanyName();
		String news="Company name:-"+coname+", BRL Group/Lab:-"+gname+", Abbreviation:-"+abbre;
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		Boolean data=bRLGroupDAO.delete(id,user);
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
		BRLGroup ss=bRLGroupDAO.findId(id);
		String gname=ss.getGroupname();
		String abbre=ss.getAbbreviation();
		String coname=ss.getCompanyMaster().getCompanyName();
		String news="Company name:-"+coname+", BRL Group/Lab:-"+gname+", Abbreviation:-"+abbre;
		Boolean data=bRLGroupDAO.activeId(id,user);
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
	public ReadList updates(Integer id,Integer ccode,String name,String abbre,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		BRLGroup ss=bRLGroupDAO.findId(id);
		String gname=ss.getGroupname();
		String abbres=ss.getAbbreviation();
		String coname=ss.getCompanyMaster().getCompanyName();
		Timestamp createdDate;
		String createdBy;
		createdBy=ss.getCreatedBy();
		createdDate=ss.getCreatedDate();
		
		CompanyMaster com=companyMasterDAO.findId(ccode);
		String cnamenew=com.getCompanyName();
		String news="";
		String old="";
		
		if(!coname.equalsIgnoreCase(cnamenew))
		{
			news=news+"Comapany Name:-"+cnamenew;
			old=old+"Comapany Name:-"+coname;
		}
		if(!gname.equalsIgnoreCase(name))
		{
			if(news !=""){
				news=news+", Abbreviation:-"+name;
				old=old+", Abbreviation:-"+gname;
			}else{
				news=news+"Abbreviation:-"+name;
				old=old+"Abbreviation:-"+gname;
			}
			
		}
		
		if(!abbres.equalsIgnoreCase(abbre))
		{
			if(news !=""){
				news=news+", BRL Group/Lab:-"+abbre;
				old=old+", BRL Group/Lab:-"+abbres;
			}else{
				news=news+"BRL Group/Lab:-"+abbre;
				old=old+"BRL Group/Lab:-"+abbres;
			}
			
		}
		
		BRLGroup ssd=new BRLGroup();
		ssd.setId(id);
		ssd.setGroupname(name);
		ssd.setAbbreviation(abbre);
		ssd.setCompanyMaster(com);
		ssd.setCreatedDate(createdDate);
		ssd.setCreatedBy(createdBy);
		ssd.setModifyBy(user);
		ssd.setModifyDate(new Timestamp(new Date().getTime()));
		ssd.setIsactive(tabacticve);
		BRLGroup data=bRLGroupDAO.save(ssd);
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
	public ReadList save(Integer ccode,String name,String abbre,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		CompanyMaster com=companyMasterDAO.findId(ccode);
		String cnamenew=com.getCompanyName();
		BRLGroup ss=new BRLGroup();
		ss.setGroupname(name);
		ss.setAbbreviation(abbre);
		ss.setCompanyMaster(com);
		ss.setCreatedBy(user);
		ss.setCreatedDate(new Timestamp(new Date().getTime()));
		ss.setIsactive(tabacticve);
		String news="Company name:-"+cnamenew+", BRL Group/Lab:-"+name+", Abbreviation:-"+abbre;
		BRLGroup data=bRLGroupDAO.save(ss);
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
	public List<BRLGroup> findNameActive(String name,String abbre) {
		return bRLGroupDAO.findNameActive(name,abbre);
	}
	
	@Override
	public List<BRLGroup> findNameInactive(String name,String abbre) {
		return bRLGroupDAO.findNameInactive(name,abbre);
	}
}