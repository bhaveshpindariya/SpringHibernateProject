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
@Table(name="LOGIN_MASTER",schema="ADMINISTRATOR")
public class AdminMaster implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id; 
	private String username;
	private String password;
	private String email;
	private String key;
	private Integer active;
	private Timestamp createdDate;
	private String createdBy;
	private Timestamp modifyDate;
	private String modifyBy;
	private RoleManagement roleManagement;
	
	@javax.persistence.Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="ID",unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }

	public void setId(Integer id) {
        this.id = id;
    }
	
	@Column(name="LOGIN_USERNAME", nullable=false)
    public String getUsername() {
        return this.username;
    }

	public void setUsername(String username) {
        this.username = username;
    }
	
	@Column(name="LOGIN_PASSWORD", nullable=false)
    public String getPassword() {
        return this.password;
    }

	public void setPassword(String password) {
        this.password = password;
    }
	
	@Column(name="EMAIL", nullable=false,length = 100)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="STATUS", nullable=true)
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	
	@Column(name="CHANGE_KEY", nullable=true,length = 100)
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ROLE_MASTER_ID",nullable=false)
	public RoleManagement getRoleManagement() {
        return this.roleManagement;
    }

	public void setRoleManagement(RoleManagement roleManagement) {
        this.roleManagement = roleManagement;
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
