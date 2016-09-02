package com.solusoft.jpa;

public class UserData{
	
	private Integer id; 
	private String caseId;
	private String ecode;
	private String ename;
	private String email;
	private String role;
	private String dname;
	private String reason;
	private String dateEntry;
	private Integer isactive; 
	private String ealias;
	private String cname;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	
	public String getEcode() {
		return ecode;
	}
	public void setEcode(String ecode) {
		this.ecode = ecode;
	}
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getDateEntry() {
		return dateEntry;
	}
	public void setDateEntry(String dateEntry) {
		this.dateEntry = dateEntry;
	}
	
	public Integer getIsactive() {
		return isactive;
	}
	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}
	
	public String getEalias() {
		return ealias;
	}
	public void setEalias(String ealias) {
		this.ealias = ealias;
	}
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
}