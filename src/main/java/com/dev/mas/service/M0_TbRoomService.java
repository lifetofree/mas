package com.dev.mas.service;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.dev.mas.exception.SequenceException;

import com.dev.mas.model.M0_TbRoom;

public interface M0_TbRoomService {
	
	public List<M0_TbRoom> list() throws SequenceException;
	public M0_TbRoom listById(long id) throws SequenceException;
	public List<M0_TbRoom> findByCriteria(Query query) throws SequenceException;
	
	public void save(M0_TbRoom m0_tbroom) throws SequenceException;

}
