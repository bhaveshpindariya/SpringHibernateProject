
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

import com.solusoft.jpa.DepartmentMapping;
import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.AdminMaster;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.CompanyMaster;
import com.solusoft.jpa.entity.CustomDepartment;
import com.solusoft.jpa.entity.DepartmentMaster;
import com.solusoft.jpa.entity.SapCustDepartMapping;
import com.solusoft.jpa.entity.SiteMaster;
import com.solusoft.jpa.entity.VerticalMaster;
import com.solusoft.services.CompanyService;
import com.solusoft.services.CustomDepartmenServicer;
import com.solusoft.services.DepartmentService;
import com.solusoft.services.SapCustDeparService;
import com.solusoft.services.SiteService;
import com.solusoft.services.VerticalService;


@Controller
public class SapCustomeMappingController {

	@Autowired
	CustomDepartmenServicer customDepartmenServicer;
	
	@Autowired
	VerticalService verticalService;
	
	@Autowired
	SiteService siteService;
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	SapCustDeparService sapCustDeparService;
	
	@Autowired
	CompanyService companyService;
	
	private static final String tabName="SAP_CUSTOMDEPARTMENT_MAPPING";
	
	private static final Logger logger = LoggerFactory
			.getLogger(SapCustomeMappingController.class);
	
	@RequestMapping(value = "/SapCustomeDepartment", method = RequestMethod.GET)
	public String EmployeeSitedetail(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("Get:/ All Sap department and custom department mapping Data...");
		
		List<SapCustDepartMapping> masters = sapCustDeparService.findAll();
		List<DepartmentMapping> datas=new ArrayList<DepartmentMapping>();
		if(masters.size()>0){
			int i=1;
			for(SapCustDepartMapping p:masters){
				if(p.getVerticalMaster() !=null){
					if(p.getCustomDepartment().getIsactive()==0 && p.getSiteMaster().getIsactive()==0){
						DepartmentMapping de=new DepartmentMapping();
						de.setNo(i);
						de.setId(p.getId());
						de.setDepartCode(p.getDepartmentMaster().getDeptcode());
						de.setCudtdepartCode(p.getCustomDepartment().getDeptcode());
						de.setDename(p.getDepartmentMaster().getDeptname());
						de.setVid(p.getVerticalMaster().getId());
						de.setVname(p.getVerticalMaster().getVname());
						de.setSid(p.getSiteMaster().getId());
						de.setSname(p.getSiteMaster().getSname());
						de.setCustdename(p.getCustomDepartment().getDeptname());
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
						de.setCname(p.getDepartmentMaster().getCompanyMaster().getCompanyName());
						de.setCid(p.getDepartmentMaster().getCompanyMaster().getCompanyCode());
						datas.add(de);
						i++;
					}
				}else{
					if(p.getCustomDepartment().getIsactive()==0 && p.getSiteMaster().getIsactive()==0){
						DepartmentMapping de=new DepartmentMapping();
						de.setNo(i);
						de.setId(p.getId());
						de.setDepartCode(p.getDepartmentMaster().getDeptcode());
						de.setCudtdepartCode(p.getCustomDepartment().getDeptcode());
						de.setDename(p.getDepartmentMaster().getDeptname());
						de.setVname("");
						de.setVid(0);
						de.setSid(p.getSiteMaster().getId());
						de.setSname(p.getSiteMaster().getSname());
						de.setCustdename(p.getCustomDepartment().getDeptname());
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
						de.setCname(p.getDepartmentMaster().getCompanyMaster().getCompanyName());
						de.setCid(p.getDepartmentMaster().getCompanyMaster().getCompanyCode());
						datas.add(de);
						i++;
					}
					
				}
			}
		}
		
		List<SapCustDepartMapping> masteres = sapCustDeparService.findAllInactive();
		List<DepartmentMapping> dataes=new ArrayList<DepartmentMapping>();
		if(masteres.size()>0){
			int i=1;
			for(SapCustDepartMapping p:masteres){
				    DepartmentMapping de=new DepartmentMapping();
				    de.setNo(i);
					de.setId(p.getId());
					de.setDepartCode(p.getDepartmentMaster().getDeptcode());
					de.setCudtdepartCode(p.getCustomDepartment().getDeptcode());
					de.setDename(p.getDepartmentMaster().getDeptname());
					if(p.getVerticalMaster()!=null){
						de.setVid(p.getVerticalMaster().getId());
						de.setVname(p.getVerticalMaster().getVname());
					}else{
						de.setVname("");
						de.setVid(0);
					}
					de.setSid(p.getSiteMaster().getId());
					de.setSname(p.getSiteMaster().getSname());
					de.setCustdename(p.getCustomDepartment().getDeptname());
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
					de.setCname(p.getDepartmentMaster().getCompanyMaster().getCompanyName());
					de.setCid(p.getDepartmentMaster().getCompanyMaster().getCompanyCode());
					dataes.add(de);
					i++;
			}
		}
		model.addAttribute("master", datas);
		model.addAttribute("masters", dataes);
		return "SapMaping";
	}
	
