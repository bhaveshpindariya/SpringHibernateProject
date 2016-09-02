package com.solusoft.jpa.dao;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.entity.Auditrail;


public interface AudittrailDAO {

	 @ Transactional
	 public Auditrail save(Auditrail details);
	 
	 public List<Auditrail> findAll();
	 
	 public List<String> findName();
	 
	 public List<Auditrail> findByTable(String tname);
}
