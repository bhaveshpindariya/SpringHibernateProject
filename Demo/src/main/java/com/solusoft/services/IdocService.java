package com.solusoft.services;

import java.util.List;

import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.IdocsUser;


public interface IdocService {

	public List<IdocsUser> findall();
	 
	public IdocsUser save(IdocsUser details);
	
	public IdocsUser findId(Integer id);
	
	public void saves(Auditrail de);
	
}