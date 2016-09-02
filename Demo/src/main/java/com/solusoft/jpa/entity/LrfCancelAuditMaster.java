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
@Table(name="LRF_CANCEL_AUDIT",schema="ADMINISTRATOR")
public class LrfCancelAuditMaster implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id; 
	private Timestamp cancelDate;
	private Timestamp requestDate;
	private String rename;
	private String crdetail;
	private String redep;
	private String participentName;
	private String other;
	private String taskName;
	private CancelResonMaster cancelResonMaster;
	private String cancelby;
	private String lrfNo;
	private String requestorFullName;
	private String cancelByName;
	private PrimaryCaseDetail primaryCaseDetail;
	
    @javax.persistence.Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="ID",unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
	public void setId(Integer id) {
        this.id = id;
    }

	@Column (name="CANCEL_DATE",nullable=false)
	public Timestamp getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(Timestamp cancelDate) {
		this.cancelDate = cancelDate;
	}
	
	@Column (name="REQUEST_DATE",nullable=false)
	public Timestamp getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Timestamp requestDate) {
		this.requestDate = requestDate;
	}
	
	@Column(name="REQUESTOR_NAME", nullable=false)
    public String getRename() {
        return this.rename;
    }
	public void setRename(String rename) {
        this.rename = rename;
    } 
	
	@Column(name="REQUESTOR_FULL_NAME", nullable=false)
    public String getRequestorFullName() {
        return this.requestorFullName;
    }
	public void setRequestorFullName(String requestorFullName) {
        this.requestorFullName = requestorFullName;
    }
	
	@Column(name="REQUESTOR_DEPARTMENT", nullable=false)
    public String getRedep() {
        return this.redep;
    }
	public void setRedep(String redep) {
        this.redep = redep;
    }
	
	@Column(name="PARTICIPENT_NAME", nullable=false)
    public String getParticipentName() {
        return this.participentName;
    }
	public void setParticipentName(String participentName) {
        this.participentName = participentName;
    }
	
	@Column (name="OTHER_REASON",nullable=true)
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CASE_FK_ID",nullable=false)
    public PrimaryCaseDetail getPrimaryCaseDetail() {
        return this.primaryCaseDetail;
    }

	public void setPrimaryCaseDetail(PrimaryCaseDetail primaryCaseDetail) {
		this.primaryCaseDetail = primaryCaseDetail;
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
	
	@Column(name="CANCEL_REASON_DETAIL", nullable=false)
    public String getCrdetail() {
        return this.crdetail;
    }
	public void setCrdetail(String crdetail) {
        this.crdetail = crdetail;
    }
	
	@Column(name="CANCEL_BY_ALIAS", nullable=false)
    public String getCancelby() {
        return this.cancelby;
    }
	public void setCancelby(String cancelby) {
        this.cancelby = cancelby;
    }
	
	@Column(name="CANCEL_BY_NAME", nullable=false)
    public String getCancelByName() {
        return this.cancelByName;
    }
	public void setCancelByName(String cancelByName) {
        this.cancelByName = cancelByName;
    }
	
	@Column(name="LRF_NO", nullable=false,length = 20)
    public String getLrfNo() {
        return this.lrfNo;
    }
	public void setLrfNo(String lrfNo) {
        this.lrfNo = lrfNo;
    }
}
