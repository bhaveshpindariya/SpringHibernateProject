package com.solusoft.jpa.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name="PM_PROCESS_AUDIT",schema="ADMINISTRATOR")
public class ProcessAuditMaster implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id; 
	private PrimaryCaseDetail primaryCaseDetail;
	private String casetitle;
	private String wfid;
	private String wfdate;
	private String stepname;
	private String stepuser;
	private String stepreason;
	private Timestamp timein;
	private Timestamp timeout;
	private String taskname;
	private String docid;
	private String docname;
	private String sopno;
	private String docstatus;
	private String stepusername;
	private String dname;
	
    @javax.persistence.Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="ID",unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
	public void setId(Integer id) {
        this.id = id;
    }
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CASE_FK_ID",nullable=false)
    public PrimaryCaseDetail getPrimaryCaseDetail() {
        return this.primaryCaseDetail;
    }

	public void setPrimaryCaseDetail(PrimaryCaseDetail primaryCaseDetail) {
		this.primaryCaseDetail = primaryCaseDetail;
    }
	
	@Column (name="CASE_TITLE",nullable=false)
	public String getCasetitle() {
		return casetitle;
	}
	public void setCasetitle(String casetitle) {
		this.casetitle = casetitle;
	}
	
	@Column (name="WF_ID",nullable=false)
	public String getWfid() {
		return wfid;
	}
	public void setWfid(String wfid) {
		this.wfid = wfid;
	}
	
	@Column (name="WF_CREATION_DATE",nullable=false)
	public String getWfdate() {
		return wfdate;
	}
	public void setWfdate(String wfdate) {
		this.wfdate = wfdate;
	}
	
	@Column (name="STEP_NAME",nullable=false)
	public String getStepname() {
		return stepname;
	}
	public void setStepname(String stepname) {
		this.stepname = stepname;
	}
	
	@Column (name="STEP_USER",nullable=false)
	public String getStepuser() {
		return stepuser;
	}
	public void setStepuser(String stepuser) {
		this.stepuser = stepuser;
	}
	
	@Column (name="STEP_USER_NAME",nullable=false)
	public String getStepusername() {
		return stepusername;
	}
	public void setStepusername(String stepusername) {
		this.stepusername = stepusername;
	}
	
	@Column (name="STEP_RESPONSE",nullable=false)
	public String getStepreason() {
		return stepreason;
	}
	public void setStepreason(String stepreason) {
		this.stepreason = stepreason;
	}
	
	@Column (name="TIME_IN",nullable=false)
	public Timestamp getTimein() {
		return timein;
	}
	public void setTimein(Timestamp timein) {
		this.timein = timein;
	}
	
	@Column (name="TIME_OUT",nullable=false)
	public Timestamp getTimeout() {
		return timeout;
	}
	public void setTimeout(Timestamp timeout) {
		this.timeout = timeout;
	}
	
	@Column (name="TASK_NAME",nullable=false)
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	
	@Column (name="DOCID",nullable=false)
	public String getDocid() {
		return docid;
	}
	public void setDocid(String docid) {
		this.docid = docid;
	}
	
	@Column (name="DOCNAME",nullable=false)
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
	
	@Column (name="SOPNO",nullable=false)
	public String getSopno() {
		return sopno;
	}
	public void setSopno(String sopno) {
		this.sopno = sopno;
	}
	
	@Column (name="DOCUMENT_STATUS",nullable=false)
	public String getDocstatus() {
		return docstatus;
	}
	public void setDocstatus(String docstatus) {
		this.docstatus = docstatus;
	}
	
	@Column (name="DEPARTMENT_NAME",nullable=false)
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
}
