package com.solusoft.services;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.solusoft.jpa.ReadList;
import com.solusoft.jpa.dao.AudittrailDAO;
import com.solusoft.jpa.dao.LocationDAO;
import com.solusoft.jpa.entity.Auditrail;
import com.solusoft.jpa.entity.LocationMaster;


@Service("locationService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationDAO locationDAO;

	@Autowired
	AudittrailDAO audittrailDAO;
	
	private static final String tabName="LOCATION_MASTER";
	
	private static final int tabacticve=0;
	
	@Override
	public List<LocationMaster> findAll() {
		return locationDAO.findAll();
	}
	
	@Override
	public List<LocationMaster> findAllInactive() {
		return locationDAO.findAllInactive();
	}
	
	@Override
	public ReadList update(Integer id,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		LocationMaster ll=locationDAO.findId(id);
		String code=ll.getCode();
		String lname=ll.getName();
		String news="Location Code:-"+code+", Location Name:-"+lname;
		Boolean data=locationDAO.delete(id,user);
		if(data==true){
			Auditrail de=new Auditrail();
			de.setOperation("Inactive");
			de.setRecord(""+id);
			de.setOvalue(news);
			de.setNvalue(news);
			de.setModifyBy(user);
			de.setModifyDate(new Timestamp(new Date().getTime()));
			de.setTableName(tabName);
			audittrailDAO.save(de);
			rs.setSuccess(data);
		}
		return rs;
	}
	
	@Override
	public ReadList activeId(Integer id,String user){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		LocationMaster ll=locationDAO.findId(id);
		String code=ll.getCode();
		String lname=ll.getName();
		String news="Location Code:-"+code+", Location Name:-"+lname;
		Boolean data=locationDAO.activeId(id,user);
		if(data==true){
			Auditrail de=new Auditrail();
			de.setOperation("Activation");
			de.setRecord(""+id);
			de.setOvalue(news);
			de.setNvalue(news);
			de.setModifyBy(user);
			de.setModifyDate(new Timestamp(new Date().getTime()));
			de.setTableName(tabName);
			audittrailDAO.save(de);
			rs.setSuccess(data);
		}
		return rs;
	}
	
	@Override
	public ReadList updates(Integer id,String details,String user,String code){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		LocationMaster ll=locationDAO.findId(id);
		String codes=ll.getCode();
		String lname=ll.getName();
		Timestamp createdDate;
		String createdBy;
		createdBy=ll.getCreatedBy();
		createdDate=ll.getCreatedDate();
		
		String news="";
		String old="";
		if(!codes.equalsIgnoreCase(code))
		{
			news=news+"Location Code:-"+code;
			old=old+"Location Code:-"+codes;
		}
		if(!lname.equalsIgnoreCase(details))
		{
			if(news !=""){
				news=news+", Location Name:-"+details;
				old=old+", Location Name:-"+lname;
			}else{
				news=news+"Location Name:-"+details;
				old=old+"Location Name:-"+lname;
			}
		}
		LocationMaster newss=new LocationMaster();
		newss.setId(id);
		newss.setCode(code);
		newss.setName(details);
		newss.setCreatedDate(createdDate);
		newss.setCreatedBy(createdBy);
		newss.setModifyBy(user);
		newss.setModifyDate(new Timestamp(new Date().getTime()));
		newss.setIsactive(tabacticve);
		LocationMaster data=locationDAO.save(newss);
		if(news!=""){
			if(data.getId()>0){
				Auditrail de=new Auditrail();
				de.setOperation("Update");
				de.setRecord(""+id);
				de.setNvalue(news);
				de.setOvalue(old);
				de.setModifyBy(user);
				de.setModifyDate(new Timestamp(new Date().getTime()));
				de.setTableName(tabName);
				audittrailDAO.save(de);
				rs.setSuccess(true);
			}
		}else{
			rs.setSuccess(true);
		}
		return rs;
	}
	
	@Override
	public ReadList save(String details,String user,String code){
		ReadList rs = new ReadList();
		rs.setSuccess(false);
		LocationMaster ss=new LocationMaster();
		ss.setCode(code);
		ss.setName(details);
		ss.setCreatedBy(user);
		ss.setCreatedDate(new Timestamp(new Date().getTime()));
		ss.setIsactive(tabacticve);
		String news="Location Code:-"+code+", Location Name:-"+details;
		LocationMaster data=locationDAO.save(ss);
		if(data.getId()>0){
			Auditrail de=new Auditrail();
			de.setOperation("Inserted");
			de.setRecord(""+data.getId());
			de.setNvalue(news);
			de.setOvalue("");
			de.setCreatedBy(user);
			de.setCreatedDate(new Timestamp(new Date().getTime()));
			de.setTableName(tabName);
			audittrailDAO.save(de);
			rs.setSuccess(true);
		}
		return rs;
	}
	
	@Override
	public List<LocationMaster> findNameActive(String detail,String code) {
		return locationDAO.findNameActive(detail,code);
	}
	
	@Override
	public List<LocationMaster> findNameInactive(String detail,String code) {
		return locationDAO.findNameInactive(detail,code);
	}
}