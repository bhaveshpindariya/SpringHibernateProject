package com.solusoft.jpa.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="PRIMARY_CASE_DETAIL",schema="ADMINISTRATOR")
public class PrimaryCaseDetail implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id; 
	private String caseId;
	private String solutionPrefix;
	private String createdBy;
	private Timestamp createdDate;
	
	
    @javax.persistence.Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name="ID",unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
	public void setId(Integer id) {
        this.id = id;
    }
	
	@Column(name="CASE_ID", nullable=false)
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	
	@Column(name="SOLUTION_PREFIX", nullable=true)
	public String getSolutionPrefix() {
		return solutionPrefix;
	}
	public void setSolutionPrefix(String solutionPrefix) {
		this.solutionPrefix = solutionPrefix;
	}
	
	@Column(name="CREATED_BY", nullable=true)
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name="CREATED_DATE", nullable=true)
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
