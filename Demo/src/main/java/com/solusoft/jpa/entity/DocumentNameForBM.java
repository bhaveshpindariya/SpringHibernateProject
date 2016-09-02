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
@Table(name="DOCUMENT_NAME_BM",schema="ADMINISTRATOR")
public class DocumentNameForBM implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id; 
	private String type;
	private VerticalMaster verticalid;
	private CustomDepartment customDepartment;
	private DocTypeMaster documentid;
	private Integer srno; 	
	private String  documentno; 
	  
    @javax.persistence.Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="ID",unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }

	public void setId(Integer id) {
        this.id = id;
    }
	
	@Column (name="TYPE_ABBREVIATION", nullable=false,length = 20)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="VERTICAL_MASTER_ID",nullable=true)
    public VerticalMaster getVerticalid() {
        return this.verticalid;
    }

	public void setVerticalid(VerticalMaster verticalid) {
		this.verticalid = verticalid;
    }
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="DOC_TYPE_MASTER_ID",nullable=false)
    public DocTypeMaster getDocumentid() {
        return this.documentid;
    }

	public void setDocumentid(DocTypeMaster documentid){
		this.documentid = documentid;
    }
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CUSTOMDEPARTMENT_ID",nullable=false)
    public CustomDepartment getCustomDepartment() {
        return this.customDepartment;
    }

	public void setCustomDepartment(CustomDepartment customDepartment) {
		this.customDepartment = customDepartment;
    }
	
	@Column (name="DOCUMENT_NO",unique=true, nullable=false,length = 100)
	public String getDocumentno() {
		return documentno;
	}

	public void setDocumentno(String documentno) {
		this.documentno = documentno;
	}

	@Column (name="SRNO", nullable=false)
	public Integer getSrno() {
		return srno;
	}

	public void setSrno(Integer srno) {
		this.srno = srno;
	}
	
	
}
