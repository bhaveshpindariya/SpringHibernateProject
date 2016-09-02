
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

import com.solusoft.jpa.EmpVerData;
import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.AdminMaster;
import com.solusoft.jpa.entity.AgreementTypeMaster;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.CompanyMaster;
import com.solusoft.jpa.entity.EmpVerticalMaster;
import com.solusoft.jpa.entity.EmployeeMaster;
import com.solusoft.jpa.entity.VerticalMaster;
import com.solusoft.services.AgreementTypeServicer;
import com.solusoft.services.CompanyService;
import com.solusoft.services.EmpVerService;
import com.solusoft.services.EmployeeService;
import com.solusoft.services.VerticalService;


@Controller
public class EmployeeVerController {

	@Autowired
	EmpVerService empVerService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	VerticalService verticalService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	AgreementTypeServicer agreementTypeServicer;
	
	private static final String tabName="AGR_VERTICAL_LEGAL_MANAGER";
	
	private static final Logger logger = LoggerFactory
			.getLogger(EmployeeVerController.class);
	
	@RequestMapping(value = "/EmployeeVerdetail", method = RequestMethod.GET)
	public String EmployeeSitedetail(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("Get:/ All Vertical Legal Manager Data...");
		
		List<EmpVerticalMaster> masters = empVerService.findAll();
		List<EmpVerData> datas=new ArrayList<EmpVerData>();
		if(masters.size()>0){
			int i=1;
			for(EmpVerticalMaster p:masters){
				if(p.getVerticalMaster().getIsactive()==0 && p.getAgreementTypeMaster().getIsactive()==0){
					EmpVerData de=new EmpVerData();
					de.setNo(i);
					de.setId(p.getId());
					de.setVid(p.getVerticalMaster().getId());
					de.setVname(p.getVerticalMaster().getVname());
					de.setEid(p.getEmployeeMaster().getEmpid());
					de.setEname(p.getEmployeeMaster().getName());
					de.setCid(p.getEmployeeMaster().getCompanycode().getCompanyCode());
					de.setCname(p.getEmployeeMaster().getCompanycode().getCompanyName());
					de.setAid(p.getAgreementTypeMaster().getId());
					de.setAname(p.getAgreementTypeMaster().getAgreementtype());
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
		
		List<EmpVerticalMaster> masteres = empVerService.findAllInactive();
		List<EmpVerData> dataes=new ArrayList<EmpVerData>();
		if(masteres.size()>0){
			int i=1;
			for(EmpVerticalMaster p:masteres){
				    EmpVerData de=new EmpVerData();
					de.setNo(i);
					de.setId(p.getId());
					de.setVid(p.getVerticalMaster().getId());
					de.setVname(p.getVerticalMaster().getVname());
					de.setEid(p.getEmployeeMaster().getEmpid());
					de.setEname(p.getEmployeeMaster().getName());
					de.setCid(p.getEmployeeMaster().getCompanycode().getCompanyCode());
					de.setCname(p.getEmployeeMaster().getCompanycode().getCompanyName());
					de.setAid(p.getAgreementTypeMaster().getId());
					de.setAname(p.getAgreementTypeMaster().getAgreementtype());
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
		return "VerticalLegalManager";
	}
	
	
	@RequestMapping(value ="rs/getagreelegalactive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<EmpVerData> getagreelegalactive(Model model){
		List<EmpVerticalMaster> masters = empVerService.findAll();
		List<EmpVerData> datas=new ArrayList<EmpVerData>();
		if(masters.size()>0){
			int i=1;
			for(EmpVerticalMaster p:masters){
				if(p.getVerticalMaster().getIsactive()==0 && p.getAgreementTypeMaster().getIsactive()==0){
					EmpVerData de=new EmpVerData();
					de.setNo(i);
					de.setId(p.getId());
					de.setVid(p.getVerticalMaster().getId());
					de.setVname(p.getVerticalMaster().getVname());
					de.setEid(p.getEmployeeMaster().getEmpid());
					de.setEname(p.getEmployeeMaster().getName());
					de.setCid(p.getEmployeeMaster().getCompanycode().getCompanyCode());
					de.setCname(p.getEmployeeMaster().getCompanycode().getCompanyName());
					de.setAid(p.getAgreementTypeMaster().getId());
					de.setAname(p.getAgreementTypeMaster().getAgreementtype());
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
	
	@RequestMapping(value ="rs/getagreelegalinactive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<EmpVerData> getagreelegalinactive(Model model){
		List<EmpVerticalMaster> masteres = empVerService.findAllInactive();
		List<EmpVerData> dataes=new ArrayList<EmpVerData>();
		if(masteres.size()>0){
			int i=1;
			for(EmpVerticalMaster p:masteres){
				    EmpVerData de=new EmpVerData();
					de.setNo(i);
					de.setId(p.getId());
					de.setVid(p.getVerticalMaster().getId());
					de.setVname(p.getVerticalMaster().getVname());
					de.setEid(p.getEmployeeMaster().getEmpid());
					de.setEname(p.getEmployeeMaster().getName());
					de.setCid(p.getEmployeeMaster().getCompanycode().getCompanyCode());
					de.setCname(p.getEmployeeMaster().getCompanycode().getCompanyName());
					de.setAid(p.getAgreementTypeMaster().getId());
					de.setAname(p.getAgreementTypeMaster().getAgreementtype());
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
	
	@RequestMapping(value ="deleteEmpVid",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Master(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		return empVerService.update(id,au.getUsername());
		
	}
	
	@RequestMapping(value ="activeIdEv",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList activeIdEv(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		return empVerService.activeId(id,au.getUsername());
		
	}
	
	@RequestMapping(value ="updateEmpVid",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Masters(@RequestParam (value="ID",required=true) Integer id,
					 @RequestParam (value="Vid",required=true) Integer vid,
					 @RequestParam (value="Aid",required=true) Integer aid,
					 @RequestParam (value="Emp",required=true) long empId,
					 Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		List<EmpVerticalMaster> dc=empVerService.findNameActive(empId,vid,aid);
		List<EmpVerticalMaster> dcs=empVerService.findNameInactive(empId,vid,aid);
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		if(dc.size()>=2){
			  rs.setSuccess(false);
			  rs.setMessage("Legal managerr already exists in active list");
			  return rs;
		}else if(dcs.size()>=2){
			  rs.setMessage("Legal manager already exists in inactive list");
			  rs.setSuccess(false);
			  return rs;
		}else if(dc.size()>=1){
			for(EmpVerticalMaster dcss:dc){
				if(dcss.getId().equals(id)){
					rs=empVerService.updates(id,empId,vid,aid,au.getUsername());
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Legal manager already exits in active list");
					return rs;
				}
		   }
		}else if(dcs.size()>=1){
			for(EmpVerticalMaster dcss:dcs){
				if(dcss.getId().equals(id)){
					rs=empVerService.updates(id,empId,vid,aid,au.getUsername());
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Legal manager already exists in inactive list");
					return rs;
				}
		   }
		}else{
				rs=empVerService.updates(id,empId,vid,aid,au.getUsername());
				  return rs;
		}
		return rs;
	}
	
	@RequestMapping(value ="insertEmpVid",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Masteres(@RequestParam (value="Vid",required=true) Integer vid,
					  @RequestParam (value="Aid",required=true) Integer aid,
					  @RequestParam (value="Emp",required=true) long empId,
					  Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		List<EmpVerticalMaster> dcs=empVerService.findNameActive(empId,vid,aid);
		List<EmpVerticalMaster> dc=empVerService.findNameInactive(empId,vid,aid);
		ReadList rs = new ReadList();
		if(dc.size()>=1){
			rs.setSuccess(false);
			rs.setMessage("Legal manager already exists in inactive list");
			return rs;
		}else if(dcs.size()>=1){
			rs.setMessage("Legal manager already exists in active list");
			rs.setSuccess(false);
			return rs;
		}else{
			ReadList rss = new ReadList();
			rss=empVerService.save(empId,vid,aid,au.getUsername());
			return rss;
		}
	}
	
	@RequestMapping(value ="synchronizeExcelLegalApprovers",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList synchronizeExcelLegalApprovers(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ReadList rs = new ReadList();
		try {
			    AdminMaster au=(AdminMaster) session.getAttribute("user");
				ResourceBundle rss=ResourceBundle.getBundle("com.solusoft.controller.generic");
				String path=rss.getString("Excelpath");	
				FileInputStream file = new FileInputStream(new File(path));
	            POIFSFileSystem fs = new POIFSFileSystem(file);  
	            HSSFWorkbook wb = new HSSFWorkbook(fs);  
	            HSSFSheet sheet = wb.getSheet(rss.getString("LegalManager")); 
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
		                if(ce1 != null && ce1.getCellType() != Cell.CELL_TYPE_BLANK && ce2 != null && ce2.getCellType() != Cell.CELL_TYPE_BLANK && ce3 != null && ce3.getCellType() != Cell.CELL_TYPE_BLANK && ce4 != null && ce4.getCellType() != Cell.CELL_TYPE_BLANK){
		                	CompanyMaster co=companyService.findId((int)Math.round(row.getCell(0).getNumericCellValue()));
		                	if(co!=null){
		                		AgreementTypeMaster aes=agreementTypeServicer.finddetail(co,String.valueOf(row.getCell(1).getRichStringCellValue()).trim());
			                	if(aes!=null){
		                			VerticalMaster ver=verticalService.findName(String.valueOf(row.getCell(2).getRichStringCellValue()).trim().toUpperCase());
		                			if(ver!=null){
		                					EmployeeMaster em=employeeService.findName(String.valueOf(row.getCell(3).getRichStringCellValue()).trim().toUpperCase());
				                			if(em!=null){
				                					EmpVerticalMaster dcs=empVerService.finddata(em.getEmpid(),ver.getId(),aes.getId());
				                					if(dcs!=null){
				                						dcs.setAgreementTypeMaster(aes);
				                						dcs.setEmployeeMaster(em);
				                						dcs.setVerticalMaster(ver);
				                						dcs.setCreatedBy(au.getUsername());
				                						dcs.setCreatedDate(new Timestamp(new Date().getTime()));
				                						dcs.setIsactive(0);
						                				EmpVerticalMaster save=empVerService.saves(dcs);
							 		                	if(save.getId()>0){
								 			                rs.setSuccess(true);
								 			            }else{
								 			                rs.setSuccess(false);
								 			                rs.setMessage("Error updated record" + j);
								 			                return rs;
								 			            }
				                					}else{
				                						EmpVerticalMaster vfm=new EmpVerticalMaster();
					                					vfm.setAgreementTypeMaster(aes);
					                					vfm.setEmployeeMaster(em);
					                					vfm.setVerticalMaster(ver);
					                					vfm.setCreatedBy(au.getUsername());
					                					vfm.setCreatedDate(new Timestamp(new Date().getTime()));
					                					vfm.setIsactive(0);
					                					EmpVerticalMaster save=empVerService.saves(vfm);
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
						                		rs.setMessage("Please enter the correct entries in the excel data. Other approvers is not available in Employee master :-- "  + j);
							                	return rs;
				                			}
				                	}else{
		                				rs.setSuccess(false);
				                		rs.setMessage("Please enter the correct entries in the excel data. Vertical is not available in Vertical master :-- "  + j);
					                	return rs;
		                			}
			                	}else{
			                		rs.setSuccess(false);
			                		rs.setMessage("Please enter the correct entries in the excel data. Agreement type is not available in Agreement type :-- "  + j);
				                	return rs;
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
			agreementTypeServicer.intse(de);
	    }
	 return rs;
	}
}