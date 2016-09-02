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
@Table(name="AGREEMENT_SCREENS",schema="ADMINISTRATOR")
public class AgreementScreens implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id; 
	private AgreementTypeMaster agreementTypeMaster;
	private String viewid;
	private String viewname;
	private String screenfor;
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
	
	@Column(name="VIEW_DEFINITION_ID", nullable=false)
	public String getViewid() {
		return viewid;
	}
	public void setViewid(String viewid) {
		this.viewid = viewid;
	}
	
	@Column(name="VIEW_DEFINITION_NAME", nullable=false)
	public String getViewname() {
		return viewname;
	}
	public void setViewname(String viewname) {
		this.viewname = viewname;
	}
	
	@Column(name="SCREEN_FOR",nullable=true)
	public String getScreenfor() {
		return screenfor;
	}
	public void setScreenfor(String screenfor) {
		this.screenfor = screenfor;
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
	
}
