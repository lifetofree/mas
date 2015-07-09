package com.dev.mas.controller;

import java.util.Date;
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
import com.dev.mas.model.CarBooking;
import com.dev.mas.service.CarBookingService;


@Controller
@RequestMapping(value = "/typecar")
public class MasterTypeCarController {

	
	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private CarBookingService carbookingService;
	
	
	private CarBooking carbooking = new CarBooking();
	@RequestMapping(value = { "", "/show" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap modelmap) {
		//add
		
		modelmap.addAttribute("addTypeCar", carbooking);
		

		try {

			List<CarBooking> carbookingList = carbookingService.list();
			modelmap.addAttribute("retSampleList", carbookingList);
			modelmap.addAttribute("retSamples", "---");
			modelmap.addAttribute("tcStatus", carbookingList);
			
			

		} catch (SequenceException e) {
			//System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "MasterTypeCar";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(ModelMap modelmap,
			@ModelAttribute(value = "addTypeCar") CarBooking carbooking,
			BindingResult result) {

		// list data
		CarBooking	carBookingDesc = null;
		try {
			
			// add data
			Date date = new Date();
			carbooking.setCreateDate(date);
			carbookingService.save(carbooking);
			
    		//modelmap.addAttribute("addTypeCar",new CarBooking());

			List<CarBooking> carbookingList = carbookingService.list();
			
			
			for (int i = 0; i< carbookingList.size();i++) {
				carBookingDesc = carbookingList.get(i);
				if (carBookingDesc.getTcStatus() == 1)
				{
					carBookingDesc.setTcStatusDesc("Online");
				} else {
					carBookingDesc.setTcStatusDesc("Offline");
				}
			}
			
			
			modelmap.addAttribute("retSampleList", carbookingList);
			modelmap.addAttribute("retSamples", "---");
			modelmap.addAttribute("TcStatusDesc", carbookingList);
			
		
		} catch (SequenceException e) {
			 System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}
		
		return "MasterTypeCar";
	}
	

		
}
