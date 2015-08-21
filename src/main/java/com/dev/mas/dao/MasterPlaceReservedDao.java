package com.dev.mas.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;


import com.dev.mas.model.MasterPlaceReserved;

public interface MasterPlaceReservedDao {
	

	public List<MasterPlaceReserved> list();
	public MasterPlaceReserved listById(long id);
	public List<MasterPlaceReserved> findByCriteria(Query query);
	
	public void save(MasterPlaceReserved roomreserved_m0_tbplace);


}
