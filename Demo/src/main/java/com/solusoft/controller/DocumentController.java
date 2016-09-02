package com.solusoft.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.solusoft.jpa.Doctcom;
import com.solusoft.jpa.Doctypes;
import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.AdminMaster;
import com.solusoft.jpa.entity.DocTypeMaster;
import com.solusoft.jpa.entity.DocumentCompnydetail;
import com.solusoft.services.DocumentCompnyService;
import com.solusoft.services.DocumentServicer;

@Controller
public class DocumentController {

	@Autowired
	DocumentServicer documentServicer;
	
	@Autowired
	DocumentCompnyService documentCompnyService;
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(DocumentController.class);
	
	@RequestMapping(value = "/docType", method = RequestMethod.GET)
	public String docType(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GEt:/ All Document type Data...");
		
		List<DocTypeMaster> masters = documentServicer.findAll();
		List<Doctypes> datas=new ArrayList<Doctypes>();
		if(masters.size()>0){
			int i=1;
			for(DocTypeMaster p:masters){
				Doctypes de=new Doctypes();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getDetais());
				de.setDocname(p.getDoname());
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
		
		List<DocTypeMaster> masteres = documentServicer.findAllInactive();
		List<Doctypes> dataes=new ArrayList<Doctypes>();
		if(masteres.size()>0){
			int i=1;
			for(DocTypeMaster p:masteres){
				Doctypes de=new Doctypes();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getDetais());
				de.setDocname(p.getDoname());
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
		return "DocumentTypeMasters";
		
	}
	
	@RequestMapping(value ="rs/getdocActive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<Doctypes> getprintActive(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		List<DocTypeMaster> masters = documentServicer.findAll();
		List<Doctypes> datas=new ArrayList<Doctypes>();
		if(masters.size()>0){
			int i=1;
			for(DocTypeMaster p:masters){
				Doctypes de=new Doctypes();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getDetais());
				de.setDocname(p.getDoname());
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
	
	@RequestMapping(value ="rs/getdocInActive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<Doctypes> getprintInActive(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		List<DocTypeMaster> masteres = documentServicer.findAllInactive();
		List<Doctypes> dataes=new ArrayList<Doctypes>();
		if(masteres.size()>0){
			int i=1;
			for(DocTypeMaster p:masteres){
				Doctypes de=new Doctypes();
				de.setNo(i);
				de.setId(p.getId());
				de.setName(p.getDetais());
				de.setDocname(p.getDoname());
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
	
	@RequestMapping(value ="deleteDoc",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Master(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		return documentServicer.update(id,au.getUsername());
		
	}
	
	@RequestMapping(value ="activeIdDoc",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList activeIdDoc(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		return documentServicer.activeId(id,au.getUsername());
		
	}
	
	@RequestMapping(value ="updateDoc",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Masters(@RequestParam (value="ID",required=true) Integer id,
					@RequestParam (value="Name",required=true) String detail,
					@RequestParam (value="Docnames",required=true) String docnames,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		List<DocTypeMaster> dc=documentServicer.findNameActive(detail.toUpperCase(),docnames.toUpperCase());
		List<DocTypeMaster> dcs=documentServicer.findNameInactive(detail.toUpperCase(),docnames.toUpperCase());
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		if(dc.size()>=2){
			  rs.setSuccess(false);
			  rs.setMessage("Document already exists in active list or active list");
			  return rs;
		}else if(dcs.size()>=2){
			 rs.setMessage("Document already exists in active list or inactive list");
			 rs.setSuccess(false);
			 return rs;
		}else if(dc.size()>=1){
			for(DocTypeMaster dcss:dc){
				if(dcss.getId().equals(id)){
					rs=documentServicer.updates(id,detail,au.getUsername(),docnames);
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Document already exists in active list or active list");
					return rs;
				}
		   }
		}else if(dcs.size()>=1){
			for(DocTypeMaster dcss:dcs){
				if(dcss.getId().equals(id)){
					rs=documentServicer.updates(id,detail,au.getUsername(),docnames);
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Document already exists in active list or inactive list");
					return rs;
				}
		   }
		}else{
			rs=documentServicer.updates(id,detail,au.getUsername(),docnames);
			return rs;
		}
		return rs;
		
	}
	
	@RequestMapping(value ="insertDoc",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList Masteres(@RequestParam (value="Name",required=true) String detail,
					  @RequestParam (value="Docnames",required=true) String docnames,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		List<DocTypeMaster> dcs=documentServicer.findNameActive(detail.toUpperCase(),docnames.toUpperCase());
		List<DocTypeMaster> dc=documentServicer.findNameInactive(detail.toUpperCase(),docnames.toUpperCase());
		ReadList rs = new ReadList();
		if(dc.size()>=1){
			rs.setSuccess(false);
			rs.setMessage("Document already exists in active list or inactive list");
			return rs;
		}else if(dcs.size()>=1){
			rs.setMessage("Document already exists in active list or active list");
			rs.setSuccess(false);
			return rs;
		}else{
			ReadList rss = new ReadList();
			rss=documentServicer.save(detail,au.getUsername(),docnames);
			return rss;
		}
	}
	
	//document and custome depart
	
	@RequestMapping(value ="rs/getDoc",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<DocTypeMaster> getDoc(Model model){
		return documentServicer.findAll();
	}
	

	//document and company mapping only R&d 
	
	@RequestMapping(value = "/docComType", method = RequestMethod.GET)
	public String docComType(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		logger.info("GEt:/ All Document Company Data...");
		
		List<DocumentCompnydetail> masters = documentCompnyService.findAll();
		List<Doctcom> datas=new ArrayList<Doctcom>();
		if(masters.size()>0){
			int i=1;
			for(DocumentCompnydetail p:masters){
				if(p.getDocumentid().getIsactive()==0 ){
					Doctcom de=new Doctcom();
					de.setNo(i);
					de.setId(p.getId());
					de.setCcode(p.getCompanyMaster().getCompanyCode());
					de.setCname(p.getCompanyMaster().getCompanyName());
					de.setDid(p.getDocumentid().getId());
					de.setDocname(p.getDocumentid().getDetais());
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
		
		List<DocumentCompnydetail> masteres = documentCompnyService.findAllInactive();
		List<Doctcom> dataes=new ArrayList<Doctcom>();
		if(masteres.size()>0){
			int i=1;
			for(DocumentCompnydetail p:masteres){
					Doctcom de=new Doctcom();
					de.setNo(i);
					de.setId(p.getId());
					de.setCcode(p.getCompanyMaster().getCompanyCode());
					de.setCname(p.getCompanyMaster().getCompanyName());
					de.setDid(p.getDocumentid().getId());
					de.setDocname(p.getDocumentid().getDetais());
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
					};
					dataes.add(de);
					i++;
			}
		}
		model.addAttribute("master", datas);
		model.addAttribute("masters", dataes);
		return "DocCompany";
		
	}
	
	@RequestMapping(value ="rs/getdoccomActive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<Doctcom> getdoccomActive(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		List<DocumentCompnydetail> masters = documentCompnyService.findAll();
		List<Doctcom> datas=new ArrayList<Doctcom>();
		if(masters.size()>0){
			int i=1;
			for(DocumentCompnydetail p:masters){
				if(p.getDocumentid().getIsactive()==0 ){
					Doctcom de=new Doctcom();
					de.setNo(i);
					de.setId(p.getId());
					de.setCcode(p.getCompanyMaster().getCompanyCode());
					de.setCname(p.getCompanyMaster().getCompanyName());
					de.setDid(p.getDocumentid().getId());
					de.setDocname(p.getDocumentid().getDetais());
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
	
	@RequestMapping(value ="rs/getdoccomInActive",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	List<Doctcom> getdoccomInActive(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		List<DocumentCompnydetail> masteres = documentCompnyService.findAllInactive();
		List<Doctcom> dataes=new ArrayList<Doctcom>();
		if(masteres.size()>0){
			int i=1;
			for(DocumentCompnydetail p:masteres){
					Doctcom de=new Doctcom();
					de.setNo(i);
					de.setId(p.getId());
					de.setCcode(p.getCompanyMaster().getCompanyCode());
					de.setCname(p.getCompanyMaster().getCompanyName());
					de.setDid(p.getDocumentid().getId());
					de.setDocname(p.getDocumentid().getDetais());
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
					};
					dataes.add(de);
					i++;
			}
		}
		return dataes;
	}
	
	@RequestMapping(value ="deleteDocCom",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList DeleteDocCom(@RequestParam (value="ID",required=true) Integer id,
						  Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user"); 
		return documentCompnyService.update(id,au.getUsername());
		
	}
	
	@RequestMapping(value ="activeIdDoCom",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList activeIdDoCom(@RequestParam (value="ID",required=true) Integer id,
					Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		return documentCompnyService.activeId(id,au.getUsername());
		
	}
	
	@RequestMapping(value ="updateDocCom",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList UpdateDocCom(@RequestParam (value="ID",required=true) Integer id,
					 	  @RequestParam (value="Doc",required=true) Integer docId,
					 	  @RequestParam (value="Com",required=true) Integer comId,
					 	  Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		ReadList rs = new ReadList();
		List<DocumentCompnydetail> dc=documentCompnyService.findNameActive(docId,comId);
		List<DocumentCompnydetail> dcs=documentCompnyService.findNameInactive(docId,comId);
		rs.setSuccess(false);
		if(dc.size()>=2){
			  rs.setSuccess(false);
			  rs.setMessage("Document company already exists in active list");
			  return rs;
		}else if(dcs.size()>=2){
			 rs.setMessage("Document company already exists in inactive list");
			 rs.setSuccess(false);
			 return rs;
		}else if(dc.size()>=1){
			for(DocumentCompnydetail dcss:dc){
				if(dcss.getId().equals(id)){
					rs=documentCompnyService.updates(id,comId,docId,au.getUsername());
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Document already exists in active list");
					return rs;
				}
		   }
		}else if(dcs.size()>=1){
			for(DocumentCompnydetail dcss:dcs){
				if(dcss.getId().equals(id)){
					rs=documentCompnyService.updates(id,comId,docId,au.getUsername());
					return rs;
				}else{
					rs.setSuccess(false);
					rs.setMessage("Document already exists in inactive list");
					return rs;
				}
		   }
		}else{
				rs=documentCompnyService.updates(id,comId,docId,au.getUsername());
				return rs;
		}
		return rs;
	}
	
	@RequestMapping(value ="insertDocCom",method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody
	ReadList InsertDocCom(@RequestParam (value="Doc",required=true) Integer docId,
							@RequestParam (value="Com",required=true) Integer comId,
					  		Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		AdminMaster au=(AdminMaster) session.getAttribute("user");
		List<DocumentCompnydetail> dcs=documentCompnyService.findNameActive(docId,comId);
		List<DocumentCompnydetail> dc=documentCompnyService.findNameInactive(docId,comId);
		ReadList rs = new ReadList();
		if(dc.size()>=1){
			rs.setSuccess(false);
			rs.setMessage("Document company already exists in inactive list");
			return rs;
		}else if(dcs.size()>=1){
			rs.setMessage("Document company already exists in active list");
			rs.setSuccess(false);
			return rs;
		}else{
			ReadList rss = new ReadList();
			rss=documentCompnyService.save(comId,docId,au.getUsername());
			return rss;
		}
	}
}