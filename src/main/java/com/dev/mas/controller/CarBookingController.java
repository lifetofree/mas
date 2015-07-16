package com.dev.mas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.dev.mas.exception.SequenceException;
import com.dev.mas.model.CarBooking;
import com.dev.mas.model.MasterPlace;
import com.dev.mas.model.MasterTypeCar;
import com.dev.mas.model.MasterTypeRent;
import com.dev.mas.service.CarBookingService;

@Controller
@RequestMapping(value = "/carbookings")
public class CarBookingController {

	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private CarBookingService carbookingService;

	private CarBooking carbooking = new CarBooking();
	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap modelmap) {
		Query query = null;
		modelmap.addAttribute("addCarBooking", carbooking);
		try {
			
			List<MasterTypeRent> typerentList = carbookingService.listtyperent();
			List<MasterTypeCar> typecarList = carbookingService.listtypecar();
			List<MasterPlace> placeList = carbookingService.listplace();
			query = new Query();
			query.addCriteria(Criteria.where("tcStatus").lt(9));
			
			typerentList = carbookingService.findByCriteriatyperent(query);
			typecarList = carbookingService.findByCriteria(query);
			placeList = carbookingService.findByCriteriaplace(query);
			
			modelmap.addAttribute("typerentTH", typerentList);
			modelmap.addAttribute("typecar", typecarList);
			modelmap.addAttribute("place", placeList);
			
		} catch (SequenceException e) {
			// System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "CarBooking";
	}

	/*@RequestMapping(value = { "/save" }, params = { "btnsave" },method = RequestMethod.POST)
	public String processForm(ModelMap modelmap, @RequestParam String btnsave, 
			@ModelAttribute(value = "addCarBooking") CarBooking carbooking,
			BindingResult result) {
		// list data
		
		if (btnsave.equals("savecarbooking")) {
		try {
			
			// add data
			Date date = new Date();
			carbooking.setCreateDate(date);
			carbooking.getTridx();
			carbooking.getTcidx();
			carbooking.getTpidx();
			carbooking.getTpidx();
			carbooking.getDatestart();
			carbooking.getDateend();
			carbooking.getTimestart();
			carbooking.getTimeend();
			carbooking.getResponsible();
			carbooking.getQty();
			carbooking.getTel();
			carbooking.getObjective();
			carbooking.setTsidx(2);
			carbookingService.savecarbooking(carbooking);
			modelmap.addAttribute("addCarBooking",new CarBooking());
			
				} catch (SequenceException e) {
					//modelmap.addAttribute("retSamples", e.getErrMsg());
				} finally {
					modelmap.addAttribute("addCarBooking", new CarBooking());
				}
			} else if (btnsave.equals("cancel")) {
				modelmap.addAttribute("addCarBooking", new CarBooking());
			}

			return "redirect:/carbookings/";
		
	}*/
}
