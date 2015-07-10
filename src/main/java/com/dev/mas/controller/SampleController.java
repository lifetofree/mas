package com.dev.mas.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dev.mas.exception.SequenceException;
import com.dev.mas.model.Hosting;
import com.dev.mas.service.HostingService;

@Controller
@RequestMapping(value = "/samples")
public class SampleController {

	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private HostingService hostingService;

	private Hosting hosting = new Hosting();

	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap modelmap) {
		// clear form
		modelmap.addAttribute("dataHosting", new Hosting());
		try {
			List<Hosting> hostingList = hostingService.list();
			modelmap.addAttribute("retSampleList", hostingList);
			modelmap.addAttribute("retSamples", "---");
		} catch (SequenceException e) {
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "sample";
		
	}

	@RequestMapping(value = { "/upsert/{id}" }, method = RequestMethod.GET)
	public String processEdit(ModelMap modelmap, @PathVariable int id) {
		try {
			// show form
			hosting = hostingService.listById(id);
			modelmap.addAttribute("dataHosting", hosting);
			
			// all list
			List<Hosting> hostingList = hostingService.list();
			modelmap.addAttribute("retSampleList", hostingList);
			modelmap.addAttribute("retSamples", "---");
		} catch (SequenceException e) {
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "sample";
	}

	@RequestMapping(value = { "/upsert" }, method = RequestMethod.POST)
	public String processUpdateForm(ModelMap modelmap, Hosting hosting) {
		try {
			hostingService.save(hosting);
		} catch (SequenceException e) {
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {
			modelmap.addAttribute("dataHosting", new Hosting()); 
		}

		return "redirect:/samples/";
	}
	
}
