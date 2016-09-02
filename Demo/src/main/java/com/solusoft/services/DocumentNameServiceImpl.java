package com.solusoft.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.dao.DocumentNameDAO;
import com.solusoft.jpa.entity.DocumentNameForBL;
import com.solusoft.jpa.entity.DocumentNameForBM;
import com.solusoft.jpa.entity.DocumentNameForBRL;



@Service("documentNameService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class DocumentNameServiceImpl implements DocumentNameService {

	@Autowired
	DocumentNameDAO documentNameDAO;
	
	
	@Override
	public List<DocumentNameForBL> findAllBl() {
		return documentNameDAO.findAllBl();
	}
	
	@Override
	public List<DocumentNameForBM> findAllBm() {
		return documentNameDAO.findAllBm();
	}
	
	@Override
	public List<DocumentNameForBRL> findAllBrl() {
		return documentNameDAO.findAllBrl();
	}
}