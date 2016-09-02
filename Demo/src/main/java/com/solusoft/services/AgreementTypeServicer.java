package com.solusoft.services;


import java.util.List;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.AgreementTypeMaster;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.CompanyMaster;

public interface AgreementTypeServicer {

	public List<AgreementTypeMaster> findAll();
	
	public List<AgreementTypeMaster> findAgreementType(String agtype);
	
	public List<AgreementTypeMaster> findAllInactive();
	
	public ReadList activeId(Integer id,String user);
	
	public List<AgreementTypeMaster> findAllByCompany(Integer cid);
	
	public ReadList delete(Integer id,String user);
	
	public ReadList updates(Integer id,String anamenew,Integer cid,String user);
	
	public ReadList save(String name,Integer cid,String user);
	
	public List<AgreementTypeMaster> findNameActive(String name,Integer cid);
	
	public List<AgreementTypeMaster> findNameInactive(String name,Integer cid);
	
	public AgreementTypeMaster finddetail(CompanyMaster cname,String name);
	
	public AgreementTypeMaster saves(AgreementTypeMaster aa);
	
	public void intse(Auditrail de);
	
}