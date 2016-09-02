package com.solusoft.jpa.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.solusoft.jpa.entity.CancelResonMaster;

public interface CancelResonDAO {

	 public List<CancelResonMaster> findAllPM();
	 
	 public List<CancelResonMaster> findAllLRF();
	 
	 public List<CancelResonMaster> findAllInactivePM();
	 
	 public List<CancelResonMaster> findAllInactiveLRF();
	 
	 @ Transactional
	 public Boolean delete(Integer id,String user);
	 
	 @ Transactional
	 public Boolean activeId(Integer id,String user);
	 
	 @ Transactional
	 public CancelResonMaster save(CancelResonMaster details);
	 
	 public List<CancelResonMaster> findNameInactive(String name,String mod);
	 
	 public List<CancelResonMaster> findNameActive(String name,String mod);
	 
	 public CancelResonMaster findId(Integer id);
}
