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
@Table(name="AGREEMENT_ATTACHMENTS",schema="ADMINISTRATOR")
public class AgreementAttachments implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id; 
	private AgreementTypeMaster agreementTypeMaster;
	private String docclass;
	private String doctype;
	private Boolean mandadory;
	private Boolean mandadorydom;
	private Boolean atclass;
	private Integer isactive; 	
	private Timestamp createdDate;
	private String createdBy;
	private Timestamp modifyDate;
	private String modifyBy;
		
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
	@JoinColumn(name="AGR_TYPE_ID",nullable=false)
    public AgreementTypeMaster getAgreementTypeMaster() {
        return this.agreementTypeMaster;
    }

	public void setAgreementTypeMaster(AgreementTypeMaster agreementTypeMaster) {
		this.agreementTypeMaster = agreementTypeMaster;
    }
	
	@Column(name="DOC_CLASS", nullable=false)
	public String getDocclass() {
		return docclass;
	}
	public void setDocclass(String docclass) {
		this.docclass = docclass;
	}
	
	@Column(name="DOC_TYPE", nullable=true)
	public String getDoctype() {
		return doctype;
	}
	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}
	
	@Column (name="IS_ACTIVE", nullable=false)
    public Integer getIsactive() {
        return this.isactive;
    }

	public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }
	
	@Column (name="CREATE_DATE", nullable=true)
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column (name="CREATE_BY", nullable=true)
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column (name="MODIFY_DATE", nullable=true)
	public Timestamp getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	@Column (name="MODIFY_BY", nullable=true)
	public String getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	
	@Column (name="IS_MANDATORY")
	public Boolean getMandadory() {
		return mandadory;
	}
	public void setMandadory(Boolean mandadory) {
		this.mandadory = mandadory;
	}
	
	@Column (name="IS_MANDATORY_DOMESTIC")
	public Boolean getMandadorydom() {
		return mandadorydom;
	}
	public void setMandadorydom(Boolean mandadorydom) {
		this.mandadorydom = mandadorydom;
	}
	
	@Column (name="IS_AGR_TYPE_CLASS")
	public Boolean getAtclass() {
		return atclass;
	}
	public void setAtclass(Boolean atclass) {
		this.atclass = atclass;
	}
	
	
}
