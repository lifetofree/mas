package com.dev.mas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.dev.mas.model.Hosting;

@Service
public class HostingDaoImpl implements HostingDao {

	@Autowired
	private MongoOperations mongoOperation;
	
	private Hosting hosting = new Hosting();
//	private List<Hosting> hostingList = new List<Hosting>;
	
	@Override
	public List<Hosting> list() {
		
		List<Hosting> hostingList = mongoOperation.findAll(Hosting.class);
		return hostingList;
		
	}
	
	@Override
	public Hosting listById(long id) {
		
		hosting = mongoOperation.findById(id, Hosting.class);
		return hosting;
		
	}
	
	@Override
	public List<Hosting> findByCriteria(Query query) {
		
		List<Hosting> hostingList = mongoOperation.find(query, Hosting.class);
		return hostingList;
		
	}
	
	@Override
	public void save(Hosting hosting) {

		mongoOperation.save(hosting);

	}

}
