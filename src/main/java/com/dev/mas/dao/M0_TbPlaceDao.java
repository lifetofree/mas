package com.dev.mas.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;


import com.dev.mas.model.M0_TbPlace;


public interface M0_TbPlaceDao {
	
	public List<M0_TbPlace> list();
	public M0_TbPlace listById(long id);
	public List<M0_TbPlace> findByCriteria(Query query);
	
	public void save(M0_TbPlace m0_tbplace);


}
