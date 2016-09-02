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

import com.solusoft.jpa.LoginData;
import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.RoleData;
import com.solusoft.jpa.entity.AdminMaster;
import com.solusoft.jpa.entity.RoleManagement;
import com.solusoft.services.LoginService;
import com.solusoft.services.RoleService;


@Controller
public class UserManagementController {

	@Autowired
	RoleService roleService;
	
	@Autowired
	LoginService loginService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserManagementController.class);
	
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public String roles(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All roles Data...");
		List<RoleManagement> masters = roleService.findall();
		List<RoleData> datas=new ArrayList<RoleData>();
		if(masters.size()>0){
			int i=1;
			for(RoleManagement p:masters){
				RoleData na=new RoleData();
				na.setNo(i);
				na.setId(p.getId());
				na.setRolename(p.getRolename());
				na.setCreatedBy(p.getCreatedBy());
				if(p.getCreatedDate() !=null){
					String pattern = "dd/MM/yyyy";
				    SimpleDateFormat formats = new SimpleDateFormat(pattern);
					Timestamp tt=p.getCreatedDate();
					Date startDate = tt;
					na.setCreatedDate(formats.format(startDate)+"");
				}else{
					na.setCreatedDate("");
				}
				na.setModifyBy(p.getModifyBy());
				
				if(p.getModifyDate() !=null){
					String pattern1 = "dd/MM/yyyy";
				    SimpleDateFormat formats1 = new SimpleDateFormat(pattern1);
					Timestamp tt1=p.getModifyDate();
					Date startDate1 = tt1;
					na.setModifyDate(formats1.format(startDate1)+"");
				}else{
					na.setModifyDate("");
				}
				datas.add(na);
				i++;
			}
		}
		model.addAttribute("master", datas);
		return "Role";
	}
	
	
	
	@RequestMapping(value ="rs/getRoles",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<RoleData> getRoles(Model model){
		List<RoleManagement> masters = roleService.findall();
		List<RoleData> datas=new ArrayList<RoleData>();
		if(masters.size()>0){
			int i=1;
			for(RoleManagement p:masters){
				RoleData na=new RoleData();
				na.setNo(i);
				na.setId(p.getId());
				na.setRolename(p.getRolename());
				na.setCreatedBy(p.getCreatedBy());
				if(p.getCreatedDate() !=null){
					String pattern = "dd/MM/yyyy";
				    SimpleDateFormat formats = new SimpleDateFormat(pattern);
					Timestamp tt=p.getCreatedDate();
					Date startDate = tt;
					na.setCreatedDate(formats.format(startDate)+"");
				}else{
					na.setCreatedDate("");
				}
				na.setModifyBy(p.getModifyBy());
				
				if(p.getModifyDate() !=null){
					String pattern1 = "dd/MM/yyyy";
				    SimpleDateFormat formats1 = new SimpleDateFormat(pattern1);
					Timestamp tt1=p.getModifyDate();
					Date startDate1 = tt1;
					na.setModifyDate(formats1.format(startDate1)+"");
				}else{
					na.setModifyDate("");
				}
				datas.add(na);
				i++;
			}
		}
		return datas;
	}
	
	
	@RequestMapping(value ="insertuserRole",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList InsertMasteres(@RequestParam (value="Role",required=true) String role,
					  		Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		List<RoleManagement> dc=roleService.findRole(role);
		ReadList rs = new ReadList();
		if(dc.size()>=1){
			rs.setSuccess(false);
			rs.setMessage("user role already exists.");
			return rs;
		}else{
			ReadList rss = new ReadList();
			rss=roleService.save(role,au.getUsername());
			return rss;
		}
	}
	
	@RequestMapping(value = "/userManagement", method = RequestMethod.GET)
	public String userManagement(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All userManagement Data...");
		List<AdminMaster> masters = loginService.findall();
		List<LoginData> datas=new ArrayList<LoginData>();
		if(masters.size()>0){
			int i=1;
			for(AdminMaster p:masters){
				if(!("APPAdministrator").equalsIgnoreCase(p.getRoleManagement().getRolename().trim())){
					LoginData na=new LoginData();
					na.setNo(i);
					na.setId(p.getId());
					na.setName(p.getUsername());
					na.setPassword(p.getPassword());
					na.setRole(p.getRoleManagement().getRolename());
					na.setRoleid(p.getRoleManagement().getId());
					na.setEmail(p.getEmail());
					na.setCreatedBy(p.getCreatedBy());
					if(p.getCreatedDate() !=null){
						String pattern = "dd/MM/yyyy";
					    SimpleDateFormat formats = new SimpleDateFormat(pattern);
						Timestamp tt=p.getCreatedDate();
						Date startDate = tt;
						na.setCreatedDate(formats.format(startDate)+"");
					}else{
						na.setCreatedDate("");
					}
					na.setModifyBy(p.getModifyBy());
					
					if(p.getModifyDate() !=null){
						String pattern1 = "dd/MM/yyyy";
					    SimpleDateFormat formats1 = new SimpleDateFormat(pattern1);
						Timestamp tt1=p.getModifyDate();
						Date startDate1 = tt1;
						na.setModifyDate(formats1.format(startDate1)+"");
					}else{
						na.setModifyDate("");
					}
					datas.add(na);
					i++;
				}
			}
		}
		model.addAttribute("master", datas);
		return "UserDetail";
	}
	
	@RequestMapping(value ="rs/getuserdata",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<LoginData> getuserdata(Model model){
		List<AdminMaster> masters = loginService.findall();
		List<LoginData> datas=new ArrayList<LoginData>();
		if(masters.size()>0){
			int i=1;
			for(AdminMaster p:masters){
				if(!("APPAdministrator").equalsIgnoreCase(p.getRoleManagement().getRolename().trim())){
					LoginData na=new LoginData();
					na.setNo(i);
					na.setId(p.getId());
					na.setName(p.getUsername());
					na.setPassword(p.getPassword());
					na.setRole(p.getRoleManagement().getRolename());
					na.setRoleid(p.getRoleManagement().getId());
					na.setEmail(p.getEmail());
					na.setCreatedBy(p.getCreatedBy());
					if(p.getCreatedDate() !=null){
						String pattern = "dd/MM/yyyy";
					    SimpleDateFormat formats = new SimpleDateFormat(pattern);
						Timestamp tt=p.getCreatedDate();
						Date startDate = tt;
						na.setCreatedDate(formats.format(startDate)+"");
					}else{
						na.setCreatedDate("");
					}
					na.setModifyBy(p.getModifyBy());
					
					if(p.getModifyDate() !=null){
						String pattern1 = "dd/MM/yyyy";
					    SimpleDateFormat formats1 = new SimpleDateFormat(pattern1);
						Timestamp tt1=p.getModifyDate();
						Date startDate1 = tt1;
						na.setModifyDate(formats1.format(startDate1)+"");
					}else{
						na.setModifyDate("");
					}
					datas.add(na);
					i++;
					}
			}
		}
		return datas;
	}
	
	@RequestMapping(value ="deleteuserdata",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList deleteMasterMapping(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		return loginService.delete(id,au.getUsername());
	}
	
	@RequestMapping(value ="updateUserdata",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList updateUserdata(@RequestParam (value="ID",required=true) Integer id,
							 @RequestParam (value="Name",required=true) String name,
							 @RequestParam (value="Pass",required=true) String pass,
							 @RequestParam (value="Email",required=true) String email,
							 @RequestParam (value="Role",required=true) Integer role,
					 Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		List<AdminMaster> dc=loginService.finddata(role,name.toUpperCase());
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		if(dc.size()>=2){
			  rs.setSuccess(false);
			  rs.setMessage("User role already exists in user detail");
			  return rs;
		}else if(dc.size()>=1){
			for(AdminMaster dcss:dc){
				if(dcss.getId().equals(id)){
					rs=loginService.updates(id,name,pass,email,role,au.getUsername());
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("User role already exists in user detail");
					return rs;
				}
			}
		}else{
			rs=loginService.updates(id,name,pass,email,role,au.getUsername());
			return rs;
		}
		return rs;
	}
	
	@RequestMapping(value ="insertUserdata",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList insertEmpSitVer(@RequestParam (value="Name",required=true) String name,
			 				 @RequestParam (value="Pass",required=true) String pass,
			 				 @RequestParam (value="Email",required=true) String email,
			 				 @RequestParam (value="Role",required=true) Integer role,
					  Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		List<AdminMaster> dc=loginService.finddata(role,name.toUpperCase());
		ReadList rs = new ReadList();
		if(dc.size()>=1){
			rs.setSuccess(false);
			rs.setMessage("User role already exists in user detail");
			return rs;
		}else{
			ReadList rss = new ReadList();
			rss=loginService.save(name,pass,email,role,au.getUsername());
			return rss;
		}
		
	}
}