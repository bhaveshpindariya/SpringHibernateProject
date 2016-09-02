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

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.BRLGroupData;
import com.solusoft.jpa.entity.AdminMaster;
import com.solusoft.jpa.entity.BRLGroup;
import com.solusoft.services.BRLGroupService;

@Controller
public class BRLGropController {

	@Autowired
	BRLGroupService bRLGroupService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(BRLGropController.class);
	
	@RequestMapping(value = "/BRLGroupData", method = RequestMethod.GET)
	public String BRLGroupData(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All BRL Group/Lab Data...");
		List<BRLGroup> masters = bRLGroupService.findAll();
		List<BRLGroupData> datas=new ArrayList<BRLGroupData>();
		if(masters.size()>0){
			int i=1;
			for(BRLGroup p:masters){
				BRLGroupData de=new BRLGroupData();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getGroupname());
				de.setAbbre(p.getAbbreviation());
				de.setCompanycode(p.getCompanyMaster().getCompanyCode());
				de.setCompanyname(p.getCompanyMaster().getCompanyName());
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
		
		List<BRLGroup> masteres = bRLGroupService.findAllInactive();
		List<BRLGroupData> dataes=new ArrayList<BRLGroupData>();
		if(masteres.size()>0){
			int i=1;
			for(BRLGroup p:masteres){
				BRLGroupData de=new BRLGroupData();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getGroupname());
				de.setAbbre(p.getAbbreviation());
				de.setCompanycode(p.getCompanyMaster().getCompanyCode());
				de.setCompanyname(p.getCompanyMaster().getCompanyName());
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
		model.addAttribute("masteres", dataes);
		model.addAttribute("masters", datas);
		return "BRLGroups";
	}
	
	@RequestMapping(value ="rs/getbrlActive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<BRLGroupData> getbrlActive(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		List<BRLGroup> masters = bRLGroupService.findAll();
		List<BRLGroupData> datas=new ArrayList<BRLGroupData>();
		if(masters.size()>0){
			int i=1;
			for(BRLGroup p:masters){
				BRLGroupData de=new BRLGroupData();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getGroupname());
				de.setAbbre(p.getAbbreviation());
				de.setCompanycode(p.getCompanyMaster().getCompanyCode());
				de.setCompanyname(p.getCompanyMaster().getCompanyName());
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
	
	@RequestMapping(value ="rs/getbrlInActive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<BRLGroupData> getbrlInActive(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		List<BRLGroup> masteres = bRLGroupService.findAllInactive();
		List<BRLGroupData> dataes=new ArrayList<BRLGroupData>();
		if(masteres.size()>0){
			int i=1;
			for(BRLGroup p:masteres){
				BRLGroupData de=new BRLGroupData();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getGroupname());
				de.setAbbre(p.getAbbreviation());
				de.setCompanycode(p.getCompanyMaster().getCompanyCode());
				de.setCompanyname(p.getCompanyMaster().getCompanyName());
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
	
	@RequestMapping(value ="deleteBrlGroup",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Master(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		return bRLGroupService.update(id,au.getUsername());

	}

	@RequestMapping(value ="activeIdForBrl",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList activeId(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		return bRLGroupService.activeId(id,au.getUsername());
	}
	
	@RequestMapping(value ="updateBrlGroup",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Masters(@RequestParam (value="ID",required=true) Integer id,
					 @RequestParam (value="Com",required=true) Integer ccode,
					 @RequestParam (value="BrlName",required=true) String name,
					 @RequestParam (value="BrlAbbve",required=true) String abbre,
					 Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		List<BRLGroup> dc=bRLGroupService.findNameActive(name.toUpperCase(),abbre.toUpperCase());
		List<BRLGroup> dcs=bRLGroupService.findNameInactive(name.toUpperCase(),abbre.toUpperCase());
		ReadList rs = new ReadList();
		if(dc.size()>=2){
			  rs.setSuccess(false);
			  rs.setMessage("BRL Group already exists in active list");
			  return rs;
		}else if(dcs.size()>=2){
				rs.setMessage("BRL Group already exists in inactive list");
				rs.setSuccess(false);
				return rs;
		}else if(dc.size()>=1){
			for(BRLGroup dcss:dc){
				if(dcss.getId().equals(id)){
					rs=bRLGroupService.updates(id,ccode,name,abbre,au.getUsername());
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("BRL Group already exits in active list");
					return rs;
				}
		   }
		}else if(dcs.size()>=1){
			for(BRLGroup dcss:dcs){
				if(dcss.getId().equals(id)){
					rs=bRLGroupService.updates(id,ccode,name,abbre,au.getUsername());
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("BRL Group already exists in inactive list");
					return rs;
				}
		   }
		}else{
			rs=bRLGroupService.updates(id,ccode,name,abbre,au.getUsername());
		  return rs;
		}
		return rs;
	}
	
	@RequestMapping(value ="insertBrlGroup",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Masteres(@RequestParam (value="Com",required=true) Integer ccode,
					  @RequestParam (value="BrlName",required=true) String name,
					  @RequestParam (value="BrlAbbve",required=true) String abbre,
					  Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		List<BRLGroup> dcs=bRLGroupService.findNameActive(name.toUpperCase(),abbre.toUpperCase());
		List<BRLGroup> dc=bRLGroupService.findNameInactive(name.toUpperCase(),abbre.toUpperCase());
		System.out.println("1 "+dcs.size());
		System.out.println("2 "+dc.size());
		ReadList rs = new ReadList();
		if(dc.size()>=1){
			rs.setSuccess(false);
			rs.setMessage("BRL Group already exists in active list or inactive list");
			return rs;
		}else if(dcs.size()>=1){
			rs.setMessage("BRL Group already exists in active list or inactive list");
			rs.setSuccess(false);
			return rs;
		}else{
			ReadList rss = new ReadList();
			rss=bRLGroupService.save(ccode,name,abbre,au.getUsername());
			return rss;
		}
	}
	
}