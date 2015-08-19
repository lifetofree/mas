package com.dev.mas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dev.mas.exception.SequenceException;
//import com.dev.mas.model.MIS_DomainHosting;
import com.dev.mas.model.MIS_DomainHosting.*;
import com.dev.mas.service.MIS_DomainHostingService;

@Controller
@RequestMapping(value = "/domainhosting")
public class MIS_DomainHostingController {
	@Autowired
	private ApplicationContext _ctx;
	
	@Autowired
	private MIS_DomainHostingService _mis_domainhostingservice;
	
//	private MIS_DomainHosting _mis_domainhosting = new MIS_DomainHosting();
	private List<m0_mis_domainlist> _m0_mis_domainlist = null;
	private Query _query = new Query();
	
	@RequestMapping(value = { "", "/domainlist" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap modelmap) {
		_m0_mis_domainlist = _getDefaultDomainList();
		modelmap.addAttribute("retDomainList", _m0_mis_domainlist);
		return "domainhosting/home";
	}
	
	private List<m0_mis_domainlist> _getDefaultDomainList() {
		try {
			_query.with(new Sort(Sort.Direction.DESC, "id"));
			_m0_mis_domainlist = _mis_domainhostingservice.m0_mis_domainlist_findBC(_query);
		}
		catch (SequenceException e) {
			
		} finally {
			
		}
		return _m0_mis_domainlist;
	}
}
