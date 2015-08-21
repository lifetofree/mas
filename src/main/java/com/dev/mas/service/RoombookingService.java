package com.dev.mas.service;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.dev.mas.exception.SequenceException;

import com.dev.mas.model.Roombooking;

public interface RoombookingService {
	
	public List<Roombooking> list() throws SequenceException;
	public Roombooking listById(long id) throws SequenceException;
	public List<Roombooking> findByCriteria(Query query) throws SequenceException;
	
	public void save(Roombooking roombooking) throws SequenceException;

}
