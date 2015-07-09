package com.dev.mas.controller;


import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;




@Controller
public class CarBookingController {
	
	@RequestMapping(value = "/carbookings", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "CarBooking";
	}
	
	
}


