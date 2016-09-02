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
@Table(name="LRF_PROCESS_AUDIT",schema="ADMINISTRATOR")
public class LegalProcessHistory implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id; 
	private Timestamp requestDate;
	private Timestamp rejectDate;
	private String lrfNo;
	private String reason;
	private String status;
	private String stepName;
	private String process;
	private PrimaryCaseDetail primaryCaseDetail;
	
	private EmployeeMaster employeeMaster;
	private AgreementTypeMaster agreementTypeMaster;
	
	
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
	
	@Column (name="REQUEST_DATE",nullable=false)
	public Timestamp getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Timestamp requestDate) {
		this.requestDate = requestDate;
	}
	
	@Column (name="REJECT_DATE",nullable=false)
	public Timestamp getRejectDate() {
		return rejectDate;
	}
	public void setRejectDate(Timestamp rejectDate) {
		this.rejectDate = rejectDate;
	}
	
	@Column(name="LRF_NUMBER", nullable=false,length = 20)
	public String getLrfNo() {
		return lrfNo;
	}
	public void setLrfNo(String lrfNo) {
		this.lrfNo = lrfNo;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USER_NAME",nullable=false)
	public EmployeeMaster getEmployeeMaster() {
		return employeeMaster;
	}
	public void setEmployeeMaster(EmployeeMaster employeeMaster) {
		this.employeeMaster = employeeMaster;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="AGREEMENT_ID",nullable=false)
	public AgreementTypeMaster getAgreementTypeMaster() {
		return agreementTypeMaster;
	}
	public void setAgreementTypeMaster(AgreementTypeMaster agreementTypeMaster) {
		this.agreementTypeMaster = agreementTypeMaster;
	}
	
	@Column(name="REASON",nullable=true)
    public String getReason() {
        return this.reason;
    }

	public void setReason(String reason) {
        this.reason = reason;
    }
	
	@Column(name="STATUS", nullable=false)
    public String getStatus() {
        return this.status;
    }
	public void setStatus(String status) {
        this.status = status;
    }
	
	@Column(name="STEP_NAME", nullable=false)
    public String getStepName() {
        return this.stepName;
    }
	public void setStepName(String stepName) {
        this.stepName = stepName;
    }
	
	@Column(name="PROCESS", nullable=true)
    public String getProcess() {
        return this.process;
    }
	public void setProcess(String process) {
        this.process = process;
    }
}
