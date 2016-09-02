package com.solusoft.jpa.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="IDOC_USERS",schema="ADMINISTRATOR")
public class IdocsUser implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id; 
	private String loginName;
	private String fullName;
	private String email;
	private Timestamp udate;
	private long ename;
	private String dname;
	
	
	
    @javax.persistence.Id
    @Column (name="USER_ID",unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
	public void setId(Integer id) {
        this.id = id;
    }
	
	@Column(name="LOGIN_NAME", nullable=false)
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	@Column(name="FULL_NAME", nullable=false)
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@Column(name="EMAIL_ID", nullable=false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column (name="USER_CREATION_DATE",nullable=false)
	public Timestamp getUdate() {
		return udate;
	}
	public void setUdate(Timestamp udate) {
		this.udate = udate;
	}
	
	@Column(name="EMP_NUM", nullable=false)
	public long getEname() {
		return ename;
	}
	public void setEname(long ename) {
		this.ename = ename;
	}
	
	@Column(name="DEPARTMENT_NAME", nullable=false)
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
}
