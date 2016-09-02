package com.solusoft.jpa.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.entity.AgreementAttachments;

public interface AgreementAttachmentsDAO {

         public List<AgreementAttachments> findactive();
         
         public List<AgreementAttachments> findalldata();
         
         public void delete(AgreementAttachments entity);
         
         @ Transactional
    	 public Boolean activeId(Integer id,String user);
         
         @ Transactional
    	 public Boolean delete(Integer id,String user);
         
         public List<AgreementAttachments> findNameActive(Integer aid,String docc,String doct,Boolean iatc,Boolean im,Boolean imd);
     	
     	 public List<AgreementAttachments> findNameInactive(Integer aid,String docc,String doct,Boolean iatc,Boolean im,Boolean imd);
         
         public AgreementAttachments findId(Integer id);
         
         public AgreementAttachments savedata(AgreementAttachments details);
         
         public List<AgreementAttachments> findAllInactive();
}
