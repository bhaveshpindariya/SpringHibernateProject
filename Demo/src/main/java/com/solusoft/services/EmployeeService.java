package com.solusoft.services;


import java.util.List;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.EmployeeMaster;


public interface EmployeeService {

	public List<EmployeeMaster> findAll();
	
	public List<EmployeeMaster> findAlls(Integer ccode);
	
	public EmployeeMaster save(EmployeeMaster obj);
	 
    public EmployeeMaster findId(long id);
    
    public void saves(Auditrail de);
    
    public EmployeeMaster findName(String name);
}