package com.solusoft.jpa.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.entity.LocationMaster;

public interface LocationDAO {

	 public List<LocationMaster> findAll();
	 
	 public List<LocationMaster> findAllInactive();
	 
	 @ Transactional
	 public Boolean activeId(Integer id,String user);
	 
	 @ Transactional
	 public Boolean delete(Integer id,String user);
	 
	 @ Transactional
	 public LocationMaster save(LocationMaster details);
	 
	 public List<LocationMaster> findNameActive(String detail,String code);
	 
	 public List<LocationMaster> findNameInactive(String detail,String code);
	 
	 public LocationMaster findId(Integer id);
	 
}
