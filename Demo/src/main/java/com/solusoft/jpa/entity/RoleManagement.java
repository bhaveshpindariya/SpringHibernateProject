package com.solusoft.jpa.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="ROLE_MASTER",schema="ADMINISTRATOR")
public class RoleManagement implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id; 
	private String rolename;
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
	
	@Column(name="ROLE_NAME", nullable=false)
    public String getRolename() {
        return this.rolename;
    }

	public void setRolename(String rolename) {
        this.rolename = rolename;
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
