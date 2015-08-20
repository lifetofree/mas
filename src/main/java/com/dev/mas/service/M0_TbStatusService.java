package com.dev.mas.service;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.dev.mas.exception.SequenceException;

import com.dev.mas.model.M0_TbStatus;

public interface M0_TbStatusService {
	
	public List<M0_TbStatus> list() throws SequenceException;
	public M0_TbStatus listById(long id) throws SequenceException;
	public List<M0_TbStatus> findByCriteria(Query query) throws SequenceException;
	
	public void save(M0_TbStatus m0_tbstatus) throws SequenceException;

}
