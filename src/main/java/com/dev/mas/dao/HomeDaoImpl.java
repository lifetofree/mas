package com.dev.mas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.dev.mas.model.Home;


@Repository("homeDao")
public class HomeDaoImpl implements HomeDao {
	
	@Autowired
	private MongoOperations mongoOperation;
	
	private Home home = new Home();
//	private List<Hosting> hostingList = new List<Hosting>;
	
	@Override
	public List<Home> list() {
		
		List<Home> homeList = mongoOperation.findAll(Home.class);
		return homeList;
		
	}
	
	@Override
	public Home listById(long id) {
		
		home = mongoOperation.findById(id, Home.class);
		return home;
		
	}
	
	@Override
	public List<Home> findByCriteria(Query query) {
		
		List<Home> homeList = mongoOperation.find(query, Home.class);
		return homeList;
		
	}
	
	@Override
	public void save(Home home) {

		mongoOperation.save(home);

	}
	
	

}
