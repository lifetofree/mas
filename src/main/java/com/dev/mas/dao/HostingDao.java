package com.dev.mas.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.dev.mas.model.Hosting;

public interface HostingDao {

	public List<Hosting> list();
	public Hosting listById(long id);
	public List<Hosting> findByCriteria(Query query);
	
	public void save(Hosting hosting);

}
