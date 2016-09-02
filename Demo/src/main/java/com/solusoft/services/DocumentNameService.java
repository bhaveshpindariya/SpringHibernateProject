package com.solusoft.services;


import java.util.List;

import com.solusoft.jpa.entity.DocumentNameForBL;
import com.solusoft.jpa.entity.DocumentNameForBM;
import com.solusoft.jpa.entity.DocumentNameForBRL;

public interface DocumentNameService {

   public List<DocumentNameForBL> findAllBl();
   
   public List<DocumentNameForBM> findAllBm();
	
   public List<DocumentNameForBRL> findAllBrl();


}