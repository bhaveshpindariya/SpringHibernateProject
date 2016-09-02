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
import com.solusoft.jpa.dao.EmpSiteVerDAO;
import com.solusoft.jpa.dao.EmployeeDAO;
import com.solusoft.jpa.dao.SiteMasterDAO;
import com.solusoft.jpa.dao.VerticalDAO;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.EmpSiteVer;
import com.solusoft.jpa.entity.EmployeeMaster;
import com.solusoft.jpa.entity.SiteMaster;
import com.solusoft.jpa.entity.VerticalMaster;

@Service("empSiteVerService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class EmpSiteVerServiceImpl implements EmpSiteVerService {

	
	@Autowired
	AudittrailDAO audittrailDAO;
	
	@Autowired
	SiteMasterDAO siteMasterDAO;
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	@Autowired
	VerticalDAO verticalDAO;
	
	@Autowired
	EmpSiteVerDAO empSiteVerDAO;
	
	private static final String tabName="EMPLOYEE_SITE_VERTICAL";
	
	private static final int tabacticve=0;
	
	@Override
	public List<EmpSiteVer> findAll() {
		return empSiteVerDAO.findAll();
	}
	
	@Override
	public List<EmpSiteVer> findAllInactive() {
		return empSiteVerDAO.findAllInactive();
	}
	
	
	@Override
	public ReadList activeId(Integer id,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		EmpSiteVer ll=empSiteVerDAO.findId(id);
		String sname=ll.getSiteMaster().getSname();
		String ename=ll.getEmployeeMaster().getName();
		String news="";
		if(ll.getVerticalMaster() !=null){
			news="Employee Name:-"+ename+", Site Name:-"+sname+", Vertical Name:-"+ll.getVerticalMaster().getVname();
		}else{
			news="Employee Name:-"+ename+", Site Name:-"+sname;
		}
		Boolean data=empSiteVerDAO.activeId(id,user);
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
		EmpSiteVer ll=empSiteVerDAO.findId(id);
		String sname=ll.getSiteMaster().getSname();
		String ename=ll.getEmployeeMaster().getName();
		String news="";
		if(ll.getVerticalMaster() !=null){
			news="Employee Name:-"+ename+", Site Name:-"+sname+", Vertical Name:-"+ll.getVerticalMaster().getVname();
		}else{
			news="Employee Name:-"+ename+", Site Name:-"+sname;
		}
		Boolean data=empSiteVerDAO.delete(id, user);
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
	public ReadList updates(Integer id,long empId,Integer sitId,Integer verId,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		String news="";
		String old="";
		String vname="";
		EmpSiteVer ll=empSiteVerDAO.findId(id);
		String salian=ll.getSiteMaster().getSname();
		String ename=ll.getEmployeeMaster().getName();
		if(ll.getVerticalMaster()!=null){
			vname=ll.getVerticalMaster().getVname();
		}
		Timestamp createdDate;
		String createdBy;
		createdBy=ll.getCreatedBy();
		createdDate=ll.getCreatedDate();
		
		SiteMaster sig=siteMasterDAO.findId(sitId);
		String salians=sig.getSname();
		
		EmployeeMaster le=employeeDAO.findId(empId);
		String enames=le.getName();
		String vnames="";
		VerticalMaster ve=null;
		if(verId != 0){
			ve=verticalDAO.findId(verId);
			vnames=ve.getVname();
		}
		
		if(!ename.equalsIgnoreCase(enames))
		{
			news=news+"Employee Name:-"+enames;
			old=old+"Employee Name:-"+ename;
		}
		
		if(!salian.equalsIgnoreCase(salians))
		{
			if(news !=""){
				news=news+", Site Name:-"+salians;
				old=old+", Site Name:-"+salian;
			}else{
				news=news+"Site Name:-"+salians;
				old=old+"Site Name:-"+salian;
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
		
		
		EmpSiteVer ss=new EmpSiteVer();
		ss.setId(id);
		ss.setEmployeeMaster(le);
		ss.setSiteMaster(sig);
		ss.setVerticalMaster(ve);
		ss.setCreatedDate(createdDate);
		ss.setCreatedBy(createdBy);
		ss.setModifyBy(user);
		ss.setModifyDate(new Timestamp(new Date().getTime()));
		ss.setIsactive(tabacticve);
		EmpSiteVer data=empSiteVerDAO.save(ss);
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
	public List<EmpSiteVer> findNameActive(Integer sitId,long empId,Integer verId) {
		return empSiteVerDAO.findNameActive(sitId,empId,verId);
	}
	
	@Override
	public List<EmpSiteVer> findNameInactive(Integer sitId,long empId,Integer verId) {
		return empSiteVerDAO.findNameInactive(sitId,empId,verId);
	}
	
	@Override
	public ReadList save(long empId,Integer sitId,Integer verId,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		SiteMaster sig=siteMasterDAO.findId(sitId);
		String sname=sig.getSname();
		
		EmployeeMaster le=employeeDAO.findId(empId);
		String enames=le.getName();
		
		String vnames="";
		VerticalMaster ve=null;
		if(verId != 0){
			ve=verticalDAO.findId(verId);
			vnames=ve.getVname();
		}
		
		String news="";
		if(ve !=null){
			news="Employee Name:-"+enames+", Site Name:-"+sname;
		}else{
			news="Employee Name:-"+enames+", Site Name:-"+sname+", Vertical Name:-"+vnames;
		}
		
		EmpSiteVer ss=new EmpSiteVer();
		ss.setEmployeeMaster(le);
		ss.setSiteMaster(sig);
		ss.setVerticalMaster(ve);
		ss.setCreatedBy(user);
		ss.setCreatedDate(new Timestamp(new Date().getTime()));
		ss.setIsactive(tabacticve);
		EmpSiteVer data=empSiteVerDAO.save(ss);
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
}
