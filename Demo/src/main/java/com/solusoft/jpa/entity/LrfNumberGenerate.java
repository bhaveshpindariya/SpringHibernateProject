package com.solusoft.jpa.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="LRF_NUM_GENERATE",schema="ADMINISTRATOR")
public class LrfNumberGenerate implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long lrfNo; 
	private String caseId;
		
    @javax.persistence.Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="LRF_NUMBER",unique=true, nullable=false)
    public long getLrfNo() {
        return this.lrfNo;
    }
	public void setLrfNo(long lrfNo) {
        this.lrfNo = lrfNo;
    }
	
	@Column (name="CASE_ID",nullable=false)
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	
}
