package com.solusoft.controller;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.solusoft.jpa.GetiDocConnection;
import com.solusoft.jpa.IdocData;
import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.AdminMaster;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.EmployeeMaster;
import com.solusoft.jpa.entity.IdocsUser;
import com.solusoft.jpa.entity.Idoctrail;
import com.solusoft.services.EmployeeService;
import com.solusoft.services.IdocService;
import com.solusoft.services.IdoctrailService;
import com.solusoft.jpa.IDocServiceStub;
import com.solusoft.jpa.IDocServiceStub.DepartmentMemberDTO;
import com.solusoft.jpa.IDocServiceStub.GetUsersByUsersRef;
import com.solusoft.jpa.IDocServiceStub.GetUsersByUsersRefResponse;
import com.solusoft.jpa.IDocServiceStub.InsertUser;
import com.solusoft.jpa.IDocServiceStub.InsertUserExt;
import com.solusoft.jpa.IDocServiceStub.InsertUserExtResponse;
import com.solusoft.jpa.IDocServiceStub.InsertUserResponse;
import com.solusoft.jpa.IDocServiceStub.SaveDeprartmentMember;
import com.solusoft.jpa.IDocServiceStub.UserDTO;
import com.solusoft.jpa.IDocServiceStub.UserOriginSourceDTO;

@Controller
public class UserSelectionController {

	@Autowired
	IdocService idocService;
		
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	IdoctrailService idoctrailService;
	
