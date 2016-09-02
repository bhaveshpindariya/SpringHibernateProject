package com.solusoft.services;


import java.util.List;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.entity.AgreementAttachments;
import com.solusoft.jpa.entity.Auditrail;

public interface AgreementAttachmentsService {

	public List<AgreementAttachments> findactive();
	
	public List<AgreementAttachments> findalldata();
	
    public ReadList activeId(Integer id,String user);
	
	public ReadList deleteId(Integer id,String user);
	
	public void delete(AgreementAttachments entity);
	
	public List<AgreementAttachments> findAllInactive();
	
    public List<AgreementAttachments> findNameActive(Integer aid,String docc,String doct,Boolean iatc,Boolean im,Boolean imd);
	
	public List<AgreementAttachments> findNameInactive(Integer aid,String docc,String doct,Boolean iatc,Boolean im,Boolean imd);
	
	public ReadList save(Integer aid,String docc,String doct,Boolean iatc,Boolean im,Boolean imd,String user);
	
	public ReadList updates(Integer id,Integer aid,String docc,String doct,Boolean iatc,Boolean im,Boolean imd,String user);
	
	public AgreementAttachments savedata(AgreementAttachments details);
	
	public void saves(Auditrail de);
	
}