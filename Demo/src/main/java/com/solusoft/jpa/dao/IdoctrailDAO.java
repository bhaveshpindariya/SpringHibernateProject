package com.solusoft.jpa.dao;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.solusoft.jpa.entity.Idoctrail;


public interface IdoctrailDAO {

	 @ Transactional
	 public Idoctrail save(Idoctrail details);
	 
	 public List<Idoctrail> findAll();
	  
	 public Idoctrail findId(long id);
	 
	 public void delete(Idoctrail details);
}
