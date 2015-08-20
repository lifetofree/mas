package com.dev.mas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.dev.mas.dao.M0_TbStatusDao;
import com.dev.mas.dao.SequenceDao;
import com.dev.mas.exception.SequenceException;

import com.dev.mas.model.M0_TbStatus;

@Service("m0_tbstatusService")
public class M0_TbStatusServiceImpl implements M0_TbStatusService {
	
	private static final String M0_TbStatus_SEQ_KEY = "m0_tbstatus";

	@Autowired
	private SequenceDao sequenceDao;

	@Autowired
	private M0_TbStatusDao m0_tbstatusDao;

	@Override
	public List<M0_TbStatus> list() throws SequenceException {

		return m0_tbstatusDao.list();

	}

	@Override
	public M0_TbStatus listById(long id) throws SequenceException {

		return m0_tbstatusDao.listById(id);

	}
	
	@Override
	public List<M0_TbStatus> findByCriteria(Query query) throws SequenceException {

		return m0_tbstatusDao.findByCriteria(query);

	}
	
	@Override
	public void save(M0_TbStatus m0_tbstatus) throws SequenceException {

		if (m0_tbstatus.getId() == 0) {
			m0_tbstatus.setId(sequenceDao.getNextSequenceId(M0_TbStatus_SEQ_KEY));
		} else {
			m0_tbstatus.setId(m0_tbstatus.getId());
		}
		m0_tbstatus.setName(m0_tbstatus.getName());
		m0_tbstatus.setDomain(m0_tbstatus.getDomain());
		m0_tbstatusDao.save(m0_tbstatus);

	}

}
