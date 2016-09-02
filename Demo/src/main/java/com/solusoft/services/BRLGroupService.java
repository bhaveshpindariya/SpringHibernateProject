package com.solusoft.services;

import java.util.List;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.BRLGroup;

public interface BRLGroupService {

	public List<BRLGroup> findAll();
	
	public List<BRLGroup> findAllInactive();
	
	public ReadList activeId(Integer id,String user);
	
	public ReadList update(Integer id,String user);
	
	public ReadList updates(Integer id,Integer ccode,String name,String abbre,String user);
		
	public ReadList save(Integer ccode,String name,String abbre,String user);
		
	public List<BRLGroup> findNameActive(String name,String abbrev);
	
	public List<BRLGroup> findNameInactive(String name,String abbrev);
}