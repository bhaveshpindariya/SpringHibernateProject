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
@Table(name="DOCUMENT_NAME_BRL",schema="ADMINISTRATOR")
public class DocumentNameForBRL implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id; 
	private DocTypeMaster documentid;
	private BRLGroup brlGroup;
	private ProjectMaster projectMaster;
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
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="DOC_TYPE_MASTER_ID",nullable=false)
    public DocTypeMaster getDocumentid() {
        return this.documentid;
    }

	public void setDocumentid(DocTypeMaster documentid) {
		this.documentid = documentid;
    }
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="BRL_GROUP_ID",nullable=false)
    public BRLGroup getBrlGroup() {
        return brlGroup;
    }

	public void setBrlGroup(BRLGroup brlGroup) {
		this.brlGroup = brlGroup;
    }

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PROJECTMASTER_ID",nullable=true)
	public ProjectMaster getProjectMaster() {
		return projectMaster;
	}

	public void setProjectMaster(ProjectMaster projectMaster) {
		this.projectMaster = projectMaster;
	}

	
	@Column (name="SRNO", nullable=false)
	public Integer getSrno() {
		return srno;
	}

	public void setSrno(Integer srno) {
		this.srno = srno;
	}
	
	@Column (name="DOCUMENT_NO",unique=true, nullable=false,length = 100)
	public String getDocumentno() {
		return documentno;
	}

	public void setDocumentno(String documentno) {
		this.documentno = documentno;
	}
	
}
