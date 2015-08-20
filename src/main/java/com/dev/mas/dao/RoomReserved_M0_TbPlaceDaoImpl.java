package com.dev.mas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import com.dev.mas.model.RoomReserved_M0_TbPlace;

@Repository("roomserved_m0_tbplace")
public class RoomReserved_M0_TbPlaceDaoImpl implements RoomReserved_M0_TbPlaceDao {
	
	@Autowired
	private MongoOperations mongoOperation;
	
	private RoomReserved_M0_TbPlace roomreserved_m0_tbplace = new RoomReserved_M0_TbPlace();
//	private List<Hosting> hostingList = new List<Hosting>;
	
	@Override
	public List<RoomReserved_M0_TbPlace> list() {
		
		List<RoomReserved_M0_TbPlace> roomreserved_m0_tbplaceList = mongoOperation.findAll(RoomReserved_M0_TbPlace.class);
		return roomreserved_m0_tbplaceList;
		
	}
	
	@Override
	public RoomReserved_M0_TbPlace listById(long id) {
		
		roomreserved_m0_tbplace = mongoOperation.findById(id, RoomReserved_M0_TbPlace.class);
		return roomreserved_m0_tbplace;
		
	}
	
	@Override
	public List<RoomReserved_M0_TbPlace> findByCriteria(Query query) {
		
		List<RoomReserved_M0_TbPlace> roomreserved_m0_tbplaceList = mongoOperation.find(query, RoomReserved_M0_TbPlace.class);
		return roomreserved_m0_tbplaceList;
		
	}
	
	@Override
	public void save(RoomReserved_M0_TbPlace roomreserved_m0_tbplace) {

		mongoOperation.save(roomreserved_m0_tbplace);

	}

	
}
