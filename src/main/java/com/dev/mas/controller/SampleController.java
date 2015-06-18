package com.dev.mas.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap modelmap) {

		try {

			List<Hosting> hostingList = hostingService.list();
			modelmap.addAttribute("retSampleList", hostingList);

		} catch (SequenceException e) {
			System.out.println(e.getErrMsg());
		} finally {

		}

		return "sample";
	}

	@RequestMapping(value = "/runsave", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		try {

			hostingService.save("cloud.google.com");
			hostingService.save("heroku.com");
			hostingService.save("cloudbees.com");
			model.addAttribute("retSamples", "123456");

		} catch (SequenceException e) {
			System.out.println(e.getErrMsg());
		} finally {

		}

		return "sample";
	}
}
