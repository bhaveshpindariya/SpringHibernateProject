
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

import com.solusoft.jpa.EmpSiteVerData;
import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.AdminMaster;
import com.solusoft.jpa.entity.EmpSiteVer;
import com.solusoft.services.EmpSiteVerService;


@Controller
public class EmployeeSiteVerController {

	@Autowired
	EmpSiteVerService empSiteVerService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(EmployeeSiteVerController.class);
	
	@RequestMapping(value = "/EmployeeSiteVerdetail", method = RequestMethod.GET)
	public String EmployeeSiteVerdetail(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("Get:/ All Employee Site Ver detail Data...");
		
		List<EmpSiteVer> masters = empSiteVerService.findAll();
		List<EmpSiteVerData> datas=new ArrayList<EmpSiteVerData>();
		if(masters.size()>0){
			int i=1;
			for(EmpSiteVer p:masters){
				if(p.getVerticalMaster()!=null)
				{
					if(p.getSiteMaster().getIsactive()==0 && p.getVerticalMaster().getIsactive()==0){
						EmpSiteVerData de=new EmpSiteVerData();
						de.setNo(i);
						de.setId(p.getId());
						de.setSid(p.getSiteMaster().getId());
						de.setSname(p.getSiteMaster().getSname());
						de.setSalians(p.getSiteMaster().getSaliens());
						de.setEid(p.getEmployeeMaster().getEmpid());
						de.setEname(p.getEmployeeMaster().getName());
						de.setCid(p.getSiteMaster().getCompanyMaster().getCompanyCode());
						if(p.getVerticalMaster()!=null){
							de.setVname(p.getVerticalMaster().getVname());
							de.setVid(p.getVerticalMaster().getId());
						}else{
							de.setVname("");
							de.setVid(0);
						}
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
				}else{
					if(p.getSiteMaster().getIsactive()==0 ){
						EmpSiteVerData de=new EmpSiteVerData();
						de.setNo(i);
						de.setId(p.getId());
						de.setSid(p.getSiteMaster().getId());
						de.setSname(p.getSiteMaster().getSname());
						de.setSalians(p.getSiteMaster().getSaliens());
						de.setEid(p.getEmployeeMaster().getEmpid());
						de.setEname(p.getEmployeeMaster().getName());
						de.setCid(p.getSiteMaster().getCompanyMaster().getCompanyCode());
						if(p.getVerticalMaster()!=null){
							de.setVname(p.getVerticalMaster().getVname());
							de.setVid(p.getVerticalMaster().getId());
						}else{
							de.setVname("");
							de.setVid(0);
						}
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
		}
		
		List<EmpSiteVer> masteres =  empSiteVerService.findAllInactive();
		List<EmpSiteVerData> dataes=new ArrayList<EmpSiteVerData>();
		if(masteres.size()>0){
			int i=1;
			for(EmpSiteVer p:masteres){
					EmpSiteVerData de=new EmpSiteVerData();
					de.setNo(i);
					de.setId(p.getId());
					de.setSid(p.getSiteMaster().getId());
					de.setSname(p.getSiteMaster().getSname());
					de.setSalians(p.getSiteMaster().getSaliens());
					de.setEid(p.getEmployeeMaster().getEmpid());
					de.setEname(p.getEmployeeMaster().getName());
					if(p.getVerticalMaster()!=null){
						de.setVname(p.getVerticalMaster().getVname());
						de.setVid(p.getVerticalMaster().getId());
					}else{
						de.setVname("");
						de.setVid(0);
					}
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
		return "EmployeeSitesVer";
	}
	
	@RequestMapping(value ="rs/getesvactive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<EmpSiteVerData> getesvactive(Model model){
		List<EmpSiteVer> masters = empSiteVerService.findAll();
		List<EmpSiteVerData> datas=new ArrayList<EmpSiteVerData>();
		if(masters.size()>0){
			int i=1;
			for(EmpSiteVer p:masters){
				if(p.getVerticalMaster()!=null)
				{
					if(p.getSiteMaster().getIsactive()==0 && p.getVerticalMaster().getIsactive()==0){
						EmpSiteVerData de=new EmpSiteVerData();
						de.setNo(i);
						de.setId(p.getId());
						de.setSid(p.getSiteMaster().getId());
						de.setSname(p.getSiteMaster().getSname());
						de.setSalians(p.getSiteMaster().getSaliens());
						de.setEid(p.getEmployeeMaster().getEmpid());
						de.setEname(p.getEmployeeMaster().getName());
						de.setCid(p.getSiteMaster().getCompanyMaster().getCompanyCode());
						de.setVname(p.getVerticalMaster().getVname());
						de.setVid(p.getVerticalMaster().getId());
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
				}else{
					if(p.getSiteMaster().getIsactive()==0 ){
						EmpSiteVerData de=new EmpSiteVerData();
						de.setNo(i);
						de.setId(p.getId());
						de.setSid(p.getSiteMaster().getId());
						de.setSname(p.getSiteMaster().getSname());
						de.setSalians(p.getSiteMaster().getSaliens());
						de.setEid(p.getEmployeeMaster().getEmpid());
						de.setEname(p.getEmployeeMaster().getName());
						de.setCid(p.getSiteMaster().getCompanyMaster().getCompanyCode());
						de.setVname("");
						de.setVid(0);
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
		}
		return datas;
	}
	
	@RequestMapping(value ="rs/getesvinactive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<EmpSiteVerData> getesvinactive(Model model){
		List<EmpSiteVer> masteres =  empSiteVerService.findAllInactive();
		List<EmpSiteVerData> dataes=new ArrayList<EmpSiteVerData>();
		if(masteres.size()>0){
			int i=1;
			for(EmpSiteVer p:masteres){
					EmpSiteVerData de=new EmpSiteVerData();
					de.setNo(i);
					de.setId(p.getId());
					de.setSid(p.getSiteMaster().getId());
					de.setSname(p.getSiteMaster().getSname());
					de.setSalians(p.getSiteMaster().getSaliens());
					de.setEid(p.getEmployeeMaster().getEmpid());
					de.setEname(p.getEmployeeMaster().getName());
					if(p.getVerticalMaster()!=null){
						de.setVname(p.getVerticalMaster().getVname());
						de.setVid(p.getVerticalMaster().getId());
					}else{
						de.setVname("");
						de.setVid(0);
					}
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
	
	@RequestMapping(value ="deleteEmpSitVer",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList deleteEmpSitVer(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		return empSiteVerService.update(id,au.getUsername());
		
	}
	
	@RequestMapping(value ="activeIdEsVer",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList activeIdEsVer(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		return empSiteVerService.activeId(id,au.getUsername());
		
	}
	
	@RequestMapping(value ="updateEmpSitVer",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList updateEmpSitVer(@RequestParam (value="ID",required=true) Integer id,
					 @RequestParam (value="Sit",required=true) Integer sitId,
					 @RequestParam (value="Emp",required=true) long empId,
					 @RequestParam (value="Vid",required=true) Integer vid,
					 Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		List<EmpSiteVer> dc=empSiteVerService.findNameActive(sitId,empId,vid);
		List<EmpSiteVer> dcs=empSiteVerService.findNameInactive(sitId,empId,vid);
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		if(dc.size()>=2){
			  rs.setSuccess(false);
			  rs.setMessage("Employee site vertical already exists in active list or inactive list");
			  return rs;
		}else if(dcs.size()>=2){
			 rs.setMessage("Employee site vertical already exists in active list or inactive list");
			 rs.setSuccess(false);
			 return rs;
		}else if(dc.size()>=1){
			for(EmpSiteVer dcss:dc){
				if(dcss.getId().equals(id)){
					rs=empSiteVerService.updates(id,empId,sitId,vid,au.getUsername());
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Employee site vertical already exists in active list or inactive list");
					return rs;
				}
		   }
		}else if(dcs.size()>=1){
			for(EmpSiteVer dcss:dcs){
				if(dcss.getId().equals(id)){
					rs=empSiteVerService.updates(id,empId,sitId,vid,au.getUsername());
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Employee site vertical already exists in active list or inactive list");
					return rs;
				}
		   }
		}else{
			rs=empSiteVerService.updates(id,empId,sitId,vid,au.getUsername());
			return rs;
		}
		return rs;
	}
	
	@RequestMapping(value ="insertEmpSitVer",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList insertEmpSitVer(@RequestParam (value="Sit",required=true) Integer sitId,
					  @RequestParam (value="Emp",required=true) long empId,
					  @RequestParam (value="Vid",required=true) Integer vid,
					  Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		List<EmpSiteVer> dcs=empSiteVerService.findNameActive(sitId,empId,vid);
		List<EmpSiteVer> dc=empSiteVerService.findNameInactive(sitId,empId,vid);
		ReadList rs = new ReadList();
		if(dc.size()>=1){
			rs.setSuccess(false);
			rs.setMessage("Employee site vertical already exists in active list or inactive list");
			return rs;
		}else if(dcs.size()>=1){
			rs.setMessage("Employee site vertical already exists in active list or inactive list");
			rs.setSuccess(false);
			return rs;
		}else{
			ReadList rss = new ReadList();
			rss=empSiteVerService.save(empId,sitId,vid,au.getUsername());
			return rss;
		}
		
	}
}