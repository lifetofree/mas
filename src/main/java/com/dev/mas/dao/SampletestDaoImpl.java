package com.dev.mas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import com.dev.mas.model.Sampletest;

@Repository("sampletestDao")
public class SampletestDaoImpl implements SampletestDao {
	
	@Autowired
	private MongoOperations mongoOperation;
	
	private Sampletest sampletest = new Sampletest();
//	private List<Hosting> hostingList = new List<Hosting>;
	
	public List<Sampletest> list() {
		
		List<Sampletest> sampletestList = mongoOperation.findAll(Sampletest.class);
		return sampletestList;
		
	}
	
	@Override
	public Sampletest listById(long id) {
		
		sampletest = mongoOperation.findById(id, Sampletest.class);
		return sampletest;
		
	}
	
	@Override
	public List<Sampletest> findByCriteria(Query query) {
		
		List<Sampletest> sampletestList = mongoOperation.find(query, Sampletest.class);
		return sampletestList;
		
	}
	
	@Override
	public void save(Sampletest sampletest) {

		mongoOperation.save(sampletest);

	}
	
	

}
