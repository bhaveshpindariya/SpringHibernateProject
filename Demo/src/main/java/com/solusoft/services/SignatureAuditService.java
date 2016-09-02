package com.solusoft.services;

import java.util.List;
import com.solusoft.jpa.entity.SignatureAuditMaster;

public interface SignatureAuditService {

	public List<SignatureAuditMaster> findall();
	
}