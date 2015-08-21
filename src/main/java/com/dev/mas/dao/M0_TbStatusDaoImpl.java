package com.dev.mas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import com.dev.mas.model.M0_TbStatus;

@Repository("m0_tbstatusDao")
public class M0_TbStatusDaoImpl implements M0_TbStatusDao {
	
	@Autowired
	private MongoOperations mongoOperation;
	
	private M0_TbStatus m0_tbstatus = new M0_TbStatus();
//	private List<Hosting> hostingList = new List<Hosting>;
	
	@Override
	public List<M0_TbStatus> list() {
		
		List<M0_TbStatus> m0_tbstatusList = mongoOperation.findAll(M0_TbStatus.class);
		return m0_tbstatusList;
		
	}
	
	@Override
	public M0_TbStatus listById(long id) {
		
		m0_tbstatus = mongoOperation.findById(id, M0_TbStatus.class);
		return m0_tbstatus;
		
	}
	
	@Override
	public List<M0_TbStatus> findByCriteria(Query query) {
		
		List<M0_TbStatus> m0_tbstatusList = mongoOperation.find(query, M0_TbStatus.class);
		return m0_tbstatusList;
		
	}
	
	@Override
	public void save(M0_TbStatus m0_tbstatus) {

		mongoOperation.save(m0_tbstatus);

	}


}
