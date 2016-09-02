package com.solusoft.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.solusoft.jpa.ProjectData;
import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.AdminMaster;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.CompanyMaster;
import com.solusoft.jpa.entity.ProjectMaster;
import com.solusoft.services.CompanyService;
import com.solusoft.services.ProjectService;

@Controller
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@Autowired
	CompanyService companyService;
	
	private static final String tabName="PROJECT_MASTER";
	
	private static final Logger logger = LoggerFactory
			.getLogger(ProjectController.class);
	
	@RequestMapping(value = "/projectMaster", method = RequestMethod.GET)
	public String projectMaster(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All Project Data...");
		List<ProjectMaster> masters = projectService.findAll();
		List<ProjectData> datas=new ArrayList<ProjectData>();
		if(masters.size()>0){
			for(ProjectMaster p:masters){
				ProjectData de=new ProjectData();
				de.setNo(p.getDataid());
				de.setBusar(p.getBusinessarea());
				de.setComname(p.getCompanyMaster().getCompanyName());
				de.setProjectid(p.getProjectid());
				de.setProjectname(p.getProjectnamename());
				String pattern = "dd/MM/yyyy";
			    SimpleDateFormat formats = new SimpleDateFormat(pattern);
				Timestamp tt=p.getProjectcreateiondate();
				Date startDate = tt;
				de.setPrcre(formats.format(startDate)+"");
				de.setMainproids(p.getMainproid());
				de.setStatusofpros(p.getStatusofpro());
				datas.add(de);
				
			}
		}
		model.addAttribute("master", datas);
		return "ProjectMasters";
		
	}
	
	@RequestMapping(value ="webserviceProject",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList webserviceProject(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ReadList rs = new ReadList();
		try {

				ResourceBundle rss=ResourceBundle.getBundle("com.solusoft.controller.generic");
				String path=rss.getString("Excelpath");	
				FileInputStream file = new FileInputStream(new File(path));
	            POIFSFileSystem fs = new POIFSFileSystem(file);  
	            HSSFWorkbook wb = new HSSFWorkbook(fs);  
	            HSSFSheet sheet = wb.getSheet(rss.getString("Project"));  
	            HSSFRow row; 
	            int j=2;
	            if(sheet.getLastRowNum()>0){
		            for(int i=1; i<=sheet.getLastRowNum(); i++)
		            	{  
		            		 row = sheet.getRow(i);  
		            		 ProjectMaster pro=new ProjectMaster();
		            		 Cell ce0 = row.getCell(0);
		            	  if (ce0 != null && ce0.getCellType() != Cell.CELL_TYPE_BLANK){
		            		 pro.setDataid((long)Math.round(row.getCell(0).getNumericCellValue()));
		            		 Cell ce = row.getCell(1);
		                	 if (ce != null && ce.getCellType() != Cell.CELL_TYPE_BLANK){
		                		 pro.setGroupid(String.valueOf(row.getCell(1).getRichStringCellValue()).trim());
		                	 }else{
		                		 pro.setGroupid("");
		                	 }
		                	 Cell ce1 = row.getCell(2);
		                	 if (ce1 != null && ce1.getCellType() != Cell.CELL_TYPE_BLANK){
		                		 pro.setProjectid(String.valueOf(row.getCell(2).getRichStringCellValue()).trim());
		                	 }else{
		                		 rs.setSuccess(false);
		                		 rs.setMessage("Please correct entries in the excel data. PROJECT_ID is blank :-- "  + j);
				                 return rs; 
		                	 }
		                	 Cell ce2 = row.getCell(3);
		                	 if (ce2 != null && ce2.getCellType() != Cell.CELL_TYPE_BLANK){
		                		 pro.setProjectnamename(String.valueOf(row.getCell(3).getRichStringCellValue()).trim());
		                	 }else{
		                		 rs.setSuccess(false);
		                		 rs.setMessage("Please correct entries in the excel data. PROJECT_NAME is blank :-- "  + j);
				                 return rs; 
		                	 }
		                	 Cell ce3 = row.getCell(4);
		                	 if (ce3 != null && ce3.getCellType() != Cell.CELL_TYPE_BLANK){
		                		 CompanyMaster co=companyService.findId((int)Math.round(row.getCell(4).getNumericCellValue()));
		                		 if(co !=null){
		                			 pro.setCompanyMaster(co);
		                		 }else{
		                			 rs.setSuccess(false);
		                			 rs.setMessage("Please enter the correct entries in the excel data. COMPANY_CODE is not available in Company master :-- "  + j);
					                 return rs;
		                		 }
			                }else{
			                	rs.setSuccess(false);
			                	rs.setMessage("Please correct entries in the excel data. COMPANY_CODE is blank :-- " + j);
			                	return rs;
			                }
		                	 Cell ce4 = row.getCell(5);
		                	 if (ce4 != null && ce4.getCellType() != Cell.CELL_TYPE_BLANK){
		                		 Date parsedDate = (Date)(row.getCell(5).getDateCellValue());
				                 Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
				                 pro.setProjectcreateiondate(timestamp);
		                	 }else{
		                		 rs.setSuccess(false);
		                		 rs.setMessage("Please correct entries in the excel data. PROJECT_CREATED_DATE is blank :-- "  + j);
				                 return rs; 
		                	 }
		                	 Cell ce5 = row.getCell(6);
		                	 if (ce5 != null && ce5.getCellType() != Cell.CELL_TYPE_BLANK){
		                		 Date parsedDate = (Date)(row.getCell(6).getDateCellValue());
				                 Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
				                 pro.setStartdate(timestamp);
		                	 }else{
		                		 Timestamp timestamp = null;
		                		 pro.setStartdate(timestamp);
		                	 }
		                	 Cell ce6 = row.getCell(7);
		                	 if (ce6 != null && ce6.getCellType() != Cell.CELL_TYPE_BLANK){
		                		 Date parsedDate = (Date)(row.getCell(7).getDateCellValue());
				                 Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
				                 pro.setEnddate(timestamp);
		                	 }else{
		                		 Timestamp timestamp = null;
		                		 pro.setEnddate(timestamp);
		                	 }
		                	 
		                	 Cell ce7 = row.getCell(8);
		                	 if (ce7 != null && ce7.getCellType() != Cell.CELL_TYPE_BLANK){
		                		 pro.setPmempid(Math.round((row.getCell(8).getNumericCellValue()))+"");
		                	 }else{
		                		 pro.setPmempid("");
		                	 }
		                	 Cell ce8 = row.getCell(9);
		                	 if (ce8 != null && ce8.getCellType() != Cell.CELL_TYPE_BLANK){
		                		 pro.setTypeproject(String.valueOf(row.getCell(9).getRichStringCellValue()).trim());
		                	 }else{
		                		 pro.setTypeproject("");
		                	 }
		                	 Cell ce9 = row.getCell(10);
		                	 if (ce9 != null && ce9.getCellType() != Cell.CELL_TYPE_BLANK){
		                		 pro.setBusinessarea(Math.round((row.getCell(10).getNumericCellValue()))+"");
		                	 }else{
		                		 pro.setBusinessarea("");
		                	 }
		                	 Cell ce10 = row.getCell(11);
		                	 if (ce10 != null && ce10.getCellType() != Cell.CELL_TYPE_BLANK){
		                		  pro.setProcenter(Math.round((row.getCell(11).getNumericCellValue()))+"");
		                		 
		                	 }else{
		                		 pro.setProcenter("");
		                	 }
		                	 Cell ce11 = row.getCell(12);
		                	 if (ce11 != null && ce11.getCellType() != Cell.CELL_TYPE_BLANK){
		                		  pro.setMainproid((long)Math.round(row.getCell(12).getNumericCellValue()));
		                	 }else{
		                		 rs.setSuccess(false);
		                		 rs.setMessage("Please correct entries in the excel data. MAIN_PROJECT_ID is blank :-- "  + j);
				                 return rs;
		                	 }
		                	 Cell ce12 = row.getCell(13);
		                	 if (ce12 != null && ce12.getCellType() != Cell.CELL_TYPE_BLANK){
		                		 pro.setStatusofpro(String.valueOf(row.getCell(13).getRichStringCellValue()).trim());
		                	 }else{
		                		 rs.setSuccess(false);
		                		 rs.setMessage("Please correct entries in the excel data. STATUS_OF_THE_PROJECT is blank :-- "  + j);
				                 return rs;
		                	 }
		                	 Cell ce13 = row.getCell(14);
		                	 if (ce13 != null && ce13.getCellType() != Cell.CELL_TYPE_BLANK){
		                		 pro.setProlev(String.valueOf(row.getCell(14).getRichStringCellValue()).trim());
		                	 }else{
		                		 pro.setProlev("");
		                	 }
		                	 Cell ce14 = row.getCell(15);
		                	 if (ce14 != null && ce14.getCellType() != Cell.CELL_TYPE_BLANK){
		                		 Date parsedDate = (Date)(row.getCell(15).getDateCellValue());
				                 Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
				                 pro.setReferencedate(timestamp);
		                	 }else{
		                		 rs.setSuccess(false);
		                		 rs.setMessage("Please correct entries in the excel data. ReferenceDate is blank :-- "  + j);
				                return rs; 
		                	 }
		                	 Cell ce15 = row.getCell(16);
		                	 if (ce15 != null && ce15.getCellType() != Cell.CELL_TYPE_BLANK){
		                		 Date parsedDate = (Date)(row.getCell(16).getDateCellValue());
				                 Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
				                 pro.setUpdatedate(timestamp);
		                	 }else{
		                		 rs.setSuccess(false);
		                		 rs.setMessage("Please correct entries in the excel data. UpdateDate is blank :-- "  + j);
				                 return rs; 
		                	 }
		                		                	 
		                	 ProjectMaster save=projectService.save(pro);
			                 if(save.getDataid()>0){
				                	rs.setSuccess(true);
				                }else{
				                	rs.setSuccess(false);
				                	rs.setMessage("Error updated record" + j);
				                	return rs;
				                }
		            	  }else{
		            		  rs.setSuccess(false);
			                  rs.setMessage("Please correct entries in the excel data. DataID is blank :--  :-- " + j);
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
			projectService.saves(de);
	    }
	 return rs;
	}
	
	@RequestMapping(value ="rs/getProjectRef",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<ProjectData> getReportingRef(Model model){
		List<ProjectMaster> masters = projectService.findAll();
		List<ProjectData> datas=new ArrayList<ProjectData>();
		if(masters.size()>0){
			for(ProjectMaster p:masters){
				ProjectData de=new ProjectData();
				de.setNo(p.getDataid());
				de.setBusar(p.getBusinessarea());
				de.setComname(p.getCompanyMaster().getCompanyName());
				de.setProjectid(p.getProjectid());
				de.setProjectname(p.getProjectnamename());
				String pattern = "dd/MM/yyyy";
			    SimpleDateFormat formats = new SimpleDateFormat(pattern);
				Timestamp tt=p.getProjectcreateiondate();
				Date startDate = tt;
				de.setPrcre(formats.format(startDate)+"");
				de.setMainproids(p.getMainproid());
				de.setStatusofpros(p.getStatusofpro());
				datas.add(de);
				
			}
		}
		return datas;
	}
	
}