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
@Table(name="PM_PRINT_AUDIT",schema="ADMINISTRATOR")
public class PrintAuditMaster implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id; 
	private String printDocId;
	private Timestamp printdate;
	private String printfor;
	private String documentName;
	private String typeofprint;
	private String printname;
	private Integer count; 
	private String other;
	private PrimaryCaseDetail primaryCaseDetail;
	private String dname;
	
	private EmployeeMaster emid;
	private PrintResonMaster printreson;
	
	
    @javax.persistence.Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="ID",unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
	public void setId(Integer id) {
        this.id = id;
    }

	@Column (name="PRINT_DOC_ID",nullable=false)
	public String getPrintDocId() {
		return printDocId;
	}
	public void setPrintDocId(String printDocId) {
		this.printDocId = printDocId;
	}

	@Column (name="PRINT_DATE",nullable=false)
	public Timestamp getPrintdate() {
		return printdate;
	}
	public void setPrintdate(Timestamp printdate) {
		this.printdate = printdate;
	}
	
	@Column (name="PRINT_FOR",nullable=false)
	public String getPrintfor() {
		return printfor;
	}
	public void setPrintfor(String printfor) {
		this.printfor = printfor;
	}

	@Column (name="DOCUMENT_NAME",nullable=false)
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	@Column (name="TYPE_OF_PRINT",nullable=false)
	public String getTypeofprint() {
		return typeofprint;
	}
	public void setTypeofprint(String typeofprint) {
		this.typeofprint = typeofprint;
	}

	@Column (name="PRINTER_NAME",nullable=false)
	public String getPrintname() {
		return printname;
	}
	public void setPrintname(String printname) {
		this.printname = printname;
	}

	@Column (name="PRINT_COUNT",nullable=false)
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
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
	@JoinColumn(name="PRINT_REASON_MASTER_ID",nullable=false)
	public PrintResonMaster getPrintreson() {
		return printreson;
	}
	public void setPrintreson(PrintResonMaster printreson) {
		this.printreson = printreson;
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
