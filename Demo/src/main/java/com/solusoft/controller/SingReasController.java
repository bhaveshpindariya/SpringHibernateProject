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
import com.solusoft.jpa.SigRole;
import com.solusoft.jpa.SignType;
import com.solusoft.jpa.SignatureAudit;
import com.solusoft.jpa.entity.AdminMaster;
import com.solusoft.jpa.entity.SignatureAuditMaster;
import com.solusoft.jpa.entity.SingReasMaster;
import com.solusoft.jpa.entity.SingRole;
import com.solusoft.services.SignatureAuditService;
import com.solusoft.services.SingReasServicer;
import com.solusoft.services.SingRoleServicer;

@Controller
public class SingReasController {

	@Autowired
	SingReasServicer singReasServicer;
	
	@Autowired
	SingRoleServicer singRoleServicer;
	
	@Autowired
	SignatureAuditService signatureAuditService;
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(SingReasController.class);
	
	@RequestMapping(value = "/signReason", method = RequestMethod.GET)
	public String signReason(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All Signature reason Data...");
		
		List<SingReasMaster> masters = singReasServicer.findAll();
		List<SignType> datas=new ArrayList<SignType>();
		if(masters.size()>0){
			int i=1;
			for(SingReasMaster p:masters){
				if(p.getSingRole().getIsactive()==0){
					SignType de=new SignType();
					de.setNo(i);
					de.setId(p.getId());
					de.setName(p.getDetais());
					de.setRoles(p.getSingRole().getSrole());
					de.setRole(p.getSingRole().getId());
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
		
		List<SingReasMaster> masteres = singReasServicer.findAllInactive();
		List<SignType> dataes=new ArrayList<SignType>();
		if(masteres.size()>0){
			int i=1;
			for(SingReasMaster p:masteres){
					SignType de=new SignType();
					de.setNo(i);
					de.setId(p.getId());
					de.setName(p.getDetais());
					de.setRoles(p.getSingRole().getSrole());
					de.setRole(p.getSingRole().getId());
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
		return "SingReasMasters";
	}
	
	@RequestMapping(value ="rs/getsignactive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<SignType> getsignactive(Model model){
		List<SingReasMaster> masters = singReasServicer.findAll();
		List<SignType> datas=new ArrayList<SignType>();
		if(masters.size()>0){
			int i=1;
			for(SingReasMaster p:masters){
				if(p.getSingRole().getIsactive()==0){
					SignType de=new SignType();
					de.setNo(i);
					de.setId(p.getId());
					de.setName(p.getDetais());
					de.setRoles(p.getSingRole().getSrole());
					de.setRole(p.getSingRole().getId());
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
	
	@RequestMapping(value ="rs/getsigninactive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<SignType> getsigninactive(Model model){
		List<SingReasMaster> masteres = singReasServicer.findAllInactive();
		List<SignType> dataes=new ArrayList<SignType>();
		if(masteres.size()>0){
			int i=1;
			for(SingReasMaster p:masteres){
					SignType de=new SignType();
					de.setNo(i);
					de.setId(p.getId());
					de.setName(p.getDetais());
					de.setRoles(p.getSingRole().getSrole());
					de.setRole(p.getSingRole().getId());
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
	
	
	@RequestMapping(value ="activeIdsrc",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList activeIdsrc(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		return singReasServicer.activeId(id,au.getUsername());
	}
	
	@RequestMapping(value ="deleteed",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Master(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		return singReasServicer.update(id,au.getUsername());
		
	}
	
	@RequestMapping(value ="updateed",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Masters(@RequestParam (value="ID",required=true) Integer id,
					 @RequestParam (value="Name",required=true) String detail,
			 		 @RequestParam (value="Sroles",required=true) Integer roles,
			 		 Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		List<SingReasMaster> dc=singReasServicer.findNameActive(detail.toUpperCase(),roles);
		List<SingReasMaster> dcs=singReasServicer.findNameInactive(detail.toUpperCase(),roles);
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		if(dc.size()>=2){
			  rs.setSuccess(false);
			  rs.setMessage("Signature reason already exists in active list");
			  return rs;
		}else if(dcs.size()>=2){
			  rs.setMessage("Signature reason already exists in inactive list");
			  rs.setSuccess(false);
			  return rs;
		}else if(dc.size()>=1){
			for(SingReasMaster dcss:dc){
				if(dcss.getId().equals(id)){
					rs=singReasServicer.updates(id,detail,au.getUsername(),roles);
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Signature reason already exits in active list");
					return rs;
				}
		   }
		}else if(dcs.size()>=1){
			 for(SingReasMaster dcss:dcs){
				  if(dcss.getId().equals(id)){
					rs=singReasServicer.updates(id,detail,au.getUsername(),roles);
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Signature reason already exists in inactive list");
					return rs;
				}
		   }
		}else{
		  rs=singReasServicer.updates(id,detail,au.getUsername(),roles);
		  return rs;
		}
		return rs;
	}
	
	@RequestMapping(value ="inserted",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Masteres(@RequestParam (value="Name",required=true) String detail,
					  @RequestParam (value="Srole",required=true) Integer srole,
					  Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		List<SingReasMaster> dcs=singReasServicer.findNameActive(detail.toUpperCase(),srole);
		List<SingReasMaster> dc=singReasServicer.findNameInactive(detail.toUpperCase(),srole);
		ReadList rs = new ReadList();
		if(dc.size()>=1){
			rs.setSuccess(false);
			rs.setMessage("Signature reason already exists in inactive list");
			return rs;
		}else if(dcs.size()>=1){
			rs.setMessage("Signature reason already exists in active list");
			rs.setSuccess(false);
			return rs;
		}else{
			ReadList rss = new ReadList();
			rss=singReasServicer.save(detail,au.getUsername(),srole);
			return rss;
		}
	}
	
	//sign role
	
	@RequestMapping(value = "/signRole", method = RequestMethod.GET)
	public String signRole(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All Signature role Data...");
		
		List<SingRole> masters = singRoleServicer.findAll();
		List<SigRole> datas=new ArrayList<SigRole>();
		if(masters.size()>0){
			int i=1;
			for(SingRole p:masters){
				SigRole de=new SigRole();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getSrole());
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
		
		List<SingRole> masteres = singRoleServicer.findAllInactive();
		List<SigRole> dataes=new ArrayList<SigRole>();
		if(masteres.size()>0){
			int i=1;
			for(SingRole p:masteres){
				SigRole de=new SigRole();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getSrole());
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
		return "SingRoleMasters";
	}
	
	@RequestMapping(value ="rs/getsignrolactive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<SigRole> getsignrolactive(Model model){
		List<SingRole> masters = singRoleServicer.findAll();
		List<SigRole> datas=new ArrayList<SigRole>();
		if(masters.size()>0){
			int i=1;
			for(SingRole p:masters){
				SigRole de=new SigRole();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getSrole());
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
	
	@RequestMapping(value ="rs/getsignrolinactive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<SigRole> getsignrolinactive(Model model){
		List<SingRole> masteres = singRoleServicer.findAllInactive();
		List<SigRole> dataes=new ArrayList<SigRole>();
		if(masteres.size()>0){
			int i=1;
			for(SingRole p:masteres){
				SigRole de=new SigRole();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getSrole());
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
	
	@RequestMapping(value ="rs/getRole",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<SingRole> getRole(
					Model model){
		return singRoleServicer.findAll();
	}
	
	@RequestMapping(value ="activeIdsr",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList activeIdsr(@RequestParam (value="ID",required=true) Integer id,
					 Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		return singRoleServicer.activeId(id,au.getUsername());
	}
	
	@RequestMapping(value ="deleteSirole",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList siRolde(@RequestParam (value="ID",required=true) Integer id,
					 Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		return singRoleServicer.updateRole(id,au.getUsername());
	}
	
	@RequestMapping(value ="updateSirole",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList siRolup(@RequestParam (value="ID",required=true) Integer id,
			 		 @RequestParam (value="Name",required=true) String detail,
			 		 Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		List<SingRole> dc=singRoleServicer.findNameActive(detail.toUpperCase());
		List<SingRole> dcs=singRoleServicer.findNameInactive(detail.toUpperCase());
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		if(dc.size()>=2){
			  rs.setSuccess(false);
			  rs.setMessage("Signature role already exists in active list");
			  return rs;
		}else if(dcs.size()>=2){
			  rs.setMessage("Signature role already exists in inactive list");
			  rs.setSuccess(false);
			  return rs;
		}else if(dc.size()>=1){
			for(SingRole dcss:dc){
				if(dcss.getId().equals(id)){
					rs=singRoleServicer.updatesRole(id,detail,au.getUsername());
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Signature role already exits in active list");
					return rs;
				}
		   }
		}else if(dcs.size()>=1){
			 for(SingRole dcss:dcs){
				  if(dcss.getId().equals(id)){
					  rs=singRoleServicer.updatesRole(id,detail,au.getUsername());
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Signature role already exists in inactive list");
					return rs;
				}
		   }
		}else{
		  rs=singRoleServicer.updatesRole(id,detail,au.getUsername());
		  return rs;
		}
		return rs;
	}
	
	@RequestMapping(value ="insertSirole",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList siRolin(@RequestParam (value="Name",required=true) String detail,
					 Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		List<SingRole> dcs=singRoleServicer.findNameActive(detail.toUpperCase());
		List<SingRole> dc=singRoleServicer.findNameInactive(detail.toUpperCase());
		ReadList rs = new ReadList();
		if(dc.size()>=1){
			rs.setSuccess(false);
			rs.setMessage("Signature role already exists in inactive list");
			return rs;
		}else if(dcs.size()>=1){
			rs.setMessage("Signature role already exists in active list");
			rs.setSuccess(false);
			return rs;
		}else{
			ReadList rss = new ReadList();
			rss=singRoleServicer.saveRole(detail,au.getUsername());
			return rss;
		}
	}
	
	//sing audit
	
	@RequestMapping(value = "/signAudit", method = RequestMethod.GET)
	public String signAudit(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All Signature audit Data...");
		
		List<SignatureAuditMaster> masters = signatureAuditService.findall();
		List<SignatureAudit> datas=new ArrayList<SignatureAudit>();
		if(masters.size()>0){
			int i=1;
			for(SignatureAuditMaster p:masters){
					SignatureAudit de=new SignatureAudit();
					de.setNo(i);
					de.setId(p.getId());
					de.setDepname(p.getDname());
					de.setRname(p.getSingrole().getSrole());
					de.setEname(p.getEmployeeMaster().getName());
					de.setDocumentname(p.getDocumentName());
					if(p.getSigDate() !=null){
						String pattern = "dd/MM/yyyy";
					    SimpleDateFormat formats = new SimpleDateFormat(pattern);
						Timestamp tt=p.getSigDate();
						Date startDate = tt;
						de.setSidate(formats.format(startDate)+"");
					}else{
						de.setSidate("");
					}
					
					if(p.getOther().equalsIgnoreCase("NULL")){
						de.setSigReson(p.getSigreson().getDetais());
					}else{
						de.setSigReson(p.getOther());
					}
					datas.add(de);
					i++;
			}
		}
		model.addAttribute("master", datas);
		return "SignatureAuditss";
	}
}