package com.dev.mas.service;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.dev.mas.exception.SequenceException;
import com.dev.mas.model.MIS_DomainHosting.*;

public interface MIS_DomainHostingService {
	public List<m0_mis_domainlist> m0_mis_domainlist_findBC(Query query) throws SequenceException;
	public void saveDomainList(m0_mis_domainlist domainlist) throws SequenceException;
}
