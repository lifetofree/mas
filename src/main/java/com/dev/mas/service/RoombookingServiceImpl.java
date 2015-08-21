package com.dev.mas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;



import com.dev.mas.dao.RoombookingDao;
import com.dev.mas.dao.SequenceDao;
import com.dev.mas.exception.SequenceException;
import com.dev.mas.model.Roombooking;

@Service("roombookingService")
public class RoombookingServiceImpl implements RoombookingService {
	
	private static final String Roombooking_SEQ_KEY = "roombooking";

	@Autowired
	private SequenceDao sequenceDao;

	@Autowired
	private RoombookingDao roombookingDao;

	@Override
	public List<Roombooking> list() throws SequenceException {

		return roombookingDao.list();

	}

	@Override
	public Roombooking listById(long id) throws SequenceException {

		return roombookingDao.listById(id);

	}
	
	@Override
	public List<Roombooking> findByCriteria(Query query) throws SequenceException {

		return roombookingDao.findByCriteria(query);

	}
	
	@Override
	public void save(Roombooking roombooking) throws SequenceException {

		if (roombooking.getId() == 0) {
			roombooking.setId(sequenceDao.getNextSequenceId(Roombooking_SEQ_KEY));
		} else {
			roombooking.setId(roombooking.getId());
		}
		roombooking.setName(roombooking.getName());
		roombooking.setDomain(roombooking.getDomain());
		roombookingDao.save(roombooking);

	}


}
