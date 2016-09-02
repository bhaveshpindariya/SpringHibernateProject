package com.solusoft.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="DEPARTMENT_MASTER",schema="ADMINISTRATOR")
public class DepartmentMaster implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long deptcode; 
	private String deptname;
	private CompanyMaster companyMaster;
	
	  
    @javax.persistence.Id
    @Column (name="DEPTCODE",unique=true, nullable=false)
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

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COMPANYCODE",nullable=false)
    public CompanyMaster getCompanyMaster() {
        return this.companyMaster;
    }
	public void setCompanyMaster(CompanyMaster companyMaster) {
		this.companyMaster = companyMaster;
    }

}
