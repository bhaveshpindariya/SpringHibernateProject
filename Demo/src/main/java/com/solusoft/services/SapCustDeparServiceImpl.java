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
import com.solusoft.jpa.dao.DepartmentDAO;
import com.solusoft.jpa.dao.SapCustDepartDAO;
import com.solusoft.jpa.dao.SiteMasterDAO;
import com.solusoft.jpa.dao.VerticalDAO;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.CustomDepartment;
import com.solusoft.jpa.entity.DepartmentMaster;
import com.solusoft.jpa.entity.SapCustDepartMapping;
import com.solusoft.jpa.entity.SiteMaster;
import com.solusoft.jpa.entity.VerticalMaster;

@Service("sapCustDeparService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class SapCustDeparServiceImpl implements SapCustDeparService {

	
	@Autowired
	AudittrailDAO audittrailDAO;
	
	@Autowired
	CustomDepartmentDAO customDepartmentDAO;
	
	@Autowired
	DepartmentDAO departmentDAO;
	
	@Autowired
	CompanyMasterDAO companyMasterDAO;
	
	@Autowired
	SapCustDepartDAO sapCustDepartDAO;
	
	@Autowired
	SiteMasterDAO siteMasterDAO;
	
	@Autowired
	VerticalDAO verticalDAO;
	
	private static final String tabName="SAP_CUSTOMDEPARTMENT_MAPPING";
	
	private static final int tabacticve=0;
	
	public void saves(Auditrail de) {
		audittrailDAO.save(de);
	}
	
	@Override
	public List<SapCustDepartMapping> findAll() {
		return sapCustDepartDAO.findAll();
	}
	
	@Override
	public List<SapCustDepartMapping> findAllInactive() {
		return sapCustDepartDAO.findAllInactive();
	}
	
	
	@Override
	public ReadList activeId(Integer id,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		SapCustDepartMapping ll=sapCustDepartDAO.findId(id);
		String custDepart =ll.getCustomDepartment().getDeptname();
		String depart=ll.getDepartmentMaster().getDeptname();
		String sname=ll.getSiteMaster().getSname();
		String news="";
		if(ll.getVerticalMaster() !=null){
			news="Department :-"+depart+", Custom Department :-"+custDepart+", Vertical :-"+ll.getVerticalMaster().getVname()+", Site :-"+sname;
		}else{
			news="Department :-"+depart+", Custom Department :-"+custDepart+", Site :-"+sname;
		}
		Boolean data=sapCustDepartDAO.activeId(id);
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
		SapCustDepartMapping ll=sapCustDepartDAO.findId(id);
		String custDepart =ll.getCustomDepartment().getDeptname();
		String depart=ll.getDepartmentMaster().getDeptname();
		String sname=ll.getSiteMaster().getSname();
		String news="";
		if(ll.getVerticalMaster() !=null){
			news="Department :-"+depart+", Custom Department :-"+custDepart+", Vertical :-"+ll.getVerticalMaster().getVname()+", Site :-"+sname;
		}else{
			news="Department :-"+depart+", Custom Department :-"+custDepart+", Site :-"+sname;
		}
		Boolean data=sapCustDepartDAO.update(id);
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
	public ReadList updates(Integer id,long department,long custDepartment,String user,Integer vid,Integer sid){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		String news="";
		String old="";
		String vname="";
		
		DepartmentMaster ll=departmentDAO.findId(department);
		String departNameNew =ll.getDeptname();
		
		CustomDepartment sig=customDepartmentDAO.findId(custDepartment);
		String custDepart=sig.getDeptname();
		
		String vnames="";
		VerticalMaster ve=null;
		if(vid != 0){
			ve=verticalDAO.findId(vid);
			vnames=ve.getVname();
		}
		
		SiteMaster so=siteMasterDAO.findId(sid);
		String snames=so.getSname();
		
		SapCustDepartMapping le=sapCustDepartDAO.findId(id);
		String departNameold =le.getDepartmentMaster().getDeptname();
		String custDepartold =le.getCustomDepartment().getDeptname();
		if(le.getVerticalMaster()!=null){
			vname=le.getVerticalMaster().getVname();
		}
		String sname=le.getSiteMaster().getSname();
		Timestamp createdDate;
		String createdBy;
		createdBy=le.getCreatedBy();
		createdDate=le.getCreatedDate();
		
		if(!departNameNew.equalsIgnoreCase(departNameold))
		{
		   news=news+"Department :-"+departNameNew;
		   old=old+"Department :-"+departNameold;
			
		}
		
		if(!custDepart.equalsIgnoreCase(custDepartold))
		{
			if(news !=""){
				news=news+", Custom Department :-"+custDepart;
				old=old+", Custom Department :-"+custDepartold;
			}else{
				news=news+"Custom Department :-"+custDepart;
				old=old+"Custom Department :-"+custDepartold;
			}
		}
		
		if(vname !=""){
			if(vnames !=""){
				if(!vname.equalsIgnoreCase(vnames))
				{
					if(news !=""){
						news=news+", Vertical Name:-"+vnames;
						old=old+", Vertical Name:-"+vname;
					}else{
						news=news+"Vertical Name:-"+vnames;
						old=old+"Vertical Name:-"+vname;
					}
				}
			}else{
				if(!vname.equalsIgnoreCase(vnames))
				{
					if(news !=""){
						old=old+", Vertical Name:-"+vname;
					}else{
						old=old+"Vertical Name:-"+vname;
					}
				}
			}
		}else{
			if(vnames !=""){
				if(!vname.equalsIgnoreCase(vnames))
				{
					if(news !=""){
						news=news+", Vertical Name:-"+vnames;
					}else{
						news=news+"Vertical Name:-"+vnames;
					}
				}
			}
		}
		
		if(!snames.equalsIgnoreCase(sname))
		{
			if(news !=""){
				news=news+", Site :-"+snames;
				old=old+", Site :-"+sname;
			}else{
				news=news+"Site :-"+snames;
				old=old+"Site :-"+sname;
			}
		}
		SapCustDepartMapping ss=new SapCustDepartMapping();
		ss.setId(id);
		ss.setCustomDepartment(sig);
		ss.setDepartmentMaster(ll);
		ss.setCreatedDate(createdDate);
		ss.setCreatedBy(createdBy);
		ss.setVerticalMaster(ve);
		ss.setSiteMaster(so);
		ss.setModifyBy(user);
		ss.setModifyDate(new Timestamp(new Date().getTime()));
		ss.setIsactive(tabacticve);
		SapCustDepartMapping data=sapCustDepartDAO.save(ss);
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
	public List<SapCustDepartMapping> findNameActive(long department,long custDepartment,Integer vid,Integer sid) {
		return sapCustDepartDAO.findNameActive(department,custDepartment,vid,sid);
	}
	
	@Override
	public SapCustDepartMapping finddetail(long department,long custDepartment,Integer vid,Integer sid) {
		return sapCustDepartDAO.finddetail(department,custDepartment,vid,sid);
	}
	
	@Override
	public List<SapCustDepartMapping> findNameInactive(long department,long custDepartment,Integer vid,Integer sid) {
		return sapCustDepartDAO.findNameInactive(department,custDepartment,vid,sid);
	}
	
	@Override
	public ReadList save(long department,long custDepartment,String user,Integer vid,Integer sid){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		
		DepartmentMaster ll=departmentDAO.findId(department);
		String departNameNew =ll.getDeptname();
		
		CustomDepartment sig=customDepartmentDAO.findId(custDepartment);
		String custDepart=sig.getDeptname();
		
		String vnames="";
		VerticalMaster ve=null;
		if(vid != 0){
			ve=verticalDAO.findId(vid);
			vnames=ve.getVname();
		}
		
		SiteMaster so=siteMasterDAO.findId(sid);
		String sname=so.getSname();
		
		
		String news="";
		if(ve !=null){
			news="Department :-"+departNameNew+", Custom Department :-"+custDepart+", Vertical :-"+vnames+", Site :-"+sname;
		}else{
			news="Department :-"+departNameNew+", Custom Department :-"+custDepart+", Site :-"+sname;
		}
		
		SapCustDepartMapping ss=new SapCustDepartMapping();
		ss.setCustomDepartment(sig);
		ss.setDepartmentMaster(ll);
		ss.setCreatedBy(user);
		ss.setVerticalMaster(ve);
		ss.setSiteMaster(so);
		ss.setCreatedDate(new Timestamp(new Date().getTime()));
		ss.setIsactive(tabacticve);
		SapCustDepartMapping data=sapCustDepartDAO.save(ss);
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
	public SapCustDepartMapping save(SapCustDepartMapping obj) {
		return sapCustDepartDAO.save(obj);
	}
}
