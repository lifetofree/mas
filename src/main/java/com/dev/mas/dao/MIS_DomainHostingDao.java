package com.dev.mas.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.dev.mas.model.MIS_DomainHosting.*;

public interface MIS_DomainHostingDao {
	public List<m0_mis_domainlist> m0_mis_domainlist_findBC(Query query);
	public void saveDomainList(m0_mis_domainlist domainlist);
}
