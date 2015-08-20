package com.dev.mas.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;


import com.dev.mas.model.MasterStatus;

public interface MasterStatusDao {
	
	public List<MasterStatus> list();
	public MasterStatus listById(long id);
	public List<MasterStatus> findByCriteria(Query query);
	
	public void save(MasterStatus masterstatus);

}
