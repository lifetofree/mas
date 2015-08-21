package com.dev.mas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import com.dev.mas.model.M0_TbRoom;

@Repository("m0_tbroomDao")
public class M0_TbRoomImpl implements M0_TbRoomDao {
	
	@Autowired
	private MongoOperations mongoOperation;
	
	private M0_TbRoom m0_tbroom = new M0_TbRoom();
//	private List<Hosting> hostingList = new List<Hosting>;
	
	@Override
	public List<M0_TbRoom> list() {
		
		List<M0_TbRoom> m0_tbroomList = mongoOperation.findAll(M0_TbRoom.class);
		return m0_tbroomList;
		
	}
	
	@Override
	public M0_TbRoom listById(long id) {
		
		m0_tbroom = mongoOperation.findById(id, M0_TbRoom.class);
		return m0_tbroom;
		
	}
	
	@Override
	public List<M0_TbRoom> findByCriteria(Query query) {
		
		List<M0_TbRoom> m0_tbroomList = mongoOperation.find(query, M0_TbRoom.class);
		return m0_tbroomList;
		
	}
	
	@Override
	public void save(M0_TbRoom m0_tbroom) {

		mongoOperation.save(m0_tbroom);

	}

}
