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

import com.solusoft.jpa.AgreementscreensData;
import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.AdminMaster;
import com.solusoft.jpa.entity.AgreementScreens;
import com.solusoft.jpa.entity.AgreementTypeMaster;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.services.AgreementTypeServicer;
import com.solusoft.services.AgreementscreensService;

@Controller
public class AgreementscreensController {

	@Autowired
	AgreementscreensService agreementscreensService;
	
	@Autowired
	AgreementTypeServicer agreementTypeServicer;
	
	private static final String tabName="AGREEMENT_SCREENS";
	
	private static final Logger logger = LoggerFactory.getLogger(AgreementscreensController.class);
	
	@RequestMapping(value = "/agreementscreen", method = RequestMethod.GET)
	public String agreementscreen(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All agreement screens Data...");
		List<AgreementScreens> masters = agreementscreensService.findactive();
		List<AgreementscreensData> datas=new ArrayList<AgreementscreensData>();
		if(masters.size()>0){
			int i=1;
			for(AgreementScreens p:masters){
				if(p.getAgreementTypeMaster().getIsactive()==0){
					AgreementscreensData de=new AgreementscreensData();
					de.setId(p.getId());
					de.setNo(i);
					de.setAid(p.getAgreementTypeMaster().getId());
					de.setAname(p.getAgreementTypeMaster().getAgreementtype());
					de.setViewid(p.getViewid());
					de.setViewname(p.getViewname());
					de.setScreenfor(p.getScreenfor());
					de.setCid(p.getAgreementTypeMaster().getCompanyMaster().getCompanyCode());
					de.setCname(p.getAgreementTypeMaster().getCompanyMaster().getCompanyName());
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
		}
		List<AgreementScreens> masteres = agreementscreensService.findAllInactive();
		List<AgreementscreensData> dataes=new ArrayList<AgreementscreensData>();
		if(masters.size()>0){
			int i=1;
			for(AgreementScreens p:masteres){
				AgreementscreensData de=new AgreementscreensData();
				de.setId(p.getId());
				de.setNo(i);
				de.setAid(p.getAgreementTypeMaster().getId());
				de.setAname(p.getAgreementTypeMaster().getAgreementtype());
				de.setViewid(p.getViewid());
				de.setViewname(p.getViewname());
				de.setScreenfor(p.getScreenfor());
				de.setCid(p.getAgreementTypeMaster().getCompanyMaster().getCompanyCode());
				de.setCname(p.getAgreementTypeMaster().getCompanyMaster().getCompanyName());
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
		model.addAttribute("master", datas);
		model.addAttribute("masters", dataes);
		return "Agreementscreens";
	}
	
	@RequestMapping(value ="synchronizeExcelAgreementscreens",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList synchronizeExcelAgreementscreens(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ReadList rs = new ReadList();
		try {
				List<AgreementScreens> masters = agreementscreensService.findalldata();
				if(masters.size()>0){
					for(AgreementScreens agatt:masters){
						agreementscreensService.delete(agatt);
					}
				}
				AdminMaster au=(AdminMaster) session.getAttribute("user");
				ResourceBundle rss=ResourceBundle.getBundle("com.solusoft.controller.generic");
				String path=rss.getString("Excelpath");	
				FileInputStream file = new FileInputStream(new File(path));
	            POIFSFileSystem fs = new POIFSFileSystem(file);  
	            HSSFWorkbook wb = new HSSFWorkbook(fs);  
	            HSSFSheet sheet = wb.getSheet(rss.getString("AgreementScreens"));  
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
		            	    	List<AgreementTypeMaster> data = agreementTypeServicer.findAgreementType(String.valueOf(row.getCell(0).getRichStringCellValue()).toUpperCase().trim());
		            	    	if(data.size()>0){
		            	    		for(AgreementTypeMaster a:data){
		            	    			AgreementScreens as=new AgreementScreens();
		            	    			as.setAgreementTypeMaster(a);
		            	    			as.setViewid(String.valueOf(row.getCell(1).getRichStringCellValue()).trim());
		            	    			as.setViewname(String.valueOf(row.getCell(2).getRichStringCellValue()).trim());
		            	    			as.setScreenfor(String.valueOf(row.getCell(3).getRichStringCellValue()).trim());
		            	    			as.setIsactive((int)Math.round(row.getCell(4).getNumericCellValue()));
		            	    			as.setCreatedBy(au.getUsername());
					                	as.setCreatedDate(new Timestamp(new Date().getTime()));
					                	AgreementScreens save=agreementscreensService.savedata(as);
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
				                	rs.setMessage("Please enter the correct entries in the excel data. Agreement Type is wrong :-- "  + j);
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
				agreementscreensService.saves(de);
		}
		return rs;
	}
	
	@RequestMapping(value ="rs/getAgreementScreenActive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<AgreementscreensData> getAgreementScreen(Model model){
		List<AgreementScreens> masters = agreementscreensService.findactive();
		List<AgreementscreensData> datas=new ArrayList<AgreementscreensData>();
		if(masters.size()>0){
			int i=1;
			for(AgreementScreens p:masters){
				if(p.getAgreementTypeMaster().getIsactive()==0){
					AgreementscreensData de=new AgreementscreensData();
					de.setId(p.getId());
					de.setNo(i);
					de.setAid(p.getAgreementTypeMaster().getId());
					de.setAname(p.getAgreementTypeMaster().getAgreementtype());
					de.setViewid(p.getViewid());
					de.setViewname(p.getViewname());
					de.setScreenfor(p.getScreenfor());
					de.setCid(p.getAgreementTypeMaster().getCompanyMaster().getCompanyCode());
					de.setCname(p.getAgreementTypeMaster().getCompanyMaster().getCompanyName());
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
		}
		return datas;
	}
	
	@RequestMapping(value ="rs/getAgreementScreenInActive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<AgreementscreensData> getAgreementScreenInActive(Model model){
		List<AgreementScreens> masters = agreementscreensService.findAllInactive();
		List<AgreementscreensData> datas=new ArrayList<AgreementscreensData>();
		if(masters.size()>0){
			int i=1;
			for(AgreementScreens p:masters){
				AgreementscreensData de=new AgreementscreensData();
				de.setId(p.getId());
				de.setNo(i);
				de.setAid(p.getAgreementTypeMaster().getId());
				de.setAname(p.getAgreementTypeMaster().getAgreementtype());
				de.setViewid(p.getViewid());
				de.setViewname(p.getViewname());
				de.setScreenfor(p.getScreenfor());
				de.setCid(p.getAgreementTypeMaster().getCompanyMaster().getCompanyCode());
				de.setCname(p.getAgreementTypeMaster().getCompanyMaster().getCompanyName());
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
	
	@RequestMapping(value ="activeagreementscreens",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList activeagreementscreens(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		return agreementscreensService.activeId(id,au.getUsername());
		
	}
	
	@RequestMapping(value ="deleteagreementscreens",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList deleteagreementscreens(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		return agreementscreensService.deleteId(id,au.getUsername());
		
	}
	
	@RequestMapping(value ="updateAgreementscreen",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList update(@RequestParam (value="Id",required=true) Integer id,
			@RequestParam (value="Agid",required=true) Integer aid,@RequestParam (value="Viewid",required=true) String vid,
			@RequestParam (value="Viewname",required=true) String viewname,@RequestParam (value="Scrfor",required=true) String scrfor,
			Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		viewname=viewname.replaceAll(" bhai ", "&");
		scrfor=scrfor.replaceAll(" bhai ", "&");
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		List<AgreementScreens> dcs=agreementscreensService.findNameInactive(aid,vid.toUpperCase(),viewname.toUpperCase(),scrfor.toUpperCase());
		List<AgreementScreens> dc=agreementscreensService.findNameActive(aid,vid.toUpperCase(),viewname.toUpperCase(),scrfor.toUpperCase());
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		if(dc.size()>=2){
			  rs.setSuccess(false);
			  rs.setMessage("Agreement screens already exists in active list");
			  return rs;
		}else if(dcs.size()>=2){
			  rs.setMessage("Agreement screens already exists in inactive list");
			  rs.setSuccess(false);
			  return rs;
		}else if(dc.size()>=1){
			for(AgreementScreens dcss:dc){
				if(dcss.getId().equals(id)){
					rs=agreementscreensService.updates(id,aid,vid,viewname,scrfor,au.getUsername());
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Agreement screens already exits in active list");
					return rs;
				}
		   }
		}else if(dcs.size()>=1){
			for(AgreementScreens dcss:dcs){
				if(dcss.getId().equals(id)){
					rs=agreementscreensService.updates(id,aid,vid,viewname,scrfor,au.getUsername());
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Agreement screens already exists in inactive list");
					return rs;
				}
		   }
		}else{
		  rs=agreementscreensService.updates(id,aid,vid,viewname,scrfor,au.getUsername());
		  return rs;
		}
		return rs;
	}
	
	@RequestMapping(value ="insertAgreementscreen",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList insert(@RequestParam (value="Agid",required=true) Integer aid,@RequestParam (value="Viewid",required=true) String vid,
					@RequestParam (value="Viewname",required=true) String viewname,@RequestParam (value="Scrfor",required=true) String scrfor,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		viewname=viewname.replaceAll(" bhai ", "&");
		scrfor=scrfor.replaceAll(" bhai ", "&");
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		List<AgreementScreens> dcs=agreementscreensService.findNameInactive(aid,vid.toUpperCase(),viewname.toUpperCase(),scrfor.toUpperCase());
		List<AgreementScreens> dc=agreementscreensService.findNameActive(aid,vid.toUpperCase(),viewname.toUpperCase(),scrfor.toUpperCase());
		ReadList rs = new ReadList();
		if(dc.size()>=1){
			rs.setSuccess(false);
			rs.setMessage("Agreement screens already exists in active list");
			return rs;
		}else if(dcs.size()>=1){
			rs.setMessage("Agreement screens already exists in inactive list");
			rs.setSuccess(false);
			return rs;
		}else{
			ReadList rss = new ReadList();
			rss=agreementscreensService.save(aid,vid,viewname,scrfor,au.getUsername());
			return rss;
		}
	}
	
	@RequestMapping(value ="rs/screenFor",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<AgreementscreensData> screenFor(Model model){
		List<AgreementscreensData> datas=new ArrayList<AgreementscreensData>();
		ResourceBundle rss=ResourceBundle.getBundle("com.solusoft.controller.generic");
		String path=rss.getString("AGR_TYPE_SCREEN_FOR");	
		String[] out = path.split(";");
		for(String s:out){
			AgreementscreensData a=new AgreementscreensData();
			a.setScreenfor(s);
			datas.add(a);
		}
		return datas;
	}
}