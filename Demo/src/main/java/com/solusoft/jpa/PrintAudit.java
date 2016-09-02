package com.solusoft.jpa;


public class PrintAudit{
	
	public Integer no;
	public Integer id;
	public String date;
	public String ename;
	public String dname;
	public String documentname;
	public String count;
	public String pname;
	public String preason;
	public String typrint;
	public String printfor;
	private String caseId;
	
	
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
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
	
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public String getPreason() {
		return preason;
	}
	public void setPreason(String preason) {
		this.preason = preason;
	}
	
	public String getTyprint() {
		return typrint;
	}
	public void setTyprint(String typrint) {
		this.typrint = typrint;
	}
	
	public String getPrintfor() {
		return printfor;
	}
	public void setPrintfor(String printfor) {
		this.printfor = printfor;
	}
	
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}	
}