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

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.Reporting;
import com.solusoft.jpa.entity.AdminMaster;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.CompanyMaster;
import com.solusoft.jpa.entity.EmployeeMaster;
import com.solusoft.jpa.entity.ReportingMaster;
import com.solusoft.services.CompanyService;
import com.solusoft.services.EmployeeService;
import com.solusoft.services.ReportingService;



@Controller
public class ReportingController {

	@Autowired
	ReportingService reportingService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	CompanyService companyService;
	
	private static final String tabName="REPORTING_MASTER";
	
	private static final Logger logger = LoggerFactory
			.getLogger(ReportingController.class);
	
	@RequestMapping(value = "/reportingDetail", method = RequestMethod.GET)
	public String reportingDetail(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All Reporting Data...");
		List<ReportingMaster> masters = reportingService.findAll();
		List<Reporting> datas=new ArrayList<Reporting>();
		if(masters.size()>0){
			for(ReportingMaster p:masters){
				Reporting de=new Reporting();
				de.setNo(p.getId());
				de.setCname(p.getCompanyMaster().getCompanyName());
				de.setEcode(p.getEmployeeMaster().getEmpid());
				de.setEname(p.getEmployeeMaster().getName());
				if(p.getHocode()>0){
					de.setHocode(p.getHocode()+"");
					de.setHoname(p.getHoname());
				}else{
					de.setHocode("");
					de.setHoname("");
				}
				
				if(p.getManagercode()>0){
					de.setMcode(p.getManagercode()+"");
					de.setMname(p.getMname());
				}else{
					de.setMcode("");
					de.setMname("");
				}
				datas.add(de);
			}
		}
		model.addAttribute("master", datas);
		return "ReportingMaster";
		
	}
	
