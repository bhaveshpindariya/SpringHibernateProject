package com.solusoft.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
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

import com.solusoft.jpa.BranchData;
import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.AdminMaster;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.BranchMaster;
import com.solusoft.jpa.entity.CompanyMaster;
import com.solusoft.services.BranchService;
import com.solusoft.services.CompanyService;


@Controller
public class BranchController {

	@Autowired
	BranchService branchService;
	
	@Autowired
	CompanyService companyService;
	
	private static final String tabName="BRANCH_MASTER";
	
	private static final Logger logger = LoggerFactory
			.getLogger(BranchController.class);
	
	@RequestMapping(value = "/branchs", method = RequestMethod.GET)
	public String branchs(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All Branch Data...");
		List<BranchMaster> masters = branchService.findAll();
		List<BranchData> datas=new ArrayList<BranchData>();
		if(masters.size()>0){
			int i=1;
			for(BranchMaster p:masters){
				BranchData de=new BranchData();
				de.setNo(i);
				de.setEbCode(p.getBranchcode());
				de.setEbName(p.getBranchname());
				de.setCompanyName(p.getCompanyMaster().getCompanyName());
				datas.add(de);
				i++;
			}
		}
		model.addAttribute("master", datas);
		return "BranchDetail";
		
	}
	
	@RequestMapping(value ="webserviceBranch",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList webserviceBranch(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ReadList rs = new ReadList();
		try {

				ResourceBundle rss=ResourceBundle.getBundle("com.solusoft.controller.generic");
				String path=rss.getString("Excelpath");	
				FileInputStream file = new FileInputStream(new File(path));
	            POIFSFileSystem fs = new POIFSFileSystem(file);  
	            HSSFWorkbook wb = new HSSFWorkbook(fs);  
	            HSSFSheet sheet = wb.getSheet(rss.getString("Branch"));  
	            HSSFRow row;  
	            int j=2;
	            if(sheet.getLastRowNum()>0){
		            for(int i=1; i<=sheet.getLastRowNum(); i++)
		            	{  
		            		row = sheet.getRow(i);  
		            		BranchMaster de=new BranchMaster();
		            		Cell ce0 = row.getCell(0);
				            if(ce0 != null && ce0.getCellType() != Cell.CELL_TYPE_BLANK){
				                de.setBranchcode((int)Math.round(row.getCell(0).getNumericCellValue()));
				                Cell ce1 = row.getCell(1);
			            	    if(ce1 != null && ce1.getCellType() != Cell.CELL_TYPE_BLANK){
			            	    	 de.setBranchname(String.valueOf(row.getCell(1).getRichStringCellValue()).trim());
				                	 rs.setSuccess(true);
				                }else{
				                	rs.setSuccess(false);	
				                }
			            	    Cell ce2 = row.getCell(2);
			            	    if(ce2 != null && ce2.getCellType() != Cell.CELL_TYPE_BLANK){
			            	    	 CompanyMaster co=companyService.findId((int)Math.round(row.getCell(2).getNumericCellValue()));
			            	    	 if(co !=null){
			 		                	de.setCompanyMaster(co);
			 		                	if(rs.getSuccess()){
			 		                		BranchMaster save=branchService.save(de);
			 		                		if(save.getBranchcode()>0){
				 			                	rs.setSuccess(true);
				 			                }else{
				 			                	rs.setSuccess(false);
				 			                	rs.setMessage("Error updated record" + j);
				 			                	return rs;
				 			                }
			 		                	}else{
			 		                		rs.setSuccess(false);
						                	rs.setMessage("Please enter the correct entries in the excel data. BranchName is blank :-- "  + j);
						                	return rs;
			 		                	}
			 		                }else{
			 		                	rs.setSuccess(false);
					                	rs.setMessage("Please enter the correct entries in the excel data. CompanyCode is not available in Company master :-- "  + j);
					                	return rs;
			 		                }
			            	    }else{
			            	    	rs.setSuccess(false);
				                	rs.setMessage("Please enter the correct entries in the excel data. CompanyCode is blank :-- "  + j);
				                	return rs;
				                }
				            }else{
				            	rs.setSuccess(false);
			                	rs.setMessage("Please enter the correct entries in the excel data. BranchCode is blank :-- " + j);
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
			branchService.saves(de);
	    }
	 return rs;
	}
	
	@RequestMapping(value ="rs/getBranch",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<BranchData> getBranch(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		List<BranchMaster> masters = branchService.findAll();
		List<BranchData> datas=new ArrayList<BranchData>();
		if(masters.size()>0){
			int i=1;
			for(BranchMaster p:masters){
				BranchData de=new BranchData();
				de.setNo(i);
				de.setEbCode(p.getBranchcode());
				de.setEbName(p.getBranchname());
				de.setCompanyName(p.getCompanyMaster().getCompanyName());
				datas.add(de);
				i++;
			}
		}
		return datas;
	}
	
}