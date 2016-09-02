package com.solusoft.jpa;

public class DepartData{
	
	public Integer no;
	private long dCode; 
	private String dName;
	private String dAbbra;
	public Integer cid;
	private String companyName;
	private String createdDate;
	private String createdBy;
	private String modifyDate;
	private String modifyBy; 
	
	public Integer getCid() {
		return cid;
	}	
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public Integer getNo() {
		return no;
	}	
	public void setNo(Integer no) {
		this.no = no;
	}
	
	public long getdCode() {
		return dCode;
	}
	public void setdCode(long dCode) {
		this.dCode = dCode;
	}
	
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	
	public String getdAbbra() {
		return dAbbra;
	}
	public void setdAbbra(String dAbbra) {
		this.dAbbra = dAbbra;
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