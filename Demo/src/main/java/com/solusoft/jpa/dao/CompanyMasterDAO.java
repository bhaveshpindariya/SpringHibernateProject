package com.solusoft.jpa.dao;

import java.util.List;

import com.solusoft.jpa.entity.CompanyMaster;

public interface CompanyMasterDAO {

         public List<CompanyMaster> findall();
         
         public CompanyMaster findId(Integer id);
         
         public CompanyMaster save(CompanyMaster obj);
         
         public CompanyMaster findName(String name);
}
