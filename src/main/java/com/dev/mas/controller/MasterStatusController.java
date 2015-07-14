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
import com.dev.mas.model.MasterStatus;
import com.dev.mas.service.CarBookingService;

@Controller
@RequestMapping(value = "/status")
public class MasterStatusController {

	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private CarBookingService carbookingService;

	private MasterStatus masterstatus = new MasterStatus();

	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap modelmap) {
		List<MasterStatus> statustList = null;
		try {
			statustList = getListMasterStatus();
			modelmap.addAttribute("addStatus", new MasterStatus());
			modelmap.addAttribute("retSampleList", statustList);
			modelmap.addAttribute("retSamples", "---");
		} catch (SequenceException e) {
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {
			statustList = null;
		}

		return "MasterStatus";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String processEdit(ModelMap modelmap, @PathVariable int id) {
		List<MasterStatus> statustList = null;
		try {

			// show form
			masterstatus = carbookingService.listByIdstatus(id);
			modelmap.addAttribute("addStatus", masterstatus);

			// all list
			statustList = getListMasterStatus();
			modelmap.addAttribute("retSampleList", statustList);
			modelmap.addAttribute("retSamples", "---");
		} catch (SequenceException e) {
			System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "MasterStatus";
	}

	@RequestMapping(value = { "/edit" }, params = { "btnedit" }, method = RequestMethod.POST)
	public String processUpsertPost(ModelMap modelmap,
			@RequestParam String btnedit, MasterStatus masterstatus) {

		if (btnedit.equals("savestatus")) {
			try {
				Date date = new Date();
				masterstatus.setCreateDate(date);
				carbookingService.savestatus(masterstatus);
			} catch (SequenceException e) {
				modelmap.addAttribute("retSamples", e.getErrMsg());
			} finally {
				modelmap.addAttribute("addStatus", new MasterStatus());
			}
		} else if (btnedit.equals("cancel")) {
			modelmap.addAttribute("addStatus", new MasterStatus());
		}

		return "redirect:/status/";
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String processDelete(ModelMap modelmap, @PathVariable int id) {
		try {
			masterstatus = carbookingService.listByIdstatus(id);

			Date date = new Date();
			masterstatus.setCreateDate(date);
			masterstatus.setTcStatus(9);
			carbookingService.savestatus(masterstatus);

		} catch (SequenceException e) {
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {
			modelmap.addAttribute("addStatus", new MasterStatus());
		}

		return "redirect:/status/";
	}
	
	
	private List<MasterStatus> getListMasterStatus() throws SequenceException {
		List<MasterStatus> statusList = null;
		MasterStatus masterstatusDesc = null;
		Query query = null;
		try {
			query = new Query();
			query.addCriteria(Criteria.where("tcStatus").lt(9));
			query.with(new Sort(Sort.Direction.DESC, "id"));
			statusList = carbookingService.findByCriteriastatus(query);

			for (int i = 0; i < statusList.size(); i++) {
				masterstatusDesc = statusList.get(i);

				if (masterstatusDesc.getTcStatus() == 1) {
					masterstatusDesc.setTcStatusDesc("Online");
				} else if (masterstatusDesc.getTcStatus() == 0) {
					masterstatusDesc.setTcStatusDesc("Offline");
				}
			}
			return statusList;
		} finally {
			statusList = null;
			masterstatusDesc = null;
			query = null;
		}
	}
}
