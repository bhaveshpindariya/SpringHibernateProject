package com.solusoft.jpa.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;





@Entity
@Table(name="AUDIT_TRAIL",schema="ADMINISTRATOR")
public class Auditrail implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id; 
	private String operation;
	private String record; 
	private String ovalue;
	private String nvalue;
	private Timestamp createdDate;
	private String createdBy;
	private Timestamp modifyDate;
	private String modifyBy; 
	private String tableName;
	  
    @javax.persistence.Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="ID",unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }

	public void setId(Integer id) {
        this.id = id;
    }
	
	@Column(name="OPERATION", nullable=false)
    public String getOperation() {
        return this.operation;
    }

	public void setOperation(String operation) {
        this.operation = operation;
    } 
	
	@Column(name="TABLE_NAME", nullable=false)
    public String getTableName() {
        return this.tableName;
    }

	public void setTableName(String tableName) {
        this.tableName = tableName;
    } 
	
	@Column(name="RECORD_NO", nullable=false)
    public String getRecord() {
        return this.record;
    }

	public void setRecord(String record) {
        this.record = record;
    }
	
	@Column(name="OLD_VALUE", nullable=true,length = 500)
    public String getOvalue() {
        return this.ovalue;
    }

	public void setOvalue(String ovalue) {
        this.ovalue = ovalue;
    } 
	
	@Column(name="NEW_VALUE", nullable=true,length = 500)
    public String getNvalue() {
        return this.nvalue;
    }

	public void setNvalue(String nvalue) {
        this.nvalue = nvalue;
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