	@RequestMapping(value ="webserviceReporting",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList webserviceReporting(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ReadList rs = new ReadList();
		try {

				ResourceBundle rss=ResourceBundle.getBundle("com.solusoft.controller.generic");
				String path=rss.getString("Excelpath");	
				FileInputStream file = new FileInputStream(new File(path));
	            POIFSFileSystem fs = new POIFSFileSystem(file);  
	            HSSFWorkbook wb = new HSSFWorkbook(fs);  
	            HSSFSheet sheet = wb.getSheet(rss.getString("Reporting"));  
	            HSSFRow row;
	            int j=2;
	            if(sheet.getLastRowNum()>0){
		            for(int i=1; i<=sheet.getLastRowNum(); i++)
		            	{  
		            	 row = sheet.getRow(i);  
		            	 Cell ce0 = row.getCell(0);
		            	 Cell ce10 = row.getCell(1);
		            	 if(ce0 != null && ce0.getCellType() != Cell.CELL_TYPE_BLANK && ce10 != null && ce10.getCellType() != Cell.CELL_TYPE_BLANK){
		            		List<ReportingMaster> re=reportingService.findId((long)Math.round(row.getCell(1).getNumericCellValue()));
			                if(re.size() == 1){
			                	ReportingMaster res=new ReportingMaster();
			                	for(ReportingMaster ss:re){
			                		res.setId(ss.getId());
			                	}
			                	CompanyMaster co=companyService.findId((int)Math.round(row.getCell(0).getNumericCellValue()));
			                	if(co !=null){
				                	EmployeeMaster em=employeeService.findId((long)Math.round(row.getCell(1).getNumericCellValue()));
				                	if(em !=null){
				                		 Cell cee = row.getCell(2);
						                 if (cee != null && cee.getCellType() != Cell.CELL_TYPE_BLANK){
						                	if(em.getName().equalsIgnoreCase(String.valueOf(row.getCell(2).getRichStringCellValue()).trim()) && em.getCompanycode().getCompanyCode().equals((int)Math.round(row.getCell(0).getNumericCellValue()))){
							                		res.setCompanyMaster(co);
							                		res.setEmployeeMaster(em);
							                		res.setEname(String.valueOf(row.getCell(2).getRichStringCellValue()).trim());
							                		Cell ce = row.getCell(3);
							                		Cell ce1 = row.getCell(4);
							                		if (ce != null && ce.getCellType() != Cell.CELL_TYPE_BLANK && ce1 != null && ce1.getCellType() != Cell.CELL_TYPE_BLANK ){
							                			EmployeeMaster ems=employeeService.findId((long)Math.round(row.getCell(3).getNumericCellValue()));
							                			if(ems.getName().equalsIgnoreCase(String.valueOf(row.getCell(4).getRichStringCellValue()).trim())){
							                				res.setManagercode(ems.getEmpid());
								                			res.setMname(ems.getName());
							                			}else{
							                				rs.setSuccess(false);
												            rs.setMessage("Please enter the correct entries in the excel data. ManagerCode And ManagerName is different in Employee master :-- " + j);
												            return rs; 
							                			}
							                		}else{
							                			long l = 0;
								                		res.setManagercode(l);
								                		res.setMname(""); 
							                		}
							                		Cell ce2 = row.getCell(5);
							                		Cell ce3 = row.getCell(6);
							                		if (ce2 != null && ce2.getCellType() != Cell.CELL_TYPE_BLANK && ce3 != null && ce3.getCellType() != Cell.CELL_TYPE_BLANK ){
							                			EmployeeMaster ems=employeeService.findId((long)Math.round(row.getCell(5).getNumericCellValue()));
							                			if(ems.getName().equalsIgnoreCase(String.valueOf(row.getCell(6).getRichStringCellValue()).trim())){
							                				res.setHocode(ems.getEmpid());
								                			res.setHoname(ems.getName());
							                			}else{
							                				rs.setSuccess(false);
												            rs.setMessage("Please enter the correct entries in the excel data. ManagerCode And ManagerName is different in Employee master :-- " + j);
												            return rs; 
							                			}
							                		}else{
							                			 long l = 0;
							                			 res.setHocode(l);
								                		 res.setHoname(""); 
							                		}
						                	}else{
						                		rs.setSuccess(false);
								                rs.setMessage("Please enter the correct entries in the excel data. EmployeeCode And CompanyCode is different in Employee master :-- " + j);
								                return rs;
						                	}
					                	 }else{
					                		 rs.setSuccess(false);
							                 rs.setMessage("Please enter the correct entries in the excel data. EmployeeName is blank :-- " + j);
							                 return rs;
					                	 }
					                	 ReportingMaster save=reportingService.save(res);
						                 if(save.getId()>0){
							               	rs.setSuccess(true);
							             }else{
							               	rs.setSuccess(false);
							               	rs.setMessage("Error updated record " + j);
							               	return rs;
							             }
				                	}else{
				                		rs.setSuccess(false);
					                	rs.setMessage("Please enter the correct entries in the excel data. EmployeeCode is not available in Employee master :-- " + j);
					                	return rs;
					            	}
				                }else{
				                	rs.setSuccess(false);
				                	rs.setMessage("Please enter the correct entries in the excel data. CompanyCode is not available in Company master :-- "  + j);
				                	return rs;
				                }
			                }else{
			                	if(re.size()==0){
			                	ReportingMaster res=new ReportingMaster();
			                	CompanyMaster co=companyService.findId((int)Math.round(row.getCell(0).getNumericCellValue()));
			                	if(co !=null){
				                	EmployeeMaster em=employeeService.findId((long)Math.round(row.getCell(1).getNumericCellValue()));
				                	if(em !=null){
				                		 Cell cee = row.getCell(2);
						                 if (cee != null && cee.getCellType() != Cell.CELL_TYPE_BLANK){
						                	if(em.getName().equalsIgnoreCase(String.valueOf(row.getCell(2).getRichStringCellValue()).trim()) && em.getCompanycode().getCompanyCode().equals((int)Math.round(row.getCell(0).getNumericCellValue()))){
						                		res.setCompanyMaster(co);
						                		res.setEmployeeMaster(em);
						                		res.setEname(String.valueOf(row.getCell(2).getRichStringCellValue()).trim());
						                		Cell ce = row.getCell(3);
						                		Cell ce1 = row.getCell(4);
						                		if (ce != null && ce.getCellType() != Cell.CELL_TYPE_BLANK && ce1 != null && ce1.getCellType() != Cell.CELL_TYPE_BLANK ){
						                			EmployeeMaster ems=employeeService.findId((long)Math.round(row.getCell(3).getNumericCellValue()));
						                			if(ems.getName().equalsIgnoreCase(String.valueOf(row.getCell(4).getRichStringCellValue()).trim())){
						                				res.setManagercode(ems.getEmpid());
							                			res.setMname(ems.getName());
						                			}else{
						                				rs.setSuccess(false);
											            rs.setMessage("Please enter the correct entries in the excel data. ManagerCode And ManagerName is different in Employee master :-- " + j);
											            return rs; 
						                			}
						                		}else{
						                			long l = 0;
							                		res.setManagercode(l);
							                		res.setMname(""); 
						                		}
						                		Cell ce2 = row.getCell(5);
						                		Cell ce3 = row.getCell(6);
						                		if (ce2 != null && ce2.getCellType() != Cell.CELL_TYPE_BLANK && ce3 != null && ce3.getCellType() != Cell.CELL_TYPE_BLANK ){
						                			EmployeeMaster ems=employeeService.findId((long)Math.round(row.getCell(5).getNumericCellValue()));
						                			if(ems.getName().equalsIgnoreCase(String.valueOf(row.getCell(6).getRichStringCellValue()).trim())){
						                				res.setHocode(ems.getEmpid());
							                			res.setHoname(ems.getName());
						                			}else{
						                				rs.setSuccess(false);
											            rs.setMessage("Please enter the correct entries in the excel data. ManagerCode And ManagerName is different in Employee master :-- " + j);
											            return rs; 
						                			}
						                		}else{
						                			long l = 0;
						                			 res.setHocode(l);
							                		 res.setHoname(""); 
						                		}
							                	 
						                	}else{
						                		rs.setSuccess(false);
								                rs.setMessage("Please enter the correct entries in the excel data. EmployeeCode And CompanyCode is different in Employee master :-- " + j);
								                return rs;
						                	}
					                	 }else{
					                		 rs.setSuccess(false);
							                 rs.setMessage("Please enter the correct entries in the excel data. EmployeeName is blank :-- " + j);
							                 return rs;
					                	 }
					                	
					                	 ReportingMaster save=reportingService.save(res);
						                 if(save.getId()>0){
							               	rs.setSuccess(true);
							             }else{
							               	rs.setSuccess(false);
							               	rs.setMessage("Error updated record " + j);
							               	return rs;
							             }
				                	}else{
				                		rs.setSuccess(false);
					                	rs.setMessage("Please enter the correct entries in the excel data. EmployeeCode is not available in Employee master :-- " + j);
					                	return rs;
					            	}
				                }else{
				                	rs.setSuccess(false);
				                	rs.setMessage("Please enter the correct entries in the excel data. CompanyCode is not available in Company master :-- "  + j);
				                	return rs;
				                }
			                }
			              }
		              }else{
		            	  rs.setSuccess(false);
		                  rs.setMessage("Please enter the correct entries in the excel data. CompanyCode or EmployeeCode are blank :-- " + j);
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
			reportingService.saves(de);
	    }
	 return rs;
	}
	
	@RequestMapping(value ="rs/getReportingRef",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<Reporting> getReportingRef(Model model){
		List<ReportingMaster> masters = reportingService.findAll();
		List<Reporting> datas=new ArrayList<Reporting>();
		if(masters.size()>0){
			for(ReportingMaster p:masters){
				Reporting de=new Reporting();
				de.setNo(p.getId());
				de.setCname(p.getCompanyMaster().getCompanyName());
				de.setEcode(p.getEmployeeMaster().getEmpid());
				de.setEname(p.getEmployeeMaster().getName());
				if(p.getHocode()>0){
					de.setHocode(p.getHocode()+"");
					de.setHoname(p.getHoname());
				}else{
					de.setHocode("");
					de.setHoname("");
				}
				
				if(p.getManagercode()>0){
					de.setMcode(p.getManagercode()+"");
					de.setMname(p.getMname());
				}else{
					de.setMcode("");
					de.setMname("");
				}
				datas.add(de);
			}
		}
		return datas;
	}
	
}