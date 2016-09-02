package com.solusoft.jpa.dao;

import java.util.List;

import com.solusoft.jpa.entity.BranchMaster;


public interface BranchDAO {

	 public List<BranchMaster> findAll();
	 
	 public BranchMaster findId(Integer id);
	 
	 public BranchMaster save(BranchMaster obj);
}
