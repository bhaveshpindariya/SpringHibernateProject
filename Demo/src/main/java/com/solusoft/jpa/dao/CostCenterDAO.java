package com.solusoft.jpa.dao;

import java.util.List;
import com.solusoft.jpa.entity.CostCenterMaster;

public interface CostCenterDAO {

	 public List<CostCenterMaster> findAll();
	 
	 public CostCenterMaster findId(String id);
     
     public CostCenterMaster save(CostCenterMaster obj);
}
