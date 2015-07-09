package com.dev.mas.controller;

import java.util.List;
//import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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

		// show form
		modelmap.addAttribute("addHosting", hosting);

		// list data
		try {

			List<Hosting> hostingList = hostingService.list();
			modelmap.addAttribute("retSampleList", hostingList);
			modelmap.addAttribute("retSamples", "---");

		} catch (SequenceException e) {
			// System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "sample";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String processEdit(ModelMap modelmap, @PathVariable int id) {

		// list data
		try {

			// add data
			hosting = hostingService.listById(id);
			modelmap.addAttribute("addHosting", hosting);

			List<Hosting> hostingList = hostingService.list();
			modelmap.addAttribute("retSampleList", hostingList);
			modelmap.addAttribute("retSamples", "---");

		} catch (SequenceException e) {
			 System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "sample";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
	public String processUpdateForm(ModelMap modelmap, @PathVariable int id,
			@ModelAttribute(value = "addHosting") Hosting hosting,
			BindingResult result) {

		// list data
		try {

			// add data
			hostingService.save(hosting);
			modelmap.addAttribute("addHosting", new Hosting());

			// List<Hosting> hostingList = hostingService.list();
			// modelmap.addAttribute("retSampleList", hostingList);
			// modelmap.addAttribute("retSamples", "---");

		} catch (SequenceException e) {
			// System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		// return "sample";
		return "redirect:/samples/";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String processForm(ModelMap modelmap,
			@ModelAttribute(value = "addHosting") Hosting hosting,
			BindingResult result) {

		// list data
		try {

			// add data
			hostingService.save(hosting);
			modelmap.addAttribute("addHosting", new Hosting());

			// List<Hosting> hostingList = hostingService.list();
			// modelmap.addAttribute("retSampleList", hostingList);
			// modelmap.addAttribute("retSamples", "---");

		} catch (SequenceException e) {
			// System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		// return "sample";
		return "redirect:/samples/";
	}
}
