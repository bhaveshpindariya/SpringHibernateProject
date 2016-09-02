package com.solusoft.services;


import java.util.List;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.ProjectMaster;


public interface ProjectService {

	public List<ProjectMaster> findAll();
	
	public ProjectMaster save(ProjectMaster obj);
	 
	public ProjectMaster findId(long id);
	
	public void saves(Auditrail de);
}