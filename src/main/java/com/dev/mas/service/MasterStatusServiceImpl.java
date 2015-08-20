package com.dev.mas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


import com.dev.mas.dao.MasterStatusDao;
import com.dev.mas.dao.SequenceDao;
import com.dev.mas.exception.SequenceException;

import com.dev.mas.model.MasterStatus;

@Service("masterstatusService")
public class MasterStatusServiceImpl implements MasterStatusService {
	
	private static final String MasterStatus_SEQ_KEY = "roomreserved_m0_tbstatus";

	@Autowired
	private SequenceDao sequenceDao;

	@Autowired
	private MasterStatusDao masterstatusDao;

	@Override
	public List<MasterStatus> list() throws SequenceException {

		return masterstatusDao.list();

	}

	@Override
	public MasterStatus listById(long id) throws SequenceException {

		return masterstatusDao.listById(id);

	}
	
	@Override
	public List<MasterStatus> findByCriteria(Query query) throws SequenceException {

		return masterstatusDao.findByCriteria(query);

	}
	
	@Override
	public void save(MasterStatus masterstatus) throws SequenceException {

		if (masterstatus.getId() == 0) {
			masterstatus.setId(sequenceDao.getNextSequenceId(MasterStatus_SEQ_KEY));
		} else {
			masterstatus.setId(masterstatus.getId());
		}
		masterstatus.setStatusTH(masterstatus.getStatusTH());
		masterstatus.setStatusEN(masterstatus.getStatusEN());
		masterstatusDao.save(masterstatus);

	}

}
