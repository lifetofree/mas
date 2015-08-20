package com.dev.mas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import com.dev.mas.model.MasterStatusReserved;

@Repository("masterstatusreservedDao")
public class MasterStatusReservedDaoImpl implements MasterStatusReservedDao {
	
	@Autowired
	private MongoOperations mongoOperation;
	
	private MasterStatusReserved masterstatusreserved = new MasterStatusReserved();
//	private List<Hosting> hostingList = new List<Hosting>;
	
	@Override
	public List<MasterStatusReserved> list() {
		
		List<MasterStatusReserved> masterstatusreservedList = mongoOperation.findAll(MasterStatusReserved.class);
		return masterstatusreservedList;
		
	}
	
	@Override
	public MasterStatusReserved listById(long id) {
		
		masterstatusreserved = mongoOperation.findById(id, MasterStatusReserved.class);
		return masterstatusreserved;
		
	}
	
	@Override
	public List<MasterStatusReserved> findByCriteria(Query query) {
		
		List<MasterStatusReserved> masterstatusreservedList = mongoOperation.find(query, MasterStatusReserved.class);
		return masterstatusreservedList;
		
	}
	
	@Override
	public void save(MasterStatusReserved masterstatusreserved) {

		mongoOperation.save(masterstatusreserved);

	}
	
}
