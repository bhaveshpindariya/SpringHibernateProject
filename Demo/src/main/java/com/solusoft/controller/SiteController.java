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

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.SiteData;
import com.solusoft.jpa.entity.AdminMaster;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.CompanyMaster;
import com.solusoft.jpa.entity.SiteMaster;
import com.solusoft.services.CompanyService;
import com.solusoft.services.SiteService;

@Controller
public class SiteController {

	@Autowired
	SiteService siteService;
	
	@Autowired
	CompanyService companyService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(SiteController.class);
	
	private static final String tabName="SITE_MASTER";
	
	@RequestMapping(value = "/siteMaster", method = RequestMethod.GET)
	public String siteMaster(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All Site Detail Data...");
		List<SiteMaster> masters = siteService.findAll();
		List<SiteData> datas=new ArrayList<SiteData>();
		if(masters.size()>0){
			int i=1;
			for(SiteMaster p:masters){
				SiteData de=new SiteData();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getSname());
				de.setSalians(p.getSaliens());
				de.setSabb(p.getSabbra());				
				de.setSaddress(p.getSaddress());
				de.setCompanycode(p.getCompanyMaster().getCompanyCode());
				de.setCompanyname(p.getCompanyMaster().getCompanyName());
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
		
		List<SiteMaster> masteres = siteService.findAllInactive();
		List<SiteData> dataes=new ArrayList<SiteData>();
		if(masteres.size()>0){
			int i=1;
			for(SiteMaster p:masteres){
				SiteData de=new SiteData();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getSname());
				de.setSalians(p.getSaliens());
				de.setSabb(p.getSabbra());				
				de.setSaddress(p.getSaddress());
				de.setCompanycode(p.getCompanyMaster().getCompanyCode());
				de.setCompanyname(p.getCompanyMaster().getCompanyName());
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
		return "SiteMasters";
	}
	
	@RequestMapping(value ="rs/getsitactive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<SiteData> getsitactive(Model model){
		List<SiteMaster> masters = siteService.findAll();
		List<SiteData> datas=new ArrayList<SiteData>();
		if(masters.size()>0){
			int i=1;
			for(SiteMaster p:masters){
				SiteData de=new SiteData();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getSname());
				de.setSalians(p.getSaliens());
				de.setSabb(p.getSabbra());				
				de.setSaddress(p.getSaddress());
				de.setCompanycode(p.getCompanyMaster().getCompanyCode());
				de.setCompanyname(p.getCompanyMaster().getCompanyName());
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
	
	@RequestMapping(value ="rs/getsitinactive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<SiteData> getsitinactive(Model model){
		List<SiteMaster> masteres = siteService.findAllInactive();
		List<SiteData> dataes=new ArrayList<SiteData>();
		if(masteres.size()>0){
			int i=1;
			for(SiteMaster p:masteres){
				SiteData de=new SiteData();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getSname());
				de.setSalians(p.getSaliens());
				de.setSabb(p.getSabbra());				
				de.setSaddress(p.getSaddress());
				de.setCompanycode(p.getCompanyMaster().getCompanyCode());
				de.setCompanyname(p.getCompanyMaster().getCompanyName());
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
	
	@RequestMapping(value ="activeIdSc",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList activeIdSc(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		return siteService.activeId(id,au.getUsername());

	}
	
	@RequestMapping(value ="deleteSite",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Master(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		return siteService.update(id,au.getUsername());

	}
	
	@RequestMapping(value ="updateSiteData",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Masters(@RequestParam (value="ID",required=true) Integer id,
					 @RequestParam (value="Name",required=true) String detail,
					 @RequestParam (value="Salias",required=true) String salias,
					 @RequestParam (value="Sabb",required=true) String sabb,
					 @RequestParam (value="Sadd",required=true) String sadd,
					 @RequestParam (value="Com",required=true) Integer ccode,
					 Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		List<SiteMaster> dc=siteService.findNameActive(detail.toUpperCase(),salias.toUpperCase(),sabb.toUpperCase(),sadd.toUpperCase(),ccode);
		List<SiteMaster> dcs=siteService.findNameInactive(detail.toUpperCase(),salias.toUpperCase(),sabb.toUpperCase(),sadd.toUpperCase(),ccode);
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		if(dc.size()>=2){
			  rs.setSuccess(false);
			  rs.setMessage("Site already exists in active list");
			  return rs;
		}else if(dcs.size()>=2){
			  rs.setMessage("Site already exists in inactive list");
			  rs.setSuccess(false);
			  return rs;
		}else if(dc.size()>=1){
			for(SiteMaster dcss:dc){
				if(dcss.getId().equals(id)){
					rs=siteService.updates(id,detail,au.getUsername(),salias,sabb,sadd,ccode);
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Site already exits in active list");
					return rs;
				}
		   }
		}else if(dcs.size()>=1){
			for(SiteMaster dcss:dcs){
				if(dcss.getId().equals(id)){
					rs=siteService.updates(id,detail,au.getUsername(),salias,sabb,sadd,ccode);
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Site already exists in inactive list");
					return rs;
				}
		   }
		}else{
			rs=siteService.updates(id,detail,au.getUsername(),salias,sabb,sadd,ccode);
			return rs;
		}
		return rs;
	}
	
	@RequestMapping(value ="insertSiteData",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Masteres(@RequestParam (value="Name",required=true) String detail,
					  @RequestParam (value="Salias",required=true) String salias,
					  @RequestParam (value="Sabb",required=true) String sabb,
					  @RequestParam (value="Sadd",required=true) String sadd,
					  @RequestParam (value="Com",required=true) Integer ccode,
			 		  Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		List<SiteMaster> dcs=siteService.findNameActive(detail.toUpperCase(),salias.toUpperCase(),sabb.toUpperCase(),sadd.toUpperCase(),ccode);
		List<SiteMaster> dc=siteService.findNameInactive(detail.toUpperCase(),salias.toUpperCase(),sabb.toUpperCase(),sadd.toUpperCase(),ccode);
		ReadList rs = new ReadList();
		if(dc.size()>=1){
			rs.setSuccess(false);
			rs.setMessage("Site already exists in inactive list");
			return rs;
		}else if(dcs.size()>=1){
			rs.setMessage("Site already exists in active list");
			rs.setSuccess(false);
			return rs;
		}else{
			ReadList rss = new ReadList();
			rss=siteService.save(detail,au.getUsername(),salias,sabb,sadd,ccode);
			return rss;
		}
	}
	
	@RequestMapping(value ="rs/getSit",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<SiteMaster> getSit(
					Model model){
		return siteService.findAll();
	}
	@RequestMapping(value ="rs/getSitComp",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<SiteMaster> getSitComp(@RequestParam (value="Company_name",required=true) Integer ccode,
					Model model){
		return siteService.findAlls(ccode);
	}
	
	@RequestMapping(value ="synchronizeExcelSite",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList synchronizeExcelSite(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ReadList rs = new ReadList();
		try {
			    AdminMaster au=(AdminMaster) session.getAttribute("user");
				ResourceBundle rss=ResourceBundle.getBundle("com.solusoft.controller.generic");
				String path=rss.getString("Excelpath");	
				FileInputStream file = new FileInputStream(new File(path));
	            POIFSFileSystem fs = new POIFSFileSystem(file);  
	            HSSFWorkbook wb = new HSSFWorkbook(fs);  
	            HSSFSheet sheet = wb.getSheet(rss.getString("Site"));  
	            HSSFRow row; 
	            int j=2;
	            if(sheet.getLastRowNum()>0){
		            for(int i=1; i<=sheet.getLastRowNum(); i++)
		            	{  
		            	row = sheet.getRow(i);  
		            	Cell ce1 = row.getCell(0);
	            	    Cell ce2 = row.getCell(1);
	            	    Cell ce3 = row.getCell(2);
	            	    Cell ce4 = row.getCell(3);
	            	    Cell ce5 = row.getCell(4);
		                if(ce1 != null && ce1.getCellType() != Cell.CELL_TYPE_BLANK && ce2 != null && ce2.getCellType() != Cell.CELL_TYPE_BLANK && ce3 != null && ce3.getCellType() != Cell.CELL_TYPE_BLANK && ce4 != null && ce4.getCellType() != Cell.CELL_TYPE_BLANK && ce5 != null && ce5.getCellType() != Cell.CELL_TYPE_BLANK){
		                	CompanyMaster co=companyService.findId((int)Math.round(row.getCell(4).getNumericCellValue()));
		                	if(co!=null){ 
		                		String sname=String.valueOf(row.getCell(0).getRichStringCellValue()).trim();
		                		String salians=String.valueOf(row.getCell(1).getRichStringCellValue()).trim();
		                		String sabbra=String.valueOf(row.getCell(2).getRichStringCellValue()).trim();
		                		String sadd=String.valueOf(row.getCell(3).getRichStringCellValue()).trim();
		                		List<SiteMaster> se=siteService.finddetail(sname.toUpperCase(),salians.toUpperCase(),sabbra.toUpperCase(),sadd.toUpperCase(),co);
		                		if(se.size()==1){
			                		for(SiteMaster ae:se){
			                			ae.setSname(sname);
			                			ae.setSaliens(salians);
			                			ae.setsabbra(sabbra);
			                			ae.setsaddress(sadd);
			                			ae.setCompanyMaster(co);
			                			ae.setCreatedBy(au.getUsername());
			                			ae.setCreatedDate(new Timestamp(new Date().getTime()));
			                			ae.setIsactive(0);
					                	SiteMaster save=siteService.save(ae);
						                if(save.getId()>0){
							               	rs.setSuccess(true);
							            }else{
							               	rs.setSuccess(false);
							               	rs.setMessage("Error updated record" + j);
							               	return rs;
							            }
			                		}
			                	}else{
			                		
			                		SiteMaster de=new SiteMaster();
			                		de.setSname(sname);
				                	de.setSaliens(salians);
				                	de.setsabbra(sabbra);
				                	de.setsaddress(sadd);
				                	de.setCompanyMaster(co);
					                de.setCreatedBy(au.getUsername());
				                	de.setCreatedDate(new Timestamp(new Date().getTime()));
				                	de.setIsactive(0);
				                	SiteMaster save=siteService.save(de);
					                if(save.getId()>0){
						               	rs.setSuccess(true);
						            }else{
						               	rs.setSuccess(false);
						               	rs.setMessage("Error updated record" + j);
						               	return rs;
						            }
			                	}
		                	}else{
		                		rs.setSuccess(false);
		                		rs.setMessage("Please enter the correct entries in the excel data. Company code is not available in Company master :-- "  + j);
			                	return rs;
		                	}
			            }else{
			            	rs.setSuccess(false);
		                	rs.setMessage("Please enter the correct entries in the excel data. blank :-- " + j);
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
			siteService.saves(de);
	    }
	 return rs;
	}
	
}