package com.dev.mas.service;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.dev.mas.exception.SequenceException;

import com.dev.mas.model.M0_TbPlace;

public interface M0_TbPlaceService {
	
	public List<M0_TbPlace> list() throws SequenceException;
	public M0_TbPlace listById(long id) throws SequenceException;
	public List<M0_TbPlace> findByCriteria(Query query) throws SequenceException;
	
	public void save(M0_TbPlace m0_tbplace) throws SequenceException;

}
