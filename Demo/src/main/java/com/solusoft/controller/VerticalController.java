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
import com.solusoft.jpa.VerticalMas;
import com.solusoft.jpa.entity.AdminMaster;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.VerticalMaster;
import com.solusoft.services.VerticalService;

@Controller
public class VerticalController {

	@Autowired
	VerticalService verticalService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(VerticalController.class);
	
	private static final String tabName="VERTICAL_MASTER";
	
	@RequestMapping(value = "/vertical", method = RequestMethod.GET)
	public String vertical(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All Vertical Data...");
		List<VerticalMaster> masters = verticalService.findAll();
		List<VerticalMas> datas=new ArrayList<VerticalMas>();
		if(masters.size()>0){
			int i=1;
			for(VerticalMaster p:masters){
				VerticalMas de=new VerticalMas();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getVname());
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
				de.setVerabbreviation(p.getVerabbreviation());
				datas.add(de);
				i++;
			}
		}
		
		List<VerticalMaster> masteres = verticalService.findAllInactive();
		List<VerticalMas> dataes=new ArrayList<VerticalMas>();
		if(masteres.size()>0){
			int i=1;
			for(VerticalMaster p:masteres){
				VerticalMas de=new VerticalMas();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getVname());
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
				de.setVerabbreviation(p.getVerabbreviation());
				dataes.add(de);
				i++;
			}
		}
		model.addAttribute("masters", dataes);
		model.addAttribute("master", datas);
		return "verticalMasters";
	}
	
	@RequestMapping(value ="rs/getveractive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<VerticalMas> getveractive(Model model){
		List<VerticalMaster> masters = verticalService.findAll();
		List<VerticalMas> datas=new ArrayList<VerticalMas>();
		if(masters.size()>0){
			int i=1;
			for(VerticalMaster p:masters){
				VerticalMas de=new VerticalMas();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getVname());
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
				de.setVerabbreviation(p.getVerabbreviation());
				datas.add(de);
				i++;
			}
		}
		return datas;
	}
	
	@RequestMapping(value ="rs/getverinactive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<VerticalMas> getverinactive(Model model){
		List<VerticalMaster> masteres = verticalService.findAllInactive();
		List<VerticalMas> dataes=new ArrayList<VerticalMas>();
		if(masteres.size()>0){
			int i=1;
			for(VerticalMaster p:masteres){
				VerticalMas de=new VerticalMas();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getVname());
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
				de.setVerabbreviation(p.getVerabbreviation());
				dataes.add(de);
				i++;
			}
		}
		return dataes;
	}
		
	@RequestMapping(value ="rs/getVer",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<VerticalMaster> getRole(
					Model model){
		return verticalService.findAll();
	}
	
	@RequestMapping(value ="activeIdforVer",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList activeIdforVer(@RequestParam (value="ID",required=true) Integer id,
					        Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		return verticalService.activeId(id,au.getUsername());
	}
	
	@RequestMapping(value ="deleteVer",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList siRolde(@RequestParam (value="ID",required=true) Integer id,
					 Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		return verticalService.updateVer(id,au.getUsername());
	}
	
	@RequestMapping(value ="updateVer",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList siRolup(@RequestParam (value="ID",required=true) Integer id,
			 		 @RequestParam (value="Name",required=true) String detail,
			 		 @RequestParam (value="Vabb",required=true) String vabb,
			 		 Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		
		List<VerticalMaster> dc=verticalService.findNameActive(detail.toUpperCase(),vabb.toUpperCase());
		List<VerticalMaster> dcs=verticalService.findNameInactive(detail.toUpperCase(),vabb.toUpperCase());
		ReadList rs = new ReadList();
		if(dc.size()>=2){
			  rs.setSuccess(false);
			  rs.setMessage("Vertical already exists in inactive list or active list ");
			  return rs;
		}else if(dcs.size()>=2){
				rs.setMessage("Vertical already exists in inactive list or active list ");
				rs.setSuccess(false);
				return rs;
		}else if(dc.size()>=1){
			for(VerticalMaster dcss:dc){
				if(dcss.getId().equals(id)){
					rs=verticalService.updatesVer(id,detail,au.getUsername(),vabb);
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Vertical already exists in inactive list or active list ");
					return rs;
				}
		   }
		}else if(dcs.size()>=1){
			for(VerticalMaster dcss:dcs){
				if(dcss.getId().equals(id)){
					rs=verticalService.updatesVer(id,detail,au.getUsername(),vabb);
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Vertical already exists in inactive list or active list ");
					return rs;
				}
		   }
		}else{
			rs=verticalService.updatesVer(id,detail,au.getUsername(),vabb);
		  return rs;
		}
		return rs;
	}
	
	@RequestMapping(value ="insertVer",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList siRolin(@RequestParam (value="Name",required=true) String detail,
					 @RequestParam (value="Vabb",required=true) String vabb,
					 Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		
		List<VerticalMaster> dcs=verticalService.findNameActive(detail.toUpperCase(),vabb.toUpperCase());
		List<VerticalMaster> dc=verticalService.findNameInactive(detail.toUpperCase(),vabb.toUpperCase());
		ReadList rs = new ReadList();
		if(dc.size()>=1){
			rs.setSuccess(false);
			rs.setMessage("Vertical already exists in inactive list or active list ");
			return rs;
		}else if(dcs.size()>=1){
			rs.setMessage("Vertical already exists in inactive list or active list ");
			rs.setSuccess(false);
			return rs;
		}else{
			ReadList rss = new ReadList();
			rss=verticalService.saveVer(detail,au.getUsername(),vabb);
			return rss;
		}
	}
	
	// vertical and custom department mapping
	
	@RequestMapping(value ="rs/getVertical",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<VerticalMaster> getVertical(Model model){
		return verticalService.findAll();
	}
	
	@RequestMapping(value ="synchronizeExcelVer",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList synchronizeExcelVer(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ReadList rs = new ReadList();
		try {
			AdminMaster au=(AdminMaster) session.getAttribute("user");
			ResourceBundle rss=ResourceBundle.getBundle("com.solusoft.controller.generic");
			String path=rss.getString("Excelpath");	
			FileInputStream file = new FileInputStream(new File(path));
            POIFSFileSystem fs = new POIFSFileSystem(file);  
            HSSFWorkbook wb = new HSSFWorkbook(fs);  
            HSSFSheet sheet = wb.getSheet(rss.getString("Vertical"));  
            HSSFRow row;  
            int j=2;
            if(sheet.getLastRowNum()>0){
	            for(int i=1; i<=sheet.getLastRowNum(); i++)
	            	{  
	            		row = sheet.getRow(i);  
	            		Cell ce1 = row.getCell(0);
	            	    Cell ce2 = row.getCell(1);
		            	if(ce1 != null && ce1.getCellType() != Cell.CELL_TYPE_BLANK && ce2 != null && ce2.getCellType() != Cell.CELL_TYPE_BLANK){
	            	    	List<VerticalMaster> ver=verticalService.findNames(String.valueOf(row.getCell(0).getRichStringCellValue()).trim().toUpperCase(), String.valueOf(row.getCell(1).getRichStringCellValue()).trim().toUpperCase());
	            	    	if(ver.size()==1){
	            	    		for(VerticalMaster co:ver){
	            	    			co.setVname(String.valueOf(row.getCell(0).getRichStringCellValue()).trim());
	            	    			co.setVerabbreviation(String.valueOf(row.getCell(1).getRichStringCellValue()).trim());
	            	    			co.setCreatedBy(au.getUsername());
	    			            	co.setCreatedDate(new Timestamp(new Date().getTime()));
	    			            	co.setIsactive(0);
	    			            	VerticalMaster save=verticalService.save(co);
	    				            if(save.getId()>0){
	    				               	rs.setSuccess(true);
	    				            }else{
	    				               	rs.setSuccess(false);
	    				               	rs.setMessage("Error updated record " + j);
	    				               	return rs;
	    				            }
	            	    		}
	            	    	}else{
	            	    		VerticalMaster co=new VerticalMaster();
	            	    		co.setVname(String.valueOf(row.getCell(0).getRichStringCellValue()).trim());
            	    			co.setVerabbreviation(String.valueOf(row.getCell(1).getRichStringCellValue()).trim());
            	    			co.setCreatedBy(au.getUsername());
    			            	co.setCreatedDate(new Timestamp(new Date().getTime()));
    			            	co.setIsactive(0);
    			            	VerticalMaster save=verticalService.save(co);
    				            if(save.getId()>0){
    				               	rs.setSuccess(true);
    				            }else{
    				               	rs.setSuccess(false);
    				               	rs.setMessage("Error updated record " + j);
    				               	return rs;
    				            }
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
			verticalService.saves(de);
	   }
	 return rs;
	}
	
}