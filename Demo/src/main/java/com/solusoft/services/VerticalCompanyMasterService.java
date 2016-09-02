package com.solusoft.services;

import java.util.List;
import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.VerticalCompanyMaster;

public interface VerticalCompanyMasterService {

	public List<VerticalCompanyMaster> findAll();
	
	public List<VerticalCompanyMaster> findAllInactive();
	
	public ReadList activeId(Integer id,String user);
	
	public ReadList update(Integer id,String user);
	
	public ReadList updates(Integer id,Integer vid,Integer cid,String user);
	
	public ReadList save(Integer vId,Integer cid,String user);
	
	public List<VerticalCompanyMaster> findNameActive(Integer vId,Integer cId);
	
	public List<VerticalCompanyMaster> findNameInactive(Integer vId,Integer cId);
	
	public List<VerticalCompanyMaster> finddata(Integer vId,Integer cId);
	
	public VerticalCompanyMaster saves(VerticalCompanyMaster aa);
}
