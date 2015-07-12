package com.dev.mas.service;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.dev.mas.exception.SequenceException;
import com.dev.mas.model.Hosting;

public interface HostingService {

	public List<Hosting> list() throws SequenceException;
	public Hosting listById(long id) throws SequenceException;
	public List<Hosting> findByCriteria(Query query) throws SequenceException;
	
	public void save(Hosting hosting) throws SequenceException;
	
}
