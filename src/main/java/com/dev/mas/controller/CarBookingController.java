package com.dev.mas.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;





import org.springframework.web.bind.annotation.RequestParam;

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
	public String rentpage(ModelMap modelmap) {
		Query query = null;
		modelmap.addAttribute("addCarBooking", carbooking);
		CarBooking 		carbookingDesc = null;
		MasterPlace 	masterplace = null;
		String			timestart   = null;
		try {
			
			List<CarBooking> carbookingList   = carbookingService.listcarbooking();
			List<MasterTypeRent> typerentList = carbookingService.listtyperent();
			List<MasterTypeCar> typecarList   = carbookingService.listtypecar();
			List<MasterPlace> placeList       = carbookingService.listplace();
			
			query = new Query();
			query.addCriteria(Criteria.where("tcStatus").lt(9));
			
			typerentList = carbookingService.findByCriteriatyperent(query);
			typecarList = carbookingService.findByCriteria(query);
			placeList = carbookingService.findByCriteriaplace(query);

			for (int i = 0; i < carbookingList.size(); i++) {
				carbookingDesc = carbookingList.get(i);
				masterplace = carbookingService.listByIdplace(carbookingDesc.getTpidx());
				carbookingDesc.setTpidxDesc(masterplace.getPlaceTH());
				
				timestart = carbookingDesc.getTimestart();				
				timestart = timestart.substring(0,2) + ":" + timestart.substring(2,4);
				carbookingDesc.setTimestartDisplay(timestart);
			}
			
			modelmap.addAttribute("retSampleList", carbookingList);
			modelmap.addAttribute("typerent", typerentList);
			modelmap.addAttribute("typecar", typecarList);
			modelmap.addAttribute("place", placeList);
			
			
			
		} catch (SequenceException e) {
			// System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "CarBooking";
	}

	@RequestMapping(value = { "/save" }, params = { "btnsave" },method = RequestMethod.POST)
	public String processForm(ModelMap modelmap, @RequestParam String btnsave, 
			@ModelAttribute(value = "addCarBooking") CarBooking carbooking,
			BindingResult result) {
		// list data
		
		if (btnsave.equals("savecarbooking")) {
		try {
			
			
			// add data
			Date date = new Date();
			carbooking.setCreateDate(date);
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
		
	}
}
