package com.dev.mas.service;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.dev.mas.exception.SequenceException;

import com.dev.mas.model.RoomReserved_M0_TbPlace;

public interface RoomReserved_M0_TbPlaceService {
	
	public List< RoomReserved_M0_TbPlace> list() throws SequenceException;
	public  RoomReserved_M0_TbPlace listById(long id) throws SequenceException;
	public List< RoomReserved_M0_TbPlace> findByCriteria(Query query) throws SequenceException;
	
	public void save( RoomReserved_M0_TbPlace roomreserved_m0_tbplace) throws SequenceException;

}
