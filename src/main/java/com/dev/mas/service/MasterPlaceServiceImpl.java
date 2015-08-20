package com.dev.mas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.dev.mas.dao.MasterPlaceDao;
import com.dev.mas.dao.SequenceDao;
import com.dev.mas.exception.SequenceException;

import com.dev.mas.model.MasterPlace;

@Service("masterplaceService")
public class MasterPlaceServiceImpl implements MasterPlaceService {
	
	private static final String MasterPlace_SEQ_KEY = "roomreserved_m0_tbplace";

	@Autowired
	private SequenceDao sequenceDao;

	@Autowired
	private MasterPlaceDao masterplaceDao;

	@Override
	public List<MasterPlace> list() throws SequenceException {

		
		return masterplaceDao.list();

	}

	@Override
	public MasterPlace listById(long id) throws SequenceException {

		return masterplaceDao.listById(id);

	}
	
	@Override
	public List<MasterPlace> findByCriteria(Query query) throws SequenceException {

		return masterplaceDao.findByCriteria(query);

	}
	
	@Override
	public void save(MasterPlace masterplace) throws SequenceException {

		if (masterplace.getId() == 0) {
			masterplace.setId(sequenceDao.getNextSequenceId(MasterPlace_SEQ_KEY));
		} else {
			masterplace.setId(masterplace.getId());
		}
		masterplace.setPlaceTH(masterplace.getPlaceTH());
		masterplace.setTrStatus(masterplace.getTrStatus());
		masterplace.setTrStatusDesc(masterplace.getTrStatusDesc());
		masterplaceDao.save(masterplace);

	}

}
