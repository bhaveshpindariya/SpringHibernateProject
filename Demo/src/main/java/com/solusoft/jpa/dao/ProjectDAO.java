package com.solusoft.jpa.dao;

import java.util.List;
import com.solusoft.jpa.entity.ProjectMaster;


public interface ProjectDAO {

	 public List<ProjectMaster> findAll();
	 
	 public ProjectMaster findId(long id);
	 
	 public ProjectMaster save(ProjectMaster obj);
}
