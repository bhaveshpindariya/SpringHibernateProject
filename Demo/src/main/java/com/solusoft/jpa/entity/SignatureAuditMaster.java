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
@Table(name="PM_SIGNATURE_AUDIT",schema="ADMINISTRATOR")
public class SignatureAuditMaster implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id; 
	private SingReasMaster sigreson;
	private SingRole singrole;
	private EmployeeMaster employeeMaster;
	private String documentName;
	private Timestamp sigDate;
	private String docver;
	private String other;
	private String documentId;
	private PrimaryCaseDetail primaryCaseDetail;
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
	@JoinColumn (name="SIGNATURE_REASON_ID",nullable=false)
	public SingReasMaster getSigreson() {
		return sigreson;
	}
	public void setSigreson(SingReasMaster sigreson) {
		this.sigreson = sigreson;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="SIGNATURE_ROLE_ID",nullable=false)
	public SingRole getSingrole() {
		return singrole;
	}
	public void setSingrole(SingRole singrole) {
		this.singrole = singrole;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="EMPLOYEE_ID",nullable=false)
	public EmployeeMaster getEmployeeMaster() {
		return employeeMaster;
	}

	public void setEmployeeMaster(EmployeeMaster employeeMaster) {
		this.employeeMaster = employeeMaster;
	}
	
	@Column (name="DOCUMENT_NAME",nullable=false)
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	@Column (name="SIGNATURE_DATE",nullable=false)
	public Timestamp getSigDate() {
		return sigDate;
	}
	public void setSigDate(Timestamp sigDate) {
		this.sigDate = sigDate;
	}

	@Column (name="DOCUMENT_ID",nullable=false)
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	
	@Column (name="DOCUMENT_VERSION_ID",nullable=false)
	public String getDocver() {
		return docver;
	}
	public void setDocver(String docver) {
		this.docver = docver;
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
	
	@Column (name="DEPARTMENT_NAME",nullable=false)
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
}
