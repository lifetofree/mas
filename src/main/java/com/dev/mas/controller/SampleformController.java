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

import com.dev.mas.model.Sampletest;

import com.dev.mas.service.SampletestService;

@Controller
@RequestMapping(value = "/sampleform")
public class SampleformController {
	
	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private SampletestService sampletestService;

	private Sampletest sampletest = new Sampletest();
	private List<Sampletest> sampletestList = null;
	private Query query = new Query();

	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap modelmap) {
		// clear form
		modelmap.addAttribute("dataSampletest", new Sampletest());
		// try {
		// List<Hosting> hostingList = hostingService.list();
		// query.with(new Sort(Sort.Direction.DESC, "id"));
		// List<Hosting> hostingList = hostingService.findByCriteria(query);
		List<Sampletest> sampletestList = getDefaultList();
		modelmap.addAttribute("retSampleformList", sampletestList);
		modelmap.addAttribute("retSampleform", "---");
		// } catch (SequenceException e) {
		// modelmap.addAttribute("retSamples", e.getErrMsg());
		// } finally {
		//
		// }

		return "sampleform";

	}

	@RequestMapping(value = { "/upsert/{id}" }, method = RequestMethod.GET)
	public String processUpsertGet(ModelMap modelmap, @PathVariable int id) {
		try {
			// show form
			sampletest = sampletestService.listById(id);
			modelmap.addAttribute("dataSampletest", sampletest);

			// all list
			List<Sampletest> sampletestList = getDefaultList();
			modelmap.addAttribute("retSampleformList", sampletestList);
			modelmap.addAttribute("retSampleform", "---");
		} catch (SequenceException e) {
			modelmap.addAttribute("retSampleform", e.getErrMsg());
		} finally {

		}

		return "sampleform";
	}
	
	//delete
	@RequestMapping(value = { "/sampleform/{id}/delete" }, method = RequestMethod.POST)
	public String delete(ModelMap modelmap, @PathVariable("id") int id)
		{
		//try {
			// show form
		//	sampletest = sampletestService.listById(id);
		//	modelmap.addAttribute("dataSampletest", sampletest);

		//	List<Sampletest> sampletestList = getDefaultList();
		//	modelmap.addAttribute("retSampleformList", sampletestList);
		//	modelmap.addAttribute("retSampleform", "---");
		//} catch (SequenceException e) {
		//	modelmap.addAttribute("retSampleform", e.getErrMsg());
		//} finally {

		//}

		return "redirect:/sampleform/";
	}
	

	@RequestMapping(value = { "/upsert" }, params = { "cmdName" }, method = RequestMethod.POST)
	public String processUpsertPost(ModelMap modelmap,
			@RequestParam String cmdName, Sampletest sampletest) {
		if (cmdName.equals("save")) {
			try {
				sampletestService.save(sampletest);
			} catch (SequenceException e) {
				modelmap.addAttribute("retSampleform", e.getErrMsg());
			} finally {
				modelmap.addAttribute("dataSampletest", new Sampletest());
			}
		} else if (cmdName.equals("cancel")) {
			modelmap.addAttribute("dataSampletest", new Sampletest());
		}

		return "redirect:/sampleform/";
	}

	private List<Sampletest> getDefaultList() {
		try {
			query.with(new Sort(Sort.Direction.DESC, "id"));
			sampletestList = sampletestService.findByCriteria(query);
		} catch (SequenceException e) {

		} finally {

		}

		return sampletestList;
	}

}
