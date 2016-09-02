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
@Table(name="BRL_GROUP",schema="ADMINISTRATOR")
public class BRLGroup implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id; 
	private String groupname;
	private String abbreviation;
	private CompanyMaster companyMaster;
	private Timestamp createdDate;
	private String createdBy;
	private Timestamp modifyDate;
	private String modifyBy; 
	private Integer isactive; 
	
	  
    @javax.persistence.Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="ID",unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }

	public void setId(Integer id) {
        this.id = id;
    }
	
	@Column(name="BRLGROUP_NAME", nullable=false)
    public String getGroupname() {
        return this.groupname;
    }

	public void setGroupname(String groupname) {
        this.groupname = groupname;
    } 
	
	@Column(name="BRLGROUP_ABBREVIATION", nullable=false)
    public String getAbbreviation() {
        return this.abbreviation;
    }
	public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COMAPANYCODE",nullable=false)
    public CompanyMaster getCompanyMaster() {
        return this.companyMaster;
    }

	public void setCompanyMaster(CompanyMaster companyMaster) {
		this.companyMaster = companyMaster;
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
