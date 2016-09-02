package com.solusoft.services;
import java.util.List;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.ReportingMaster;


public interface ReportingService {

	public List<ReportingMaster> findAll();
	
	public ReportingMaster save(ReportingMaster obj);
	 
	public List<ReportingMaster> findId(long id);
	
	public void saves(Auditrail de);
}