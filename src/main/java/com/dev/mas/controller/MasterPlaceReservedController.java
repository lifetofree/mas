package com.dev.mas.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev.mas.exception.SequenceException;
import com.dev.mas.model.MasterPlaceReserved;
import com.dev.mas.service.MasterPlaceReservedService;

@Controller
@RequestMapping(value = "/place")
public class MasterPlaceReservedController {
	
	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private  MasterPlaceReservedService masterplacereservedService; //RoomReserved

	private MasterPlaceReserved masterplacereserved = new MasterPlaceReserved();

	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap modelmap) {
		List<MasterPlaceReserved> placeList = null;
		try {
			placeList = getListMasterPlace();
			modelmap.addAttribute("addPlace", new MasterPlaceReserved());
			modelmap.addAttribute("retSampleList", placeList);
			modelmap.addAttribute("retSamples", "---");
		} catch (SequenceException e) {
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {
			placeList = null;
		}

		return "MasterPlaceReserved";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String processEdit(ModelMap modelmap, @PathVariable int id) {
		List<MasterPlaceReserved> placeList = null;
		try {

			// show form
			masterplacereserved = masterplacereservedService.listById(id); //roomreserved ,IDplace
			modelmap.addAttribute("addPlace", masterplacereserved);

			// all list
			placeList = getListMasterPlace();
			modelmap.addAttribute("retSampleList", placeList);
			modelmap.addAttribute("retSamples", "---");
		} catch (SequenceException e) {
			System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "MasterPlaceReserved";
	}

	@RequestMapping(value = { "/edit" }, params = { "btnedit" }, method = RequestMethod.POST)
	public String processUpsertPost(ModelMap modelmap,
			@RequestParam String btnedit, MasterPlaceReserved masterplacereserved) {

		if (btnedit.equals("save")) {
			try {
				Date date = new Date();
				masterplacereserved.setCreateDate(date);
				masterplacereservedService.save(masterplacereserved);// roomreserved , saveplace
			} catch (SequenceException e) {
				modelmap.addAttribute("retSamples", e.getErrMsg());
			} finally {
				modelmap.addAttribute("addPlace", new MasterPlaceReserved());
			}
		} else if (btnedit.equals("cancel")) {
			modelmap.addAttribute("addPlace", new MasterPlaceReserved());
		}

		return "redirect:/place/";
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String processDelete(ModelMap modelmap, @PathVariable int id) {
		try {
			masterplacereserved = masterplacereservedService.listById(id); //roomreserved ,IDplace

			Date date = new Date();
			masterplacereserved.setCreateDate(date);
			masterplacereserved.setTrStatus(9);
			masterplacereservedService.save(masterplacereserved); //roomreserved , saveplace

		} catch (SequenceException e) {
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {
			modelmap.addAttribute("addPlace", new MasterPlaceReserved());
		}

		return "redirect:/place/";
	}


	private List<MasterPlaceReserved> getListMasterPlace() throws SequenceException {
		List<MasterPlaceReserved> placeList = null;
		MasterPlaceReserved masterplacereservedDesc = null;
		Query query = null;
		try {
			query = new Query();
			query.addCriteria(Criteria.where("trStatus").lt(9));
			query.with(new Sort(Sort.Direction.DESC, "id"));
			placeList = masterplacereservedService.findByCriteria(query); //roomreserved , Criteriaplace

			for (int i = 0; i < placeList.size(); i++) {
				masterplacereservedDesc = placeList.get(i);

				if (masterplacereservedDesc.getTrStatus() == 1) {
					masterplacereservedDesc.setTrStatusDesc("Online");
				} else if (masterplacereservedDesc.getTrStatus() == 0) {
					masterplacereservedDesc.setTrStatusDesc("Offline");
				}
			}
			return placeList;
		} finally {
			placeList = null;
			masterplacereservedDesc = null;
			query = null;
		}
	}

}
