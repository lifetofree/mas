package com.dev.mas.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;


import com.dev.mas.model.M0_TbRoom;

public interface M0_TbRoomDao {
	
	public List<M0_TbRoom> list();
	public M0_TbRoom listById(long id);
	public List<M0_TbRoom> findByCriteria(Query query);
	
	public void save(M0_TbRoom m0_tbroom);

}
