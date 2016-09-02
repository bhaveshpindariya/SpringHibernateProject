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

import com.solusoft.jpa.CancelAudit;
import com.solusoft.jpa.PrintReso;
import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.AdminMaster;
import com.solusoft.jpa.entity.CancelAuditMaster;
import com.solusoft.jpa.entity.CancelResonMaster;
import com.solusoft.jpa.entity.LrfCancelAuditMaster;
import com.solusoft.jpa.entity.LrfNumberGenerate;
import com.solusoft.services.CancelResonServicer;
import com.solusoft.services.LrfNumberServicer;



@Controller
public class CancelController {

	@Autowired
	CancelResonServicer cancelResonServicer;
	
	@Autowired
	LrfNumberServicer lrfNumberServicer;
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(CancelController.class);
	
	@RequestMapping(value = "/cancelResPM", method = RequestMethod.GET)
	public String cancelResPM(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All PM Cancel reason Data...");
		
		List<CancelResonMaster> masters = cancelResonServicer.findAllPM();
		List<PrintReso> datas=new ArrayList<PrintReso>();
		if(masters.size()>0){
			int i=1;
			for(CancelResonMaster p:masters){
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
		List<CancelResonMaster> masteres = cancelResonServicer.findAllInactivePM();
		List<PrintReso> dataes=new ArrayList<PrintReso>();
		if(masteres.size()>0){
			int i=1;
			for(CancelResonMaster p:masteres){
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
		return "CancelResonMastersPM";
		
	}
	
	@RequestMapping(value = "/cancelResLRF", method = RequestMethod.GET)
	public String cancelResLRF(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All LRF Cancel reason Data...");
		
		List<CancelResonMaster> masters = cancelResonServicer.findAllLRF();
		List<PrintReso> datas=new ArrayList<PrintReso>();
		if(masters.size()>0){
			int i=1;
			for(CancelResonMaster p:masters){
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
		List<CancelResonMaster> masteres = cancelResonServicer.findAllInactiveLRF();
		List<PrintReso> dataes=new ArrayList<PrintReso>();
		if(masteres.size()>0){
			int i=1;
			for(CancelResonMaster p:masteres){
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
		return "CancelResonMastersLRF";
		
	}
	
	
	@RequestMapping(value ="rs/getLRFcancelActive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<PrintReso> getLRFcancelActive(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		List<CancelResonMaster> masters = cancelResonServicer.findAllLRF();
		List<PrintReso> datas=new ArrayList<PrintReso>();
		if(masters.size()>0){
			int i=1;
			for(CancelResonMaster p:masters){
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
	
	@RequestMapping(value ="rs/getPMcancelActive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<PrintReso> getPMcancelActive(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		List<CancelResonMaster> masters = cancelResonServicer.findAllPM();
		List<PrintReso> datas=new ArrayList<PrintReso>();
		if(masters.size()>0){
			int i=1;
			for(CancelResonMaster p:masters){
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
	
	@RequestMapping(value ="rs/getPMcancelInActive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<PrintReso> getPMcancelInActive(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		List<CancelResonMaster> masteres = cancelResonServicer.findAllInactivePM();
		List<PrintReso> dataes=new ArrayList<PrintReso>();
		if(masteres.size()>0){
			int i=1;
			for(CancelResonMaster p:masteres){
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
		return dataes;
	}
	
	@RequestMapping(value ="rs/getLRFcancelInActive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<PrintReso> getLRFcancelInActive(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		List<CancelResonMaster> masteres = cancelResonServicer.findAllInactiveLRF();
		List<PrintReso> dataes=new ArrayList<PrintReso>();
		if(masteres.size()>0){
			int i=1;
			for(CancelResonMaster p:masteres){
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
		return dataes;
	}
	
	@RequestMapping(value = "/cancelAudit", method = RequestMethod.GET)
	public String Masters(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All Cancel audit Data...");
		
		List<CancelAuditMaster> masters = cancelResonServicer.findAlls();
		List<CancelAudit> datas=new ArrayList<CancelAudit>();
		if(masters.size()>0){
			int i=1;
			for(CancelAuditMaster p:masters){
				CancelAudit de=new CancelAudit();
				de.setNo(i);
				de.setId(p.getId());
				de.setEname(p.getEmid().getName());
				de.setDname(p.getDname());
				if(p.getOther().equalsIgnoreCase("NULL")){
					de.setCreason(p.getCancelResonMaster().getDetais());
				}else{
					de.setCreason(p.getOther());
				}
				if(p.getCancelDate() !=null){
					String pattern = "dd/MM/yyyy";
				    SimpleDateFormat formats = new SimpleDateFormat(pattern);
					Timestamp tt=p.getCancelDate();
					Date startDate = tt;
					de.setDate(formats.format(startDate)+"");
				}else{
					de.setDate("");
				}
				de.setTaskId(p.getTaskId());
				de.setTaskName(p.getTaskName());
				de.setDocumenttitle(p.getDocTitle());
				de.setDocno(p.getDocNo());
				de.setParticipentName(p.getParticipentName());
				de.setCaseId(p.getPrimaryCaseDetail().getCaseId());
				datas.add(de);
				i++;
			}
		}
		model.addAttribute("master", datas);
		return "CancelAuditMasters";
	}
	
	@RequestMapping(value = "/lrfCancelAudit", method = RequestMethod.GET)
	public String lrfCancelAudit(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All Lrf Cancel audit Data...");
		List<LrfCancelAuditMaster> masters = cancelResonServicer.finddata();
		List<CancelAudit> datas=new ArrayList<CancelAudit>();
		if(masters.size()>0){
			int i=1;
			for(LrfCancelAuditMaster p:masters){
				CancelAudit de=new CancelAudit();
				de.setNo(i);
				de.setId(p.getId());
				de.setDocno(p.getLrfNo());
				de.setEname(p.getRename());
				de.setDname(p.getRedep());
				if(p.getOther().equalsIgnoreCase("NULL")){
					de.setCreason(p.getCancelResonMaster().getDetais());
				}else{
					de.setCreason(p.getOther());
				}
				if(p.getCancelDate() !=null){
					String pattern = "dd/MM/yyyy";
				    SimpleDateFormat formats = new SimpleDateFormat(pattern);
					Timestamp tt=p.getCancelDate();
					Date startDate = tt;
					de.setDate(formats.format(startDate)+"");
				}else{
					de.setDate("");
				}
				de.setTaskName(p.getTaskName());
				de.setParticipentName(p.getParticipentName());
				datas.add(de);
				i++;
			}
		}
		model.addAttribute("master", datas);
		return "LrfCancelAuditMasters";
	}
	
	@RequestMapping(value = "/lrfNumberGenerate", method = RequestMethod.GET)
	public String lrfNumberGenerate(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All Lrf Number Data...");
		List<LrfNumberGenerate> masters = lrfNumberServicer.findall();
		model.addAttribute("master", masters);
		return "LrfNumber";
	}
	
	@RequestMapping(value ="activeIdCancel",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList activeId(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		return cancelResonServicer.activeId(id,au.getUsername());
	}
	
	@RequestMapping(value ="deleteCancel",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Master(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		return cancelResonServicer.delete(id,au.getUsername());

	}
	
	@RequestMapping(value ="updateCancel",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Masters(@RequestParam (value="ID",required=true) Integer id,
					 @RequestParam (value="Name",required=true) String detail,
					 @RequestParam (value="Mod",required=true) String mod,
					 Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		List<CancelResonMaster> dc=cancelResonServicer.findNameActive(detail.toUpperCase(),mod.toUpperCase());
		List<CancelResonMaster> dcs=cancelResonServicer.findNameInactive(detail.toUpperCase(),mod.toUpperCase());
		ReadList rs = new ReadList();
		if(dc.size()>=2){
			  rs.setSuccess(false);
			  rs.setMessage("Cancel reason already exists in active list");
			  return rs;
		}else if(dcs.size()>=2){
				rs.setMessage("Cancel reason already exists in inactive list");
				rs.setSuccess(false);
				return rs;
		}else if(dc.size()>=1){
			for(CancelResonMaster dcss:dc){
				if(dcss.getId().equals(id)){
					rs=cancelResonServicer.updates(id,detail,au.getUsername(),mod.toUpperCase());
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Cancel reason already exits in active list");
					return rs;
				}
		   }
		}else if(dcs.size()>=1){
			for(CancelResonMaster dcss:dcs){
				if(dcss.getId().equals(id)){
					rs=cancelResonServicer.updates(id,detail,au.getUsername(),mod.toUpperCase());
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Cancel reason already exists in inactive list");
					return rs;
				}
		   }
		}else{
		  rs=cancelResonServicer.updates(id,detail,au.getUsername(),mod.toUpperCase());
		  return rs;
		}
		return rs;
	}
	
	@RequestMapping(value ="insertCancel",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Masteres(@RequestParam (value="Name",required=true) String detail,
					  @RequestParam (value="Mod",required=true) String mod,
					  Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		List<CancelResonMaster> dcs=cancelResonServicer.findNameActive(detail.toUpperCase(),mod.toUpperCase());
		List<CancelResonMaster> dc=cancelResonServicer.findNameInactive(detail.toUpperCase(),mod.toUpperCase());
		ReadList rs = new ReadList();
		if(dc.size()>=1){
			rs.setSuccess(false);
			rs.setMessage("Cancel reason already exists in inactive list");
			return rs;
		}else if(dcs.size()>=1){
			rs.setMessage("Cancel reason already exists in active list");
			rs.setSuccess(false);
			return rs;
		}else{
			ReadList rss = new ReadList();
			rss=cancelResonServicer.save(detail,au.getUsername(),mod.toUpperCase());
			return rss;
		}
	}
		
}