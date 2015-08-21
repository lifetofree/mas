package com.dev.mas.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.dev.mas.model.Home;

public interface HomeDao {
	
	public List<Home> list();
	public Home listById(long id);
	public List<Home> findByCriteria(Query query);
	
	public void save(Home home);

}
