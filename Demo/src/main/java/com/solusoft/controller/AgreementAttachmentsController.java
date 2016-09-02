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

import com.solusoft.jpa.AgreementAttachmentsData;
import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.AdminMaster;
import com.solusoft.jpa.entity.AgreementAttachments;
import com.solusoft.jpa.entity.AgreementTypeMaster;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.services.AgreementAttachmentsService;
import com.solusoft.services.AgreementTypeServicer;

@Controller
public class AgreementAttachmentsController {

	@Autowired
	AgreementAttachmentsService agreementAttachmentsService;
	
	@Autowired
	AgreementTypeServicer agreementTypeServicer;
	
	private static final String tabName="AGREEMENT_ATTACHMENTS";
	
	private static final Logger logger = LoggerFactory.getLogger(AgreementAttachmentsController.class);
	
	@RequestMapping(value = "/agreementattachments", method = RequestMethod.GET)
	public String agreementattachments(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All agreement attachments Data...");
		List<AgreementAttachments> masters = agreementAttachmentsService.findactive();
		List<AgreementAttachmentsData> datas=new ArrayList<AgreementAttachmentsData>();
		if(masters.size()>0){
			int i=1;
			for(AgreementAttachments p:masters){
				if(p.getAgreementTypeMaster().getIsactive()==0){
					AgreementAttachmentsData de=new AgreementAttachmentsData();
					de.setId(p.getId());
					de.setNo(i);
					de.setAid(p.getAgreementTypeMaster().getId());
					de.setAname(p.getAgreementTypeMaster().getAgreementtype());
					de.setDocclass(p.getDocclass());
					de.setDoctype(p.getDoctype());
					de.setAtclass(p.getAtclass());
					de.setMandadory(p.getMandadory());
					de.setMandadorydom(p.getMandadorydom());
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
		List<AgreementAttachments> masteres = agreementAttachmentsService.findAllInactive();
		List<AgreementAttachmentsData> dataes=new ArrayList<AgreementAttachmentsData>();
		if(masters.size()>0){
			int i=1;
			for(AgreementAttachments p:masteres){
					AgreementAttachmentsData de=new AgreementAttachmentsData();
					de.setId(p.getId());
					de.setNo(i);
					de.setAid(p.getAgreementTypeMaster().getId());
					de.setAname(p.getAgreementTypeMaster().getAgreementtype());
					de.setDocclass(p.getDocclass());
					de.setDoctype(p.getDoctype());
					de.setAtclass(p.getAtclass());
					de.setMandadory(p.getMandadory());
					de.setMandadorydom(p.getMandadorydom());
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
		return "Agreementattachments";
	}
	
	@RequestMapping(value ="synchronizeExcelAgreementAttachments",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList synchronizeExcelAgreementAttachments(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ReadList rs = new ReadList();
		try {
				List<AgreementAttachments> masters = agreementAttachmentsService.findalldata();
				if(masters.size()>0){
					for(AgreementAttachments agatt:masters){
						agreementAttachmentsService.delete(agatt);
						
					}
				}
				AdminMaster au=(AdminMaster) session.getAttribute("user");
				ResourceBundle rss=ResourceBundle.getBundle("com.solusoft.controller.generic");
				String path=rss.getString("Excelpath");	
				FileInputStream file = new FileInputStream(new File(path));
	            POIFSFileSystem fs = new POIFSFileSystem(file);  
	            HSSFWorkbook wb = new HSSFWorkbook(fs);  
	            HSSFSheet sheet = wb.getSheet(rss.getString("AgreementAttachments"));  
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
		            	    Cell ce6 = row.getCell(5);
		            	    Cell ce7 = row.getCell(6);
		            	    if(ce1 != null && ce1.getCellType() != Cell.CELL_TYPE_BLANK && ce2 != null && ce2.getCellType() != Cell.CELL_TYPE_BLANK && ce4 != null && ce4.getCellType() != Cell.CELL_TYPE_BLANK && ce5 != null && ce5.getCellType() != Cell.CELL_TYPE_BLANK && ce6 != null && ce6.getCellType() != Cell.CELL_TYPE_BLANK && ce7 != null && ce7.getCellType() != Cell.CELL_TYPE_BLANK){
		            	    	List<AgreementTypeMaster> data = agreementTypeServicer.findAgreementType(String.valueOf(row.getCell(0).getRichStringCellValue()).toUpperCase().trim());
		            	    	if(data.size()>0){
		            	    		for(AgreementTypeMaster a:data){
		            	    			AgreementAttachments as=new AgreementAttachments();
		            	    			as.setAgreementTypeMaster(a);
		            	    			as.setDocclass(String.valueOf(row.getCell(1).getRichStringCellValue()).trim());
		            	    			if(ce3 != null && ce1.getCellType() != Cell.CELL_TYPE_BLANK && ce3 != null){
		            	    				as.setDoctype(String.valueOf(row.getCell(2).getRichStringCellValue()).trim());
		            	    			}else{
		            	    				as.setDoctype("");
		            	    			}
		            	    			if((int)Math.round(row.getCell(3).getNumericCellValue())==0){
		            	    				as.setAtclass(false);
		            	    			}else{
		            	    				as.setAtclass(true);
		            	    			}
		            	    			if((int)Math.round(row.getCell(4).getNumericCellValue())==0){
		            	    				as.setMandadory(false);
		            	    			}else{
		            	    				as.setMandadory(true);
		            	    			}
		            	    			if((int)Math.round(row.getCell(5).getNumericCellValue())==0){
		            	    				as.setMandadorydom(false);
		            	    			}else{
		            	    				as.setMandadorydom(true);
		            	    			}
		            	    			as.setIsactive((int)Math.round(row.getCell(6).getNumericCellValue()));
		            	    			as.setCreatedBy(au.getUsername());
					                	as.setCreatedDate(new Timestamp(new Date().getTime()));
					                	AgreementAttachments save=agreementAttachmentsService.savedata(as);
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
				agreementAttachmentsService.saves(de);
		}
		return rs;
	}
	
	@RequestMapping(value ="rs/getActiveAgreementattachments",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<AgreementAttachmentsData> getActiveAgreementattachments(Model model){
		List<AgreementAttachments> masters = agreementAttachmentsService.findactive();
		List<AgreementAttachmentsData> datas=new ArrayList<AgreementAttachmentsData>();
		if(masters.size()>0){
			int i=1;
			for(AgreementAttachments p:masters){
				if(p.getAgreementTypeMaster().getIsactive()==0){
					AgreementAttachmentsData de=new AgreementAttachmentsData();
					de.setId(p.getId());
					de.setNo(i);
					de.setAid(p.getAgreementTypeMaster().getId());
					de.setAname(p.getAgreementTypeMaster().getAgreementtype());
					de.setDocclass(p.getDocclass());
					de.setDoctype(p.getDoctype());
					de.setAtclass(p.getAtclass());
					de.setMandadory(p.getMandadory());
					de.setMandadorydom(p.getMandadorydom());
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
	
	@RequestMapping(value ="rs/getInActiveAgreementattachments",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<AgreementAttachmentsData> getInActiveAgreementattachments(Model model){
		List<AgreementAttachments> masters = agreementAttachmentsService.findAllInactive();
		List<AgreementAttachmentsData> datas=new ArrayList<AgreementAttachmentsData>();
		if(masters.size()>0){
			int i=1;
			for(AgreementAttachments p:masters){
					AgreementAttachmentsData de=new AgreementAttachmentsData();
					de.setId(p.getId());
					de.setNo(i);
					de.setAid(p.getAgreementTypeMaster().getId());
					de.setAname(p.getAgreementTypeMaster().getAgreementtype());
					de.setDocclass(p.getDocclass());
					de.setDoctype(p.getDoctype());
					de.setAtclass(p.getAtclass());
					de.setMandadory(p.getMandadory());
					de.setMandadorydom(p.getMandadorydom());
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
	
	@RequestMapping(value ="activeagreementattachments",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList activeagreementattachments(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		return agreementAttachmentsService.activeId(id,au.getUsername());
		
	}
	
	@RequestMapping(value ="deleteagreementattachments",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList deleteagreementattachments(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		return agreementAttachmentsService.deleteId(id,au.getUsername());
		
	}
	
	@RequestMapping(value ="insertAgreementattachment",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList insert(@RequestParam (value="Agid",required=true) Integer aid,
			        @RequestParam (value="Docc",required=true) String docc,
					@RequestParam (value="Doct",required=true) String doct,
					@RequestParam (value="Iatc",required=true) Boolean iatc,
					@RequestParam (value="Im",required=true) Boolean im,
					@RequestParam (value="Imd",required=true) Boolean imd,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		docc=docc.replaceAll(" bhai ", "&");
		doct=doct.replaceAll(" bhai ", "&");
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		List<AgreementAttachments> dcs=agreementAttachmentsService.findNameInactive(aid,docc.toUpperCase(),doct.toUpperCase(),iatc,im,imd);
		List<AgreementAttachments> dc=agreementAttachmentsService.findNameActive(aid,docc.toUpperCase(),doct.toUpperCase(),iatc,im,imd);
		ReadList rs = new ReadList();
		if(dc.size()>=1){
			rs.setSuccess(false);
			rs.setMessage("Agreement attachments already exists in active list");
			return rs;
		}else if(dcs.size()>=1){
			rs.setMessage("Agreement attachments already exists in inactive list");
			rs.setSuccess(false);
			return rs;
		}else{
			ReadList rss = new ReadList();
			rss=agreementAttachmentsService.save(aid,docc,doct,iatc,im,imd,au.getUsername());
			return rss;
		}
	}
	
	@RequestMapping(value ="updateAgreementattachment",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList update(@RequestParam (value="Id",required=true) Integer id,
					@RequestParam (value="Agid",required=true) Integer aid,
			        @RequestParam (value="Docc",required=true) String docc,
					@RequestParam (value="Doct",required=true) String doct,
					@RequestParam (value="Iatc",required=true) Boolean iatc,
					@RequestParam (value="Im",required=true) Boolean im,
					@RequestParam (value="Imd",required=true) Boolean imd,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		docc=docc.replaceAll(" bhai ", "&");
		doct=doct.replaceAll(" bhai ", "&");
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		List<AgreementAttachments> dcs=agreementAttachmentsService.findNameInactive(aid,docc.toUpperCase(),doct.toUpperCase(),iatc,im,imd);
		List<AgreementAttachments> dc=agreementAttachmentsService.findNameActive(aid,docc.toUpperCase(),doct.toUpperCase(),iatc,im,imd);
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		if(dc.size()>=2){
			  rs.setSuccess(false);
			  rs.setMessage("Agreement attachments already exists in active list");
			  return rs;
		}else if(dcs.size()>=2){
			  rs.setMessage("Agreement attachments already exists in inactive list");
			  rs.setSuccess(false);
			  return rs;
		}else if(dc.size()>=1){
			for(AgreementAttachments dcss:dc){
				if(dcss.getId().equals(id)){
					rs=agreementAttachmentsService.updates(id,aid,docc,doct,iatc,im,imd,au.getUsername());
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Agreement attachments already exits in active list");
					return rs;
				}
		   }
		}else if(dcs.size()>=1){
			for(AgreementAttachments dcss:dcs){
				if(dcss.getId().equals(id)){
					rs=agreementAttachmentsService.updates(id,aid,docc,doct,iatc,im,imd,au.getUsername());
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Agreement attachments already exists in inactive list");
					return rs;
				}
		   }
		}else{
		  rs=agreementAttachmentsService.updates(id,aid,docc,doct,iatc,im,imd,au.getUsername());
		  return rs;
		}
		return rs;
	}
	
}