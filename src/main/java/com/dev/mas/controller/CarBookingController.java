package com.dev.mas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.dev.mas.model.CarBooking;
import com.dev.mas.service.CarBookingService;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.dev.mas.exception.SequenceException;



@Controller
@RequestMapping(value = "/carbookings")
public class CarBookingController {
	
	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private CarBookingService carbookingService;
	
	
	private CarBooking carbooking = new CarBooking();
	@RequestMapping(value = { "", "/show" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap modelmap) {
		//add
		
		modelmap.addAttribute("addCarBooking", carbooking);
		

		try {

			List<CarBooking> carbookingList = carbookingService.list();
			modelmap.addAttribute("retSampleList", carbookingList);
			modelmap.addAttribute("retSamples", "---");

		} catch (SequenceException e) {
			//System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "CarBooking";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(ModelMap modelmap,
			@ModelAttribute(value = "addCarBooking") CarBooking carbooking,
			BindingResult result) {

		// list data
		try {
			
			// add data
			carbookingService.save(carbooking);
			modelmap.addAttribute("addCarBooking",new CarBooking());

			List<CarBooking> carbookingList = carbookingService.list();
			modelmap.addAttribute("retSampleList", carbookingList);
			modelmap.addAttribute("retSamples", "---");

		} catch (SequenceException e) {
			 System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}
		
		return "CarBooking";
	}
	
	
	/*//master admin
	@RequestMapping(value = "/admin")
	public String Admin() {
		
		return "MasterAdmin";
	}
		
	//master emp
	@RequestMapping(value = "/emp")
	public String Employee() {
		
		return "MasterEmployee";
	}
	
	//master driver
	@RequestMapping(value = "/driver")
	public String Driver() {
		
		return "MasterDriver";
	}
	
	
	//master car
		@RequestMapping(value = "/cars")
		public String Car() {
			
			return "MasterCar";
		}
		
		
		//master place
		@RequestMapping(value = "/place")
		public String Place() {
			
			return "MasterPlace";
		}
		
		
		//master typerent
		@RequestMapping(value = "/type")
		public String TypeRent() {
			
			return "MasterTypeRent";
		}
		*/
	
}


