package com.dev.mas.controller;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dev.mas.config.AppConfig;
import com.dev.mas.exception.SequenceException;
import com.dev.mas.service.HostingService;

@Controller
public class SampleController {

	@RequestMapping(value = "/sample", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		ApplicationContext ctx = 
	            new AnnotationConfigApplicationContext(AppConfig.class);
		HostingService hostingService = (HostingService) ctx.getBean("hostingServiceImpl");
	 
		try {
	 
			hostingService.save("cloud.google.com");
			hostingService.save("heroku.com");
			hostingService.save("cloudbees.com");
			model.addAttribute("retSamples", "123456");
	 
		} catch (SequenceException e) {
			System.out.println(e.getErrMsg());
		} finally {
			((ConfigurableApplicationContext)ctx).close();
		}
		
		return "sample";
	}
}
