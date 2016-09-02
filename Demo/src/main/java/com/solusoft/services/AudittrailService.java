package com.solusoft.services;


import java.util.List;
import com.solusoft.jpa.entity.Auditrail;


public interface AudittrailService {

	public List<Auditrail> findall();
	
	public List<String> findName();
	
	public List<Auditrail> findByTable(String tname);
}