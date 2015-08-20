package com.dev.mas.service;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.dev.mas.exception.SequenceException;

import com.dev.mas.model.MasterPlaceReserved;

public interface MasterPlaceReservedService {
	
	public List<MasterPlaceReserved> list() throws SequenceException;
	public MasterPlaceReserved listById(long id) throws SequenceException;
	public List<MasterPlaceReserved> findByCriteria(Query query) throws SequenceException;
	
	public void save(MasterPlaceReserved masterplacereserved) throws SequenceException;

}
