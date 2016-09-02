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

import com.solusoft.jpa.LocatType;
import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.AdminMaster;
import com.solusoft.jpa.entity.LocationMaster;
import com.solusoft.services.LocationService;

@Controller
public class LocationController {

	@Autowired
	LocationService locationService;
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(LocationController.class);
	
	@RequestMapping(value = "/location", method = RequestMethod.GET)
	public String Master(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All Location type Data...");
		
		List<LocationMaster> masters = locationService.findAll();
		List<LocatType> datas=new ArrayList<LocatType>();
		if(masters.size()>0){
			int i=1;
			for(LocationMaster p:masters){
					LocatType de=new LocatType();
					de.setNo(i);
					de.setId(p.getId());
					de.setName(p.getName());
					de.setCode(p.getCode());
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
		
		List<LocationMaster> masteres = locationService.findAllInactive();
		List<LocatType> dataes=new ArrayList<LocatType>();
		if(masteres.size()>0){
			int i=1;
			for(LocationMaster p:masteres){
					LocatType de=new LocatType();
					de.setNo(i);
					de.setId(p.getId());
					de.setName(p.getName());
					de.setCode(p.getCode());
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
		model.addAttribute("master", datas);
		model.addAttribute("masters", dataes);
		return "LocationMasters";
	}
	
	@RequestMapping(value ="rs/getlocaactive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<LocatType> getlocaactive(Model model){
		List<LocationMaster> masters = locationService.findAll();
		List<LocatType> datas=new ArrayList<LocatType>();
		if(masters.size()>0){
			int i=1;
			for(LocationMaster p:masters){
					LocatType de=new LocatType();
					de.setNo(i);
					de.setId(p.getId());
					de.setName(p.getName());
					de.setCode(p.getCode());
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
	
	@RequestMapping(value ="rs/getlocainactive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<LocatType> getlocainactive(Model model){
		List<LocationMaster> masteres = locationService.findAllInactive();
		List<LocatType> dataes=new ArrayList<LocatType>();
		if(masteres.size()>0){
			int i=1;
			for(LocationMaster p:masteres){
					LocatType de=new LocatType();
					de.setNo(i);
					de.setId(p.getId());
					de.setName(p.getName());
					de.setCode(p.getCode());
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
	
	@RequestMapping(value ="activeIdLo",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList activeIdLo(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		return locationService.activeId(id,au.getUsername());

	}
	
	@RequestMapping(value ="deleteLoc",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Master(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		return locationService.update(id,au.getUsername());

	}
	
	@RequestMapping(value ="updateLoc",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Masters(@RequestParam (value="ID",required=true) Integer id,
					 @RequestParam (value="Name",required=true) String detail,
					 @RequestParam (value="Code",required=true) String code,
					 Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		List<LocationMaster> dc=locationService.findNameActive(detail.toUpperCase(),code.toUpperCase());
		List<LocationMaster> dcs=locationService.findNameInactive(detail.toUpperCase(),code.toUpperCase());
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		if(dc.size()>=2){
			  rs.setSuccess(false);
			  rs.setMessage("Location already exists in active list");
			  return rs;
		}else if(dcs.size()>=2){
			  rs.setMessage("Location already exists in inactive list");
			  rs.setSuccess(false);
			  return rs;
		}else if(dc.size()>=1){
			for(LocationMaster dcss:dc){
				if(dcss.getId().equals(id)){
					rs=locationService.updates(id,detail,au.getUsername(),code);
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Location already exits in active list");
					return rs;
				}
		   }
		}else if(dcs.size()>=1){
			 for(LocationMaster dcss:dcs){
				  if(dcss.getId().equals(id)){
					  rs=locationService.updates(id,detail,au.getUsername(),code);
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Location already exists in inactive list");
					return rs;
				}
		   }
		}else{
		  rs=locationService.updates(id,detail,au.getUsername(),code);
		  return rs;
		}
		return rs;
	}
	
	@RequestMapping(value ="insertLoc",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Masteres(@RequestParam (value="Name",required=true) String detail,
					  @RequestParam (value="Code",required=true) String code,
					  Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		List<LocationMaster> dcs=locationService.findNameActive(detail.toUpperCase(),code.toUpperCase());
		List<LocationMaster> dc=locationService.findNameInactive(detail.toUpperCase(),code.toUpperCase());
		ReadList rs = new ReadList();
		if(dc.size()>=1){
			rs.setSuccess(false);
			rs.setMessage("Location already exists in active list or inactive list");
			return rs;
		}else if(dcs.size()>=1){
			rs.setMessage("Location already exists in active list or inactive list");
			rs.setSuccess(false);
			return rs;
		}else{
			ReadList rss = new ReadList();
			rss=locationService.save(detail,au.getUsername(),code);
			return rss;
		}
	}
}