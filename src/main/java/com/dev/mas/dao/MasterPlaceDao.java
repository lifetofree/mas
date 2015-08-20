package com.dev.mas.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;


import com.dev.mas.model.MasterPlace;

public interface MasterPlaceDao {
	

	public List<MasterPlace> list();
	public MasterPlace listById(long id);
	public List<MasterPlace> findByCriteria(Query query);
	
	public void save(MasterPlace roomreserved_m0_tbplace);


}
