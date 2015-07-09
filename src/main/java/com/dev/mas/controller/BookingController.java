package com.dev.mas.controller;


import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RequestMethod;

import com.dev.mas.exception.SequenceException;
import com.dev.mas.model.Booking;
import com.dev.mas.service.BookingService;



@Controller
@RequestMapping(value = "/bookings")
public class BookingController {
	
	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private BookingService bookingService;
	
	
	private Booking booking = new Booking();
	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap modelmap) {
		//add
		
		modelmap.addAttribute("addBooking", booking);
		

		try {

			List<Booking> bookingList = bookingService.list();
			modelmap.addAttribute("retSampleList", bookingList);
			modelmap.addAttribute("retSamples", "---");

		} catch (SequenceException e) {
//			System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "booking";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(ModelMap modelmap,
			@ModelAttribute(value = "addBooking") Booking booking,
			BindingResult result) {

		// list data
		try {
			
			// add data
			bookingService.save(booking);
			modelmap.addAttribute("addBooking",new Booking());

			List<Booking> bookingList = bookingService.list();
			modelmap.addAttribute("retSampleList", bookingList);
			modelmap.addAttribute("retSamples", "---");

		} catch (SequenceException e) {
			// System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}
		
		return "booking";
	}
	
	
	
//	@RequestMapping(value = "/runsave", method = RequestMethod.GET)
//	public String home(Locale locale, ModelMap modelmap) {
//
//		try {
//
//			bookingService.save("cloud.google.com");
//			bookingService.save("heroku.com");
//			bookingService.save("cloudbees.com");
//
//			List<Booking> bookingList = bookingService.list();
//			modelmap.addAttribute("retSampleList", bookingList);
//			modelmap.addAttribute("retSamples", "---");
//
//		} catch (SequenceException e) {
//			// System.out.println(e.getErrMsg());
//			modelmap.addAttribute("retSamples", e.getErrMsg());
//		} finally {
//
//		}
//
//		return "booking";
//	}
	
}
