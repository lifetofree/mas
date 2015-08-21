package com.dev.mas.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;


import com.dev.mas.model.MasterStatusReserved;

public interface MasterStatusReservedDao {
	
	public List<MasterStatusReserved> list();
	public MasterStatusReserved listById(long id);
	public List<MasterStatusReserved> findByCriteria(Query query);
	
	public void save(MasterStatusReserved masterstatusreserved);

}
