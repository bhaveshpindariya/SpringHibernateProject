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

import com.solusoft.jpa.PrintAudit;
import com.solusoft.jpa.PrintReso;
import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.AdminMaster;
import com.solusoft.jpa.entity.LrfPrintAuditMaster;
import com.solusoft.jpa.entity.PrintAuditMaster;
import com.solusoft.jpa.entity.PrintResonMaster;
import com.solusoft.services.PrintResonServicer;



@Controller
public class PrintReasonController {

	@Autowired
	PrintResonServicer printResonServicer;
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(PrintReasonController.class);
	
	@RequestMapping(value = "/printResPM", method = RequestMethod.GET)
	public String printResPM(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All PM Print reason Data...");
		
		List<PrintResonMaster> masters = printResonServicer.findAllPM();
		List<PrintReso> datas=new ArrayList<PrintReso>();
		if(masters.size()>0){
			int i=1;
			for(PrintResonMaster p:masters){
				PrintReso de=new PrintReso();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getDetais());
				de.setModule(p.getModule());
				de.setCreatedBy(p.getCreatedBy());
				if(p.getCreatedDate() !=null){
					String pattern = "dd/MM/yyyy";
				    SimpleDateFormat formats = new SimpleDateFormat(pattern);
					Timestamp tt=p.getCreatedDate();
					Date startDate = tt;
					de.setCreatedDate(formats.format(startDate)+"");
				}else{
					de.setCreatedDate("");
				}
				de.setModifyBy(p.getModifyBy());
				
				if(p.getModifyDate() !=null){
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
		List<PrintResonMaster> masteres = printResonServicer.findAllInactivePM();
		List<PrintReso> dataes=new ArrayList<PrintReso>();
		if(masteres.size()>0){
			int i=1;
			for(PrintResonMaster p:masteres){
				PrintReso de=new PrintReso();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getDetais());
				de.setModule(p.getModule());
				de.setCreatedBy(p.getCreatedBy());
				if(p.getCreatedDate() !=null){
					String pattern = "dd/MM/yyyy";
				    SimpleDateFormat formats = new SimpleDateFormat(pattern);
					Timestamp tt=p.getCreatedDate();
					Date startDate = tt;
					de.setCreatedDate(formats.format(startDate)+"");
				}else{
					de.setCreatedDate("");
				}
				de.setModifyBy(p.getModifyBy());
				
				if(p.getModifyDate() !=null){
					String pattern1 = "dd/MM/yyyy";
				    SimpleDateFormat formats1 = new SimpleDateFormat(pattern1);
					Timestamp tt1=p.getModifyDate();
					Date startDate1 = tt1;
					de.setModifyDate(formats1.format(startDate1)+"");
				}else{
					de.setModifyDate("");
				}
				dataes.add(de);
				i++;
			}
		}
		model.addAttribute("masters", dataes);
		model.addAttribute("master", datas);
		return "PrintResonMastersPM";
		
	}
	
	
	@RequestMapping(value = "/printResLRF", method = RequestMethod.GET)
	public String printResLRF(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All LRF Print reason Data...");
		
		List<PrintResonMaster> masters = printResonServicer.findAllLRF();
		List<PrintReso> datas=new ArrayList<PrintReso>();
		if(masters.size()>0){
			int i=1;
			for(PrintResonMaster p:masters){
				PrintReso de=new PrintReso();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getDetais());
				de.setModule(p.getModule());
				de.setCreatedBy(p.getCreatedBy());
				if(p.getCreatedDate() !=null){
					String pattern = "dd/MM/yyyy";
				    SimpleDateFormat formats = new SimpleDateFormat(pattern);
					Timestamp tt=p.getCreatedDate();
					Date startDate = tt;
					de.setCreatedDate(formats.format(startDate)+"");
				}else{
					de.setCreatedDate("");
				}
				de.setModifyBy(p.getModifyBy());
				
				if(p.getModifyDate() !=null){
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
		List<PrintResonMaster> masteres = printResonServicer.findAllInactiveLRF();
		List<PrintReso> dataes=new ArrayList<PrintReso>();
		if(masteres.size()>0){
			int i=1;
			for(PrintResonMaster p:masteres){
				PrintReso de=new PrintReso();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getDetais());
				de.setModule(p.getModule());
				de.setCreatedBy(p.getCreatedBy());
				if(p.getCreatedDate() !=null){
					String pattern = "dd/MM/yyyy";
				    SimpleDateFormat formats = new SimpleDateFormat(pattern);
					Timestamp tt=p.getCreatedDate();
					Date startDate = tt;
					de.setCreatedDate(formats.format(startDate)+"");
				}else{
					de.setCreatedDate("");
				}
				de.setModifyBy(p.getModifyBy());
				
				if(p.getModifyDate() !=null){
					String pattern1 = "dd/MM/yyyy";
				    SimpleDateFormat formats1 = new SimpleDateFormat(pattern1);
					Timestamp tt1=p.getModifyDate();
					Date startDate1 = tt1;
					de.setModifyDate(formats1.format(startDate1)+"");
				}else{
					de.setModifyDate("");
				}
				dataes.add(de);
				i++;
			}
		}
		model.addAttribute("masters", dataes);
		model.addAttribute("master", datas);
		return "PrintResonMastersLRF";
		
	}
	
	@RequestMapping(value ="rs/getPMprintActive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<PrintReso> getPMprintActive(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		List<PrintResonMaster> masters = printResonServicer.findAllPM();
		List<PrintReso> datas=new ArrayList<PrintReso>();
		if(masters.size()>0){
			int i=1;
			for(PrintResonMaster p:masters){
				PrintReso de=new PrintReso();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getDetais());
				de.setModule(p.getModule());
				de.setCreatedBy(p.getCreatedBy());
				if(p.getCreatedDate() !=null){
					String pattern = "dd/MM/yyyy";
				    SimpleDateFormat formats = new SimpleDateFormat(pattern);
					Timestamp tt=p.getCreatedDate();
					Date startDate = tt;
					de.setCreatedDate(formats.format(startDate)+"");
				}else{
					de.setCreatedDate("");
				}
				de.setModifyBy(p.getModifyBy());
				
				if(p.getModifyDate() !=null){
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
	
	@RequestMapping(value ="rs/getLRFprintActive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<PrintReso> getLRFprintActive(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		List<PrintResonMaster> masters = printResonServicer.findAllLRF();
		List<PrintReso> datas=new ArrayList<PrintReso>();
		if(masters.size()>0){
			int i=1;
			for(PrintResonMaster p:masters){
				PrintReso de=new PrintReso();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getDetais());
				de.setModule(p.getModule());
				de.setCreatedBy(p.getCreatedBy());
				if(p.getCreatedDate() !=null){
					String pattern = "dd/MM/yyyy";
				    SimpleDateFormat formats = new SimpleDateFormat(pattern);
					Timestamp tt=p.getCreatedDate();
					Date startDate = tt;
					de.setCreatedDate(formats.format(startDate)+"");
				}else{
					de.setCreatedDate("");
				}
				de.setModifyBy(p.getModifyBy());
				
				if(p.getModifyDate() !=null){
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
	
	@RequestMapping(value ="rs/getPMprintInActive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<PrintReso> getPMprintInActive(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		List<PrintResonMaster> masters = printResonServicer.findAllInactivePM();
		List<PrintReso> datas=new ArrayList<PrintReso>();
		if(masters.size()>0){
			int i=1;
			for(PrintResonMaster p:masters){
				PrintReso de=new PrintReso();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getDetais());
				de.setModule(p.getModule());
				de.setCreatedBy(p.getCreatedBy());
				if(p.getCreatedDate() !=null){
					String pattern = "dd/MM/yyyy";
				    SimpleDateFormat formats = new SimpleDateFormat(pattern);
					Timestamp tt=p.getCreatedDate();
					Date startDate = tt;
					de.setCreatedDate(formats.format(startDate)+"");
				}else{
					de.setCreatedDate("");
				}
				de.setModifyBy(p.getModifyBy());
				
				if(p.getModifyDate() !=null){
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
	
	@RequestMapping(value ="rs/getLRFprintInActive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<PrintReso> getLRFprintInActive(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		List<PrintResonMaster> masters = printResonServicer.findAllInactivePM();
		List<PrintReso> datas=new ArrayList<PrintReso>();
		if(masters.size()>0){
			int i=1;
			for(PrintResonMaster p:masters){
				PrintReso de=new PrintReso();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getDetais());
				de.setModule(p.getModule());
				de.setCreatedBy(p.getCreatedBy());
				if(p.getCreatedDate() !=null){
					String pattern = "dd/MM/yyyy";
				    SimpleDateFormat formats = new SimpleDateFormat(pattern);
					Timestamp tt=p.getCreatedDate();
					Date startDate = tt;
					de.setCreatedDate(formats.format(startDate)+"");
				}else{
					de.setCreatedDate("");
				}
				de.setModifyBy(p.getModifyBy());
				
				if(p.getModifyDate() !=null){
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
	
	
	@RequestMapping(value = "/PMprintAudit", method = RequestMethod.GET)
	public String PMprintAudit(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All PM Print audit Data...");
		
		List<PrintAuditMaster> masters = printResonServicer.findAllPMAudit();
		List<PrintAudit> datas=new ArrayList<PrintAudit>();
		if(masters.size()>0){
			int i=1;
			for(PrintAuditMaster p:masters){
				PrintAudit de=new PrintAudit();
				de.setNo(i);
				de.setId(p.getId());
				de.setEname(p.getEmid().getName());
				de.setDname(p.getEmid().getDname());
				if(p.getOther().equalsIgnoreCase("NULL")){
					de.setPreason(p.getPrintreson().getDetais());
				}else{
					de.setPreason(p.getOther());
				}
				if(p.getPrintdate() !=null){
					String pattern = "dd/MM/yyyy";
				    SimpleDateFormat formats = new SimpleDateFormat(pattern);
					Timestamp tt=p.getPrintdate();
					Date startDate = tt;
					de.setDate(formats.format(startDate)+"");
				}else{
					de.setDate("");
				}
				de.setDocumentname(p.getDocumentName());
				de.setPname(p.getPrintname());
				de.setPrintfor(p.getPrintfor());
				de.setTyprint(p.getTypeofprint());
				de.setCaseId(p.getPrimaryCaseDetail().getCaseId());
				de.setCount(""+p.getCount());
				de.setDname(p.getDname());
				datas.add(de);
				i++;
			}
		}
		model.addAttribute("master", datas);
		return "PMPrintAuditMasters";
	}
	
	@RequestMapping(value = "/LRFprintAudit", method = RequestMethod.GET)
	public String LRFprintAudit(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All LRF Print audit Data...");
		
		List<LrfPrintAuditMaster> masters = printResonServicer.findAllLRFAudit();
		List<PrintAudit> datas=new ArrayList<PrintAudit>();
		if(masters.size()>0){
			int i=1;
			for(LrfPrintAuditMaster p:masters){
				PrintAudit de=new PrintAudit();
				de.setNo(i);
				de.setId(p.getId());
				de.setEname(p.getEmid().getName());
				de.setDname(p.getEmid().getDname());
				if(p.getOther().equalsIgnoreCase("NULL")){
					de.setPreason(p.getPrintreson().getDetais());
				}else{
					de.setPreason(p.getOther());
				}
				if(p.getPrintdate() !=null){
					String pattern = "dd/MM/yyyy";
				    SimpleDateFormat formats = new SimpleDateFormat(pattern);
					Timestamp tt=p.getPrintdate();
					Date startDate = tt;
					de.setDate(formats.format(startDate)+"");
				}else{
					de.setDate("");
				}
				de.setDocumentname(p.getLrfno()+"");
				de.setPname(p.getPrintname());
				de.setPrintfor(p.getPrintfor());
				de.setCaseId(p.getPrimaryCaseDetail().getCaseId());
				de.setCount(""+p.getCount());
				de.setDname(p.getDname());
				datas.add(de);
				i++;
			}
		}
		model.addAttribute("master", datas);
		return "LRFPrintAuditMasters";
	}
	
	
	@RequestMapping(value ="activeId",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList activeId(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		return printResonServicer.activeId(id,au.getUsername());
	}
	
	@RequestMapping(value ="delete",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Master(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		return printResonServicer.delete(id,au.getUsername());

	}
	
	@RequestMapping(value ="update",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Masters(@RequestParam (value="ID",required=true) Integer id,
					 @RequestParam (value="Name",required=true) String detail,
					 @RequestParam (value="Module",required=true) String module,
					 Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 

		List<PrintResonMaster> dc=printResonServicer.findNameActive(detail.toUpperCase(),module.toUpperCase());
		List<PrintResonMaster> dcs=printResonServicer.findNameInactive(detail.toUpperCase(),module.toUpperCase());
		ReadList rs = new ReadList();
		if(dc.size()>=2){
		  rs.setSuccess(false);
		  rs.setMessage("Print reason already exists in active list");
		  return rs;
		}else if(dcs.size()>=2){
			rs.setMessage("Print reason already exists in inactive list");
			rs.setSuccess(false);
			return rs;
		}else if(dc.size()>=1){
			for(PrintResonMaster dcss:dc){
				if(dcss.getId().equals(id)){
					rs=printResonServicer.updates(id,detail,module.toUpperCase(),au.getUsername());
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Print reason already exits in active list");
					return rs;
				}
		   }
		}else if(dcs.size()>=1){
			for(PrintResonMaster dcss:dcs){
				if(dcss.getId().equals(id)){
					rs=printResonServicer.updates(id,detail,module.toUpperCase(),au.getUsername());
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Print reason already exists in inactive list");
					return rs;
				}
		   }
		}else{
		  rs=printResonServicer.updates(id,detail,module.toUpperCase(),au.getUsername());
		  return rs;
		}
		return rs;
	}
	
	@RequestMapping(value ="insert",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Masteres(@RequestParam (value="Name",required=true) String detail,
			 		  @RequestParam (value="Module",required=true) String module,
					  Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		List<PrintResonMaster> dcs=printResonServicer.findNameActive(detail.toUpperCase(),module.toUpperCase());
		List<PrintResonMaster> dc=printResonServicer.findNameInactive(detail.toUpperCase(),module.toUpperCase());
		ReadList rs = new ReadList();
		if(dc.size()>=1){
			rs.setSuccess(false);
			rs.setMessage("Print reason already exists in inactive list");
			return rs;
		}else if(dcs.size()>=1){
			rs.setMessage("Print reason already exists in active list");
			rs.setSuccess(false);
			return rs;
		}else{
			ReadList rss = new ReadList();
			rss=printResonServicer.save(detail,module.toUpperCase(),au.getUsername());
			return rss;
		}
	}
		
}