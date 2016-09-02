package com.solusoft.jpa.dao;

import java.util.List;

import com.solusoft.jpa.entity.DocumentNameForBL;
import com.solusoft.jpa.entity.DocumentNameForBM;
import com.solusoft.jpa.entity.DocumentNameForBRL;

public interface DocumentNameDAO {

	public List<DocumentNameForBL> findAllBl();
	
	public List<DocumentNameForBRL> findAllBrl();
	
	public List<DocumentNameForBM> findAllBm();
}
