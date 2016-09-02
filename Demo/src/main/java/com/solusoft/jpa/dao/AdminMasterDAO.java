package com.solusoft.jpa.dao;

import java.util.List;

import com.solusoft.jpa.entity.AdminMaster;

public interface AdminMasterDAO {

         public List<AdminMaster> findByPropertys(String user,String pass);
         
         public List<AdminMaster> findByProperty(String user);
         
         public List<AdminMaster> validateuser(AdminMaster entity);
         
         public List<AdminMaster> findalls(String role);
         
         public List<AdminMaster> findall();
         
         public List<AdminMaster> finddata(Integer role,String user);
         
         public AdminMaster findId(Integer id);
         
         public AdminMaster save(AdminMaster data);
         
         public boolean delete(AdminMaster entity);
         
        
}
