package com.solusoft.services;


import java.util.List;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.AgreementScreens;
import com.solusoft.jpa.entity.Auditrail;

public interface AgreementscreensService {
	
    public List<AgreementScreens> findalldata();
	
	public void delete(AgreementScreens entity);

	public List<AgreementScreens> findactive();
	
	public List<AgreementScreens> findAllInactive();
	
	public AgreementScreens savedata(AgreementScreens details);
	
	public ReadList activeId(Integer id,String user);
	
	public ReadList deleteId(Integer id,String user);
	
    public List<AgreementScreens> findNameActive(Integer aid,String vid,String viewname,String scrfor);
	
	public List<AgreementScreens> findNameInactive(Integer aid,String vid,String viewname,String scrfor);
	
    public ReadList updates(Integer id,Integer aid,String vid,String viewname,String scrfor,String user);
	
	public ReadList save(Integer aid,String vid,String viewname,String scrfor,String user);
	
	public void saves(Auditrail de);
	
}