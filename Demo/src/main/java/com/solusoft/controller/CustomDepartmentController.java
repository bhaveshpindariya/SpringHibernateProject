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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.solusoft.jpa.DepartData;
import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.AdminMaster;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.CompanyMaster;
import com.solusoft.jpa.entity.CustomDepartment;
import com.solusoft.services.CompanyService;
import com.solusoft.services.CustomDepartmenServicer;

@Controller
public class CustomDepartmentController {

	@Autowired
	CustomDepartmenServicer customDepartmenServicer;
	
	@Autowired
	CompanyService companyService;
	
	private static final String tabName="CUSTOM_DEPARTMENT";
	
	private static final Logger logger = LoggerFactory
			.getLogger(CustomDepartmentController.class);
	
	@RequestMapping(value = "/customeDepartment", method = RequestMethod.GET)
	public String customeDepartment(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All Custom Department Data...");
		List<CustomDepartment> masters = customDepartmenServicer.findAll();
		List<DepartData> datas=new ArrayList<DepartData>();
		if(masters.size()>0){
			int i=1;
			for(CustomDepartment p:masters){
				DepartData de=new DepartData();
				de.setNo(i);
				de.setdCode(p.getDeptcode());
				de.setdName(p.getDeptname());
				de.setdAbbra(p.getDeptabbreviation());
				de.setCid(p.getCompanyMaster().getCompanyCode());
				de.setCompanyName(p.getCompanyMaster().getCompanyName());
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
		
		
		List<CustomDepartment> masteres = customDepartmenServicer.findAllInactive();
		List<DepartData> dataes=new ArrayList<DepartData>();
		if(masteres.size()>0){
			int i=1;
			for(CustomDepartment p:masteres){
				DepartData de=new DepartData();
				de.setNo(i);
				de.setdCode(p.getDeptcode());
				de.setdName(p.getDeptname());
				de.setdAbbra(p.getDeptabbreviation());
				de.setCid(p.getCompanyMaster().getCompanyCode());
				de.setCompanyName(p.getCompanyMaster().getCompanyName());
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
		
		model.addAttribute("masters", dataes);
		model.addAttribute("master", datas);
		
		return "CustomDepartment";
		
	}
	
	@RequestMapping(value ="rs/getcustdeptactive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<DepartData> getcustdeptactive(Model model){
		List<CustomDepartment> masters = customDepartmenServicer.findAll();
		List<DepartData> datas=new ArrayList<DepartData>();
		if(masters.size()>0){
			int i=1;
			for(CustomDepartment p:masters){
				DepartData de=new DepartData();
				de.setNo(i);
				de.setdCode(p.getDeptcode());
				de.setdName(p.getDeptname());
				de.setdAbbra(p.getDeptabbreviation());
				de.setCid(p.getCompanyMaster().getCompanyCode());
				de.setCompanyName(p.getCompanyMaster().getCompanyName());
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
	
	@RequestMapping(value ="rs/getcustdeptinactive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<DepartData> getcustdeptinactive(Model model){
		List<CustomDepartment> masteres = customDepartmenServicer.findAllInactive();
		List<DepartData> dataes=new ArrayList<DepartData>();
		if(masteres.size()>0){
			int i=1;
			for(CustomDepartment p:masteres){
				DepartData de=new DepartData();
				de.setNo(i);
				de.setdCode(p.getDeptcode());
				de.setdName(p.getDeptname());
				de.setdAbbra(p.getDeptabbreviation());
				de.setCid(p.getCompanyMaster().getCompanyCode());
				de.setCompanyName(p.getCompanyMaster().getCompanyName());
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
	
	@RequestMapping(value ="activeIdsustDo",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList activeIdsustDo(@RequestParam (value="ID",required=true) long id,
						  Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		return customDepartmenServicer.activeId(id,au.getUsername());
		
	}
	
	@RequestMapping(value ="deleteCustDep",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList DeleteMaster(@RequestParam (value="ID",required=true) long id,
						  Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		return customDepartmenServicer.delete(id,au.getUsername());
		
	}
	
	@RequestMapping(value ="updateCustDep",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList UpdateMasters(@RequestParam (value="ID",required=true) long id,
					 	   @RequestParam (value="Dname",required=true) String dname,
					 	   @RequestParam (value="Dabb",required=true) String dabb,
					 	   @RequestParam (value="Com",required=true) Integer cid,
					 	  Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		List<CustomDepartment> dc=customDepartmenServicer.findNameActive(id,dname.toUpperCase(),dabb.toUpperCase(),cid);
		List<CustomDepartment> dcs=customDepartmenServicer.findNameInactive(id,dname.toUpperCase(),dabb.toUpperCase(),cid);
		ReadList rs = new ReadList();
		if(dc.size()>=2){
			  rs.setSuccess(false);
			  rs.setMessage("Custome department already exists in active list");
			  return rs;
		}else if(dcs.size()>=2){
				rs.setMessage("Custome department already exists in inactive list");
				rs.setSuccess(false);
				return rs;
		}else if(dc.size()>=1){
			for(CustomDepartment dcss:dc){
				if(dcss.getDeptcode() == id){
					rs=customDepartmenServicer.updates(id,dname,dabb,cid,au.getUsername());
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Custome department already exits in active list");
					return rs;
				}
		   }
		}else if(dcs.size()>=1){
			for(CustomDepartment dcss:dcs){
				if(dcss.getDeptcode() == id){
					rs=customDepartmenServicer.updates(id,dname,dabb,cid,au.getUsername());
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Custome department already exists in inactive list");
					return rs;
				}
		   }
		}else{
			 rs=customDepartmenServicer.updates(id,dname,dabb,cid,au.getUsername());
		  return rs;
		}
		return rs;
	}
	
	@RequestMapping(value ="insertCustDep",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList InsertMasteres(@RequestParam (value="ID",required=true) long id,
					 	    @RequestParam (value="Dname",required=true) String dname,
					 	    @RequestParam (value="Dabb",required=true) String dabb,
					 	    @RequestParam (value="Com",required=true) Integer cid,
					  		Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		List<CustomDepartment> dcs=customDepartmenServicer.findNameActive(id,dname.toUpperCase(),dabb.toUpperCase(),cid);
		List<CustomDepartment> dc=customDepartmenServicer.findNameInactive(id,dname.toUpperCase(),dabb.toUpperCase(),cid);
		ReadList rs = new ReadList();
		if(dc.size()>=1){
			rs.setSuccess(false);
			rs.setMessage("Custome department already exists in active list or inactive list");
			return rs;
		}else if(dcs.size()>=1){
			rs.setMessage("Custome department already exists in active list or inactive list");
			rs.setSuccess(false);
			return rs;
		}else{
			ReadList rss = new ReadList();
			rss=customDepartmenServicer.save(id,dname,dabb,cid,au.getUsername());
			return rss;
		}
	}
	
	@RequestMapping(value ="rs/getCustDep",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<CustomDepartment> getDep(Model model){
		return customDepartmenServicer.findAll();
	}
	
	@RequestMapping(value ="rs/getCustDepForCompany",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<CustomDepartment> getCustDepForCompany(@RequestParam (value="Company_code",required=true)Integer id,
												Model model){
		return customDepartmenServicer.findAlls(id);
	}
	
	@RequestMapping(value ="synchronizeExcelCust",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList synchronizeExcelCust(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ReadList rs = new ReadList();
		try {
			    AdminMaster au=(AdminMaster) session.getAttribute("user");
				ResourceBundle rss=ResourceBundle.getBundle("com.solusoft.controller.generic");
				String path=rss.getString("Excelpath");	
				FileInputStream file = new FileInputStream(new File(path));
	            POIFSFileSystem fs = new POIFSFileSystem(file);  
	            HSSFWorkbook wb = new HSSFWorkbook(fs);  
	            HSSFSheet sheet = wb.getSheet(rss.getString("CustDepartment"));  
	            HSSFRow row; 
	            int j=2;
	            if(sheet.getLastRowNum()>0){
		            for(int i=1; i<=sheet.getLastRowNum(); i++)
		            	{  
		            	row = sheet.getRow(i);  
		            	CustomDepartment de=new CustomDepartment();
	            	    Cell ce0 = row.getCell(0);
		                if(ce0 != null && ce0.getCellType() != Cell.CELL_TYPE_BLANK){
		                	de.setDeptcode((long)Math.round(row.getCell(0).getNumericCellValue()));
		            	    Cell ce1 = row.getCell(1);
		            	    if(ce1 != null && ce1.getCellType() != Cell.CELL_TYPE_BLANK){
		            	    	 de.setDeptname(String.valueOf(row.getCell(1).getRichStringCellValue()).trim());
			                	 rs.setSuccess(true);
			                }else{
			                	rs.setSuccess(false);	
			                }
		            	    Cell ce2 = row.getCell(2);
		            	    if(ce2 != null && ce2.getCellType() != Cell.CELL_TYPE_BLANK){
		            	    	if(rs.getSuccess()){
		            	    		de.setDeptabbreviation(String.valueOf(row.getCell(2).getRichStringCellValue()).trim());
			                		rs.setSuccess(true);
		            	    	}else{
		            	    		rs.setSuccess(false);	
		            	    	}
			                }else{
			                	rs.setSuccess(false);
			                	rs.setMessage("Please enter the correct entries in the excel data. DeptAbbreviation is blank :-- "  + j);
			                	return rs;
			                }
		            	    Cell ce3 = row.getCell(3);
		            	    if(ce3 != null && ce3.getCellType() != Cell.CELL_TYPE_BLANK){
		            	    	 CompanyMaster co=companyService.findId((int)Math.round(row.getCell(3).getNumericCellValue()));
		            	    	 if(co !=null){
		 		                	de.setCompanyMaster(co);
		 		                	if(rs.getSuccess()){
		 		                		de.setCreatedBy(au.getUsername());
		 		                		de.setCreatedDate(new Timestamp(new Date().getTime()));
		 		                		de.setIsactive(0);
		 		                		CustomDepartment save=customDepartmenServicer.save(de);
		 		                		if(save.getDeptcode()>0){
			 			                	rs.setSuccess(true);
			 			                }else{
			 			                	rs.setSuccess(false);
			 			                	rs.setMessage("Error updated record" + j);
			 			                	return rs;
			 			                }
		 		                	}else{
		 		                		rs.setSuccess(false);
					                	rs.setMessage("Please enter the correct entries in the excel data. DeptName is blank :-- "  + j);
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
		                	rs.setMessage("Please enter the correct entries in the excel data. DeptCode is blank :-- " + j);
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
			customDepartmenServicer.saves(de);
	    }
	 return rs;
	}
}