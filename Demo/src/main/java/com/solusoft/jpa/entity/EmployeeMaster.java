package com.solusoft.jpa.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Index;


@Entity
@Table(name="EMPLOYEE_MASTER",schema="ADMINISTRATOR")
public class EmployeeMaster implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long empid; 
	private String title;
	private String name;
	private String alias;
	private String email;
	private CompanyMaster companycode;
	private String cname;
	private DepartmentMaster departmentcode;
	private String dname;
	private String costCentercode;
	private BranchMaster branchcode;
	private String bname;
	private String hq;
	private String attendancelocation;
	private String physicalocation;
	private long designationcode;
	private String designation;
	private String employetype;
	private String gender;
	private String mobileno;
	private String extensionno;
	private String presentaddress;
	private String permanentaddress;
	private Timestamp dataeofbirth;
	private Timestamp dataeofjoining;
	private String employestatus;
	private Timestamp dataeofconfirm;
	private Timestamp closuredate;
	private Timestamp resignationintimationdate;
	private String bloodgroup;
	private String level;
	private String persgtxt;
	private String holidaycalenderid;
	
	@javax.persistence.Id
	@Column (name="EMPLID",unique=true, nullable=false)
	public long getEmpid() {
		return empid;
	}
	public void setEmpid(long empid) {
		this.empid = empid;
	}
	
	@Column(name="TITLE", nullable=true,length = 40)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="NAME", nullable=false,length = 200)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="EMP_ALIAS", nullable=false,length = 50)
	@Index(name="eAliasIndex")
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	@Column(name="EMAIL", nullable=true,length = 100)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COMPANYCODE", nullable=false)
	public CompanyMaster getCompanycode() {
		return companycode;
	}
	public void setCompanycode(CompanyMaster companycode) {
		this.companycode = companycode;
	}
	
	@Column(name="COMPANY", nullable=false,length = 200)
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="DEPARTMENTCODE", nullable=false)
	public DepartmentMaster getDepartmentcode() {
		return departmentcode;
	}
	public void setDepartmentcode(DepartmentMaster departmentcode) {
		this.departmentcode = departmentcode;
	}
	
	@Column(name="DEPARTMENT", nullable=false,length = 400)
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	@Column(name="COSTCENTERCODE", nullable=true,length = 40)
	public String getCostCentercode() {
		return costCentercode;
	}
	public void setCostCentercode(String costCentercode) {
		this.costCentercode = costCentercode;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="BRANCHCODE", nullable=false)
	public BranchMaster getBranchcode() {
		return branchcode;
	}
	public void setBranchcode(BranchMaster branchcode) {
		this.branchcode = branchcode;
	}
	
	@Column(name="BRANCH", nullable=false,length = 400)
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	
	@Column(name="HQ", nullable=true,length = 40)
	public String getHq() {
		return hq;
	}
	public void setHq(String hq) {
		this.hq = hq;
	}
	
	@Column(name="ATTENDANCELOCATION", nullable=true,length = 100)
	public String getAttendancelocation() {
		return attendancelocation;
	}
	public void setAttendancelocation(String attendancelocation) {
		this.attendancelocation = attendancelocation;
	}
	
	@Column(name="PHYSICALLOCATION", nullable=true,length = 100)
	public String getPhysicalocation() {
		return physicalocation;
	}
	public void setPhysicalocation(String physicalocation) {
		this.physicalocation = physicalocation;
	}
	
	@Column(name="DESIGNATIONCODE", nullable=true)
	public long getDesignationcode() {
		return designationcode;
	}
	public void setDesignationcode(long designationcode) {
		this.designationcode = designationcode;
	}
	
	@Column(name="DESIGNATION", nullable=true,length = 100)
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	@Column(name="EMPLOYEETYPE", nullable=true,length = 50)
	public String getEmployetype() {
		return employetype;
	}
	public void setEmployetype(String employetype) {
		this.employetype = employetype;
	}
	
	@Column(name="GENDER", nullable=true,length = 10)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(name="MOBILE", nullable=true,length = 100)
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	
	@Column(name="EXTENSIONNO", nullable=true,length = 100)
	public String getExtensionno() {
		return extensionno;
	}
	public void setExtensionno(String extensionno) {
		this.extensionno = extensionno;
	}
	
	@Column(name="PRESENTADDRESS", nullable=true,length = 500)
	public String getPresentaddress() {
		return presentaddress;
	}
	public void setPresentaddress(String presentaddress) {
		this.presentaddress = presentaddress;
	}
	
	@Column(name="PERMANENTADDRESS", nullable=true,length = 500)
	public String getPermanentaddress() {
		return permanentaddress;
	}
	public void setPermanentaddress(String permanentaddress) {
		this.permanentaddress = permanentaddress;
	}
	
	@Column(name="DATEOFBIRTH", nullable=true)
	public Timestamp getDataeofbirth() {
		return dataeofbirth;
	}
	public void setDataeofbirth(Timestamp dataeofbirth) {
		this.dataeofbirth = dataeofbirth;
	}
	
	@Column(name="DATEOFJOINING", nullable=true)
	public Timestamp getDataeofjoining() {
		return dataeofjoining;
	}
	public void setDataeofjoining(Timestamp dataeofjoining) {
		this.dataeofjoining = dataeofjoining;
	}
	
	@Column(name="STATUSOFEMPLOYEE", nullable=true,length = 40)
	public String getEmployestatus() {
		return employestatus;
	}
	public void setEmployestatus(String employestatus) {
		this.employestatus = employestatus;
	}
	
	@Column(name="DATEOFCONFIRMATION", nullable=true)
	public Timestamp getDataeofconfirm() {
		return dataeofconfirm;
	}
	public void setDataeofconfirm(Timestamp dataeofconfirm) {
		this.dataeofconfirm = dataeofconfirm;
	}
	
	@Column(name="CLOSUREDATE", nullable=true)
	public Timestamp getClosuredate() {
		return closuredate;
	}
	public void setClosuredate(Timestamp closuredate) {
		this.closuredate = closuredate;
	}
	
	@Column(name="RESIGNATIONINTIMATIONDATE", nullable=true)
	public Timestamp getResignationintimationdate() {
		return resignationintimationdate;
	}
	public void setResignationintimationdate(Timestamp resignationintimationdate) {
		this.resignationintimationdate = resignationintimationdate;
	}
	
	@Column(name="BLOODGROUP", nullable=true,length = 10)
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	
	@Column(name="LEVEL", nullable=false,length = 50)
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	@Column(name="PERSGTXT", nullable=true,length = 50)
	public String getPersgtxt() {
		return persgtxt;
	}
	public void setPersgtxt(String persgtxt) {
		this.persgtxt = persgtxt;
	}
	
	@Column(name="HolidayCalendarID", nullable=true,length = 20)
	public String getHolidaycalenderid() {
		return holidaycalenderid;
	}
	public void setHolidaycalenderid(String holidaycalenderid) {
		this.holidaycalenderid = holidaycalenderid;
	}
	
}
