package com.dev.mas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev.mas.exception.SequenceException;

import com.dev.mas.model.M0_TbStatus;
import com.dev.mas.service.M0_TbStatusService;

@Controller
@RequestMapping(value = "/status3")
public class StatusController {
	
	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private M0_TbStatusService m0_tbstatusService;

	private M0_TbStatus m0_tbstatus = new M0_TbStatus();
	private List<M0_TbStatus> m0_tbstatusList = null;
	private Query query = new Query();

	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap modelmap) {
		// clear form
		modelmap.addAttribute("dataM0_TbStatus", new M0_TbStatus());
		// try {
		// List<Hosting> hostingList = hostingService.list();
		// query.with(new Sort(Sort.Direction.DESC, "id"));
		// List<Hosting> hostingList = hostingService.findByCriteria(query);
		List<M0_TbStatus> m0_tbstatusList = getDefaultList();
		modelmap.addAttribute("retStatusList", m0_tbstatusList);
		modelmap.addAttribute("retStatus", "---");
		// } catch (SequenceException e) {
		// modelmap.addAttribute("retSamples", e.getErrMsg());
		// } finally {
		//
		// }

		return "status";

	}

	@RequestMapping(value = { "/upsert/{id}" }, method = RequestMethod.GET)
	public String processUpsertGet(ModelMap modelmap, @PathVariable int id) {
		try {
			// show form
			m0_tbstatus = m0_tbstatusService.listById(id);
			modelmap.addAttribute("dataM0_TbStatus", m0_tbstatus);

			// all list
			List<M0_TbStatus> m0_tbstatusList = getDefaultList();
			modelmap.addAttribute("retStatusList", m0_tbstatusList);
			modelmap.addAttribute("retStatus", "---");
		} catch (SequenceException e) {
			modelmap.addAttribute("retStatus", e.getErrMsg());
		} finally {

		}

		return "status";
	}

	@RequestMapping(value = { "/upsert" }, params = { "cmdName" }, method = RequestMethod.POST)
	public String processUpsertPost(ModelMap modelmap,
			@RequestParam String cmdName, M0_TbStatus m0_tbstatus) {
		if (cmdName.equals("save")) {
			try {
				m0_tbstatusService.save(m0_tbstatus);
			} catch (SequenceException e) {
				modelmap.addAttribute("retStatus", e.getErrMsg());
			} finally {
				modelmap.addAttribute("dataM0_TbStatus", new M0_TbStatus());
			}
		} else if (cmdName.equals("cancel")) {
			modelmap.addAttribute("dataM0_TbStatus", new M0_TbStatus());
		}

		return "redirect:/status/";
	}

	private List<M0_TbStatus> getDefaultList() {
		try {
			query.with(new Sort(Sort.Direction.DESC, "id"));
			m0_tbstatusList = m0_tbstatusService.findByCriteria(query);
		} catch (SequenceException e) {

		} finally {

		}

		return m0_tbstatusList;
	}

}
