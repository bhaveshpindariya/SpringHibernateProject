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
@Table(name="SITE_MASTER",schema="ADMINISTRATOR")
public class SiteMaster implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id; 
	private String sname;
	private String saliens;
	private String sabbra;
	private String saddress;
	private CompanyMaster companyMaster;
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
	
	@Column(name="SITE_NAME", nullable=false)
    public String getSname() {
        return this.sname;
    }

	public void setSname(String sname) {
        this.sname = sname;
    } 
	
	@Column(name="SITE_ALIAS", nullable=false)
    public String getSaliens() {
        return this.saliens;
    }

	public void setSaliens(String saliens) {
        this.saliens = saliens;
    } 
	
	@Column(name="SITE_ABBREVIATION", nullable=false)
    public String getSabbra() {
        return this.sabbra;
    }
	public void setsabbra(String sabbra) {
        this.sabbra = sabbra;
    } 
	
	@Column(name="SITE_ADDRESS", nullable=false,length = 500)
    public String getSaddress() {
        return this.saddress;
    }
	public void setsaddress(String saddress) {
        this.saddress = saddress;
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
