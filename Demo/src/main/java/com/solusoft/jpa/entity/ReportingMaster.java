package com.solusoft.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name="REPORTING_MASTER",schema="ADMINISTRATOR")
public class ReportingMaster implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id; 
	private CompanyMaster companyMaster;
	private EmployeeMaster employeeMaster;
	private String ename;
	private long managercode;
	private String mname;
	private long hocode;
	private String honame;
	
	@javax.persistence.Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="ID",unique=true, nullable=false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COMAPANYCODE",nullable=false)
	public CompanyMaster getCompanyMaster() {
		return companyMaster;
	}
	public void setCompanyMaster(CompanyMaster companyMaster) {
		this.companyMaster = companyMaster;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="EMPLOYEECODE",nullable=false)
	public EmployeeMaster getEmployeeMaster() {
		return employeeMaster;
	}
	public void setEmployeeMaster(EmployeeMaster employeeMaster) {
		this.employeeMaster = employeeMaster;
	}
	
	@Column(name="EMPLOYEENAME", nullable=false,length = 100)
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	@Column (name="MANAGERCODE",nullable=true)
	public long getManagercode() {
		return managercode;
	}
	public void setManagercode(long managercode) {
		this.managercode = managercode;
	}
	
	@Column (name="MANAGERNAME",nullable=true,length = 100)
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	
	@Column (name="HODCODE", nullable=true)
	public long getHocode() {
		return hocode;
	}
	public void setHocode(long hocode) {
		this.hocode = hocode;
	}
	
	@Column (name="HODNAME", nullable=true,length = 100)
	public String getHoname() {
		return honame;
	}
	public void setHoname(String honame) {
		this.honame = honame;
	}
}
