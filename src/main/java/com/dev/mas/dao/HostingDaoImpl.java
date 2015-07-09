package com.dev.mas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.dev.mas.model.Hosting;

@Service
public class HostingDaoImpl implements HostingDao {

	@Autowired
	private MongoOperations mongoOperation;

	@Override
	public void save(Hosting hosting) {

		mongoOperation.save(hosting);

	}
	
	@Override
	public List<Hosting> list() {
		
		List<Hosting> hostingList = mongoOperation.findAll(Hosting.class);
		return hostingList;
		
	}
	
	@Override
	public Hosting listById(int id) {
		
		Hosting hosting = mongoOperation.findById(id, Hosting.class);
		return hosting;
		
	}

}
