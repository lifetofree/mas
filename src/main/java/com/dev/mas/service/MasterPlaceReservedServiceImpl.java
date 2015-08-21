package com.dev.mas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.dev.mas.dao.MasterPlaceReservedDao;
import com.dev.mas.dao.SequenceDao;
import com.dev.mas.exception.SequenceException;

import com.dev.mas.model.MasterPlaceReserved;

@Service("masterplacereservedService")
public class MasterPlaceReservedServiceImpl implements MasterPlaceReservedService {
	
	private static final String MasterPlaceReserved_SEQ_KEY = "roomreserved_m0_tbplace";

	@Autowired
	private SequenceDao sequenceDao;

	@Autowired
	private MasterPlaceReservedDao masterplacereservedDao;

	@Override
	public List<MasterPlaceReserved> list() throws SequenceException {

		
		return masterplacereservedDao.list();

	}

	@Override
	public MasterPlaceReserved listById(long id) throws SequenceException {

		return masterplacereservedDao.listById(id);

	}
	
	@Override
	public List<MasterPlaceReserved> findByCriteria(Query query) throws SequenceException {

		return masterplacereservedDao.findByCriteria(query);

	}
	
	@Override
	public void save(MasterPlaceReserved masterplacereserved) throws SequenceException {

		if (masterplacereserved.getId() == 0) {
			masterplacereserved.setId(sequenceDao.getNextSequenceId(MasterPlaceReserved_SEQ_KEY));
		} else {
			masterplacereserved.setId(masterplacereserved.getId());
		}
		masterplacereserved.setPlaceTH(masterplacereserved.getPlaceTH());
		masterplacereserved.setTrStatus(masterplacereserved.getTrStatus());
		masterplacereserved.setTrStatusDesc(masterplacereserved.getTrStatusDesc());
		masterplacereservedDao.save(masterplacereserved);

	}

}
