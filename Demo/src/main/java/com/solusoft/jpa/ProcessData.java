package com.solusoft.jpa;

import java.sql.Timestamp;

public class ProcessData{
	
	public Integer no;
	private Integer id; 
	private String casetitle;
	private String stepname;
	private String stepuser;
	private String stepreason;
	private Timestamp timein;
	private Timestamp timeout; 
	private String docstatus;
	private String dname;
	
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
	
	public String getCasetitle() {
		return casetitle;
	}
	public void setCasetitle(String casetitle) {
		this.casetitle = casetitle;
	}
	
	public String getStepname() {
		return stepname;
	}
	public void setStepname(String stepname) {
		this.stepname = stepname;
	}
	
	public String getStepuser() {
		return stepuser;
	}
	public void setStepuser(String stepuser) {
		this.stepuser = stepuser;
	}
	
	public String getStepreason() {
		return stepreason;
	}
	public void setStepreason(String stepreason) {
		this.stepreason = stepreason;
	}
	
	public Timestamp getTimein() {
		return timein;
	}
	public void setTimein(Timestamp timein) {
		this.timein = timein;
	}
	
	public Timestamp getTimeout() {
		return timeout;
	}
	public void setTimeout(Timestamp timeout) {
		this.timeout = timeout;
	}
	
	public String getDocstatus() {
		return docstatus;
	}
	public void setDocstatus(String docstatus) {
		this.docstatus = docstatus;
	}
	
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	
}