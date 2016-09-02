package com.solusoft.services;


import java.util.List;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.CostCenterMaster;

public interface CostCenterService {

	public List<CostCenterMaster> findAll();
	
	public CostCenterMaster save(CostCenterMaster obj);
	 
    public CostCenterMaster findId(String id);

    public void saves(Auditrail de);
}