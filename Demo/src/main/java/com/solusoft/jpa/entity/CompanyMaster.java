package com.solusoft.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="COMPANY_MASTER",schema="ADMINISTRATOR")
public class CompanyMaster implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer companyCode;
	private String companyName;
    private String companyAddress;
   
    @javax.persistence.Id
    @Column (name="COMPANYCODE",unique=true, nullable=false,length = 4)
    public Integer getCompanyCode() {
        return this.companyCode;
    }

	public void setCompanyCode(Integer companyCode) {
        this.companyCode = companyCode;
    }
	
	@Column(name="COMPANYNAME", nullable=false,length = 200)
    public String getCompanyName() {
        return this.companyName;
    }

	public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
	
	@Column(name="COMPANYADDRESS", nullable=true,length = 600)
    public String getCompanyAddress() {
        return this.companyAddress;
    }

	public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }
}
