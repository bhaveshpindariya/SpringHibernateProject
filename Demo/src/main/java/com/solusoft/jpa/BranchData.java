package com.solusoft.jpa;


public class BranchData{
	
	public Integer no;
	private Integer ebCode; 
	private String ebName;
	private String companyName;
	
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	
	public Integer getEbCode() {
		return ebCode;
	}
	public void setEbCode(Integer ebCode) {
		this.ebCode = ebCode;
	}
	
	public String getEbName() {
		return ebName;
	}
	public void setEbName(String ebName) {
		this.ebName = ebName;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}