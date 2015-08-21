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
import com.dev.mas.model.Roombooking;

import com.dev.mas.service.RoombookingService;

@Controller
@RequestMapping(value = "/roombooking")
public class RoombookingController {
	
	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private RoombookingService roombookingService;

	private Roombooking roombooking = new Roombooking();
	private List<Roombooking> roombookingList = null;
	private Query query = new Query();

	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap modelmap) {
		// clear form
		modelmap.addAttribute("dataRoombooking", new Roombooking());
		// try {
		// List<Hosting> hostingList = hostingService.list();
		// query.with(new Sort(Sort.Direction.DESC, "id"));
		// List<Hosting> hostingList = hostingService.findByCriteria(query);
		List<Roombooking> roombookingList = getDefaultList();
		modelmap.addAttribute("retRoombookingList", roombookingList);
		modelmap.addAttribute("retRoombooking", "---");
		// } catch (SequenceException e) {
		// modelmap.addAttribute("retSamples", e.getErrMsg());
		// } finally {
		//
		// }

		return "roombooking"; 

	}

	@RequestMapping(value = { "/upsert/{id}" }, method = RequestMethod.GET)
	public String processUpsertGet(ModelMap modelmap, @PathVariable int id) {
		try {
			// show form
			roombooking = roombookingService.listById(id);
			modelmap.addAttribute("dataRoombooking", roombooking);

			// all list
			List<Roombooking> roombookingList = getDefaultList();
			modelmap.addAttribute("retRoombookingList", roombookingList);
			modelmap.addAttribute("retRoombooking", "---");
		} catch (SequenceException e) {
			modelmap.addAttribute("retRoombooking", e.getErrMsg());
		} finally {

		}

		return "roombooking";
	}

	@RequestMapping(value = { "/upsert" }, params = { "cmdName" }, method = RequestMethod.POST)
	public String processUpsertPost(ModelMap modelmap,
			@RequestParam String cmdName, Roombooking roombooking) {
		if (cmdName.equals("save")) {
			try {
				roombookingService.save(roombooking);
			} catch (SequenceException e) {
				modelmap.addAttribute("retRoombooking", e.getErrMsg());
			} finally {
				modelmap.addAttribute("dataRoombooking", new Roombooking());
			}
		} else if (cmdName.equals("cancel")) {
			modelmap.addAttribute("dataRoombooking", new Roombooking());
		}

		return "redirect:/roombooking/";
	}

	private List<Roombooking> getDefaultList() {
		try {
			query.with(new Sort(Sort.Direction.DESC, "id"));
			roombookingList = roombookingService.findByCriteria(query);
		} catch (SequenceException e) {

		} finally {

		}

		return roombookingList;
	}

}
