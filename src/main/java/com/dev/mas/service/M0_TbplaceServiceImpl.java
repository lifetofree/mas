package com.dev.mas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.dev.mas.dao.M0_TbPlaceDao;
import com.dev.mas.dao.SequenceDao;
import com.dev.mas.exception.SequenceException;
import com.dev.mas.model.M0_TbPlace;

@Service("m0_tbplaceService")
public class M0_TbplaceServiceImpl implements M0_TbPlaceService {
	
	private static final String M0_TbPlace_SEQ_KEY = "m0_tbplace";

	@Autowired
	private SequenceDao sequenceDao;

	@Autowired
	private M0_TbPlaceDao m0_tbplaceDao;

	@Override
	public List<M0_TbPlace> list() throws SequenceException {

		return m0_tbplaceDao.list();

	}

	@Override
	public M0_TbPlace listById(long id) throws SequenceException {

		return m0_tbplaceDao.listById(id);

	}
	
	@Override
	public List<M0_TbPlace> findByCriteria(Query query) throws SequenceException {

		return m0_tbplaceDao.findByCriteria(query);

	}
	
	@Override
	public void save(M0_TbPlace m0_tbplace) throws SequenceException {

		if (m0_tbplace.getId() == 0) {
			m0_tbplace.setId(sequenceDao.getNextSequenceId(M0_TbPlace_SEQ_KEY));
		} else {
			m0_tbplace.setId(m0_tbplace.getId());
		}
		m0_tbplace.setName(m0_tbplace.getName());
		m0_tbplace.setDomain(m0_tbplace.getDomain());
		m0_tbplaceDao.save(m0_tbplace);

	}

}
