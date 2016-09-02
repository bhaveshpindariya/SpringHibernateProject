package com.solusoft.jpa;

public class SiteData{
	
	public Integer no;
	public Integer id;
	public String name;
	public String sabb;
	public String saddress;
	public String salians;
	public String companyname;
	public Integer companycode;
	private String createdDate;
	private String createdBy;
	private String modifyDate;
	private String modifyBy;
	
	
	public String getSalians() {
		return salians;
	}
	public void setSalians(String salians) {
		this.salians = salians;
	}
	
	public String getSabb() {
		return sabb;
	}
	public void setSabb(String sabb) {
		this.sabb = sabb;
	}
	
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	
	public Integer getCompanycode() {
		return companycode;
	}
	public void setCompanycode(Integer companycode) {
		this.companycode = companycode;
	}	
	
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	public String getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}	
}