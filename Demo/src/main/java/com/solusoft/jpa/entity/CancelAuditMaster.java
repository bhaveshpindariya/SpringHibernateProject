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
@Table(name="PM_CANCEL_AUDIT",schema="ADMINISTRATOR")
public class CancelAuditMaster implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id; 
	private String docNo;
	private String docTitle;
	private PrimaryCaseDetail primaryCaseDetail;
	private String taskId;
	private String taskName;
	private CancelResonMaster cancelResonMaster;
	private String participentName;
	private EmployeeMaster emid;
	private Timestamp cancelDate;
	private String other;
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

	@Column(name="DOCUMENT_NO", nullable=false)
    public String getDocNo() {
        return this.docNo;
    }

	public void setDocNo(String docNo) {
        this.docNo = docNo;
    } 
	
	@Column(name="DOCUMENT_TITLE", nullable=false)
    public String getDocTitle() {
        return this.docTitle;
    }

	public void setDocTitle(String docTitle) {
        this.docTitle = docTitle;
    } 
	
		
	@Column(name="TASK_ID", nullable=false)
    public String getTaskId() {
        return this.taskId;
    }

	public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
	
	@Column(name="TASK_NAME", nullable=false)
    public String getTaskName() {
        return this.taskName;
    }

	public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CANCEL_REASON_ID",nullable=false)
	public CancelResonMaster getCancelResonMaster() {
		return cancelResonMaster;
	}
	public void setCancelResonMaster(CancelResonMaster cancelResonMaster) {
		this.cancelResonMaster = cancelResonMaster;
	}
	
	@Column(name="PARTICIPENT_NAME", nullable=false)
    public String getParticipentName() {
        return this.participentName;
    }

	public void setParticipentName(String participentName) {
        this.participentName = participentName;
    }
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="EMPLOYEE_MASTER_ID",nullable=false)
	public EmployeeMaster getEmid() {
		return emid;
	}
	public void setEmid(EmployeeMaster emid) {
		this.emid = emid;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CASE_FK_ID",nullable=false)
    public PrimaryCaseDetail getPrimaryCaseDetail() {
        return this.primaryCaseDetail;
    }

	public void setPrimaryCaseDetail(PrimaryCaseDetail primaryCaseDetail) {
		this.primaryCaseDetail = primaryCaseDetail;
    }
	
	@Column (name="CANCEL_DATE",nullable=false)
	public Timestamp getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(Timestamp cancelDate) {
		this.cancelDate = cancelDate;
	}
	
	@Column (name="OTHER_REASON",nullable=true)
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	
	@Column (name="DEPARTMENT_NAME",nullable=false)
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
}
