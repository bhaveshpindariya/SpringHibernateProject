package com.solusoft.jpa;

public class SignatureAudit{
	
	public Integer no;
	public Integer id;
	public String ename;
	public String depname;
	public String rname;
	public String documentname;
	public String sigReson;
	public String sidate;
	
	
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
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public String getDepname() {
		return depname;
	}
	public void setDepname(String depname) {
		this.depname = depname;
	}
	
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	
	public String getDocumentname() {
		return documentname;
	}
	public void setDocumentname(String documentname) {
		this.documentname = documentname;
	}
	
	public String getSidate() {
		return sidate;
	}
	public void setSidate(String sidate) {
		this.sidate = sidate;
	}
	
	public String getSigReson() {
		return sigReson;
	}
	public void setSigReson(String sigReson) {
		this.sigReson = sigReson;
	}	
}