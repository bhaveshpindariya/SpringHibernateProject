package com.solusoft.jpa.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="IDOC_TRAIL",schema="ADMINISTRATOR")
public class Idoctrail implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id; 
	private String operation;
	private String ename;
	private String eeid;
	private String ealians;
	private Timestamp createdDate;
	private String createdBy;
	private Timestamp modifyDate;
	private String modifyBy; 
	  
    @javax.persistence.Id
    @Column (name="E_ID",unique=true, nullable=false)
    public long getId() {
        return this.id;
    }

	public void setId(long id) {
        this.id = id;
    }
	
	@Column(name="OPERATION", nullable=false)
    public String getOperation() {
        return this.operation;
    }

	public void setOperation(String operation) {
        this.operation = operation;
    } 
	
	@Column(name="EMP_NAME", nullable=false)
    public String getEname() {
        return this.ename;
    }

	public void setEname(String ename) {
        this.ename = ename;
    } 
	
	@Column(name="EMP_ALIAS", nullable=false)
    public String getEalians() {
        return this.ealians;
    }

	public void setEalians(String ealians) {
        this.ealians = ealians;
    }
	
	@Column(name="EMP_EMAIL", nullable=false)
    public String getEeid() {
        return this.eeid;
    }

	public void setEeid(String eeid) {
        this.eeid = eeid;
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
