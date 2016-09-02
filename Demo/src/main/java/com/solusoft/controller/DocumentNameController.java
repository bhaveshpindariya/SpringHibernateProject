package com.solusoft.controller;

import java.util.ArrayList;
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

import com.solusoft.jpa.DocumentName;
import com.solusoft.jpa.entity.DocumentNameForBL;
import com.solusoft.jpa.entity.DocumentNameForBM;
import com.solusoft.jpa.entity.DocumentNameForBRL;
import com.solusoft.services.DocumentNameService;

@Controller
public class DocumentNameController {

	@Autowired
	DocumentNameService documentNameService;
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(DocumentNameController.class);
	
	@RequestMapping(value = "/BlDocumentName", method = RequestMethod.GET)
	public String BlDocumentName(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All Document Name Bl Data...");
		List<DocumentNameForBL> masters = documentNameService.findAllBl();
		List<DocumentName> datas=new ArrayList<DocumentName>();
		if(masters.size()>0){
			int i=1;
			for(DocumentNameForBL p:masters){
				DocumentName de=new DocumentName();
				de.setNo(i);
				
				de.setSabb(p.getType());
				if(p.getVerticalid()!= null){
					de.setLcode(p.getVerticalid().getVname());
				}else{
					de.setLcode("");
				}
				if(p.getDocumentid() !=null ){
					de.setDabb(p.getDocumentid().getDetais());
					de.setDname(p.getDocumentid().getDoname());
				}else{
					de.setDabb("");
				}
				if(p.getCustomDepartment() !=null){
					de.setCdabb(p.getCustomDepartment().getDeptabbreviation());
				}else{
					de.setCdabb("");
				}
				de.setSrn(p.getSrno());
				de.setDocumentname(p.getDocumentno());
				datas.add(de);
				i++;
			}
		}
		model.addAttribute("master", datas);
		return "DocumentBlName";
		
	}
	
	@RequestMapping(value = "/BMDocumentName", method = RequestMethod.GET)
	public String BMDocumentName(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All Document Name BM Data...");
		List<DocumentNameForBM> masters = documentNameService.findAllBm();
		List<DocumentName> datas=new ArrayList<DocumentName>();
		if(masters.size()>0){
			int i=1;
			for(DocumentNameForBM p:masters){
				DocumentName de=new DocumentName();
				de.setNo(i);
				
				de.setSabb(p.getType());
				if(p.getVerticalid()!= null){
					de.setLcode(p.getVerticalid().getVname());
				}else{
					de.setLcode("");
				}
				if(p.getDocumentid() !=null ){
					de.setDabb(p.getDocumentid().getDetais());
					de.setDname(p.getDocumentid().getDoname());
				}else{
					de.setDabb("");
				}
				if(p.getCustomDepartment() !=null){
					de.setCdabb(p.getCustomDepartment().getDeptabbreviation());
				}else{
					de.setCdabb("");
				}
				de.setSrn(p.getSrno());
				de.setDocumentname(p.getDocumentno());
				datas.add(de);
				i++;
			}
		}
		model.addAttribute("master", datas);
		return "DocumentBmName";
		
	}
	
	@RequestMapping(value = "/BrlDocumentName", method = RequestMethod.GET)
	public String BrlDocumentName(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All Document Name Brl Data...");
		List<DocumentNameForBRL> masters = documentNameService.findAllBrl();
		List<DocumentName> datas=new ArrayList<DocumentName>();
		if(masters.size()>0){
			int i=1;
			for(DocumentNameForBRL p:masters){
				DocumentName de=new DocumentName();
				de.setNo(i);
				if(p.getBrlGroup() != null){
					de.setCdabb(p.getBrlGroup().getAbbreviation());
				}else{
					de.setCdabb("");
				}
				if(p.getDocumentid() != null){
					de.setDabb(p.getDocumentid().getDetais());
					de.setDname(p.getDocumentid().getDoname());
				}else{
					de.setDabb("");
				}
				
				if(p.getProjectMaster() != null){
					de.setLcode(p.getProjectMaster().getProjectid());
				}else{
					de.setLcode("");
				}
				de.setSrn(p.getSrno());
				de.setDocumentname(p.getDocumentno());
				datas.add(de);
				i++;
			}
		}
		model.addAttribute("master", datas);
		return "DocumentBrlName";
		
	}
	
}