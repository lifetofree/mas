package com.dev.mas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


import com.dev.mas.dao.MasterStatusReservedDao;
import com.dev.mas.dao.SequenceDao;
import com.dev.mas.exception.SequenceException;

import com.dev.mas.model.MasterStatusReserved;

@Service("masterstatusreservedService")
public class MasterStatusReservedServiceImpl implements MasterStatusReservedService {
	
	private static final String MasterStatusReserved_SEQ_KEY = "roomreserved_m0_tbstatus";

	@Autowired
	private SequenceDao sequenceDao;

	@Autowired
	private MasterStatusReservedDao masterstatusreservedDao;

	@Override
	public List<MasterStatusReserved> list() throws SequenceException {

		return masterstatusreservedDao.list();

	}

	@Override
	public MasterStatusReserved listById(long id) throws SequenceException {

		return masterstatusreservedDao.listById(id);

	}
	
	@Override
	public List<MasterStatusReserved> findByCriteria(Query query) throws SequenceException {

		return masterstatusreservedDao.findByCriteria(query);

	}
	
	@Override
	public void save(MasterStatusReserved masterstatusreserved) throws SequenceException {

		if (masterstatusreserved.getId() == 0) {
			masterstatusreserved.setId(sequenceDao.getNextSequenceId(MasterStatusReserved_SEQ_KEY));
		} else {
			masterstatusreserved.setId(masterstatusreserved.getId());
		}
		masterstatusreserved.setStatusTH(masterstatusreserved.getStatusTH());
		masterstatusreserved.setStatusEN(masterstatusreserved.getStatusEN());
		masterstatusreservedDao.save(masterstatusreserved);

	}

}
