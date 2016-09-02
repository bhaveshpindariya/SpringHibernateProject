package com.solusoft.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.dao.LrfNumberDAO;
import com.solusoft.jpa.entity.LrfNumberGenerate;



@Service("lrfNumberServicer")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class LrfNumberServicerImpl implements LrfNumberServicer {

	@Autowired
	LrfNumberDAO lrfNumberDAO;

	@Override
	public List<LrfNumberGenerate> findall() {
		return lrfNumberDAO.findall();
	}
}