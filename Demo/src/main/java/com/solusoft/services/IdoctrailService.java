package com.solusoft.services;


import java.util.List;
import com.solusoft.jpa.entity.Idoctrail;

public interface IdoctrailService {

     public Idoctrail save(Idoctrail details);
     
     public void delete(Idoctrail details);
	 
	 public List<Idoctrail> findAll();
	  
	 public Idoctrail findId(long id);
}