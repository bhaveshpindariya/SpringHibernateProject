package com.solusoft.services;


import java.util.List;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.BranchMaster;


public interface BranchService {

	public List<BranchMaster> findAll();
	
	public BranchMaster save(BranchMaster obj);
	 
	public BranchMaster findId(Integer id);
	
	public void saves(Auditrail de);
}