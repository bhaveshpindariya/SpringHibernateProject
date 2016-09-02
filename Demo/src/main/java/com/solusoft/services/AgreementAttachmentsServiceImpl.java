package com.solusoft.services;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.dao.AgreementAttachmentsDAO;
import com.solusoft.jpa.dao.AgreementTypeDAO;
import com.solusoft.jpa.dao.AudittrailDAO;
import com.solusoft.jpa.entity.AgreementAttachments;
import com.solusoft.jpa.entity.AgreementTypeMaster;
import com.solusoft.jpa.entity.Auditrail;
@Service("agreementAttachmentsService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class AgreementAttachmentsServiceImpl implements AgreementAttachmentsService {

	@Autowired
	AgreementAttachmentsDAO agreementAttachmentsDAO;
	
	@Autowired
	AgreementTypeDAO agreementTypeDAO;
	
	@Autowired
	AudittrailDAO audittrailDAO;

	private static final String tabName="AGREEMENT_ATTACHMENTS";
	
	private static final int tabacticve=0;
	
	@Override
	public List<AgreementAttachments> findactive() {
		return agreementAttachmentsDAO.findactive();
	}
	
	@Override
	public List<AgreementAttachments> findalldata() {
		return agreementAttachmentsDAO.findalldata();
	}
	
	public void delete(AgreementAttachments entity){
		agreementAttachmentsDAO.delete(entity);
	}
	
	@Override
	public List<AgreementAttachments> findAllInactive() {
		return agreementAttachmentsDAO.findAllInactive();
	}
	
	@Override
	public AgreementAttachments savedata(AgreementAttachments obj) {
		return agreementAttachmentsDAO.savedata(obj);
	}
	
	public void saves(Auditrail de) {
		audittrailDAO.save(de);
	}
	
	@Override
	public ReadList activeId(Integer id,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		AgreementAttachments ll=agreementAttachmentsDAO.findId(id);
		String aname=ll.getAgreementTypeMaster().getAgreementtype();
		String docclass=ll.getDocclass();
		String doctype=ll.getDoctype();
		Boolean mandadory=ll.getMandadory();
		Boolean mandadorydom=ll.getMandadorydom();
		Boolean atclass=ll.getAtclass();
		String news="Agreement Name:-"+aname+", Document Class:-"+docclass+", Document Type:-"+doctype+", IS_MANDATORY"+mandadory+", IS_MANDATORY_DOMESTIC"+mandadorydom+", IS_AGR_TYPE_CLASS"+atclass;
		Boolean data=agreementAttachmentsDAO.activeId(id,user);
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
		AgreementAttachments ll=agreementAttachmentsDAO.findId(id);
		String aname=ll.getAgreementTypeMaster().getAgreementtype();
		String docclass=ll.getDocclass();
		String doctype=ll.getDoctype();
		Boolean mandadory=ll.getMandadory();
		Boolean mandadorydom=ll.getMandadorydom();
		Boolean atclass=ll.getAtclass();
		String news="Agreement Name:-"+aname+", Document Class:-"+docclass+", Document Type:-"+doctype+", IS_MANDATORY"+mandadory+", IS_MANDATORY_DOMESTIC"+mandadorydom+", IS_AGR_TYPE_CLASS"+atclass;
		Boolean data=agreementAttachmentsDAO.delete(id,user);
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
	public List<AgreementAttachments> findNameActive(Integer aid,String docc,String doct,Boolean iatc,Boolean im,Boolean imd) {
		return agreementAttachmentsDAO.findNameActive(aid,docc,docc,iatc,im,imd);
	}
	
	@Override
	public List<AgreementAttachments> findNameInactive(Integer aid,String docc,String doct,Boolean iatc,Boolean im,Boolean imd) {
		return agreementAttachmentsDAO.findNameInactive(aid,docc,docc,iatc,im,imd);
	}
	
	@Override
	public ReadList save(Integer aid,String docc,String doct,Boolean iatc,Boolean im,Boolean imd,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		AgreementTypeMaster ss=agreementTypeDAO.findId(aid);
		AgreementAttachments prs=new AgreementAttachments();
		prs.setAgreementTypeMaster(ss);
		prs.setDocclass(docc);
		prs.setDoctype(doct);
		prs.setAtclass(iatc);
		prs.setMandadory(im);
		prs.setMandadorydom(imd);
		prs.setCreatedBy(user);
		prs.setCreatedDate(new Timestamp(new Date().getTime()));
		prs.setIsactive(tabacticve);
		String news="Agreement Name:-"+ss.getAgreementtype()+", Document Class:-"+docc+", Document Type:-"+doct+", IS_MANDATORY"+im+", IS_MANDATORY_DOMESTIC"+imd+", IS_AGR_TYPE_CLASS"+iatc;
		AgreementAttachments data=agreementAttachmentsDAO.savedata(prs);
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
    public ReadList updates(Integer id,Integer aid,String docc,String doct,Boolean iatc,Boolean im,Boolean imd,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		
		AgreementAttachments ll=agreementAttachmentsDAO.findId(id);
		String oldaname=ll.getAgreementTypeMaster().getAgreementtype();
		String olddocclass=ll.getDocclass();
		String olddoctype=ll.getDoctype();
		Boolean oldiatc=ll.getAtclass();
		Boolean oldim=ll.getMandadory();
		Boolean oldimd=ll.getMandadorydom();
		
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
		
		if(!olddocclass.equalsIgnoreCase(docc))
		{
			if(news !=""){
				news=news+", Doc Class:-"+docc;
				old=old+", Doc Class:-"+olddocclass;
			}else{
				news=news+"Doc Class:-"+docc;
				old=old+"Doc Class:-"+olddocclass;
			}
			
		}
		
		if(olddoctype !=""){
			if(doct !=""){
				if(!olddoctype.equalsIgnoreCase(doct))
				{
					if(news !=""){
						news=news+", Doc Type:-"+doct;
						old=old+", Doc Type:-"+olddoctype;
					}else{
						news=news+"Doc Type:-"+doct;
						old=old+"Doc Type:-"+olddoctype;
					}
				}
			}else{
				if(!olddoctype.equalsIgnoreCase(doct))
				{
					if(news !=""){
						old=old+", Doc Type:-"+doct;
					}else{
						old=old+"Doc Type:-"+doct;
					}
				}
			}
		}else{
			if(doct !=""){
				if(!olddoctype.equalsIgnoreCase(doct))
				{
					if(news !=""){
						news=news+", Doc Type:-"+doct;
					}else{
						news=news+"Doc Type:-"+doct;
					}
				}
			}
		}
		
		if(!oldim.equals(im))
		{
			if(news !=""){
				news=news+", IS_MANDATORY:-"+im;
				old=old+", IS_MANDATORY:-"+oldim;
			}else{
				news=news+"IS_MANDATORY:-"+im;
				old=old+"IS_MANDATORY:-"+oldim;
			}
			
		}
		
		if(!oldimd.equals(imd))
		{
			if(news !=""){
				news=news+", IS_MANDATORY_DOMESTIC:-"+oldimd;
				old=old+", IS_MANDATORY_DOMESTIC:-"+olddocclass;
			}else{
				news=news+"IS_MANDATORY_DOMESTIC:-"+oldimd;
				old=old+"IS_MANDATORY_DOMESTIC:-"+olddocclass;
			}
			
		}
		
		if(!oldiatc.equals(iatc))
		{
			if(news !=""){
				news=news+", IS_AGR_TYPE_CLASS:-"+iatc;
				old=old+", IS_AGR_TYPE_CLASS:-"+oldiatc;
			}else{
				news=news+"IS_AGR_TYPE_CLASS:-"+iatc;
				old=old+"IS_AGR_TYPE_CLASS:-"+oldiatc;
			}
			
		}
		
		
		AgreementAttachments prs=new AgreementAttachments();
		prs.setId(id);
		prs.setAgreementTypeMaster(ss);
		prs.setDocclass(docc);
		prs.setDoctype(doct);
		prs.setAtclass(iatc);
		prs.setMandadory(im);
		prs.setMandadorydom(imd);
		prs.setModifyBy(user);
		prs.setModifyDate(new Timestamp(new Date().getTime()));
		prs.setCreatedDate(createdDate);
		prs.setCreatedBy(createdBy);
		prs.setIsactive(tabacticve);
		AgreementAttachments data=agreementAttachmentsDAO.savedata(prs);
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
	
}