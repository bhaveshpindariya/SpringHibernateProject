package com.solusoft.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
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
import com.solusoft.jpa.entity.AdminMaster;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.BranchMaster;
import com.solusoft.jpa.entity.CompanyMaster;
import com.solusoft.jpa.entity.DepartmentMaster;
import com.solusoft.jpa.entity.EmployeeMaster;
import com.solusoft.services.BranchService;
import com.solusoft.services.CompanyService;
import com.solusoft.services.CostCenterService;
import com.solusoft.services.DepartmentService;
import com.solusoft.services.EmployeeService;
import com.solusoft.services.IdocService;
import com.solusoft.services.IdoctrailService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	IdocService idocService;
	
	@Autowired
	BranchService branchService;
	
	@Autowired
	IdoctrailService idoctrailService;
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	CostCenterService costCenterService;
	
	private static final String tabName="EMPLOYEE_MASTER";
	private static final Logger logger = LoggerFactory
			.getLogger(EmployeeController.class);

	
	
	@RequestMapping(value = "/empMaster", method = RequestMethod.GET)
	public String empMaster(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All Employee Data...");
		List<EmployeeMaster> masters = employeeService.findAll();
		model.addAttribute("master", masters);
		return "EmployeeMasters";
		
	}
	
	@RequestMapping(value ="webserviceEmployee",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList webserviceEmployee(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ParseException{
		ReadList rs = new ReadList();
		
		try {
				ResourceBundle rss=ResourceBundle.getBundle("com.solusoft.controller.generic");
				String path=rss.getString("Excelpath");	
				FileInputStream file = new FileInputStream(new File(path));
	            POIFSFileSystem fs = new POIFSFileSystem(file);  
	            HSSFWorkbook wb = new HSSFWorkbook(fs);  
	            HSSFSheet sheet = wb.getSheet(rss.getString("Employee"));  
	            HSSFRow row;  
	            int j=2;
	            if(sheet.getLastRowNum()>0){
		            for(int i=1; i<=sheet.getLastRowNum(); i++)
		            	{  
		            		row = sheet.getRow(i);  
		            		Cell ce0 = row.getCell(0);
			                if(ce0 != null && ce0.getCellType() != Cell.CELL_TYPE_BLANK){
			                	EmployeeMaster em=new EmployeeMaster();
		            			em.setEmpid((long)Math.round(row.getCell(0).getNumericCellValue()));
		            			Cell ce1 = row.getCell(1);
				                if(ce1 != null && ce1.getCellType() != Cell.CELL_TYPE_BLANK){
				                	em.setTitle(String.valueOf(row.getCell(1).getRichStringCellValue()).trim());
				                }else{
				                	em.setTitle("");
				                }
				                Cell ce2 = row.getCell(2);
				                if(ce2 != null && ce2.getCellType() != Cell.CELL_TYPE_BLANK){
				                	em.setName(String.valueOf(row.getCell(2).getRichStringCellValue()).trim());
				                }else{
				                	rs.setSuccess(false);
				                	rs.setMessage("Please enter the correct entries in the excel data. NAME is blank :-- "  + j);
				                	return rs;
				                }
				                Cell ce3 = row.getCell(3);
				                if(ce3 != null && ce3.getCellType() != Cell.CELL_TYPE_BLANK){
				                	em.setAlias(String.valueOf(row.getCell(3).getRichStringCellValue()).trim());
				                }else{
				                	rs.setSuccess(false);
				                	rs.setMessage("Please enter the correct entries in the excel data. EMP_ALIAS is blank :-- "  + j);
				                	return rs;
				                }
				                Cell ce4 =row.getCell(4);
				                if(ce4 != null && ce4.getCellType() != Cell.CELL_TYPE_BLANK){
				                	em.setEmail(String.valueOf(row.getCell(4).getRichStringCellValue()).trim());
				                }else{
				                	em.setEmail(""); 
				                }
				                Cell ce5 =row.getCell(5);
				                if(ce5 != null && ce5.getCellType() != Cell.CELL_TYPE_BLANK){
			            	    	CompanyMaster co=companyService.findId((int)Math.round(row.getCell(5).getNumericCellValue()));
			            	    	if(co !=null){
			            	    		 Cell ce6 =row.getCell(6);
							                if(ce6 != null && ce6.getCellType() != Cell.CELL_TYPE_BLANK){
							                	if(co.getCompanyName().equalsIgnoreCase(String.valueOf(row.getCell(6).getRichStringCellValue()).trim())){
							                		em.setCompanycode(co);
							                		em.setCname(co.getCompanyName());
							                	}else{
							                		rs.setSuccess(false);
								                	rs.setMessage("Please enter the correct entries in the excel data. COMPANY is wrong :-- "  + j);
								                	return rs;
							                	}
							                }else{
							                	rs.setSuccess(false);
							                	rs.setMessage("Please enter the correct entries in the excel data. COMPANY is blank :-- "  + j);
							                	return rs;
							                }
			 		                }else{
			 		                	rs.setSuccess(false);
					                	rs.setMessage("Please enter the correct entries in the excel data. COMPANYCODE is not available in Company master :-- "  + j);
					                	return rs;
			 		                }
			            	    }else{
			            	    	rs.setSuccess(false);
				                	rs.setMessage("Please enter the correct entries in the excel data. COMPANYCODE is blank :-- "  + j);
				                	return rs;
				                }
				                
				                
				                Cell ce7 =row.getCell(7);
				                if(ce7 != null && ce7.getCellType() != Cell.CELL_TYPE_BLANK){
				                	DepartmentMaster de=departmentService.findId((long)Math.round(row.getCell(7).getNumericCellValue()));
				                	if(de !=null){
				                		Cell ce8 =row.getCell(8);
						                if(ce8 != null && ce8.getCellType() != Cell.CELL_TYPE_BLANK){
						                	if(de.getDeptname().equalsIgnoreCase(String.valueOf(row.getCell(8).getRichStringCellValue()).trim()) && de.getCompanyMaster().getCompanyCode().equals((int)Math.round(row.getCell(5).getNumericCellValue()))){
						                		em.setDepartmentcode(de);
						                		em.setDname(de.getDeptname());
						                	}else{
						                		rs.setSuccess(false);
							                	rs.setMessage("Please enter the correct entries in the excel data. DEPARTMENT is wrong :-- "  + j);
							                	return rs;
						                	}
						                }else{
						                	rs.setSuccess(false);
						                	rs.setMessage("Please enter the correct entries in the excel data. DEPARTMENT is blank :-- "  + j);
						                	return rs;
						                }
			 		                }else{
			 		                	rs.setSuccess(false);
					                	rs.setMessage("Please enter the correct entries in the excel data. DEPARTMENTCODE is not available in Department master :-- "  + j);
					                	return rs;
			 		                }
				                }else{
				                	rs.setSuccess(false);
				                	rs.setMessage("Please enter the correct entries in the excel data. DEPARTMENTCODE is blank :-- "  + j);
				                	return rs;
				                }
				                
				                Cell ce9 =row.getCell(9);
				                if(ce9 != null && ce9.getCellType() != Cell.CELL_TYPE_BLANK){
				                	 em.setCostCentercode(String.valueOf(row.getCell(9).getRichStringCellValue()).trim());
				                }else{
				                	em.setCostCentercode("");
				                }
				                Cell ce10 =row.getCell(10);
				                if(ce10 != null && ce10.getCellType() != Cell.CELL_TYPE_BLANK){
				                	BranchMaster be=branchService.findId((int)Math.round(row.getCell(10).getNumericCellValue()));
				                	if(be !=null){
				                		Cell ce11 =row.getCell(11);
						                if(ce11 != null && ce11.getCellType() != Cell.CELL_TYPE_BLANK){
						                	if(be.getBranchname().equalsIgnoreCase(String.valueOf(row.getCell(11).getRichStringCellValue()).trim()) && be.getCompanyMaster().getCompanyCode().equals((int)Math.round(row.getCell(5).getNumericCellValue()))){
						                		em.setBranchcode(be);
						                		em.setBname(be.getBranchname());
						                	}else{
						                		rs.setSuccess(false);
							                	rs.setMessage("Please enter the correct entries in the excel data. BRANCH is wrong :-- "  + j);
							                	return rs;
						                	}
						                }else{
						                	rs.setSuccess(false);
						                	rs.setMessage("Please enter the correct entries in the excel data. BRANCH is blank :-- "  + j);
						                	return rs;
						                }
				                		
			 		                }else{
			 		                	rs.setSuccess(false);
					                	rs.setMessage("Please enter the correct entries in the excel data. BRANCHCODE is not available in Branch master :-- "  + j);
					                	return rs;
			 		                }
					            }else{
					            	rs.setSuccess(false);
				                	rs.setMessage("Please enter the correct entries in the excel data. BRANCHCODE is blank :-- "  + j);
				                	return rs;
				                }
				                
				                Cell ce12 =row.getCell(12);
				                if(ce12 != null && ce12.getCellType() != Cell.CELL_TYPE_BLANK){
				                	em.setHq(String.valueOf(row.getCell(12).getRichStringCellValue()).trim()); 
				                }else{
				                	em.setHq(""); 
				                }
				                Cell ce13 =row.getCell(13);
				                if(ce13 != null && ce13.getCellType() != Cell.CELL_TYPE_BLANK){
				                	em.setAttendancelocation(String.valueOf(row.getCell(13).getRichStringCellValue()).trim()); 
				                }else{
				                	em.setAttendancelocation(""); 
				                }
				                Cell ce14 =row.getCell(14);
				                if(ce14 != null && ce14.getCellType() != Cell.CELL_TYPE_BLANK){
				                	em.setPhysicalocation(String.valueOf(row.getCell(14).getRichStringCellValue()).trim()); 
				                }else{
				                	em.setPhysicalocation(""); 
				                }
				                Cell ce15 =row.getCell(15);
				                if(ce15 != null && ce15.getCellType() != Cell.CELL_TYPE_BLANK){
				                	em.setDesignationcode((long)Math.round(row.getCell(15).getNumericCellValue()));
				                }else{
				                	long l=0;
				                	em.setDesignationcode(l);
				                }
				                Cell ce16 =row.getCell(16);
				                if(ce16 != null && ce16.getCellType() != Cell.CELL_TYPE_BLANK){
				                	em.setDesignation(String.valueOf(row.getCell(16).getRichStringCellValue()).trim()); 
				                }else{
				                	em.setDesignation(""); 
				                }
				                Cell ce17 =row.getCell(17);
				                if(ce17 != null && ce17.getCellType() != Cell.CELL_TYPE_BLANK){
				                	em.setEmployetype(String.valueOf(row.getCell(17).getRichStringCellValue()).trim());
				                }else{
				                	em.setEmployetype("");
				                }
				                Cell ce18 =row.getCell(18);
				                if(ce18 != null && ce18.getCellType() != Cell.CELL_TYPE_BLANK){
				                	em.setGender(String.valueOf(row.getCell(18).getRichStringCellValue()).trim()); 
				                }else{
				                	em.setGender("");
				                }
				                Cell ce19 =row.getCell(19);
				                if(ce19 != null && ce19.getCellType() != Cell.CELL_TYPE_BLANK){
				                	if(ce19.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				                		em.setMobileno((int)Math.round(row.getCell(19).getNumericCellValue())+"");
				                	}else{
				                		em.setMobileno(String.valueOf(row.getCell(19).getRichStringCellValue()).trim());
				                	}
				               }else{
				                	em.setMobileno("");
				                }
				                Cell ce20 =row.getCell(20);
				                if(ce20 != null && ce20.getCellType() != Cell.CELL_TYPE_BLANK){
				                	if(ce20.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				                		em.setExtensionno((int)Math.round(row.getCell(20).getNumericCellValue())+"");
				                	}else{
				                		em.setExtensionno(String.valueOf(row.getCell(20).getRichStringCellValue()).trim());
				                	}
				                }else{
				                	em.setExtensionno("");
				                }
				                Cell ce21 =row.getCell(21);
				                if(ce21 != null && ce21.getCellType() != Cell.CELL_TYPE_BLANK){
				                	if(ce21.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				                		em.setPresentaddress((long)Math.round(row.getCell(21).getNumericCellValue())+"");
				                	}else{
				                		em.setPresentaddress(String.valueOf(row.getCell(21).getRichStringCellValue()).trim());
				                	}
				                }else{
				                	em.setPresentaddress("");
				                }
				                Cell ce22 =row.getCell(22);
				                if(ce22 != null && ce22.getCellType() != Cell.CELL_TYPE_BLANK){
				                	if(ce22.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				                		em.setPermanentaddress((long)Math.round(row.getCell(22).getNumericCellValue())+"");
				                	}else{
				                		em.setPermanentaddress(String.valueOf(row.getCell(22).getRichStringCellValue()).trim());
				                	}
				                }else{
				                	em.setPermanentaddress(""); 
				                }
				                Cell ce23 =row.getCell(23);
				                if(ce23 != null && ce23.getCellType() != Cell.CELL_TYPE_BLANK){
				                	Date parsedDate = (Date)(row.getCell(23).getDateCellValue());
				                	Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
				                	em.setDataeofbirth(timestamp);
				                }else{
				                	Timestamp timestamp = null;
				                	em.setDataeofbirth(timestamp);
				                }
				                Cell ce24 =row.getCell(24);
				                if(ce24 != null && ce24.getCellType() != Cell.CELL_TYPE_BLANK){
				                	Date parsedDat = (Date)(row.getCell(24).getDateCellValue());
					                Timestamp timestam = new java.sql.Timestamp(parsedDat.getTime());
					                em.setDataeofjoining(timestam);
				            	}else{
				            		Timestamp timestamp = null;
				                	em.setDataeofjoining(timestamp);
				            	}
				                Cell ce25 =row.getCell(25);
				                if(ce25 != null && ce25.getCellType() != Cell.CELL_TYPE_BLANK){
				                	em.setEmployestatus(String.valueOf(row.getCell(25).getRichStringCellValue()).trim()); 
				                }else{
				                	em.setEmployestatus(""); 
				                }
				                Cell ce26 =row.getCell(26);
				                if(ce26 != null && ce26.getCellType() != Cell.CELL_TYPE_BLANK){
				                	 Date parsedDat2 =  (Date)(row.getCell(26).getDateCellValue());
						             Timestamp timestam2= new java.sql.Timestamp(parsedDat2.getTime());
						             em.setDataeofconfirm(timestam2);
					            }else{
					               	Timestamp timestamp = null;
					               	em.setDataeofconfirm(timestamp);
					            }
				                Cell ce27 =row.getCell(27);
				                if(ce27 != null && ce27.getCellType() != Cell.CELL_TYPE_BLANK){
				                	Date parsedDat3 = (Date)(row.getCell(27).getDateCellValue());
					                Timestamp timestam3= new java.sql.Timestamp(parsedDat3.getTime());
					                em.setClosuredate(timestam3);
				                }else{
				                	Timestamp timestamp = null;
				                	em.setClosuredate(timestamp);
				                }
				                Cell ce28 =row.getCell(28);
				                if(ce28 != null && ce28.getCellType() != Cell.CELL_TYPE_BLANK){
				                	Date parsedDat4 = (Date)(row.getCell(28).getDateCellValue());
					                Timestamp timestam4= new java.sql.Timestamp(parsedDat4.getTime());
					                em.setResignationintimationdate(timestam4);
				                }else{
				                	Timestamp timestamp = null;
				                	em.setResignationintimationdate(timestamp);
				                }
				                Cell ce29 =row.getCell(29);
				                if(ce29 != null && ce29.getCellType() != Cell.CELL_TYPE_BLANK){
				                	 em.setBloodgroup(String.valueOf(row.getCell(29).getRichStringCellValue()).trim());  
				                }else{
				                	 em.setBloodgroup(""); 
				                }
				                Cell ce30 =row.getCell(30);
				                if(ce30 != null && ce30.getCellType() != Cell.CELL_TYPE_BLANK){
				                	if(ce30.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				                		em.setLevel((int)Math.round(row.getCell(30).getNumericCellValue())+"");
				                	}else{
				                		em.setLevel(String.valueOf(row.getCell(30).getRichStringCellValue()).trim());
				                	}
				                }else{
				                	rs.setSuccess(false);
				                	rs.setMessage("Please enter the correct entries in the excel data. LEVEL is blank :-- "  + j);
				                	return rs;
				                }
				                Cell ce31 =row.getCell(31);
				                if(ce31 != null && ce31.getCellType() != Cell.CELL_TYPE_BLANK){
				                	em.setPersgtxt(String.valueOf(row.getCell(31).getRichStringCellValue()).trim()); 
				                }else{
				                	em.setPersgtxt(""); 
				                }
				                Cell ce32 =row.getCell(32);
				                if(ce32 != null && ce32.getCellType() != Cell.CELL_TYPE_BLANK){
				                	em.setHolidaycalenderid(String.valueOf(row.getCell(32).getRichStringCellValue()).trim()); 
				                }else{
				                	em.setHolidaycalenderid("");
				                }
				                EmployeeMaster save=employeeService.save(em);
				                if(save.getEmpid()>0){
				                	rs.setSuccess(true);
				                	rs.setMessage("Record updated successfully");
				                }else{
				                	rs.setSuccess(false);
				                	rs.setMessage("Error updated record" + j);
				                	return rs;
				                }
			                }else{
			            		  rs.setSuccess(false);
				                  rs.setMessage("Please enter the correct entries in the excel data. EMPLID is blank :-- " + j);
				                  return rs;
			            	}
			                j++;
		            }
				}else{
		        	rs.setSuccess(false);
		        	rs.setMessage("Data is not available in Excelsheet.");
		        	return rs;
		        }
			} catch (FileNotFoundException ec) {
				ec.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		if(rs.getSuccess()==true){
		    AdminMaster au=(AdminMaster) session.getAttribute("user");
			Auditrail de=new Auditrail();
			de.setOperation("Inserted");
			de.setRecord("All");
			de.setNvalue("Excel to database imported sucessfully");
			de.setOvalue("");
			de.setCreatedBy(au.getUsername());
			de.setCreatedDate(new Timestamp(new Date().getTime()));
			de.setTableName(tabName);
			employeeService.saves(de);
	    }
		return rs;
	}
	
	@RequestMapping(value ="rs/getEmployeeForCompany",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<EmployeeMaster> getDoc(@RequestParam (value="Company_name",required=true) Integer ccode,
								Model model){
		return employeeService.findAlls(ccode);
	}
	
	@RequestMapping(value ="rs/getEmployeess",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<EmployeeMaster> getDoc(Model model){
		return employeeService.findAll();
	}
	
}