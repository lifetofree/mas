package com.dev.mas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;



import com.dev.mas.model.Roombooking;

@Repository("roombookingDao")
public class RoombookingDaoImpl implements RoombookingDao {
	
	@Autowired
	private MongoOperations mongoOperation;
	
	private Roombooking roombooking = new Roombooking();
//	private List<Roombooking> roombookingList = new List<Roombooking>;
	
	@Override
	public List<Roombooking> list() {
		
		List<Roombooking> roombookingList = mongoOperation.findAll(Roombooking.class);
		return roombookingList;
		
	}
	
	@Override
	public Roombooking listById(long id) {
		
		roombooking = mongoOperation.findById(id, Roombooking.class);
		return roombooking;
		
	}
	
	@Override
	public List<Roombooking> findByCriteria(Query query) {
		
		List<Roombooking> roombookingList = mongoOperation.find(query, Roombooking.class);
		return roombookingList;
		
	}
	
	@Override
	public void save(Roombooking roombooking) {

		mongoOperation.save(roombooking);

	}

}
