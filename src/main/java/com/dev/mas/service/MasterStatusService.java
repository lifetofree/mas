package com.dev.mas.service;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.dev.mas.exception.SequenceException;

import com.dev.mas.model.MasterStatus;


public interface MasterStatusService {
	
	public List<MasterStatus> list() throws SequenceException;
	public MasterStatus listById(long id) throws SequenceException;
	public List<MasterStatus> findByCriteria(Query query) throws SequenceException;
	
	public void save(MasterStatus masterstatus) throws SequenceException;

}
