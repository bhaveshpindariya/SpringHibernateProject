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
import com.solusoft.jpa.dao.VerticalDAO;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.VerticalMaster;

@Service("verticalService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class VerticalServiceImpl implements VerticalService {

	@Autowired
	VerticalDAO verticalDAO;
	
	@Autowired
	AudittrailDAO audittrailDAO;
	
	private static final String tabName="VERTICAL_MASTER";
	
	private static final int tabacticve=0;
	
	@Override
	public List<VerticalMaster> findAll() {
		return verticalDAO.findAll();
	}
	
	@Override
	public List<VerticalMaster> findAllInactive() {
		return verticalDAO.findAllInactive();
	}
	
	@Override
	public ReadList activeId(Integer id,String user){
		ReadList rs = new ReadList();
		VerticalMaster ss=verticalDAO.findId(id);
		String name=ss.getVname();
		String news="Vertical Name:-"+name;
		rs.setSuccess(false);
		Boolean data=verticalDAO.activeId(id,user);
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
	public ReadList updateVer(Integer id,String user){
		ReadList rs = new ReadList();
		VerticalMaster ss=verticalDAO.findId(id);
		String name=ss.getVname();
		String news="Vertical Name:-"+name;
		rs.setSuccess(false);
		Boolean data=verticalDAO.delete(id,user);
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
	public ReadList updatesVer(Integer id,String details,String user,String vabb){
		ReadList rs = new ReadList();
		
		VerticalMaster ss=verticalDAO.findId(id);
		String name=ss.getVname();
		String vb=ss.getVerabbreviation();
		Timestamp createdDate;
		String createdBy;
		createdBy=ss.getCreatedBy();
		createdDate=ss.getCreatedDate();
		
		String news="";
		String old="";
		if(!name.equalsIgnoreCase(details))
		{
			news=news+"Vertical Name:-"+details;
			old=old+"Vertical Name:-"+name;
		}
		
		if(vb !=null){
		 if(!vb.equalsIgnoreCase(vabb))
		  {
			if(news !=""){
				news=news+", Vertical Abbreviation:-"+vabb;
				old=old+", Vertical Abbreviation:-"+vb;
			}else{
				news=news+"Vertical Abbreviation:-"+vabb;
				old=old+"Vertical Abbreviation:-"+vb;
			}
			
		  }
		}else{
			if(news !=""){
				news=news+", Vertical Abbreviation:-"+vabb;
				old=old+", Vertical Abbreviation:-"+vb;
			}else{
				news=news+"Vertical Abbreviation:-"+vabb;
				old=old+"Vertical Abbreviation:-"+vb;
			}
		}
		rs.setSuccess(false);
		VerticalMaster ssd=new VerticalMaster();
		ssd.setId(id);
		ssd.setVname(details);
		ssd.setVerabbreviation(vabb);
		ssd.setCreatedDate(createdDate);
		ssd.setCreatedBy(createdBy);
		ssd.setModifyBy(user);
		ssd.setModifyDate(new Timestamp(new Date().getTime()));
		ssd.setIsactive(tabacticve);
		VerticalMaster data=verticalDAO.saveVer(ssd);
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
	public ReadList saveVer(String details,String user,String vabb){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		VerticalMaster ss=new VerticalMaster();
		ss.setVname(details);
		ss.setVerabbreviation(vabb);
		ss.setCreatedBy(user);
		ss.setCreatedDate(new Timestamp(new Date().getTime()));
		ss.setIsactive(tabacticve);
		String news="Vertical Name:-"+details+", Vertical Abbreviation:-"+vabb;
		VerticalMaster data=verticalDAO.saveVer(ss);
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
	public List<VerticalMaster> findNameActive(String detail,String ab) {
		return verticalDAO.findNameActive(detail,ab);
	}
	
	@Override
	public List<VerticalMaster> findNameInactive(String detail,String ab) {
		return verticalDAO.findNameInactive(detail,ab);
	}
	
	@Override
	public VerticalMaster save(VerticalMaster obj) {
		return verticalDAO.save(obj);
	}
	
	public void saves(Auditrail de) {
		audittrailDAO.save(de);
	}
	
	@Override
	public VerticalMaster findId(Integer id) {
		return verticalDAO.findId(id);
	}
	
	@Override
	public VerticalMaster findName(String name) {
		return verticalDAO.findName(name);
	}
	
	@Override
	public List<VerticalMaster> findNames(String name,String abs) {
		return verticalDAO.findNames(name,abs);
	}
}