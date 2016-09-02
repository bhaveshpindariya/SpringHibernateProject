package com.solusoft.jpa.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.solusoft.jpa.entity.IdocsUser;

public interface IdocDAO {

         public List<IdocsUser> findall();
         
         public IdocsUser findId(Integer id);
         
         @ Transactional
    	 public IdocsUser save(IdocsUser details);
}
