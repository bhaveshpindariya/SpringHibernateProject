package com.solusoft.jpa;

public class ProjectData{
	
	public long no;
	private String projectid; 
	private String projectname; 
	private String comname; 
	private String prcre;
	private String busar; 
	private long mainproids; 
	private String statusofpros;
	
	public long getNo() {
		return no;
	}
	public void setNo(long l) {
		this.no = l;
	}
	
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	
	public String getComname() {
		return comname;
	}
	public void setComname(String comname) {
		this.comname = comname;
	}
	
	public String getPrcre() {
		return prcre;
	}
	public void setPrcre(String prcre) {
		this.prcre = prcre;
	}
	
	public String getBusar() {
		return busar;
	}
	public void setBusar(String busar) {
		this.busar = busar;
	}
	
	public long getMainproids() {
		return mainproids;
	}
	public void setMainproids(long mainproids) {
		this.mainproids = mainproids;
	}
	
	public String getStatusofpros() {
		return statusofpros;
	}
	public void setStatusofpros(String statusofpros) {
		this.statusofpros = statusofpros;
	}
}