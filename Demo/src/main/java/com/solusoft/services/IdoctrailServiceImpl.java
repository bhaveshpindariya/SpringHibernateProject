package com.solusoft.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.solusoft.jpa.dao.IdoctrailDAO;
import com.solusoft.jpa.entity.Idoctrail;


@Service("idoctrailService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class IdoctrailServiceImpl implements IdoctrailService {

	@Autowired
	IdoctrailDAO idoctrailDAO;

	@Override
	public List<Idoctrail> findAll() {
		return idoctrailDAO.findAll();
	}
	
	public Idoctrail findId(long id) {
		return idoctrailDAO.findId(id);
	}
	
	public Idoctrail save(Idoctrail details) {
		return idoctrailDAO.save(details);
	}
	
	public void delete(Idoctrail details) {
		 idoctrailDAO.delete(details);
	}
	
}