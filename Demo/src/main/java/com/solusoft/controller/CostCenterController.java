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

import com.solusoft.jpa.CcostData;
import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.AdminMaster;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.CompanyMaster;
import com.solusoft.jpa.entity.CostCenterMaster;
import com.solusoft.services.CompanyService;
import com.solusoft.services.CostCenterService;



@Controller
public class CostCenterController {

	@Autowired
	CostCenterService costCenterService;
	
	@Autowired
	CompanyService companyService;
	
	private static final String tabName="COSTCENTER_MASTER";
	
	private static final Logger logger = LoggerFactory
			.getLogger(CostCenterController.class);
	
	@RequestMapping(value = "/costCenterDetail", method = RequestMethod.GET)
	public String costCenterDetail(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All CostCenter Data...");
		List<CostCenterMaster> masters = costCenterService.findAll();
		List<CcostData> datas=new ArrayList<CcostData>();
		if(masters.size()>0){
			int i=1;
			for(CostCenterMaster p:masters){
				CcostData de=new CcostData();
				de.setNo(i);
				de.setcCode(p.getCostCenterCode());
				de.setcName(p.getCostCenterName());
				if(p.getCompanyMaster() !=null ){
					de.setCompanyName(p.getCompanyMaster().getCompanyName());
				}else{
					de.setCompanyName("");	
				}
				datas.add(de);
				i++;
			}
		}
		model.addAttribute("master", datas);
		return "CostCenterData";
	}
	
	@RequestMapping(value ="webserviceCostcenter",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList webserviceCostcenter(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ReadList rs = new ReadList();
		try {

				ResourceBundle rss=ResourceBundle.getBundle("com.solusoft.controller.generic");
				String path=rss.getString("Excelpath");	
				FileInputStream file = new FileInputStream(new File(path));
	            POIFSFileSystem fs = new POIFSFileSystem(file);  
	            HSSFWorkbook wb = new HSSFWorkbook(fs);  
	            HSSFSheet sheet = wb.getSheet(rss.getString("Costcenter"));  
	            HSSFRow row; 
	            int j=2;
	            if(sheet.getLastRowNum()>0){
		            for(int i=1; i<=sheet.getLastRowNum(); i++)
		            	{  
		            	  row = sheet.getRow(i);  
		            	  CostCenterMaster de=new CostCenterMaster();
		            	  Cell ce0 = row.getCell(0);
			              if (ce0 != null && ce0.getCellType() != Cell.CELL_TYPE_BLANK){
			                de.setCostCenterCode(String.valueOf(row.getCell(0).getRichStringCellValue()).trim());
			                Cell ce1 = row.getCell(1);
				              if (ce1 != null && ce1.getCellType() != Cell.CELL_TYPE_BLANK){
				            	  de.setCostCenterName(String.valueOf(row.getCell(1).getRichStringCellValue()).trim());
				            	  rs.setSuccess(true);
				              }else{
				            	    rs.setSuccess(false);
				              }
				              Cell ce2 = row.getCell(2);
				              if (ce2 != null && ce2.getCellType() != Cell.CELL_TYPE_BLANK){
				            	CompanyMaster co=companyService.findId((int)Math.round(row.getCell(2).getNumericCellValue()));
				                if(co !=null){
				                	de.setCompanyMaster(co);
				                	if(rs.getSuccess()){
				                		CostCenterMaster save=costCenterService.save(de);
					                	if(save.getCostCenterCode().length()>0){
						                	rs.setSuccess(true);
						                }else{
						                	rs.setSuccess(false);
						                	rs.setMessage("Error updated record " + j);
						                	return rs;
						                }
				                	}else{
		 		                		rs.setSuccess(false);
					                	rs.setMessage("Please enter the correct entries in the excel data. CostCenterName is blank :-- "  + j);
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
			                	rs.setMessage("Please enter the correct entries in the excel data. CostCenterCode is blank :-- " + j);
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
			costCenterService.saves(de);
	    }
		return rs;
	}
	
	@RequestMapping(value ="rs/getCostCenterRef",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<CcostData> getCostCenterRef(Model model){
		List<CostCenterMaster> masters = costCenterService.findAll();
		List<CcostData> datas=new ArrayList<CcostData>();
		if(masters.size()>0){
			int i=1;
			for(CostCenterMaster p:masters){
				CcostData de=new CcostData();
				de.setNo(i);
				de.setcCode(p.getCostCenterCode());
				de.setcName(p.getCostCenterName());
				de.setCompanyName(p.getCompanyMaster().getCompanyName());
				datas.add(de);
				i++;
			}
		}
		return datas;
	}
	
}