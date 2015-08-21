package com.dev.mas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


import com.dev.mas.dao.M0_TbRoomDao;
import com.dev.mas.dao.SequenceDao;
import com.dev.mas.exception.SequenceException;

import com.dev.mas.model.M0_TbRoom;

@Service("m0_tbroomService")
public class M0_TbRoomServiceImpl implements M0_TbRoomService {
	
	private static final String M0_TbRoom_SEQ_KEY = "m0_tbroom";

	@Autowired
	private SequenceDao sequenceDao;

	@Autowired
	private M0_TbRoomDao m0_tbroomDao;

	@Override
	public List<M0_TbRoom> list() throws SequenceException {

		return m0_tbroomDao.list();

	}

	@Override
	public M0_TbRoom listById(long id) throws SequenceException {

		return m0_tbroomDao.listById(id);

	}
	
	@Override
	public List<M0_TbRoom> findByCriteria(Query query) throws SequenceException {

		return m0_tbroomDao.findByCriteria(query);

	}
	
	@Override
	public void save(M0_TbRoom m0_tbroom) throws SequenceException {

		if (m0_tbroom.getId() == 0) {
			m0_tbroom.setId(sequenceDao.getNextSequenceId(M0_TbRoom_SEQ_KEY));
		} else {
			m0_tbroom.setId(m0_tbroom.getId());
		}
		m0_tbroom.setName(m0_tbroom.getName());
		m0_tbroom.setQuantity(m0_tbroom.getQuantity());
		m0_tbroomDao.save(m0_tbroom);

	}

}
