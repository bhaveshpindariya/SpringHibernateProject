package com.solusoft.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name="COSTCENTER_MASTER",schema="ADMINISTRATOR")
public class CostCenterMaster implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String costCenterCode;
	private String costCenterName;
	private CompanyMaster companyMaster;
	
	  
    @javax.persistence.Id
    @Column (name="COSTCENTERCODE",unique=true,nullable=false,length = 20)
    public String getCostCenterCode() {
        return this.costCenterCode;
    }

	public void setCostCenterCode(String costCenterCode) {
        this.costCenterCode = costCenterCode;
    }
	
	@Column(name="COSTCENTERNAME", nullable=true,length = 100)
    public String getCostCenterName() {
        return this.costCenterName;
    }

	public void setCostCenterName(String costCenterName) {
        this.costCenterName = costCenterName;
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
