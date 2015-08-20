package com.dev.mas.service;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.dev.mas.exception.SequenceException;

import com.dev.mas.model.MasterStatusReserved;


public interface MasterStatusReservedService {
	
	public List<MasterStatusReserved> list() throws SequenceException;
	public MasterStatusReserved listById(long id) throws SequenceException;
	public List<MasterStatusReserved> findByCriteria(Query query) throws SequenceException;
	
	public void save(MasterStatusReserved masterstatusreserved) throws SequenceException;

}