	private static final String tabName="IDOC_USERS";
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserSelectionController.class);
	
	public static ResourceBundle properties = null;
	public static String strs= null;
	public static ResourceBundle iDocHelperProperties = null;
	public String contextUserName = null;
	public static String contextID = null;
	public static IDocServiceStub idocConnection = null;
	public int userId=0;
	
	@RequestMapping(value = "/idocUser", method = RequestMethod.GET)
	public String idocUser(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All IdocUser Data...");
		List<IdocsUser> masters = idocService.findall();
		List<IdocData> datas=new ArrayList<IdocData>();
		if(masters.size()>0){
			for(IdocsUser p:masters){
				IdocData de=new IdocData();
				de.setId(p.getId());
				de.setEname(p.getEname());
				de.setFullName(p.getFullName());
				de.setEmail(p.getEmail());
				de.setLoginName(p.getLoginName());
				de.setDname(p.getDname());
				if(p.getUdate() !=null){
					String pattern = "dd/MM/yyyy";
				    SimpleDateFormat formats = new SimpleDateFormat(pattern);
					Timestamp tt=p.getUdate();
					Date startDate = tt;
					de.setUdate(formats.format(startDate)+"");
				}else{
					de.setUdate("");
				}
				
				datas.add(de);
			}
		}
		model.addAttribute("master", datas);
		return "IdocUser";
	}
	
	@RequestMapping(value ="rs/getiDocUser",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<IdocData> getiDocUser(Model model){
		List<IdocsUser> masters = idocService.findall();
		List<IdocData> datas=new ArrayList<IdocData>();
		if(masters.size()>0){
			for(IdocsUser p:masters){
				IdocData de=new IdocData();
				de.setId(p.getId());
				de.setEname(p.getEname());
				de.setFullName(p.getFullName());
				de.setEmail(p.getEmail());
				de.setLoginName(p.getLoginName());
				de.setDname(p.getDname());
				if(p.getUdate() !=null){
					String pattern = "dd/MM/yyyy";
				    SimpleDateFormat formats = new SimpleDateFormat(pattern);
					Timestamp tt=p.getUdate();
					Date startDate = tt;
					de.setUdate(formats.format(startDate)+"");
				}else{
					de.setUdate("");
				}
				
				datas.add(de);
			}
		}
		return datas;
	}
	
	@RequestMapping(value ="idocsynchronize",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList idocsynchronize(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ParseException{
		ReadList rs = new ReadList();
		try {
			iDocHelperProperties = ResourceBundle.getBundle("com.solusoft.controller.generic");
			contextUserName = iDocHelperProperties.getString("contextUserNames");
			AdminMaster au=(AdminMaster) session.getAttribute("user");
			//get iDoc connection. 
			idocConnection = GetiDocConnection.getConnection();
			contextID = GetiDocConnection.getContextID(contextUserName);
			if(contextID!=null){
				if(contextID !=""){
					if(!contextID.equalsIgnoreCase("Error in Identity Login please refer logs and verify Token, Origin and LoginName.")){
						List<EmployeeMaster> e=employeeService.findAll();
						if(e.size()>0){
							for(EmployeeMaster emp:e){
								String loginname=emp.getAlias();
								String userStatusAndInfo = iDocUserExist(loginname);
								String employeeName = emp.getAlias();
								String employeeEmailId = emp.getEmail();
								String employeeDepatrment = emp.getDepartmentcode().getDeptname();
								long id=emp.getEmpid();
								    if(userStatusAndInfo.equalsIgnoreCase("false")){
								    	int value=createUserIniDoc(employeeEmailId,employeeName);
								    	if(value > 1){
								    		IdocsUser ids=new IdocsUser();
								    		ids.setId(value);
								    		ids.setLoginName(employeeName.toUpperCase());
								    		ids.setFullName(employeeName.toUpperCase());
								    		ids.setEname(id);
								    		ids.setEmail(employeeEmailId);
								    		Timestamp currentTimestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
								    		ids.setUdate(currentTimestamp);
								    		ids.setDname(employeeDepatrment);
								    		IdocsUser cc=idocService.save(ids);
								    		if(cc !=null){
									    		Idoctrail idocs=idoctrailService.findId(id);
									    		if(idocs!=null){
									    			idoctrailService.delete(idocs);
									    		}
									    		rs.setSuccess(true);
							                	rs.setMessage("Record updated successfully");
							                	strs = "hello";
								    		}else{
								    			rs.setSuccess(true);
								    			strs = "hellos";
								    		}
								    		
						                }else{
								    		Idoctrail idocs=idoctrailService.findId(id);
								    		if(idocs !=null){
								    			Timestamp createdDate;
								    			String createdBy;
								    			createdBy=idocs.getCreatedBy();
								    			createdDate=idocs.getCreatedDate();
									    		Idoctrail idoc=new Idoctrail();
									    		idoc.setId(id);
									    		idoc.setOperation("iDoc user creation fail");
									    		idoc.setEname(employeeName.toUpperCase());
									    		idoc.setEalians(employeeName.toUpperCase());
									    		idoc.setEeid(emp.getEmail());
									    		Timestamp currentTimestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
									    		idoc.setCreatedDate(createdDate);
									    		idoc.setCreatedBy(createdBy);
									    		idoc.setModifyDate(currentTimestamp);
									    		idoc.setModifyBy(au.getUsername());
									    		idoctrailService.save(idoc);
								    		}else{
									    		Idoctrail idoc=new Idoctrail();
									    		idoc.setId(id);
									    		idoc.setOperation("iDoc user creation fail");
									    		idoc.setEname(employeeName.toUpperCase());
									    		idoc.setEalians(employeeName.toUpperCase());
									    		idoc.setEeid(emp.getEmail());
									    		Timestamp currentTimestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
									    		idoc.setCreatedDate(currentTimestamp);
									    		idoc.setCreatedBy(au.getUsername());
									    		idoctrailService.save(idoc);
								    		}
								    		rs.setSuccess(true);
						                	rs.setMessage("Please check the iDoc trail report.");
								    	}
									}else{
										Integer values=iDocUserExists(loginname);
										IdocsUser data=idocService.findId(values);
											if(data == null){
												IdocsUser ids=new IdocsUser();
									    		ids.setId(values);
									    		ids.setLoginName(employeeName.toUpperCase());
									    		ids.setFullName(employeeName.toUpperCase());
									    		ids.setEname(id);
									    		ids.setEmail(employeeEmailId);
									    		Timestamp currentTimestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
									    		ids.setUdate(currentTimestamp);
									    		ids.setDname(employeeDepatrment);
									    		IdocsUser cc=idocService.save(ids);
									    		if(cc !=null){
										    		Idoctrail idocs=idoctrailService.findId(id);
										    		if(idocs!=null){
										    			idoctrailService.delete(idocs);
										    		}
										    		rs.setSuccess(true);
								                	rs.setMessage("Record updated successfully");
								                	strs = "hello";
									    		}else{
									    			rs.setSuccess(true);
									    			strs = "hellos";
									    		}
											}else{
												Idoctrail idocs=idoctrailService.findId(id);
												if(idocs!=null){
									    			idoctrailService.delete(idocs);
									    		}
												rs.setSuccess(true);
								                rs.setMessage("Record updated successfully");
								                strs = "hello";
									       }
									}
							}
						}else{
							rs.setSuccess(true);
		                	rs.setMessage("Record is not available in employee master");
		                	return rs;
						}
					}else{
						rs.setSuccess(false);
	                    rs.setMessage("IDOC "+contextID);
	                    return rs;
					}
				}else{
					rs.setSuccess(false);
	                rs.setMessage("IDOC Error in IdentityLogin,NullReferenceException");
	                return rs;
				}
			}else{
				 rs.setSuccess(false);
                 rs.setMessage("IDOC Connection Error");
                 return rs;
			}
		  
		}catch (Exception exception) {
		    rs.setSuccess(false);
        	rs.setMessage("IDOC Connection Error");
        	return rs;
		}
		if(strs !=null){
			if(strs.equalsIgnoreCase("hello")){
				AdminMaster au=(AdminMaster) session.getAttribute("user");
				Auditrail de=new Auditrail();
				de.setOperation("Inserted");
				de.setRecord("All");
				de.setNvalue("Excel to database imported sucessfully");
				de.setOvalue("");
				de.setCreatedBy(au.getUsername());
				de.setCreatedDate(new Timestamp(new Date().getTime()));
				de.setTableName(tabName);
				idocService.saves(de);
			}else if(strs.equalsIgnoreCase("hellos")){
				rs.setMessage("Error inserting record.");
			}
		}else{
			rs.setMessage("Please check the iDoc trail report.");
		}
		return rs;
	}
	
	private Integer iDocUserExists(String name) {
		try {
			GetUsersByUsersRef getUsersByUsersRef = new GetUsersByUsersRef();
			getUsersByUsersRef.setSignInEnvID(contextID);
			getUsersByUsersRef.setUsersRef(name);
			GetUsersByUsersRefResponse getUserResponse = idocConnection.getUsersByUsersRef(getUsersByUsersRef);
			UserDTO userDTO = getUserResponse.getGetUsersByUsersRefResult();
				if(userDTO == null ){
					return 1;
				}else{
					return userDTO.getID();
				}
		}catch(Exception exception){
			exception.printStackTrace();
			return 0;
		}
	}
	
	
	private String iDocUserExist(String name) {
			try {
				GetUsersByUsersRef getUsersByUsersRef = new GetUsersByUsersRef();
				getUsersByUsersRef.setSignInEnvID(contextID);
				getUsersByUsersRef.setUsersRef(name);
				GetUsersByUsersRefResponse getUserResponse = idocConnection.getUsersByUsersRef(getUsersByUsersRef);
				UserDTO userDTO = getUserResponse.getGetUsersByUsersRefResult();
					if(userDTO == null ){
						return "false";
					}else{
						return "true";
					}
			}catch(Exception exception){
				exception.printStackTrace();
				return "Error";
			}
		}
	
	private int createUserIniDoc(String mail,String loginname) {
		
		int resultUserId=0;
		try {
			
			UserDTO userDTO = new UserDTO();
			userDTO.setName(loginname);
			userDTO.setHomeDepartmentID(100);
			userDTO.setDepartmentID(100);
			userDTO.setMailAddress(mail);
			userDTO.setSystemRole("Admin-Author-Contributor");
			userDTO.setUserType("Default");
			userDTO.setCultureName("en-US");
			userDTO.setActive(true);
			userDTO.setLastLogin(Calendar.getInstance());
			
			InsertUser insertUser = new InsertUser();
			insertUser.setDto(userDTO);
			insertUser.setLoginContextId(contextID);

			InsertUserResponse interInsertUserResponse = idocConnection.insertUser(insertUser);
			int userId = interInsertUserResponse.getInsertUserResult();

			UserOriginSourceDTO userOriginSourceDTO = new UserOriginSourceDTO();
			userOriginSourceDTO.setUserID(userId);
			userOriginSourceDTO.setOriginRef(loginname);
			userOriginSourceDTO.setOrigin(iDocHelperProperties.getString("Origin"));
			userOriginSourceDTO.setActive(true);
			userOriginSourceDTO.setUserFirstName(loginname);
	
			InsertUserExt insertUserExt = new InsertUserExt();
			insertUserExt.setLoginContextId(contextID);
			insertUserExt.setPassword("password");
			insertUserExt.setUserOriginSourceDTO(userOriginSourceDTO);
			insertUserExt.setUserid(userId);
			insertUserExt.setNeverSendEmail(false);
			
			InsertUserExtResponse insertUserExtResponse = idocConnection.insertUserExt(insertUserExt);
			resultUserId = insertUserExtResponse.getInsertUserExtResult();
			
			DepartmentMemberDTO departmentMemberDTO = new DepartmentMemberDTO();
			departmentMemberDTO.setDepartmentRole("Admin-Author-Contributor");
			departmentMemberDTO.setUserID(userId);
			departmentMemberDTO.setDepartmentID(100);
			
			SaveDeprartmentMember saveDeprartmentMember = new SaveDeprartmentMember();
			saveDeprartmentMember.setLoginContextId(contextID);
			saveDeprartmentMember.setDepartmentMemberDTO(departmentMemberDTO);
			idocConnection.saveDeprartmentMember(saveDeprartmentMember);
		}catch (RemoteException exception) {
			resultUserId=0;
		}catch(Exception exception){
			resultUserId=0;
		}
	return resultUserId;
	}
}