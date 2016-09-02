package com.solusoft.jpa.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="CUSTOM_DEPARTMENT",schema="ADMINISTRATOR")
public class CustomDepartment implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long deptcode; 
	private String deptname;
	private String deptabbreviation;
	private Integer isactive; 
	private CompanyMaster companyMaster;
	private Timestamp createdDate;
	private String createdBy;
	private Timestamp modifyDate;
	private String modifyBy;
	
	  
    @javax.persistence.Id
    @Column (name="DEPTID",unique=true, nullable=false)
    public long getDeptcode() {
		return deptcode;
	}

	public void setDeptcode(long deptcode) {
		this.deptcode = deptcode;
	}

	@Column(name="DEPTNAME", nullable=false,length = 100)
	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	
	@Column(name="DEPT_ABBREVIATION", nullable=false ,length = 15)
	public String getDeptabbreviation() {
		return deptabbreviation;
	}

	public void setDeptabbreviation(String deptabbreviation) {
		this.deptabbreviation = deptabbreviation;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COMAPANYCODE",nullable=false)
    public CompanyMaster getCompanyMaster() {
        return this.companyMaster;
    }

	public void setCompanyMaster(CompanyMaster companyMaster) {
		this.companyMaster = companyMaster;
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
	
	@Column (name="IS_ACTIVE", nullable=false)
    public Integer getIsactive() {
        return this.isactive;
    }
	public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }
}
