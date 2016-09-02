package com.solusoft.jpa;


public class CancelAudit{
	
	public Integer no;
	public Integer id;
	public String date;
	public String ename;
	public String dname;
	public String docno;
	public String documenttitle;
	public String taskId;
	public String taskName;
	public String creason;
	public String participentName;
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
	
	public String getDocno() {
		return docno;
	}
	public void setDocno(String docno) {
		this.docno = docno;
	}
	
	public String getDocumenttitle() {
		return documenttitle;
	}
	public void setDocumenttitle(String documenttitle) {
		this.documenttitle = documenttitle;
	}
	
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public String getCreason() {
		return creason;
	}
	public void setCreason(String creason) {
		this.creason = creason;
	}
	
	public String getParticipentName() {
		return participentName;
	}
	public void setParticipentName(String participentName) {
		this.participentName = participentName;
	}
	
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}	
}