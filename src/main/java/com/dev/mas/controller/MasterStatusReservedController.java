package com.dev.mas.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev.mas.exception.SequenceException;

import com.dev.mas.model.MasterStatusReserved;

import com.dev.mas.service.MasterStatusReservedService;

@Controller
@RequestMapping(value = "/status")
public class MasterStatusReservedController {
	
	@Autowired
	private ApplicationContext ctx;
	
	//@Autowired
	//private RoomReservedService roomreservedService;


	@Autowired
	private MasterStatusReservedService masterstatusreservedService; // RoomReservedService roomservedService

	private MasterStatusReserved masterstatusreserved = new MasterStatusReserved();

	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap modelmap) {
		List<MasterStatusReserved> statustList = null;
		try {
			statustList = getListMasterStatus();
			modelmap.addAttribute("addStatus", new MasterStatusReserved());
			modelmap.addAttribute("retSampleList", statustList);
			modelmap.addAttribute("retSamples", "---");
		} catch (SequenceException e) {
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {
			statustList = null;
		}

		return "MasterStatusReserved";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String processEdit(ModelMap modelmap, @PathVariable int id) {
		List<MasterStatusReserved> statustList = null;
		try {

			// show form
			masterstatusreserved = masterstatusreservedService.listById(id); // roomservedService , Idstatus
			modelmap.addAttribute("addStatus", masterstatusreserved);

			// all list
			statustList = getListMasterStatus();
			modelmap.addAttribute("retSampleList", statustList);
			modelmap.addAttribute("retSamples", "---");
		} catch (SequenceException e) {
			System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "MasterStatusReserved";
	}

	@RequestMapping(value = { "/edit" }, params = { "btnedit" }, method = RequestMethod.POST)
	public String processUpsertPost(ModelMap modelmap,
			@RequestParam String btnedit, MasterStatusReserved masterstatusreserved) {

		if (btnedit.equals("savestatus")) {
			try {
				Date date = new Date();
				masterstatusreserved.setCreateDate(date);
				masterstatusreservedService.save(masterstatusreserved); //roomreservedService , savestatus
			} catch (SequenceException e) {
				modelmap.addAttribute("retSamples", e.getErrMsg());
			} finally {
				modelmap.addAttribute("addStatus", new MasterStatusReserved());
			}
		} else if (btnedit.equals("cancel")) {
			modelmap.addAttribute("addStatus", new MasterStatusReserved());
		}

		return "redirect:/status/";
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String processDelete(ModelMap modelmap, @PathVariable int id) {
		try {
			masterstatusreserved = masterstatusreservedService.listById(id); //roomreservedService , Idstatus

			Date date = new Date();
			masterstatusreserved.setCreateDate(date);
			masterstatusreserved.setTrStatus(9);
			masterstatusreservedService.save(masterstatusreserved); //roomreservedService , savestatus

		} catch (SequenceException e) {
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {
			modelmap.addAttribute("addStatus", new MasterStatusReserved());
		}

		return "redirect:/status/";
	}


	private List<MasterStatusReserved> getListMasterStatus() throws SequenceException {
		List<MasterStatusReserved> statusList = null;
		MasterStatusReserved masterstatusreservedDesc = null;
		Query query = null;
		try {
			query = new Query();
			query.addCriteria(Criteria.where("trStatus").lt(9));
			query.with(new Sort(Sort.Direction.DESC, "id"));
			statusList = masterstatusreservedService.findByCriteria(query); //roomreservedService , Criteriastatus

			for (int i = 0; i < statusList.size(); i++) {
				masterstatusreservedDesc = statusList.get(i);

				if (masterstatusreservedDesc.getTrStatus() == 1) {
					masterstatusreservedDesc.setTrStatusDesc("Online");
			} else if (masterstatusreservedDesc.getTrStatus() == 0) {
				masterstatusreservedDesc.setTrStatusDesc("Offline");
				}
			}
			return statusList;
		} finally {
		statusList = null;
		masterstatusreservedDesc = null;
			query = null;
		}
	}

}
