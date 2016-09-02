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
@Table(name="LRF_USER_SELECTION",schema="ADMINISTRATOR")
public class UserSelectionLrf implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id; 
	private String role;
	private String dname;
	private String reason;
	private Timestamp dateEntry;
	private PrimaryCaseDetail primaryCaseDetail;
	private Integer isactive; 
	private String ealias;
	
	
    @javax.persistence.Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name="ID",unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
	public void setId(Integer id) {
        this.id = id;
    }
	
	@Column(name="ROLE", nullable=false)
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Column(name="DEPARTMENT", nullable=false)
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	@Column(name="REASON",columnDefinition="LONG VARCHAR",nullable=true)
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@Column (name="DATE_OF_ENTRY",nullable=false)
	public Timestamp getDateEntry() {
		return dateEntry;
	}
	public void setDateEntry(Timestamp dateEntry) {
		this.dateEntry = dateEntry;
	}
	
	@Column (name="IS_ACTIVE",nullable=false)
	public Integer getIsactive() {
		return isactive;
	}
	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}
	
	@Column (name="EMPLOYEE_ALIAS",nullable=false)
	public String getEalias() {
		return ealias;
	}
	public void setEalias(String ealias) {
		this.ealias = ealias;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CASE_FK_ID",nullable=false)
    public PrimaryCaseDetail getPrimaryCaseDetail() {
        return this.primaryCaseDetail;
    }

	public void setPrimaryCaseDetail(PrimaryCaseDetail primaryCaseDetail) {
		this.primaryCaseDetail = primaryCaseDetail;
    }
}
