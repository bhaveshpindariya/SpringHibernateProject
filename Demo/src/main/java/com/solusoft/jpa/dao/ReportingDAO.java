package com.solusoft.jpa.dao;

import java.util.List;
import com.solusoft.jpa.entity.ReportingMaster;


public interface ReportingDAO {

	 public List<ReportingMaster> findAll();
	 
	 public List<ReportingMaster> findId(long id);
	 
	 public ReportingMaster save(ReportingMaster obj);
	
}
