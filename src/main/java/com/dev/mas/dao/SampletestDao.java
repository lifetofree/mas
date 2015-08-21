package com.dev.mas.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;


import com.dev.mas.model.Sampletest;

public interface SampletestDao {

	public List<Sampletest> list();
	public Sampletest listById(long id);
	public List<Sampletest> findByCriteria(Query query);
	
	public void save(Sampletest sampletest);

}
