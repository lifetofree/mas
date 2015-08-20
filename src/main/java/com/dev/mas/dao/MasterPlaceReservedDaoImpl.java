package com.dev.mas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.dev.mas.model.MasterPlaceReserved;

@Repository("masterplacereservedDao")
public class MasterPlaceReservedDaoImpl implements MasterPlaceReservedDao {
	
	@Autowired
	private MongoOperations mongoOperation;
	
	private MasterPlaceReserved masterplacereserved = new MasterPlaceReserved();
//	private List<Hosting> hostingList = new List<Hosting>;
	
	@Override
	public List<MasterPlaceReserved> list() {
		
		List<MasterPlaceReserved> masterplacereservedList = mongoOperation.findAll(MasterPlaceReserved.class);
		return masterplacereservedList;
		
	}
	
	@Override
	public MasterPlaceReserved listById(long id) {
		
		masterplacereserved = mongoOperation.findById(id, MasterPlaceReserved.class);
		return masterplacereserved;
		
	}
	
	@Override
	public List<MasterPlaceReserved> findByCriteria(Query query) {
		
		List<MasterPlaceReserved> masterplacereservedList = mongoOperation.find(query, MasterPlaceReserved.class);
		return masterplacereservedList;
		
	}
	
	@Override
	public void save(MasterPlaceReserved masterplacereserved) {

		mongoOperation.save(masterplacereserved);

	}

}