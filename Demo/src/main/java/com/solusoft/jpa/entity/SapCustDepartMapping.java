
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
@Table(name="SAP_CUSTOMDEPARTMENT_MAPPING",schema="ADMINISTRATOR")
public class SapCustDepartMapping implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id; 
	private DepartmentMaster departmentMaster;
	private CustomDepartment customDepartment;
	private VerticalMaster verticalMaster;
	private SiteMaster siteMaster;
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
	@JoinColumn(name="DEPARTMENTCODE",nullable=false)
	public DepartmentMaster getDepartmentMaster() {
		return departmentMaster;
	}
	public void setDepartmentMaster(DepartmentMaster departmentMaster) {
		this.departmentMaster = departmentMaster;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CUST_DEPARTMENTCODE",nullable=true)
	public CustomDepartment getCustomDepartment() {
		return customDepartment;
	}
	public void setCustomDepartment(CustomDepartment customDepartment) {
		this.customDepartment = customDepartment;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="VERTICAL_MASTER_ID",nullable=true)
	public VerticalMaster getVerticalMaster() {
		return verticalMaster;
	}
	public void setVerticalMaster(VerticalMaster verticalMaster) {
		this.verticalMaster = verticalMaster;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="SITE_MASTER_ID",nullable=true)
	public SiteMaster getSiteMaster() {
		return siteMaster;
	}
	public void setSiteMaster(SiteMaster siteMaster) {
		this.siteMaster = siteMaster;
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
