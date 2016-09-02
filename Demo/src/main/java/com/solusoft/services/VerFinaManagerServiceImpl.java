
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
import com.solusoft.jpa.dao.EmployeeDAO;
import com.solusoft.jpa.dao.VerFinaManagerDAO;
import com.solusoft.jpa.dao.VerticalDAO;
import com.solusoft.jpa.entity.AgreementTypeMaster;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.EmployeeMaster;
import com.solusoft.jpa.entity.VerticalFinanceManager;
import com.solusoft.jpa.entity.VerticalMaster;

@Service("verFinaManagerService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class VerFinaManagerServiceImpl implements VerFinaManagerService {

	
	@Autowired
	AudittrailDAO audittrailDAO;
	
	@Autowired
	VerticalDAO verticalDAO;
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	@Autowired
	AgreementTypeDAO agreementTypeDAO;
	
	@Autowired
	VerFinaManagerDAO verFinaManagerDAO;
	
	private static final String tabName="AGR_VERTICAL_OTHER_APPROVERS";
	
	private static final int tabacticve=0;
	
	@Override
	public List<VerticalFinanceManager> findAll() {
		return verFinaManagerDAO.findAll();
	}
	
	@Override
	public List<VerticalFinanceManager> findAllInactive() {
		return verFinaManagerDAO.findAllInactive();
	}
	
	@Override
	public ReadList activeId(Integer id,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		VerticalFinanceManager ll=verFinaManagerDAO.findId(id);
		String vname=ll.getVerticalMaster().getVname();
		String ename=ll.getEmployeeMaster().getName();
		String aname=ll.getAgreementTypeMaster().getAgreementtype();
		String news="Vertical Name:-"+vname+", Employee Name:-"+ename+", Agreement Name:-"+aname;
		Boolean data=verFinaManagerDAO.activeId(id,user);
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
		VerticalFinanceManager ll=verFinaManagerDAO.findId(id);
		String vname=ll.getVerticalMaster().getVname();
		String ename=ll.getEmployeeMaster().getName();
		String aname=ll.getAgreementTypeMaster().getAgreementtype();
		String news="Vertical Name:-"+vname+", Employee Name:-"+ename+", Agreement Name:-"+aname;
		Boolean data=verFinaManagerDAO.delete(id,user);
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
	public ReadList updates(Integer id,long empId,Integer vId,Integer aid,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		
		VerticalFinanceManager ll=verFinaManagerDAO.findId(id);
		String vname=ll.getVerticalMaster().getVname();
		String ename=ll.getEmployeeMaster().getName();
		String aname=ll.getAgreementTypeMaster().getAgreementtype();
		Timestamp createdDate;
		String createdBy;
		createdBy=ll.getCreatedBy();
		createdDate=ll.getCreatedDate();
		
		VerticalMaster sig=verticalDAO.findId(vId);
		String vnames=sig.getVname();
		
		EmployeeMaster le=employeeDAO.findId(empId);
		String enames=le.getName();
		
		AgreementTypeMaster ae=agreementTypeDAO.findId(aid);
		String anames=ae.getAgreementtype();
		
		String news="";
		String old="";
		if(!vname.equalsIgnoreCase(vnames))
		{
			news=news+"Vertical Name:-"+vnames;
			old=old+"Vertical Name:-"+vname;
		}
		if(!ename.equalsIgnoreCase(enames))
		{
			if(news !=""){
				news=news+", Employee Name:-"+enames;
				old=old+", Employee Name:-"+ename;
			}else{
				news=news+"Employee Name:-"+enames;
				old=old+"Employee Name:-"+ename;
			}
			
		}
		
		if(!aname.equalsIgnoreCase(anames))
		{
			if(news !=""){
				news=news+", Agreement Name:-"+anames;
				old=old+", Agreement Name:-"+aname;
			}else{
				news=news+"Agreement Name:-"+anames;
				old=old+"Agreement Name:-"+aname;
			}
			
		}
		VerticalFinanceManager ss=new VerticalFinanceManager();
		ss.setId(id);
		ss.setEmployeeMaster(le);
		ss.setVerticalMaster(sig);
		ss.setAgreementTypeMaster(ae);
		ss.setCreatedDate(createdDate);
		ss.setCreatedBy(createdBy);
		ss.setModifyBy(user);
		ss.setModifyDate(new Timestamp(new Date().getTime()));
		ss.setIsactive(tabacticve);
		VerticalFinanceManager data=verFinaManagerDAO.save(ss);
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
	public ReadList save(long empId,Integer vId,Integer aid,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		
		VerticalMaster sig=verticalDAO.findId(vId);
		String vnames=sig.getVname();
		
		EmployeeMaster le=employeeDAO.findId(empId);
		String enames=le.getName();
		
		AgreementTypeMaster ae=agreementTypeDAO.findId(aid);
		String anames=ae.getAgreementtype();
		
		String news="Vertical Name:-"+vnames+", Employee Name:-"+enames+", Agreement Name:-"+anames;
		
		VerticalFinanceManager ss=new VerticalFinanceManager();
		ss.setEmployeeMaster(le);
		ss.setVerticalMaster(sig);
		ss.setAgreementTypeMaster(ae);
		ss.setCreatedBy(user);
		ss.setCreatedDate(new Timestamp(new Date().getTime()));
		ss.setIsactive(tabacticve);
		VerticalFinanceManager data=verFinaManagerDAO.save(ss);
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
	public List<VerticalFinanceManager> findNameActive(long empId,Integer vId,Integer aId) {
		return verFinaManagerDAO.findNameActive(empId,vId,aId);
	}
	
	@Override
	public List<VerticalFinanceManager> findNameInactive(long empId,Integer vId,Integer aId) {
		return verFinaManagerDAO.findNameInactive(empId,vId,aId);
	}
	
	@Override
	public VerticalFinanceManager saves(VerticalFinanceManager obj) {
		return verFinaManagerDAO.saves(obj);
	}
	
	@Override
	public VerticalFinanceManager finddata(long empId,Integer vId,Integer aId) {
		return verFinaManagerDAO.finddata(empId,vId,aId);
	}
}