	@RequestMapping(value ="rs/getspactive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<DepartmentMapping> getspactive(Model model){
		List<SapCustDepartMapping> masters = sapCustDeparService.findAll();
		List<DepartmentMapping> datas=new ArrayList<DepartmentMapping>();
		if(masters.size()>0){
			int i=1;
			for(SapCustDepartMapping p:masters){
				if(p.getVerticalMaster() !=null){
					if(p.getCustomDepartment().getIsactive()==0 && p.getSiteMaster().getIsactive()==0){
						DepartmentMapping de=new DepartmentMapping();
						de.setNo(i);
						de.setId(p.getId());
						de.setDepartCode(p.getDepartmentMaster().getDeptcode());
						de.setCudtdepartCode(p.getCustomDepartment().getDeptcode());
						de.setDename(p.getDepartmentMaster().getDeptname());
						de.setVid(p.getVerticalMaster().getId());
						de.setVname(p.getVerticalMaster().getVname());
						de.setSid(p.getSiteMaster().getId());
						de.setSname(p.getSiteMaster().getSname());
						de.setCustdename(p.getCustomDepartment().getDeptname());
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
						de.setCname(p.getDepartmentMaster().getCompanyMaster().getCompanyName());
						de.setCid(p.getDepartmentMaster().getCompanyMaster().getCompanyCode());
						datas.add(de);
						i++;
					}
				}else{
					if(p.getCustomDepartment().getIsactive()==0 && p.getSiteMaster().getIsactive()==0){
						DepartmentMapping de=new DepartmentMapping();
						de.setNo(i);
						de.setId(p.getId());
						de.setDepartCode(p.getDepartmentMaster().getDeptcode());
						de.setCudtdepartCode(p.getCustomDepartment().getDeptcode());
						de.setDename(p.getDepartmentMaster().getDeptname());
						de.setVname("");
						de.setVid(0);
						de.setSid(p.getSiteMaster().getId());
						de.setSname(p.getSiteMaster().getSname());
						de.setCustdename(p.getCustomDepartment().getDeptname());
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
						de.setCname(p.getDepartmentMaster().getCompanyMaster().getCompanyName());
						de.setCid(p.getDepartmentMaster().getCompanyMaster().getCompanyCode());
						datas.add(de);
						i++;
					}
					
				}
			}
		}
		return datas;
	}
	
