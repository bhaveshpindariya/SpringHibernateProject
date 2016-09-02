package com.solusoft.services;


import java.util.List;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.DocTypeMaster;

public interface DocumentServicer {

	public List<DocTypeMaster> findAll();
	
	public List<DocTypeMaster> findAllInactive();
	
	public ReadList activeId(Integer id,String user);
	
	public ReadList update(Integer id,String user);
	
	public ReadList updates(Integer id,String details,String user,String docname);
	
	public ReadList save(String details,String user,String docname);
	
	public List<DocTypeMaster> findNameActive(String detail,String docnames);

	public List<DocTypeMaster> findNameInactive(String detail,String docnames);	
}