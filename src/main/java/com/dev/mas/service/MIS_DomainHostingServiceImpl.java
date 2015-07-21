package com.dev.mas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.dev.mas.dao.MIS_DomainHostingDao;
import com.dev.mas.dao.SequenceDao;
import com.dev.mas.exception.SequenceException;
import com.dev.mas.model.MIS_DomainHosting.*;

@Service("MIS_DomainHostingService")
public class MIS_DomainHostingServiceImpl implements MIS_DomainHostingService {
	private static final String M0_MIS_DOMAINLIST_SEQ_KEY = "m0_mis_domainlst";

	@Autowired
	private SequenceDao sequenceDao;
	
	@Autowired
	private MIS_DomainHostingDao mis_domainhostingdao;
	
	@Override
	public List<m0_mis_domainlist> m0_mis_domainlist_findBC(Query query) throws SequenceException {
		return mis_domainhostingdao.m0_mis_domainlist_findBC(query);
	}
	
	@Override
	public void saveDomainList(m0_mis_domainlist domainlist) throws SequenceException {
		if(domainlist.getId() == 0) {
			domainlist.setId(sequenceDao.getNextSequenceId(M0_MIS_DOMAINLIST_SEQ_KEY));
		} else {
			domainlist.setId(domainlist.getId());
		}
		domainlist.setDomain(domainlist.getDomain());
		domainlist.setStatus(domainlist.getStatus());
	}
}