	@RequestMapping(value ="rs/getspinactive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<DepartmentMapping> getspinactive(Model model){
		List<SapCustDepartMapping> masteres = sapCustDeparService.findAllInactive();
		List<DepartmentMapping> dataes=new ArrayList<DepartmentMapping>();
		if(masteres.size()>0){
			int i=1;
			for(SapCustDepartMapping p:masteres){
				    DepartmentMapping de=new DepartmentMapping();
				    de.setNo(i);
					de.setId(p.getId());
					de.setDepartCode(p.getDepartmentMaster().getDeptcode());
					de.setCudtdepartCode(p.getCustomDepartment().getDeptcode());
					de.setDename(p.getDepartmentMaster().getDeptname());
					if(p.getVerticalMaster()!=null){
						de.setVid(p.getVerticalMaster().getId());
						de.setVname(p.getVerticalMaster().getVname());
					}else{
						de.setVname("");
						de.setVid(0);
					}
					de.setSid(p.getSiteMaster().getId());
					de.setSname(p.getSiteMaster().getSname());
					de.setCustdename(p.getCustomDepartment().getDeptname());
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
					de.setCname(p.getDepartmentMaster().getCompanyMaster().getCompanyName());
					de.setCid(p.getDepartmentMaster().getCompanyMaster().getCompanyCode());
					dataes.add(de);
					i++;
			}
		}
		return dataes;
	}
	
