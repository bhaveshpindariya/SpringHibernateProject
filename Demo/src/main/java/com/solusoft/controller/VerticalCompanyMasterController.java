
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

import com.solusoft.jpa.EmpVerData;
import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.AdminMaster;
import com.solusoft.jpa.entity.VerticalCompanyMaster;
import com.solusoft.services.CompanyService;
import com.solusoft.services.VerticalCompanyMasterService;
import com.solusoft.services.VerticalService;


@Controller
public class VerticalCompanyMasterController {

	@Autowired
	VerticalCompanyMasterService verticalCompanyMasterService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	VerticalService verticalService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(VerticalCompanyMasterController.class);
	
	@RequestMapping(value = "/CompanyVerdetail", method = RequestMethod.GET)
	public String EmployeeSitedetail(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("Get:/ All Vertical Legal Manager Data...");
		
		List<VerticalCompanyMaster> masters = verticalCompanyMasterService.findAll();
		List<EmpVerData> datas=new ArrayList<EmpVerData>();
		if(masters.size()>0){
			int i=1;
			for(VerticalCompanyMaster p:masters){
				if(p.getVerticalMaster().getIsactive()==0){
					EmpVerData de=new EmpVerData();
					de.setNo(i);
					de.setId(p.getId());
					de.setVid(p.getVerticalMaster().getId());
					de.setVname(p.getVerticalMaster().getVname());
					de.setCid(p.getCompanyMaster().getCompanyCode());
					de.setCname(p.getCompanyMaster().getCompanyName());
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
		}
		
		List<VerticalCompanyMaster> masteres = verticalCompanyMasterService.findAllInactive();
		List<EmpVerData> dataes=new ArrayList<EmpVerData>();
		if(masteres.size()>0){
			int i=1;
			for(VerticalCompanyMaster p:masteres){
				    EmpVerData de=new EmpVerData();
					de.setNo(i);
					de.setId(p.getId());
					de.setVid(p.getVerticalMaster().getId());
					de.setVname(p.getVerticalMaster().getVname());
					de.setCid(p.getCompanyMaster().getCompanyCode());
					de.setCname(p.getCompanyMaster().getCompanyName());
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
		return "VerticalCompany";
	}
	
	
	@RequestMapping(value ="rs/getverticalCompanyactive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<EmpVerData> getagreelegalactive(Model model){
		List<VerticalCompanyMaster> masters = verticalCompanyMasterService.findAll();
		List<EmpVerData> datas=new ArrayList<EmpVerData>();
		if(masters.size()>0){
			int i=1;
			for(VerticalCompanyMaster p:masters){
				if(p.getVerticalMaster().getIsactive()==0){
					EmpVerData de=new EmpVerData();
					de.setNo(i);
					de.setId(p.getId());
					de.setVid(p.getVerticalMaster().getId());
					de.setVname(p.getVerticalMaster().getVname());
					de.setCid(p.getCompanyMaster().getCompanyCode());
					de.setCname(p.getCompanyMaster().getCompanyName());
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
		}
		return datas;
	}
	
	@RequestMapping(value ="rs/getverticalCompanyinactive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<EmpVerData> getagreelegalinactive(Model model){
		List<VerticalCompanyMaster> masteres = verticalCompanyMasterService.findAllInactive();
		List<EmpVerData> dataes=new ArrayList<EmpVerData>();
		if(masteres.size()>0){
			int i=1;
			for(VerticalCompanyMaster p:masteres){
				    EmpVerData de=new EmpVerData();
					de.setNo(i);
					de.setId(p.getId());
					de.setVid(p.getVerticalMaster().getId());
					de.setVname(p.getVerticalMaster().getVname());
					de.setCid(p.getCompanyMaster().getCompanyCode());
					de.setCname(p.getCompanyMaster().getCompanyName());
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
	
	@RequestMapping(value ="deleteVcom",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Master(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		return verticalCompanyMasterService.update(id,au.getUsername());
		
	}
	
	@RequestMapping(value ="activeIdVcom",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList activeIdEv(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		return verticalCompanyMasterService.activeId(id,au.getUsername());
		
	}
	
	@RequestMapping(value ="updateVcom",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Masters(@RequestParam (value="ID",required=true) Integer id,
					 @RequestParam (value="Vid",required=true) Integer vid,
					 @RequestParam (value="Cid",required=true) Integer cid,
					  Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		List<VerticalCompanyMaster> dc=verticalCompanyMasterService.findNameActive(vid,cid);
		List<VerticalCompanyMaster> dcs=verticalCompanyMasterService.findNameInactive(vid,cid);
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		if(dc.size()>=2){
			  rs.setSuccess(false);
			  rs.setMessage("Vertical company already exists in active list");
			  return rs;
		}else if(dcs.size()>=2){
			  rs.setMessage("Vertical company already exists in inactive list");
			  rs.setSuccess(false);
			  return rs;
		}else if(dc.size()>=1){
			for(VerticalCompanyMaster dcss:dc){
				if(dcss.getId().equals(id)){
					rs=verticalCompanyMasterService.updates(id,vid,cid,au.getUsername());
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Vertical company already exits in active list");
					return rs;
				}
		   }
		}else if(dcs.size()>=1){
			for(VerticalCompanyMaster dcss:dcs){
				if(dcss.getId().equals(id)){
					rs=verticalCompanyMasterService.updates(id,vid,cid,au.getUsername());
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Vertical company already exists in inactive list");
					return rs;
				}
		   }
		}else{
				rs=verticalCompanyMasterService.updates(id,vid,cid,au.getUsername());
				  return rs;
		}
		return rs;
	}
	
	@RequestMapping(value ="insertVcom",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Masteres(@RequestParam (value="Vid",required=true) Integer vid,
					  @RequestParam (value="Cid",required=true) Integer cid,
					  Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		List<VerticalCompanyMaster> dcs=verticalCompanyMasterService.findNameActive(vid,cid);
		List<VerticalCompanyMaster> dc=verticalCompanyMasterService.findNameInactive(vid,cid);
		ReadList rs = new ReadList();
		if(dc.size()>=1){
			rs.setSuccess(false);
			rs.setMessage("Vertical company already exists in inactive list");
			return rs;
		}else if(dcs.size()>=1){
			rs.setMessage("Vertical company already exists in active list");
			rs.setSuccess(false);
			return rs;
		}else{
			ReadList rss = new ReadList();
			rss=verticalCompanyMasterService.save(vid,cid,au.getUsername());
			return rss;
		}
	}
}