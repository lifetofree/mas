package com.dev.mas.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;


import com.dev.mas.model.M0_TbStatus;

public interface M0_TbStatusDao {
	
	public List<M0_TbStatus> list();
	public M0_TbStatus listById(long id);
	public List<M0_TbStatus> findByCriteria(Query query);
	
	public void save(M0_TbStatus m0_tbstatus);

}
