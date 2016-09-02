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

import com.solusoft.jpa.AgreementData;
import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.AdminMaster;
import com.solusoft.jpa.entity.AgreementTypeMaster;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.CompanyMaster;
import com.solusoft.services.AgreementTypeServicer;
import com.solusoft.services.CompanyService;

@Controller
public class AgreementTypeController {

	@Autowired
	AgreementTypeServicer agreementTypeServicer;
	
	@Autowired
	CompanyService companyService;
	
	private static final String tabName="AGREEMENT_TYPE";
	
	private static final Logger logger = LoggerFactory
			.getLogger(AgreementTypeController.class);
	
	@RequestMapping(value = "/agreementType", method = RequestMethod.GET)
	public String agreementType(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GET:/ All Agreement type Data...");
		List<AgreementTypeMaster> masters = agreementTypeServicer.findAll();
		List<AgreementData> datas=new ArrayList<AgreementData>();
		if(masters.size()>0){
			int i=1;
			for(AgreementTypeMaster p:masters){
				AgreementData de=new AgreementData();
				de.setId(p.getId());
				de.setNo(i);
				de.setName(p.getAgreementtype());
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
		
		List<AgreementTypeMaster> masteres = agreementTypeServicer.findAllInactive();
		List<AgreementData> dataes=new ArrayList<AgreementData>();
		if(masteres.size()>0){
			int i=1;
			for(AgreementTypeMaster p:masteres){
				AgreementData de=new AgreementData();
				de.setId(p.getId());
				de.setNo(i);
				de.setName(p.getAgreementtype());
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
		model.addAttribute("master", datas);
		model.addAttribute("masters", dataes);
		return "AgreementType";
		
	}
	
	@RequestMapping(value ="rs/getagreeactive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<AgreementData> getagreeactive(Model model){
		List<AgreementTypeMaster> masters = agreementTypeServicer.findAll();
		List<AgreementData> datas=new ArrayList<AgreementData>();
		if(masters.size()>0){
			int i=1;
			for(AgreementTypeMaster p:masters){
				AgreementData de=new AgreementData();
				de.setId(p.getId());
				de.setNo(i);
				de.setName(p.getAgreementtype());
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
	
	@RequestMapping(value ="rs/getagreeinactive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<AgreementData> getagreeinactive(Model model){
		List<AgreementTypeMaster> masteres = agreementTypeServicer.findAllInactive();
		List<AgreementData> dataes=new ArrayList<AgreementData>();
		if(masteres.size()>0){
			int i=1;
			for(AgreementTypeMaster p:masteres){
				AgreementData de=new AgreementData();
				de.setId(p.getId());
				de.setNo(i);
				de.setName(p.getAgreementtype());
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
	
	@RequestMapping(value ="activeIdagree",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList activeIdagree(@RequestParam (value="ID",required=true) Integer id,
						  Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		return agreementTypeServicer.activeId(id,au.getUsername());
		
	}
	
	@RequestMapping(value ="deleteAgreementType",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList DeleteMaster(@RequestParam (value="ID",required=true) Integer id,
						  Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		return agreementTypeServicer.delete(id,au.getUsername());
		
	}
	
	@RequestMapping(value ="updateAgreementType",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList UpdateMasters(@RequestParam (value="ID",required=true) Integer id,
					 	   @RequestParam (value="Com",required=true) Integer cid,
					 	   @RequestParam (value="Aname",required=true) String name,
					 	   Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		name=name.replaceAll(" bhai ", "&");
		List<AgreementTypeMaster> dc=agreementTypeServicer.findNameActive(name.toUpperCase(),cid);
		List<AgreementTypeMaster> dcs=agreementTypeServicer.findNameInactive(name.toUpperCase(),cid);
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		if(dc.size()>=2){
			  rs.setSuccess(false);
			  rs.setMessage("Agreement type already exists in active list");
			  return rs;
		}else if(dcs.size()>=2){
			  rs.setMessage("Agreement type already exists in inactive list");
			  rs.setSuccess(false);
			  return rs;
		}else if(dc.size()>=1){
			for(AgreementTypeMaster dcss:dc){
				if(dcss.getId().equals(id)){
					rs=agreementTypeServicer.updates(id,name,cid,au.getUsername());
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Agreement type already exits in active list");
					return rs;
				}
		   }
		}else if(dcs.size()>=1){
			for(AgreementTypeMaster dcss:dcs){
				if(dcss.getId().equals(id)){
					rs=agreementTypeServicer.updates(id,name,cid,au.getUsername());
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Agreement type already exists in inactive list");
					return rs;
				}
		   }
		}else{
		  rs=agreementTypeServicer.updates(id,name,cid,au.getUsername());
		  return rs;
		}
		return rs;
	}
	
	@RequestMapping(value ="insertAgreementType",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList InsertMasteres(@RequestParam (value="Aname",required=true) String name,
					 	    @RequestParam (value="Com",required=true) Integer cid,
					  		Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		name=name.replaceAll(" bhai ", "&");
		List<AgreementTypeMaster> dcs=agreementTypeServicer.findNameActive(name.toUpperCase(),cid);
		List<AgreementTypeMaster> dc=agreementTypeServicer.findNameInactive(name.toUpperCase(),cid);
		ReadList rs = new ReadList();
		if(dc.size()>=1){
			rs.setSuccess(false);
			rs.setMessage("Agreement type already exists in inactive list");
			return rs;
		}else if(dcs.size()>=1){
			rs.setMessage("Agreement type already exists in active list");
			rs.setSuccess(false);
			return rs;
		}else{
			ReadList rss = new ReadList();
			rss=agreementTypeServicer.save(name,cid,au.getUsername());
			return rss;
		}
	}
	
	@RequestMapping(value ="rs/getAgreement",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<AgreementTypeMaster> getAgreement(Model model){
		return agreementTypeServicer.findAll();
	}
	
	@RequestMapping(value ="rs/getAgreementForCompany",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<AgreementTypeMaster> findAllByCompany( @RequestParam (value="Company_name",required=true) Integer cid,
	  							Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		return agreementTypeServicer.findAllByCompany(cid);
	}
	
	@RequestMapping(value ="synchronizeExcelAgreement",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList synchronizeExcelAgreement(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ReadList rs = new ReadList();
		try {
			    AdminMaster au=(AdminMaster) session.getAttribute("user");
				ResourceBundle rss=ResourceBundle.getBundle("com.solusoft.controller.generic");
				String path=rss.getString("Excelpath");	
				FileInputStream file = new FileInputStream(new File(path));
	            POIFSFileSystem fs = new POIFSFileSystem(file);  
	            HSSFWorkbook wb = new HSSFWorkbook(fs);  
	            HSSFSheet sheet = wb.getSheet(rss.getString("Agreement")); 
	            HSSFRow row; 
	            int j=2;
	            if(sheet.getLastRowNum()>0){
		            for(int i=1; i<=sheet.getLastRowNum(); i++)
		            	{  
		            	row = sheet.getRow(i);  
		            	Cell ce1 = row.getCell(0);
	            	    Cell ce2 = row.getCell(1);
		                if(ce1 != null && ce1.getCellType() != Cell.CELL_TYPE_BLANK && ce2 != null && ce2.getCellType() != Cell.CELL_TYPE_BLANK){
		                	CompanyMaster co=companyService.findId((int)Math.round(row.getCell(0).getNumericCellValue()));
		                	if(co!=null){
		                		AgreementTypeMaster ae=agreementTypeServicer.finddetail(co,String.valueOf(row.getCell(1).getRichStringCellValue()).trim());
			                	if(ae!=null){
		                			ae.setCompanyMaster(co);
			                		ae.setAgreementtype(String.valueOf(row.getCell(1).getRichStringCellValue()).trim());
			                		ae.setCreatedBy(au.getUsername());
			                		ae.setCreatedDate(new Timestamp(new Date().getTime()));
			                		ae.setIsactive(0);
			                		AgreementTypeMaster save=agreementTypeServicer.saves(ae);
	 		                		if(save.getId()>0){
		 			                	rs.setSuccess(true);
		 			                }else{
		 			                	rs.setSuccess(false);
		 			                	rs.setMessage("Error updated record" + j);
		 			                	return rs;
		 			                }
			                	}else{
			                		AgreementTypeMaster de=new AgreementTypeMaster();
				            	    de.setCompanyMaster(co);
			                		de.setAgreementtype(String.valueOf(row.getCell(1).getRichStringCellValue()).trim());
			                		de.setCreatedBy(au.getUsername());
	 		                		de.setCreatedDate(new Timestamp(new Date().getTime()));
	 		                		de.setIsactive(0);
			                		AgreementTypeMaster save=agreementTypeServicer.saves(de);
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
		                		rs.setMessage("Please enter the correct entries in the excel data. Company name is not available in Company master :-- "  + j);
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
			agreementTypeServicer.intse(de);
	    }
	 return rs;
	}
	
}