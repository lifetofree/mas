package com.dev.mas.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.dev.mas.model.Roombooking;

public interface RoombookingDao {
	
	public List<Roombooking> list();
	public Roombooking listById(long id);
	public List<Roombooking> findByCriteria(Query query);
	
	public void save(Roombooking roombooking);

}
