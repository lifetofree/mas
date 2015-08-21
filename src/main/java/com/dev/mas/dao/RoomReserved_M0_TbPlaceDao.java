package com.dev.mas.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;


import com.dev.mas.model.RoomReserved_M0_TbPlace;

public interface RoomReserved_M0_TbPlaceDao {
	
	public List<RoomReserved_M0_TbPlace> list();
	public RoomReserved_M0_TbPlace listById(long id);
	public List<RoomReserved_M0_TbPlace> findByCriteria(Query query);
	
	public void save(RoomReserved_M0_TbPlace roomreserved_m0_tbplace);


}
