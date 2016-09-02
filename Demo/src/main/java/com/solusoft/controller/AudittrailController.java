package com.solusoft.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.solusoft.jpa.AuditData;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.Idoctrail;
import com.solusoft.services.AudittrailService;
import com.solusoft.services.IdoctrailService;

@Controller
public class AudittrailController {

	@Autowired
	AudittrailService audittrailService;
	
	@Autowired
	IdoctrailService idoctrailService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(AudittrailController.class);
	
	@RequestMapping(value = "/audittrailMaster", method = RequestMethod.GET)
	public String audittrailMaster(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All Audit trail Data...");
		List<Auditrail> masters = audittrailService.findall();
		List<AuditData> datas=new ArrayList<AuditData>();
		if(masters.size()>0){
			int i=1;
			for(Auditrail p:masters){
				AuditData de=new AuditData();
				de.setNo(i);
				de.setId(p.getId());
				de.setRecord(p.getRecord());
				de.setNvalue(p.getNvalue());
				de.setOvalue(p.getOvalue());
				de.setOperation(p.getOperation());
				de.setTableName(p.getTableName());
				de.setCreatedBy(p.getCreatedBy());
				de.setModifyBy(p.getModifyBy());
				if(p.getCreatedDate() !=null){
					String pattern = "dd/MM/yyyy";
				    SimpleDateFormat formats = new SimpleDateFormat(pattern);
					Timestamp tt=p.getCreatedDate();
					Date startDate = tt;
					de.setCreatedDate(formats.format(startDate)+"");
				}else{
					de.setCreatedDate("");
				}
				if(p.getModifyDate() !=null ){
					String pattern1 = "dd/MM/yyyy";
				    SimpleDateFormat formats1 = new SimpleDateFormat(pattern1);
					Timestamp tt1=p.getModifyDate();
					Date startDate1 = tt1;
					de.setModifyDate(formats1.format(startDate1)+"");
				}else{
					de.setModifyDate("");
				}
				datas.add(de);
				i++;
			}
		}
		
		model.addAttribute("master", datas);
		return "AudittrailMasters";
		
	}
	
	
	@RequestMapping(value = "/iDoctrail", method = RequestMethod.GET)
	public String iDoctrail(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All Idoc trail Data...");
		List<Idoctrail> masters = idoctrailService.findAll();
		List<AuditData> datas=new ArrayList<AuditData>();
		if(masters.size()>0){
			for(Idoctrail p:masters){
				AuditData de=new AuditData();
				de.setIds(p.getId());
				de.setOperation(p.getOperation());
				de.setNvalue(p.getEname());
				de.setOvalue(p.getEalians());
				de.setTableName(p.getEeid());
				de.setCreatedBy(p.getCreatedBy());
				de.setModifyBy(p.getModifyBy());
				if(p.getCreatedDate() !=null){
					String pattern = "dd/MM/yyyy";
				    SimpleDateFormat formats = new SimpleDateFormat(pattern);
					Timestamp tt=p.getCreatedDate();
					Date startDate = tt;
					de.setCreatedDate(formats.format(startDate)+"");
				}else{
					de.setCreatedDate("");
				}
				if(p.getModifyDate() !=null ){
					String pattern1 = "dd/MM/yyyy";
				    SimpleDateFormat formats1 = new SimpleDateFormat(pattern1);
					Timestamp tt1=p.getModifyDate();
					Date startDate1 = tt1;
					de.setModifyDate(formats1.format(startDate1)+"");
				}else{
					de.setModifyDate("");
				}
				datas.add(de);
			}
		}
		
		model.addAttribute("master", datas);
		return "IdoctrailMasters";
		
	}
	
	
	@RequestMapping(value ="rs/getTable",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<String> getTable(
					Model model){
		return audittrailService.findName();
	}
	
	@RequestMapping(value ="rs/getAuditDetail",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<AuditData> getAuditDetail(@RequestParam (value="TableName",required=true) String tname,
	  		Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		List<Auditrail> masters = audittrailService.findByTable(tname.toUpperCase());
		List<AuditData> datas=new ArrayList<AuditData>();
		if(masters.size()>0){
			int i=1;
			for(Auditrail p:masters){
				AuditData de=new AuditData();
				de.setNo(i);
				de.setId(p.getId());
				de.setRecord(p.getRecord());
				de.setNvalue(p.getNvalue());
				de.setOvalue(p.getOvalue());
				de.setOperation(p.getOperation());
				de.setTableName(p.getTableName());
				de.setCreatedBy(p.getCreatedBy());
				de.setModifyBy(p.getModifyBy());
				if(p.getCreatedDate() !=null){
					String pattern = "dd/MM/yyyy";
				    SimpleDateFormat formats = new SimpleDateFormat(pattern);
					Timestamp tt=p.getCreatedDate();
					Date startDate = tt;
					de.setCreatedDate(formats.format(startDate)+"");
				}else{
					de.setCreatedDate("");
				}
				if(p.getModifyDate() !=null ){
					String pattern1 = "dd/MM/yyyy";
				    SimpleDateFormat formats1 = new SimpleDateFormat(pattern1);
					Timestamp tt1=p.getModifyDate();
					Date startDate1 = tt1;
					de.setModifyDate(formats1.format(startDate1)+"");
				}else{
					de.setModifyDate("");
				}
				datas.add(de);
				i++;
			}
		}
		return datas;
	}
	
	@RequestMapping(value ="rs/getAlldata",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<AuditData> getAlldata(Model model){
		
		List<Auditrail> masters = audittrailService.findall();
		List<AuditData> datas=new ArrayList<AuditData>();
		if(masters.size()>0){
			int i=1;
			for(Auditrail p:masters){
				AuditData de=new AuditData();
				de.setNo(i);
				de.setId(p.getId());
				de.setRecord(p.getRecord());
				de.setNvalue(p.getNvalue());
				de.setOvalue(p.getOvalue());
				de.setOperation(p.getOperation());
				de.setTableName(p.getTableName());
				de.setCreatedBy(p.getCreatedBy());
				de.setModifyBy(p.getModifyBy());
				if(p.getCreatedDate() !=null){
					String pattern = "dd/MM/yyyy";
				    SimpleDateFormat formats = new SimpleDateFormat(pattern);
					Timestamp tt=p.getCreatedDate();
					Date startDate = tt;
					de.setCreatedDate(formats.format(startDate)+"");
				}else{
					de.setCreatedDate("");
				}
				if(p.getModifyDate() !=null ){
					String pattern1 = "dd/MM/yyyy";
				    SimpleDateFormat formats1 = new SimpleDateFormat(pattern1);
					Timestamp tt1=p.getModifyDate();
					Date startDate1 = tt1;
					de.setModifyDate(formats1.format(startDate1)+"");
				}else{
					de.setModifyDate("");
				}
				datas.add(de);
				i++;
			}
		}
		return datas;
	}
	
}