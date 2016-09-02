package com.solusoft.jpa.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="PROJECT_MASTER",schema="ADMINISTRATOR")
public class ProjectMaster implements java.io.Serializable {
    
	private static final long serialVersionUID = 1L;
	
	private long dataid; 
	private String groupid;
	private String projectid;
	private String projectnamename;
	private CompanyMaster companyMaster;
	private Timestamp projectcreateiondate;
	private Timestamp startdate;
	private Timestamp enddate;
	private String pmempid;
	private String typeproject;
	private String businessarea;
	private String procenter;
	private long mainproid; 
	private String statusofpro;
	private String prolev;
	private Timestamp referencedate;
	private Timestamp updatedate;
	
	@javax.persistence.Id
	@Column (name="DATAID",unique=true, nullable=false)
	public long getDataid() {
		return dataid;
	}
	public void setDataid(long dataid) {
		this.dataid = dataid;
	}
	
	@Column (name="GROUP_ID",nullable=true,length = 10)
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	
	@Column (name="PROJECT_ID",nullable=false,length = 30)
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	
	@Column (name="PROJECT_NAME",nullable=false,length = 200)
	public String getProjectnamename() {
		return projectnamename;
	}
	public void setProjectnamename(String projectnamename) {
		this.projectnamename = projectnamename;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COMPANY_CODE",nullable=false)
	public CompanyMaster getCompanyMaster() {
        return this.companyMaster;
    }
	public void setCompanyMaster(CompanyMaster companyMaster) {
		this.companyMaster = companyMaster;
    }
	
	@Column(name="PROJECT_CREATED_DATE", nullable=false)
	public Timestamp getProjectcreateiondate() {
		return projectcreateiondate;
	}
	public void setProjectcreateiondate(Timestamp projectcreateiondate) {
		this.projectcreateiondate = projectcreateiondate;
	}
	
	@Column(name="START_DATE", nullable=true)
	public Timestamp getStartdate() {
		return startdate;
	}
	public void setStartdate(Timestamp startdate) {
		this.startdate = startdate;
	}
	
	@Column(name="END_DATE", nullable=true)
	public Timestamp getEnddate() {
		return enddate;
	}
	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}
	
	@Column (name="PM_EMPL_ID",nullable=true,length = 20)
	public String getPmempid() {
		return pmempid;
	}
	public void setPmempid(String pmempid) {
		this.pmempid = pmempid;
	}
	
	@Column (name="TYPE_OF_PROJECT",nullable=true,length = 20)
	public String getTypeproject() {
		return typeproject;
	}
	public void setTypeproject(String typeproject) {
		this.typeproject = typeproject;
	}
	
	@Column (name="BUSINESS_AREA",nullable=true,length = 10)
	public String getBusinessarea() {
		return businessarea;
	}
	public void setBusinessarea(String businessarea) {
		this.businessarea = businessarea;
	}
	
	@Column (name="PROFIT_CENTER",nullable=true,length = 25)
	public String getProcenter() {
		return procenter;
	}
	public void setProcenter(String procenter) {
		this.procenter = procenter;
	}
	
	@Column (name="MAIN_PROJECT_ID",nullable=true)
	public long getMainproid() {
		return mainproid;
	}
	public void setMainproid(long mainproid) {
		this.mainproid = mainproid;
	}
	
	@Column (name="STATUS_OF_THE_PROJECT",nullable=true,length = 20)
	public String getStatusofpro() {
		return statusofpro;
	}
	public void setStatusofpro(String statusofpro) {
		this.statusofpro = statusofpro;
	}
	
	@Column (name="PROJECT_LEVEL",nullable=true,length = 20)
	public String getProlev() {
		return prolev;
	}
	public void setProlev(String prolev) {
		this.prolev = prolev;
	}
	
	@Column(name="REFERENCEDATE", nullable=false)
	public Timestamp getReferencedate() {
		return referencedate;
	}
	public void setReferencedate(Timestamp referencedate) {
		this.referencedate = referencedate;
	}
	
	@Column(name="UPDATEDDATE", nullable=false)
	public Timestamp getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}
	
}
