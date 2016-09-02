package com.solusoft.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.solusoft.jpa.dao.SignatureAuditDAO;
import com.solusoft.jpa.entity.SignatureAuditMaster;

@Service("signatureAuditService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class SignatureAuditServiceImpl implements SignatureAuditService {

	@Autowired
	SignatureAuditDAO signatureAuditDAO;
	
	@Override
	public List<SignatureAuditMaster> findall() {
		return signatureAuditDAO.findall();
	}
	
}