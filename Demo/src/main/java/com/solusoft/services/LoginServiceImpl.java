package com.solusoft.services;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.dao.AdminMasterDAO;
import com.solusoft.jpa.dao.AudittrailDAO;
import com.solusoft.jpa.dao.RoleDAO;
import com.solusoft.jpa.entity.AdminMaster;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.RoleManagement;

@Service("loginService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class LoginServiceImpl implements LoginService {

	@Autowired
	AdminMasterDAO adminMasterDAO;
	
	@Autowired
	AudittrailDAO audittrailDAO;
	
	@Autowired
	RoleDAO roleDAO;
	
	private static final String tabName="LOGIN_MASTER";

	@Override
	public AdminMaster findByUsernames(String username,String pass) {
		if (username!= null &&  username.length() > 0) {
			List<AdminMaster> masters = adminMasterDAO.findByPropertys(username,pass);
			if (masters != null && masters.size() > 0) {
				return masters.get(0);
			}
		}
		return null;
	}
	
	@Override
	public AdminMaster findByUsername(String username) {
		if (username!= null &&  username.length() > 0) {
			List<AdminMaster> masters = adminMasterDAO.findByProperty(username.toUpperCase());
			if (masters != null && masters.size() > 0) {
				return masters.get(0);
			}
		}
		return null;
	}
	
	@Override
	public ReadList validateUser(AdminMaster master) {
		ReadList result = new ReadList();
		if (master != null) {
			if (master.getUsername() != null
					&& !master.getUsername().equals("")
					&& master.getPassword() != null
					&& !master.getPassword().equals("")) {
				List<AdminMaster> masters = adminMasterDAO.validateuser(master);

				if (masters != null && masters.size() > 0) {
					result.setSuccess(true);
					result.setResults(masters);
				} else {
					result.setSuccess(false);
					result.setResults(null);
				}
			}
		}
		return result;
	}
	
	@Override
	public List<AdminMaster> findByAppicationAdmin(){
		return adminMasterDAO.findall();
	}
	
	@Override
	public List<AdminMaster> findalls(String role){
		return adminMasterDAO.findalls(role);
	}
	
	@Override
	public List<AdminMaster> findall(){
		return adminMasterDAO.findall();
	}
	
	@Override
	public List<AdminMaster> finddata(Integer role,String user){
		return adminMasterDAO.finddata(role,user);
	}
	
	@Override
	public ReadList delete(Integer id,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		AdminMaster ll=adminMasterDAO.findId(id);
		String username =ll.getUsername();
		String pass=ll.getPassword();
		String role=ll.getRoleManagement().getRolename();
		String email=ll.getEmail();
		String news="";
		news="User Name :-"+username+", Password :-"+pass+", Role :-"+role+", Email :-"+email;
		Boolean data=adminMasterDAO.delete(ll);
		if(data==true){
			Auditrail de=new Auditrail();
			de.setOperation("Delete");
			de.setRecord(""+id);
			de.setOvalue(news);
			de.setNvalue(news);
			de.setModifyBy(user);
			de.setModifyDate(new Timestamp(new Date().getTime()));
			de.setTableName(tabName);
			audittrailDAO.save(de);
			rs.setSuccess(data);
		}
		return rs;
	}
	
	@Override
	public ReadList updates(Integer id,String name,String pass,String email,Integer role,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		AdminMaster ll=adminMasterDAO.findId(id);
		String users=ll.getUsername();
		String passs=ll.getPassword();
		String emails=ll.getEmail();
		Timestamp createdDate;
		String createdBy;
		createdBy=ll.getCreatedBy();
		createdDate=ll.getCreatedDate();
		String urole=ll.getRoleManagement().getRolename();
		String news="";
		String old="";
		RoleManagement prs=roleDAO.findid(role);
		String rname=prs.getRolename();
		
		if(!users.equalsIgnoreCase(name))
		{
		   news=news+"User Name :-"+users;
		   old=old+"Department :-"+name;
			
		}
		
		if(!passs.equalsIgnoreCase(pass))
		{
			if(news !=""){
				news=news+" Password :-"+pass;
				old=old+", Password :-"+passs;
			}else{
				news=news+"Password :-"+passs;
				old=old+"Password :-"+pass;
			}
		}
		
		if(!emails.equalsIgnoreCase(email))
		{
			if(news !=""){
				news=news+" Email Address :-"+email;
				old=old+", Email Address :-"+emails;
			}else{
				news=news+"Email Address :-"+email;
				old=old+"Email Address :-"+emails;
			}
		}
		
		if(!urole.equalsIgnoreCase(rname))
		{
			if(news !=""){
				news=news+" Role :-"+rname;
				old=old+", Role :-"+urole;
			}else{
				news=news+"Role :-"+rname;
				old=old+"Role :-"+urole;
			}
		}
		
		AdminMaster ss=new AdminMaster();
		ss.setId(id);
		ss.setUsername(name);
		ss.setPassword(pass);
		ss.setEmail(email);
		ss.setRoleManagement(prs);
		ss.setCreatedDate(createdDate);
		ss.setCreatedBy(createdBy);
		ss.setModifyBy(user);
		ss.setModifyDate(new Timestamp(new Date().getTime()));
		AdminMaster data=adminMasterDAO.save(ss);
		if(news!=""){
			if(data.getId()>0){
				Auditrail de=new Auditrail();
				de.setOperation("Update");
				de.setRecord(""+id);
				de.setNvalue(news);
				de.setOvalue(old);
				de.setModifyBy(user);
				de.setModifyDate(new Timestamp(new Date().getTime()));
				de.setTableName(tabName);
				audittrailDAO.save(de);
				rs.setSuccess(true);
			}
		}else{
			rs.setSuccess(true);
		}
		return rs;
	}
	
	@Override
	public ReadList save(String name,String pass,String email,Integer role,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		RoleManagement prs=roleDAO.findid(role);
		String rname=prs.getRolename();
		String news="";
		news="User Name :-"+name+", Password :-"+pass+", Role :-"+rname+", Email :-"+email;
		AdminMaster ss=new AdminMaster();
		ss.setUsername(name);
		ss.setPassword(pass);
		ss.setEmail(email);
		ss.setRoleManagement(prs);
		ss.setCreatedBy(user);
		ss.setCreatedDate(new Timestamp(new Date().getTime()));
		AdminMaster data=adminMasterDAO.save(ss);
		if(data.getId()>0){
			Auditrail de=new Auditrail();
			de.setOperation("Inserted");
			de.setRecord(""+data.getId());
			de.setNvalue(news);
			de.setOvalue("");
			de.setCreatedBy(user);
			de.setCreatedDate(new Timestamp(new Date().getTime()));
			de.setTableName(tabName);
			audittrailDAO.save(de);
			rs.setSuccess(true);
		}
		return rs;
	}
}