package com.solusoft.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="BRANCH_MASTER",schema="ADMINISTRATOR")
public class BranchMaster implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer branchcode; 
	private String branchname;
	private CompanyMaster companyMaster;
	
	  
    @javax.persistence.Id
    @Column (name="BRANCHCODE",unique=true, nullable=false,length = 4)
    public Integer getBranchcode() {
		return branchcode;
	}

	public void setBranchcode(Integer branchcode) {
		this.branchcode = branchcode;
	}

	@Column(name="BRANCHNAME", nullable=true,length = 100)
	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
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
