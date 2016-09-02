package com.solusoft.controller;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.AdminMaster;
import com.solusoft.jpa.entity.RoleManagement;
import com.solusoft.services.LoginService;
import com.solusoft.services.RoleService;


@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	RoleService roleService;
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcomePage(Locale locale, Model model) {
		logger.debug("GET:/ Root called!");
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginForm(Locale locale, Model model,
			@RequestParam(required=false)String message) {
		String role="APPAdministrator";
		List<AdminMaster> admin=loginService.findalls(role);
		String h="";
		if(admin.size()>=1){
			if (message != null && !message.isEmpty()) {
				model.addAttribute("message", message);
			}
			model.addAttribute("status",h);
		}else{
			if (message != null && !message.isEmpty()) {
				model.addAttribute("message", message);
			}   
			h="hello";
			model.addAttribute("status",h);
			logger.info("Come to Logins and sign up......");
		}
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		logger.info("GET:/home called..");
		UserDetails userDetails;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			userDetails = (UserDetails) auth.getPrincipal();
			
			model.addAttribute("username", userDetails.getUsername());
			
			AdminMaster result = loginService.findByUsername(userDetails.getUsername());
			
			if (result != null ) {
				if(result.getRoleManagement().getRolename().equalsIgnoreCase("APPAdministrator")){
					request.getSession(true).setAttribute("user", result);
					session.setAttribute("APPAdministrator", true);
					return "redirect:/companys";
				}else if(result.getRoleManagement().getRolename().equalsIgnoreCase("PMAdministrator")){
					logger.debug(result.getUsername()+"/"+result.getPassword()+"  -"+new Date());
					request.getSession(true).setAttribute("user", result);
					session.setAttribute("PMAdministrator", true);
					return "redirect:/printResPM";
				}else if(result.getRoleManagement().getRolename().equalsIgnoreCase("LRFAdministrator")){
					logger.debug(result.getUsername()+"/"+result.getPassword()+"  -"+new Date());
					request.getSession(true).setAttribute("user", result);
					session.setAttribute("LRFAdministrator", true);
					return "redirect:/printResLRF";
				}else{
					logger.debug("username not found!");
					model.addAttribute("errorMessage", "Error in Login.");
					return "login.htm";
				}
			}else{
				logger.debug("username not found!");
				model.addAttribute("errorMessage", "Error in Login.");
				return "login.htm";
			}
		}else{
			model.addAttribute("errorMessage", "Error in Login.");
			return "login.htm";
		}
	}	
	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String validateUser(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response) {

		logger.info("POST:/login called!");
		
		AdminMaster master = new AdminMaster();
		master.setUsername(request.getParameter("j_username"));
		master.setPassword(request.getParameter("j_password"));

		ReadList result = loginService.validateUser(master);

		if (result.getSuccess()) {
			request.getSession(true).setAttribute("user", (AdminMaster)result.getResults().get(0));
			return "redirect:/index";
		} else {
			model.addAttribute("errorMessage", result.getMessage());
			return "login.htm";
		}
	}
	
	@RequestMapping(value = "/login/failure")
	public String loginFailure(Locale locale, Model model) {
		String message = "Invalid credentials!";
		return "redirect:/login?message=" + message;
	}

	@RequestMapping(value = "/login/invalid-session")
	public String invalidSession() {
		String message = "Invalid Session!";
		return "redirect:/login?message=" + message;
	}

	@RequestMapping(value = "/logout/success")
	public String logoutSuccess() {
		String message = "Logout Success!";
		return "redirect:/login?message=" + message;
	}
	
	@RequestMapping(value ="/insertRollandUser",method = RequestMethod.POST)
	public String insertRollandUser(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		ReadList rss = new ReadList();
	    String name=request.getParameter("name").trim();
		String eid=request.getParameter("email").trim();
		String pass=request.getParameter("password").trim();
		String rol=request.getParameter("role").trim();
		String message="";
		String role="APPAdministrator";
		List<AdminMaster> admin=loginService.findalls(role);
		if(admin.size()>=1){
			message="Administrator user is already in database";
		}else{
		RoleManagement data=roleService.merge(rol,name);
			if(data.getId()>0){
				rss=loginService.save(name,pass,eid,data.getId(),name);
				if(rss.getSuccess()){
					message="Administrator registration successfully";
				}else{
					message="Error in administrator registration";
				}
			}else{
				message="Error in administrator registration";
			}
		}
		return "redirect:/login?message=" + message;
	}
	
	
}