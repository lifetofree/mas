package com.dev.mas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.dev.mas.model.MasterPlace;

@Repository("masterplaceDao")
public class MasterPlaceDaoImpl implements MasterPlaceDao {
	
	@Autowired
	private MongoOperations mongoOperation;
	
	private MasterPlace masterplace = new MasterPlace();
//	private List<Hosting> hostingList = new List<Hosting>;
	
	@Override
	public List<MasterPlace> list() {
		
		List<MasterPlace> masterplaceList = mongoOperation.findAll(MasterPlace.class);
		return masterplaceList;
		
	}
	
	@Override
	public MasterPlace listById(long id) {
		
		masterplace = mongoOperation.findById(id, MasterPlace.class);
		return masterplace;
		
	}
	
	@Override
	public List<MasterPlace> findByCriteria(Query query) {
		
		List<MasterPlace> masterplaceList = mongoOperation.find(query, MasterPlace.class);
		return masterplaceList;
		
	}
	
	@Override
	public void save(MasterPlace masterplace) {

		mongoOperation.save(masterplace);

	}

}