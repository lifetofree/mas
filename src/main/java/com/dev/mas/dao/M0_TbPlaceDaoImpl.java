package com.dev.mas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import com.dev.mas.model.M0_TbPlace;

@Repository("m0_tbplaceDao")
public class M0_TbPlaceDaoImpl implements M0_TbPlaceDao {

	@Autowired
	private MongoOperations mongoOperation;
	
	private M0_TbPlace m0_tbplace = new M0_TbPlace();
//	private List<Hosting> hostingList = new List<Hosting>;
	
	@Override
	public List<M0_TbPlace> list() {
		
		List<M0_TbPlace> m0_tbplaceList = mongoOperation.findAll(M0_TbPlace.class);
		return m0_tbplaceList;
		
	}
	
	@Override
	public M0_TbPlace listById(long id) {
		
		m0_tbplace = mongoOperation.findById(id, M0_TbPlace.class);
		return m0_tbplace;
		
	}
	
	@Override
	public List<M0_TbPlace> findByCriteria(Query query) {
		
		List<M0_TbPlace> m0_tbplaceList = mongoOperation.find(query, M0_TbPlace.class);
		return m0_tbplaceList;
		
	}
	
	@Override
	public void save(M0_TbPlace m0_tbplace) {

		mongoOperation.save(m0_tbplace);

	}

}
