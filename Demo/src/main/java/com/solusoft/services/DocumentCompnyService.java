package com.solusoft.services;


import java.util.List;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.DocumentCompnydetail;


public interface DocumentCompnyService {

	public List<DocumentCompnydetail> findAll();
	
	public List<DocumentCompnydetail> findAllInactive();
	
	public ReadList activeId(Integer id,String user);
	
	public ReadList update(Integer id,String user);
	
    public ReadList updates(Integer id,Integer comId,Integer docId,String user);
	
	public ReadList save(Integer comId,Integer docId,String user);
	
	public List<DocumentCompnydetail> findNameActive(Integer detail,Integer ccode);
	
	public List<DocumentCompnydetail> findNameInactive(Integer detail,Integer ccode);
}