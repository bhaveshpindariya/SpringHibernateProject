package com.solusoft.jpa.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.entity.PrintResonMaster;

public interface PrintResonDAO {

	 public List<PrintResonMaster> findAllPM();
	 
	 public List<PrintResonMaster> findAllLRF();
	 
	 public List<PrintResonMaster> findAllInactivePM();
	 
	 public List<PrintResonMaster> findAllInactiveLRF();
	 
	 @ Transactional
	 public Boolean delete(Integer id,String user);
	 
	 @ Transactional
	 public Boolean activeId(Integer id,String user);
	 
	 @ Transactional
	 public PrintResonMaster save(PrintResonMaster details);
	 
	 public List<PrintResonMaster> findNameActive(String name,String module);
	 
	 public List<PrintResonMaster> findNameInactive(String name,String module);
	 
	 public PrintResonMaster findId(Integer id);
}
