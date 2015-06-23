package com.dev.mas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.mas.dao.HostingDao;
import com.dev.mas.dao.SequenceDao;
import com.dev.mas.exception.SequenceException;
import com.dev.mas.model.Hosting;

@Service
public class HostingServiceImpl implements HostingService {

	private static final String HOSTING_SEQ_KEY = "hosting";
	 
	@Autowired
	private SequenceDao sequenceDao;
 
	@Autowired
	private HostingDao hostingDao;
 
	@Override
	public void save(Hosting hosting) throws SequenceException {
 
//		Hosting hosting = new Hosting();
 
		hosting.setId(sequenceDao.getNextSequenceId(HOSTING_SEQ_KEY));
		hosting.setName(hosting.getName());
		hosting.setDomain(hosting.getDomain());
		hostingDao.save(hosting);
 
		System.out.println(hosting);
 
	}
	
	@Override
	public List<Hosting> list() throws SequenceException {

		return hostingDao.list();
 
	}
	
}
