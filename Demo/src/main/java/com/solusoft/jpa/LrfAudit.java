package com.solusoft.jpa;

public class LrfAudit{
	
	public Integer no;
	public Integer id;
	public String requestdate;
	public String rejecteddate;
	public String lrno;
	public String ename;
	public String reason;
	public String status;
	public String aname;
	public String stepname;
	public String process;
	
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
	
	public String getRequestdate() {
		return requestdate;
	}
	public void setRequestdate(String requestdate) {
		this.requestdate = requestdate;
	}
	
	public String getRejecteddate() {
		return rejecteddate;
	}
	public void setRejecteddate(String rejecteddate) {
		this.rejecteddate = rejecteddate;
	}
	
	public String getLrno() {
		return lrno;
	}
	public void setLrno(String lrno) {
		this.lrno = lrno;
	}
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	
	public String getStepname() {
		return stepname;
	}
	public void setStepname(String stepname) {
		this.stepname = stepname;
	}
	
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	
}