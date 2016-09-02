package com.solusoft.jpa.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.entity.AgreementTypeMaster;
import com.solusoft.jpa.entity.CompanyMaster;

public interface AgreementTypeDAO {

	 public List<AgreementTypeMaster> findAgreementType(String agtype);
	 
	 public List<AgreementTypeMaster> findAll();
	 
	 public List<AgreementTypeMaster> findAllByCompany(Integer name);
	 
	 public List<AgreementTypeMaster> findAllInactive();
	 
	 @ Transactional
	 public Boolean activeId(Integer id,String user);
	 
	 @ Transactional
	 public Boolean delete(Integer id,String user);
	 
	 @ Transactional
	 public AgreementTypeMaster save(AgreementTypeMaster details);
	 
	 public List<AgreementTypeMaster> findNameActive(String name,Integer cid);
	 
	 public List<AgreementTypeMaster> findNameInactive(String name,Integer cid);
	 
	 public AgreementTypeMaster findId(Integer id);
	 
	 public AgreementTypeMaster finddetail(CompanyMaster cname,String name);
	 
	 public AgreementTypeMaster saves(AgreementTypeMaster aa);
}
