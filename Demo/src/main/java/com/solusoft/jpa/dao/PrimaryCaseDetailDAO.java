package com.solusoft.jpa.dao;

import com.solusoft.jpa.entity.PrimaryCaseDetail;

public interface PrimaryCaseDetailDAO {

	 public PrimaryCaseDetail save(PrimaryCaseDetail ss);
	 
	 public PrimaryCaseDetail findCaseId(String caseId);
}
