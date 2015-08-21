package com.dev.mas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.dev.mas.dao.SampletestDao;
import com.dev.mas.dao.SequenceDao;
import com.dev.mas.exception.SequenceException;

import com.dev.mas.model.Sampletest;

@Service("sampletestService")
public class SampletestServiceImpl implements SampletestService {
	
	private static final String Sampletest_SEQ_KEY = "sampletest";

	@Autowired
	private SequenceDao sequenceDao;

	@Autowired
	private SampletestDao sampletestDao;

	@Override
	public List<Sampletest> list() throws SequenceException {

		return sampletestDao.list();

	}

	@Override
	public Sampletest listById(long id) throws SequenceException {

		return sampletestDao.listById(id);

	}
	
	@Override
	public List<Sampletest> findByCriteria(Query query) throws SequenceException {

		return sampletestDao.findByCriteria(query);

	}
	
	@Override
	public void save(Sampletest sampletest) throws SequenceException {

		if (sampletest.getId() == 0) {
			sampletest.setId(sequenceDao.getNextSequenceId(Sampletest_SEQ_KEY));
		} else {
			sampletest.setId(sampletest.getId());
		}
		sampletest.setName(sampletest.getName());
		sampletest.setLastname(sampletest.getLastname());
		sampletest.setPlace(sampletest.getPlace());
		sampletest.setQuantity(sampletest.getQuantity());
		sampletestDao.save(sampletest);
		

	}

	
	

}
