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
import com.solusoft.jpa.dao.AgreementscreensDAO;
import com.solusoft.jpa.dao.AudittrailDAO;
import com.solusoft.jpa.entity.AgreementScreens;
import com.solusoft.jpa.entity.AgreementTypeMaster;
import com.solusoft.jpa.entity.Auditrail;

@Service("agreementscreensService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class AgreementscreensServiceImpl implements AgreementscreensService {

	@Autowired
	AgreementscreensDAO agreementscreensDAO;
	
	@Autowired
	AgreementTypeDAO agreementTypeDAO;
	
	@Autowired
	AudittrailDAO audittrailDAO;

	private static final String tabName="AGREEMENT_SCREENS";
	
	private static final int tabacticve=0;
	
	@Override
	public List<AgreementScreens> findalldata() {
		return agreementscreensDAO.findalldata();
	}
	
	public void delete(AgreementScreens entity){
		agreementscreensDAO.delete(entity);
	}
	
	@Override
	public List<AgreementScreens> findactive() {
		return agreementscreensDAO.findactive();
	}
	
	@Override
	public List<AgreementScreens> findAllInactive() {
		return agreementscreensDAO.findAllInactive();
	}
	
	@Override
	public AgreementScreens savedata(AgreementScreens obj) {
		return agreementscreensDAO.savedata(obj);
	}
	
	@Override
	public ReadList activeId(Integer id,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		AgreementScreens ll=agreementscreensDAO.findId(id);
		String aname=ll.getAgreementTypeMaster().getAgreementtype();
		String vid=ll.getViewid();
		String vname=ll.getViewname();
		String sfor=ll.getScreenfor();
		String news="Agreement Name:-"+aname+", View Id:-"+vid+", View Name:-"+vname+", Screen For"+sfor;
		Boolean data=agreementscreensDAO.activeId(id,user);
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
	public ReadList deleteId(Integer id,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		AgreementScreens ll=agreementscreensDAO.findId(id);
		String aname=ll.getAgreementTypeMaster().getAgreementtype();
		String vid=ll.getViewid();
		String vname=ll.getViewname();
		String sfor=ll.getScreenfor();
		String news="Agreement Name:-"+aname+", View Id:-"+vid+", View Name:-"+vname+", Screen For"+sfor;
		Boolean data=agreementscreensDAO.delete(id,user);
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
    public ReadList updates(Integer id,Integer aid,String vid,String viewname,String scrfor,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		
		AgreementScreens ll=agreementscreensDAO.findId(id);
		String oldaname=ll.getAgreementTypeMaster().getAgreementtype();
		String oldviewid=ll.getViewid();
		String oldvname=ll.getViewname();
		String oldsfor=ll.getScreenfor();
		Timestamp createdDate;
		String createdBy;
		createdBy=ll.getCreatedBy();
		createdDate=ll.getCreatedDate();
		AgreementTypeMaster ss=agreementTypeDAO.findId(aid);
		String newaname=ss.getAgreementtype();
		
		String news="";
		String old="";
		
		if(!oldaname.equalsIgnoreCase(newaname))
		{
			news=news+"Agreement type:-"+newaname;
			old=old+",Agreement type:-"+oldaname;
		}
		
		if(!oldviewid.equalsIgnoreCase(vid))
		{
			if(news !=""){
				news=news+", View Id:-"+vid;
				old=old+", View Id:-"+oldviewid;
			}else{
				news=news+"View Id:-"+vid;
				old=old+"View Id:-"+oldviewid;
			}
			
		}
		
		if(!oldvname.equalsIgnoreCase(viewname))
		{
			if(news !=""){
				news=news+", View Name:-"+viewname;
				old=old+", View Name:-"+oldvname;
			}else{
				news=news+"View Name:-"+viewname;
				old=old+"View Name:-"+oldvname;
			}
			
		}
		
		if(!oldsfor.equalsIgnoreCase(vid))
		{
			if(news !=""){
				news=news+", Screen For:-"+scrfor;
				old=old+", Screen For:-"+oldsfor;
			}else{
				news=news+"Screen For:-"+scrfor;
				old=old+"Screen For:-"+oldsfor;
			}
			
		}
		
		AgreementScreens prs=new AgreementScreens();
		prs.setId(id);
		prs.setAgreementTypeMaster(ss);
		prs.setViewid(vid);
		prs.setViewname(viewname);
		prs.setScreenfor(scrfor);
		prs.setModifyBy(user);
		prs.setModifyDate(new Timestamp(new Date().getTime()));
		prs.setCreatedDate(createdDate);
		prs.setCreatedBy(createdBy);
		prs.setIsactive(tabacticve);
		AgreementScreens data=agreementscreensDAO.save(prs);
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
	public ReadList save(Integer aid,String vid,String viewname,String scrfor,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		AgreementTypeMaster ss=agreementTypeDAO.findId(aid);
		AgreementScreens prs=new AgreementScreens();
		prs.setAgreementTypeMaster(ss);
		prs.setViewid(vid);
		prs.setViewname(viewname);
		prs.setScreenfor(scrfor);
		prs.setCreatedBy(user);
		prs.setCreatedDate(new Timestamp(new Date().getTime()));
		prs.setIsactive(tabacticve);
		String news="Agreement Name:-"+ss.getAgreementtype()+", View Id:-"+vid+", View Name:-"+viewname+", Screen For"+scrfor;
		AgreementScreens data=agreementscreensDAO.save(prs);
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
	public List<AgreementScreens> findNameActive(Integer aid,String vid,String viewname,String scrfor) {
		return agreementscreensDAO.findNameActive(aid,vid,viewname,scrfor);
	}
	
	@Override
	public List<AgreementScreens> findNameInactive(Integer aid,String vid,String viewname,String scrfor) {
		return agreementscreensDAO.findNameInactive(aid,vid,viewname,scrfor);
	}
	
	public void saves(Auditrail de) {
		audittrailDAO.save(de);
	}
}