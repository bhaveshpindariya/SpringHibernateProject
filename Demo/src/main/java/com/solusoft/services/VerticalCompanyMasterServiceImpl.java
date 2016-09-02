
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
import com.solusoft.jpa.dao.VerticalCompanyMasterDAO;
import com.solusoft.jpa.dao.VerticalDAO;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.CompanyMaster;
import com.solusoft.jpa.entity.VerticalCompanyMaster;
import com.solusoft.jpa.entity.VerticalMaster;

@Service("verticalCompanyMasterService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class VerticalCompanyMasterServiceImpl implements VerticalCompanyMasterService {

	
	@Autowired
	AudittrailDAO audittrailDAO;
	
	@Autowired
	VerticalDAO verticalDAO;
	
	@Autowired
	CompanyMasterDAO companyMasterDAO;
	
	@Autowired
	VerticalCompanyMasterDAO verticalCompanyMasterDAO;
	
	private static final String tabName="VERTICAL_COMPANY_MASTER";
	
	private static final int tabacticve=0;
	
	@Override
	public List<VerticalCompanyMaster> findAll() {
		return verticalCompanyMasterDAO.findAll();
	}
	
	@Override
	public List<VerticalCompanyMaster> findAllInactive() {
		return verticalCompanyMasterDAO.findAllInactive();
	}
	
	@Override
	public ReadList update(Integer id,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		VerticalCompanyMaster ll=verticalCompanyMasterDAO.findId(id);
		String vname=ll.getVerticalMaster().getVname();
		String cname=ll.getCompanyMaster().getCompanyName();
		String news="Vertical Name:-"+vname+", Company Name:-"+cname;
		Boolean data=verticalCompanyMasterDAO.delete(id,user);
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
		VerticalCompanyMaster ll=verticalCompanyMasterDAO.findId(id);
		String vname=ll.getVerticalMaster().getVname();
		String cname=ll.getCompanyMaster().getCompanyName();
		String news="Vertical Name:-"+vname+", Company Name:-"+cname;
		Boolean data=verticalCompanyMasterDAO.activeId(id,user);
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
	public ReadList updates(Integer id,Integer vId,Integer cid,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		String news="";
		String old="";
		
		VerticalCompanyMaster ll=verticalCompanyMasterDAO.findId(id);
		String vname=ll.getVerticalMaster().getVname();
		String cname=ll.getCompanyMaster().getCompanyName();
		Timestamp createdDate;
		String createdBy;
		createdBy=ll.getCreatedBy();
		createdDate=ll.getCreatedDate();
		
		VerticalMaster sig=verticalDAO.findId(vId);
		String vnames=sig.getVname();
		
		CompanyMaster le=companyMasterDAO.findId(cid);
		String cnames=le.getCompanyName();
		
		
		if(!vname.equalsIgnoreCase(vnames))
		{
			news=news+"Vertical Name:-"+vnames;
			old=old+"Vertical Name:-"+vname;
		}
		if(!cname.equalsIgnoreCase(cnames))
		{
			if(news !=""){
				news=news+", Company Name:-"+cnames;
				old=old+", Company Name:-"+cname;
			}else{
				news=news+"Company Name:-"+cnames;
				old=old+"Company Name:-"+cname;
			}
			
		}
		
		VerticalCompanyMaster ss=new VerticalCompanyMaster();
		ss.setId(id);
		ss.setVerticalMaster(sig);
		ss.setCompanyMaster(le);
		ss.setCreatedDate(createdDate);
		ss.setCreatedBy(createdBy);
		ss.setModifyBy(user);
		ss.setModifyDate(new Timestamp(new Date().getTime()));
		ss.setIsactive(tabacticve);
		VerticalCompanyMaster data=verticalCompanyMasterDAO.save(ss);
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
	public ReadList save(Integer vId,Integer cid,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		
		VerticalMaster sig=verticalDAO.findId(vId);
		String vnames=sig.getVname();
		
		CompanyMaster le=companyMasterDAO.findId(cid);
		String cnames=le.getCompanyName();
		
		String news="Vertical Name:-"+vnames+", Company Name:-"+cnames;
		
		VerticalCompanyMaster ss=new VerticalCompanyMaster();
		ss.setVerticalMaster(sig);
		ss.setCompanyMaster(le);
		ss.setCreatedBy(user);
		ss.setCreatedDate(new Timestamp(new Date().getTime()));
		ss.setIsactive(tabacticve);
		VerticalCompanyMaster data=verticalCompanyMasterDAO.save(ss);
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
	public List<VerticalCompanyMaster> findNameActive(Integer vId,Integer cId) {
		return verticalCompanyMasterDAO.findNameActive(vId,cId);
	}
	
	@Override
	public List<VerticalCompanyMaster> findNameInactive(Integer vId,Integer cId) {
		return verticalCompanyMasterDAO.findNameInactive(vId,cId);
	}
	
	@Override
	public List<VerticalCompanyMaster> finddata(Integer vId,Integer cId) {
		return verticalCompanyMasterDAO.finddata(vId,cId);
	}
	
	@Override
	public VerticalCompanyMaster saves(VerticalCompanyMaster obj) {
		return verticalCompanyMasterDAO.saves(obj);
	}
}
