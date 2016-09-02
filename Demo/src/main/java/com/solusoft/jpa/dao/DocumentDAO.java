package com.solusoft.jpa.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.entity.DocTypeMaster;

public interface DocumentDAO {

	 public List<DocTypeMaster> findAll();
	 
	 public List<DocTypeMaster> findAllInactive();
	 
	 @ Transactional
	 public Boolean activeId(Integer id,String user);
	 
	 @ Transactional
	 public Boolean delete(Integer id,String user);
	 
	 @ Transactional
	 public DocTypeMaster save(DocTypeMaster details);
	 
	 public DocTypeMaster findId(Integer id);
	 
	 public List<DocTypeMaster> findNameActive(String detail,String doname);
	 
	 public List<DocTypeMaster> findNameInactive(String detail,String doname);
}
