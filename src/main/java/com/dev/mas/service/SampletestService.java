package com.dev.mas.service;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.dev.mas.exception.SequenceException;

import com.dev.mas.model.Sampletest;

public interface SampletestService {
	
	public List<Sampletest> list() throws SequenceException;
	public Sampletest listById(long id) throws SequenceException;
	public List<Sampletest> findByCriteria(Query query) throws SequenceException;
	
	public void save(Sampletest sampletest) throws SequenceException;
	

}
