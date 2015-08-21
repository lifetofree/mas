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
import com.dev.mas.model.Hosting;
import com.dev.mas.model.M0_TbPlace;

import com.dev.mas.service.M0_TbPlaceService;

@Controller
@RequestMapping(value = "/place2")
public class PlaceController {
	
	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private M0_TbPlaceService m0_tbplaceService;

	private M0_TbPlace m0_tbplace = new M0_TbPlace();
	private List<M0_TbPlace> m0_tbplaceList = null;
	private Query query = new Query();

	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap modelmap) {
		// clear form
		modelmap.addAttribute("dataM0_TbPlace", new Hosting());
		// try {
		// List<Hosting> hostingList = hostingService.list();
		// query.with(new Sort(Sort.Direction.DESC, "id"));
		// List<Hosting> hostingList = hostingService.findByCriteria(query);
		List<M0_TbPlace> m0_tbplaceList = getDefaultList();
		modelmap.addAttribute("retPlaceList", m0_tbplaceList);
		modelmap.addAttribute("retPlace", "---");
		// } catch (SequenceException e) {
		// modelmap.addAttribute("retSamples", e.getErrMsg());
		// } finally {
		//
		// }

		return "place";

	}

	@RequestMapping(value = { "/upsert/{id}" }, method = RequestMethod.GET)
	public String processUpsertGet(ModelMap modelmap, @PathVariable int id) {
		try {
			// show form
			m0_tbplace = m0_tbplaceService.listById(id);
			modelmap.addAttribute("dataM0_TbPlace", m0_tbplace);

			// all list
			List<M0_TbPlace> m0_tbplaceList = getDefaultList();
			modelmap.addAttribute("retPlaceList", m0_tbplaceList);
			modelmap.addAttribute("retPlace", "---");
		} catch (SequenceException e) {
			modelmap.addAttribute("retPlace", e.getErrMsg());
		} finally {

		}

		return "place";
	}

	@RequestMapping(value = { "/upsert" }, params = { "cmdName" }, method = RequestMethod.POST)
	public String processUpsertPost(ModelMap modelmap,
			@RequestParam String cmdName, M0_TbPlace m0_tbplace) {
		if (cmdName.equals("save")) {
			try {
				m0_tbplaceService.save(m0_tbplace);
			} catch (SequenceException e) {
				modelmap.addAttribute("retPlace", e.getErrMsg());
			} finally {
				modelmap.addAttribute("dataM0_TbPlace", new M0_TbPlace());
			}
		} else if (cmdName.equals("cancel")) {
			modelmap.addAttribute("dataM0", new M0_TbPlace());
		}

		return "redirect:/place/";
	}

	private List<M0_TbPlace> getDefaultList() {
		try {
			query.with(new Sort(Sort.Direction.DESC, "id"));
			m0_tbplaceList = m0_tbplaceService.findByCriteria(query);
		} catch (SequenceException e) {

		} finally {

		}

		return m0_tbplaceList;
	}

}