	@RequestMapping(value ="deleteMasterMapping",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList deleteMasterMapping(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		return sapCustDeparService.update(id,au.getUsername());
		
	}
	
	@RequestMapping(value ="activeIdMasterMapping",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList activeIdMasterMapping(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		return sapCustDeparService.activeId(id,au.getUsername());
		
	}
	
	@RequestMapping(value ="updateDepartCust",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList updateDepartCust(@RequestParam (value="ID",required=true) Integer id,
					 		  @RequestParam (value="Did",required=true) long departmen,
					 		  @RequestParam (value="CdId",required=true) long custDepartment,
					 		  @RequestParam (value="Vid",required=true) Integer vid,
					 		  @RequestParam (value="Sid",required=true) Integer sid,
					 Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		List<SapCustDepartMapping> dcs=sapCustDeparService.findNameActive(departmen,custDepartment,vid,sid);
		List<SapCustDepartMapping> dc=sapCustDeparService.findNameInactive(departmen,custDepartment,vid,sid);
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		if(dc.size()>=2){
			  rs.setSuccess(false);
			  rs.setMessage("SAP to Custome department mapping already exists in inactive list");
			  return rs;
		}else if(dcs.size()>=2){
			    rs.setMessage("SAP to Custome department mapping already exists in active list");
				rs.setSuccess(false);
				return rs;
		}else if(dc.size()>=1){
			for(SapCustDepartMapping dcss:dc){
				if(dcss.getId().equals(id)){
					rs=sapCustDeparService.updates(id,departmen,custDepartment,au.getUsername(),vid,sid);
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("SAP to Custome department mapping already exists in inactive list");
					return rs;
				}
		   }
		}else if(dcs.size()>=1){
			for(SapCustDepartMapping dcss:dcs){
				if(dcss.getId().equals(id)){
					rs=sapCustDeparService.updates(id,departmen,custDepartment,au.getUsername(),vid,sid);
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("SAP to Custome department mapping already exists in active list");
					return rs;
				}
		   }
		}else{
			rs=sapCustDeparService.updates(id,departmen,custDepartment,au.getUsername(),vid,sid);
			return rs;
		}
		return rs;
	}
	
	@RequestMapping(value ="insertDepartCust",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList insertDepartCust(@RequestParam (value="Did",required=true) long departmen,
			 		  		  @RequestParam (value="CdId",required=true) long custDepartment,
			 		  		  @RequestParam (value="Vid",required=true) Integer vid,
					 		  @RequestParam (value="Sid",required=true) Integer sid,
			 		  Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		List<SapCustDepartMapping> dcs=sapCustDeparService.findNameActive(departmen,custDepartment,vid,sid);
		List<SapCustDepartMapping> dc=sapCustDeparService.findNameInactive(departmen,custDepartment,vid,sid);
		ReadList rs = new ReadList();
		if(dc.size()>=1){
			rs.setSuccess(false);
			rs.setMessage("SAP to Custome department mapping already exists in inactive list");
			return rs;
		}else if(dcs.size()>=1){
			rs.setMessage("SAP to Custome department mapping already exists in active list");
			rs.setSuccess(false);
			return rs;
		}else{
			ReadList rss = new ReadList();
			rss=sapCustDeparService.save(departmen,custDepartment,au.getUsername(),vid,sid);
			return rss;
		}
		
	}
	
	@RequestMapping(value ="rs/getDep",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<DepartmentMaster> getDep(Model model){
		return departmentService.findAll();
	}
	
	@RequestMapping(value ="synchronizeExcelSap",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList synchronizeExcelSap(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ReadList rs = new ReadList();
		try {
			    AdminMaster au=(AdminMaster) session.getAttribute("user");
				ResourceBundle rss=ResourceBundle.getBundle("com.solusoft.controller.generic");
				String path=rss.getString("Excelpath");	
				FileInputStream file = new FileInputStream(new File(path));
	            POIFSFileSystem fs = new POIFSFileSystem(file);  
	            HSSFWorkbook wb = new HSSFWorkbook(fs);  
	            HSSFSheet sheet = wb.getSheet(rss.getString("SAPMapiing"));  
	            HSSFRow row; 
	            Integer vid=0;
	            long department;
	            long custDepartment;
	            Integer sid;
	            int j=2;
	            DepartmentMaster des=new DepartmentMaster();
	            CustomDepartment cde=new CustomDepartment();
	            VerticalMaster ver=new VerticalMaster();
	            SiteMaster se=new SiteMaster();
	            if(sheet.getLastRowNum()>0){
		            for(int i=1; i<=sheet.getLastRowNum(); i++)
		            	{  
		            	 row = sheet.getRow(i);  
		            	 Cell ce4 = row.getCell(4);
		            	 if(ce4 != null && ce4.getCellType() != Cell.CELL_TYPE_BLANK){
		            		 CompanyMaster co=companyService.findId((int)Math.round(row.getCell(4).getNumericCellValue()));
		            		 if(co !=null){
		            			 Cell ce0 = row.getCell(0);
		            			 Cell ce1 = row.getCell(1);
		 		                 if(ce0 != null && ce0.getCellType() != Cell.CELL_TYPE_BLANK && ce1 != null && ce1.getCellType() != Cell.CELL_TYPE_BLANK){
		 		                	des=departmentService.findId((long)Math.round(row.getCell(0).getNumericCellValue()));
		 		                	if(des !=null){
		 		                		if(des.getCompanyMaster().getCompanyCode().equals(co.getCompanyCode()) && des.getDeptname().equalsIgnoreCase(String.valueOf(row.getCell(1).getRichStringCellValue()).trim())){
		 		                			department=des.getDeptcode();   
		 		                		  }else{
			 		                 		rs.setSuccess(false);
							                rs.setMessage("Please enter the correct entries in the excel data. DepartmentCode or DepartmentName are wrong :-- "  + j);
							                return rs;  
			 		                 	   }
		 		                	}else{
		 		                		rs.setSuccess(false);
					                	rs.setMessage("Please enter the correct entries in the excel data. DepartmentCode is not available in Department master :-- "  + j);
					                	return rs;
		 		                	}
		 		                 }else{
		 		                	rs.setSuccess(false);
				                	rs.setMessage("Please enter the correct entries in the excel data. DepartmentCode or DepartmentName are blank :-- "  + j);
				                	return rs; 
		 		                 }
		 		                 
		 		                 Cell ce2 = row.getCell(2);
		            			 Cell ce3 = row.getCell(3);
		 		                 if(ce2 != null && ce2.getCellType() != Cell.CELL_TYPE_BLANK && ce3 != null && ce3.getCellType() != Cell.CELL_TYPE_BLANK){
		 		                	cde=customDepartmenServicer.findId((long)Math.round(row.getCell(2).getNumericCellValue()));
		 		                	if(cde !=null){
		 		                		if(cde.getCompanyMaster().getCompanyCode().equals(co.getCompanyCode()) && cde.getDeptname().equalsIgnoreCase(String.valueOf(row.getCell(3).getRichStringCellValue()).trim())){
		 		                			custDepartment=cde.getDeptcode();   
		 		                		 }else{
			 		                 		rs.setSuccess(false);
							                rs.setMessage("Please enter the correct entries in the excel data. CustomDepartmentCode or CustomDepartmentName are wrong :-- "  + j);
							                return rs;  
			 		                 	   }
		 		                	 }else{
		 		                		rs.setSuccess(false);
					                	rs.setMessage("Please enter the correct entries in the excel data. CustomDepartmentCode is not available in CustomDepartmentName master :-- "  + j);
					                	return rs;
		 		                	}
		 		                 }else{
		 		                	rs.setSuccess(false);
				                	rs.setMessage("Please enter the correct entries in the excel data. CustomDepartmentCode or CustomDepartmentName are blank :-- "  + j);
				                	return rs; 
		 		                 }
		 		                 
		 		                 Cell ce5 = row.getCell(5);
				            	 if(ce5 != null && ce5.getCellType() != Cell.CELL_TYPE_BLANK){
				            		ver=verticalService.findName(String.valueOf(row.getCell(5).getRichStringCellValue()).trim().toUpperCase());
				            		if(ver !=null){
				            			vid=ver.getId();
					            	  }
				            	  }else{
				            		  rs.setSuccess(false);
					                  rs.setMessage("Please enter the correct entries in the excel data. VerticalName is not  :-- "  + j);
					                  return rs;  
				            	  }
				            	
				            	  Cell ce6 = row.getCell(6);
					              if(ce6 != null && ce6.getCellType() != Cell.CELL_TYPE_BLANK){
					            	  se=siteService.finddetails(String.valueOf(row.getCell(6).getRichStringCellValue()).trim().toUpperCase(),co);
					            	  if(se !=null){
					            		  sid=se.getId();
						             	}else{
						             	  rs.setSuccess(false);
							              rs.setMessage("Please enter the correct entries in the excel data. SiteName available in site master :-- "  + j);
							              return rs; 
						                }
					               }else{
					            	   rs.setSuccess(false);
						               rs.setMessage("Please enter the correct entries in the excel data. SiteName is blank :-- "  + j);
						               return rs; 
					               }
					               SapCustDepartMapping dep=sapCustDeparService.finddetail(department,custDepartment,vid,sid);
					               if(dep!=null){
					            	    dep.setDepartmentMaster(des);
					            	    dep.setCustomDepartment(cde);
					            	    dep.setVerticalMaster(ver);
					            	    dep.setSiteMaster(se);
					            	    dep.setCreatedBy(au.getUsername());
					            	    dep.setCreatedDate(new Timestamp(new Date().getTime()));
					            	    dep.setIsactive(0);
					            	    SapCustDepartMapping s=sapCustDeparService.save(dep);
		 		                		if(s.getId()>0){
			 			                	rs.setSuccess(true);
			 			                }else{
			 			                	rs.setSuccess(false);
			 			                	rs.setMessage("Error updated record" + j);
			 			                	return rs;
			 			                }
				                	}else{
				                		SapCustDepartMapping scd=new SapCustDepartMapping();
				                		scd.setDepartmentMaster(des);
				                		scd.setCustomDepartment(cde);
				                		scd.setVerticalMaster(ver);
				                		scd.setSiteMaster(se);
				                		scd.setCreatedBy(au.getUsername());
				                		scd.setCreatedDate(new Timestamp(new Date().getTime()));
				                		scd.setIsactive(0);
					            	    SapCustDepartMapping s=sapCustDeparService.save(scd);
		 		                		if(s.getId()>0){
			 			                	rs.setSuccess(true);
			 			                }else{
			 			                	rs.setSuccess(false);
			 			                	rs.setMessage("Error updated record" + j);
			 			                	return rs;
			 			                }
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
			sapCustDeparService.saves(de);
	    }
		
	 return rs;
	}
}