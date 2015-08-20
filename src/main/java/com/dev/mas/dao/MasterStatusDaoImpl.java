package com.dev.mas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import com.dev.mas.model.MasterStatus;

@Repository("masterstatusDao")
public class MasterStatusDaoImpl implements MasterStatusDao {
	
	@Autowired
	private MongoOperations mongoOperation;
	
	private MasterStatus masterstatus = new MasterStatus();
//	private List<Hosting> hostingList = new List<Hosting>;
	
	@Override
	public List<MasterStatus> list() {
		
		List<MasterStatus> masterstatusList = mongoOperation.findAll(MasterStatus.class);
		return masterstatusList;
		
	}
	
	@Override
	public MasterStatus listById(long id) {
		
		masterstatus = mongoOperation.findById(id, MasterStatus.class);
		return masterstatus;
		
	}
	
	@Override
	public List<MasterStatus> findByCriteria(Query query) {
		
		List<MasterStatus> masterstatusList = mongoOperation.find(query, MasterStatus.class);
		return masterstatusList;
		
	}
	
	@Override
	public void save(MasterStatus masterstatus) {

		mongoOperation.save(masterstatus);

	}
	
}
