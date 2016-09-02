package com.solusoft.controller;

import java.sql.Timestamp;
import java.text.ParseException;
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

import com.solusoft.jpa.LrfAudit;
import com.solusoft.jpa.ProcessData;
import com.solusoft.jpa.entity.LegalProcessHistory;
import com.solusoft.jpa.entity.ProcessAuditMaster;
import com.solusoft.services.ProcessAuditService;




@Controller
public class ProcessController {

	@Autowired
	ProcessAuditService processAuditService;
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(ProcessController.class);
	
	@RequestMapping(value = "/processAudit", method = RequestMethod.GET)
	public String signAudit(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ParseException{
		logger.info("GET:/ All Process audit Data...");
		
		List<ProcessAuditMaster> masters = processAuditService.findall();
		List<ProcessData> datas=new ArrayList<ProcessData>();
		if(masters.size()>0){
			int i=1;
			for(ProcessAuditMaster p:masters){
				ProcessData de=new ProcessData();
					de.setId(p.getId());
					de.setNo(i);
					de.setCasetitle(p.getCasetitle());
					de.setStepname(p.getStepname());
					de.setStepuser(p.getStepuser());
					de.setStepreason(p.getStepreason());
					de.setTimein(p.getTimein());
					de.setTimeout(p.getTimeout());
					de.setDocstatus(p.getDocstatus());
					de.setDname(p.getDname());
					datas.add(de);
					i++;
				}
		}
		
		model.addAttribute("master", datas);
		return "ProcessAuditss";
	}
	
	@RequestMapping(value = "/lrfprocessAudit", method = RequestMethod.GET)
	public String rejectHistory(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All Legal audit logs Data...");
		List<LegalProcessHistory> masters = processAuditService.findalls();
		List<LrfAudit> datas=new ArrayList<LrfAudit>();
		if(masters.size()>0){
			int i=1;
			for(LegalProcessHistory p:masters){
				LrfAudit de=new LrfAudit();
				de.setId(p.getId());
				de.setNo(i);
				if(p.getRequestDate() !=null){
					String pattern = "dd/MM/yyyy";
				    SimpleDateFormat formats = new SimpleDateFormat(pattern);
					Timestamp tt=p.getRequestDate();
					Date startDate = tt;
					de.setRequestdate(formats.format(startDate)+"");
				}else{
					de.setRequestdate("");
				}
				
				if(p.getRejectDate() !=null){
					String pattern1 = "dd/MM/yyyy";
				    SimpleDateFormat formats1 = new SimpleDateFormat(pattern1);
					Timestamp tt1=p.getRejectDate();
					Date startDate1 = tt1;
					de.setRejecteddate(formats1.format(startDate1)+"");
				}else{
					de.setRejecteddate("");
				}
				if(p.getProcess() !=null){
					de.setProcess(p.getProcess());
				}else{
					de.setProcess("");
				}
				de.setLrno(p.getLrfNo());
				de.setEname(p.getEmployeeMaster().getName());
				de.setStatus(p.getStatus());
				de.setReason(p.getReason());
				de.setAname(p.getAgreementTypeMaster().getAgreementtype());
				de.setStepname(p.getStepName());
				datas.add(de);
				i++;
			}
		}
			
		model.addAttribute("master", datas);
		return "LegalProcessHistory";
	}
}