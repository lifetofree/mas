package com.dev.mas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


import com.dev.mas.dao.RoomReserved_M0_TbPlaceDao;
import com.dev.mas.dao.SequenceDao;
import com.dev.mas.exception.SequenceException;

import com.dev.mas.model.RoomReserved_M0_TbPlace;

@Service("roomreserved_m0_tbplaceService")
public class RoomReserved_M0_TbPlaceServiceImpl implements RoomReserved_M0_TbPlaceService {
	
	private static final String RoomReserved_M0_TbPlace_SEQ_KEY = "roomreserved_m0_tbplace";

	@Autowired
	private SequenceDao sequenceDao;

	@Autowired
	private RoomReserved_M0_TbPlaceDao roomreserved_m0_tbplaceDao;

	@Override
	public List<RoomReserved_M0_TbPlace> list() throws SequenceException {

		return roomreserved_m0_tbplaceDao.list();

	}

	@Override
	public RoomReserved_M0_TbPlace listById(long id) throws SequenceException {

		return roomreserved_m0_tbplaceDao.listById(id);

	}
	
	@Override
	public List<RoomReserved_M0_TbPlace> findByCriteria(Query query) throws SequenceException {

		return roomreserved_m0_tbplaceDao.findByCriteria(query);

	}
	
	@Override
	public void save(RoomReserved_M0_TbPlace roomreserved_m0_tbplace) throws SequenceException {

		if (roomreserved_m0_tbplace.getId() == 0) {
			roomreserved_m0_tbplace.setId(sequenceDao.getNextSequenceId(RoomReserved_M0_TbPlace_SEQ_KEY));
		} else {
			roomreserved_m0_tbplace.setId(roomreserved_m0_tbplace.getId());
		}
		roomreserved_m0_tbplace.setName(roomreserved_m0_tbplace.getName());
		roomreserved_m0_tbplace.setDomain(roomreserved_m0_tbplace.getDomain());
		roomreserved_m0_tbplaceDao.save(roomreserved_m0_tbplace);

	}
	

}
