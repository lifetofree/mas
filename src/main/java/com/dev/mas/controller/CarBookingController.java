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


	
	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap modelmap) {
		Query query = null;
		try {
			List<MasterTypeRent> typerentList = carbookingService.listtyperent();
			List<MasterTypeCar> typecarList = carbookingService.listtypecar();
			List<MasterPlace> placeList = carbookingService.listplace();
			query = new Query();
			query.addCriteria(Criteria.where("tcStatus").lt(9));
			typerentList = carbookingService.findByCriteriatyperent(query);
			typecarList = carbookingService.findByCriteria(query);
			placeList = carbookingService.findByCriteriaplace(query);
			modelmap.addAttribute("typerent", typerentList);
			modelmap.addAttribute("typecar", typecarList);
			modelmap.addAttribute("place", placeList);
//								
		} catch (SequenceException e) {
//			System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "CarBooking";
	}	
}
