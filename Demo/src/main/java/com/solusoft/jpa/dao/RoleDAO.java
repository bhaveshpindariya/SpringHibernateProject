package com.solusoft.jpa.dao;

import java.util.List;

import com.solusoft.jpa.entity.RoleManagement;


public interface RoleDAO {

         public List<RoleManagement> findall();
         
         public List<RoleManagement> findRole(String role);
         
         public RoleManagement save(RoleManagement role);
         
         public RoleManagement findid(Integer role);
}
