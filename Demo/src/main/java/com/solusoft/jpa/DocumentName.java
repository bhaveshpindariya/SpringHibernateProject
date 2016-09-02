package com.solusoft.jpa;


public class DocumentName{
	
	public Integer no;
	private String dabb; 
	private String dname;
	private String cdabb;
	private String sabb;
	public String lcode;
	public String pcode;
	public Integer srn;
	public String documentname;
	
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	
	public String getDabb() {
		return dabb;
	}
	public void setDabb(String dabb) {
		this.dabb = dabb;
	}
	
	public String getCdabb() {
		return cdabb;
	}
	public void setCdabb(String cdabb) {
		this.cdabb = cdabb;
	}
	
	public String getSabb() {
		return sabb;
	}
	public void setSabb(String sabb) {
		this.sabb = sabb;
	}
	
	public String getLcode() {
		return lcode;
	}
	public void setLcode(String lcode) {
		this.lcode = lcode;
	}
	
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	
	public Integer getSrn() {
		return srn;
	}
	public void setSrn(Integer srn) {
		this.srn = srn;
	}
	
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	public String getDocumentname() {
		return documentname;
	}
	public void setDocumentname(String documentname) {
		this.documentname = documentname;
	}
}