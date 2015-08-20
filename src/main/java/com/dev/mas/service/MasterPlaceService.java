package com.dev.mas.service;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.dev.mas.exception.SequenceException;

import com.dev.mas.model.MasterPlace;

public interface MasterPlaceService {
	
	public List<MasterPlace> list() throws SequenceException;
	public MasterPlace listById(long id) throws SequenceException;
	public List<MasterPlace> findByCriteria(Query query) throws SequenceException;
	
	public void save(MasterPlace masterplace) throws SequenceException;

}
