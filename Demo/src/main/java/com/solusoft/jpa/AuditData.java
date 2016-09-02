package com.solusoft.jpa;

public class AuditData{
	
	public Integer no;
	private long ids; 
	private Integer id;
	private String record; 
	private String operation;
	private String ovalue;
	private String nvalue;
	private String createdDate;
	private String createdBy;
	private String modifyDate;
	private String modifyBy; 
	private String tableName;
	
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	
	public long getIds() {
		return ids;
	}
	public void setIds(long ids) {
		this.ids = ids;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public String getOvalue() {
		return ovalue;
	}
	public void setOvalue(String ovalue) {
		this.ovalue = ovalue;
	}
	
	public String getNvalue() {
		return nvalue;
	}
	public void setNvalue(String nvalue) {
		this.nvalue = nvalue;
	}
	
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	public String getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}