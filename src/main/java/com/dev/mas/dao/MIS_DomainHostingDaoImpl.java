package com.dev.mas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.dev.mas.model.MIS_DomainHosting.*;

@Repository("MIS_DomainHostingDao")
public class MIS_DomainHostingDaoImpl implements MIS_DomainHostingDao {
	@Autowired
	private MongoOperations mongoOperation;
	
	@Override
	public List<m0_mis_domainlist> m0_mis_domainlist_findBC(Query query) {
		List<m0_mis_domainlist> domainlist = mongoOperation.find(query, m0_mis_domainlist.class);
		return domainlist;
	}
	
	@Override
	public void saveDomainList(m0_mis_domainlist domainlist) {
		mongoOperation.save(domainlist);
	}
}
