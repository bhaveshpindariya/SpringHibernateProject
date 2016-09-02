package com.solusoft.jpa.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.solusoft.jpa.entity.AgreementScreens;

public interface AgreementscreensDAO {
	
		 public void delete(AgreementScreens entity);
		
		 public List<AgreementScreens> findalldata();

         public List<AgreementScreens> findactive();
         
         public AgreementScreens savedata(AgreementScreens details);
         
         public AgreementScreens findId(Integer id);
         
         public List<AgreementScreens> findAllInactive();
         
         @ Transactional
    	 public Boolean activeId(Integer id,String user);
         
         @ Transactional
    	 public Boolean delete(Integer id,String user);
         
         public List<AgreementScreens> findNameActive(Integer aid,String vid,String viewname,String scrfor);
     	
     	 public List<AgreementScreens> findNameInactive(Integer aid,String vid,String viewname,String scrfor);
     	 
     	 @ Transactional
     	 public AgreementScreens save(AgreementScreens details);
         
}
