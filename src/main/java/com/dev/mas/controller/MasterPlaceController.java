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
import com.dev.mas.model.MasterPlace;
import com.dev.mas.service.MasterPlaceService;

@Controller
@RequestMapping(value = "/place")
public class MasterPlaceController {
	
	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private  MasterPlaceService masterplaceService; //RoomReserved

	private MasterPlace masterplace = new MasterPlace();

	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap modelmap) {
		List<MasterPlace> placeList = null;
		try {
			placeList = getListMasterPlace();
			modelmap.addAttribute("addPlace", new MasterPlace());
			modelmap.addAttribute("retSampleList", placeList);
			modelmap.addAttribute("retSamples", "---");
		} catch (SequenceException e) {
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {
			placeList = null;
		}

		return "MasterPlace";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String processEdit(ModelMap modelmap, @PathVariable int id) {
		List<MasterPlace> placeList = null;
		try {

			// show form
			masterplace = masterplaceService.listById(id); //roomreserved ,IDplace
			modelmap.addAttribute("addPlace", masterplace);

			// all list
			placeList = getListMasterPlace();
			modelmap.addAttribute("retSampleList", placeList);
			modelmap.addAttribute("retSamples", "---");
		} catch (SequenceException e) {
			System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "MasterPlace";
	}

	@RequestMapping(value = { "/edit" }, params = { "btnedit" }, method = RequestMethod.POST)
	public String processUpsertPost(ModelMap modelmap,
			@RequestParam String btnedit, MasterPlace masterplace) {

		if (btnedit.equals("save")) {
			try {
				Date date = new Date();
				masterplace.setCreateDate(date);
				masterplaceService.save(masterplace);// roomreserved , saveplace
			} catch (SequenceException e) {
				modelmap.addAttribute("retSamples", e.getErrMsg());
			} finally {
				modelmap.addAttribute("addPlace", new MasterPlace());
			}
		} else if (btnedit.equals("cancel")) {
			modelmap.addAttribute("addPlace", new MasterPlace());
		}

		return "redirect:/place/";
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String processDelete(ModelMap modelmap, @PathVariable int id) {
		try {
			masterplace = masterplaceService.listById(id); //roomreserved ,IDplace

			Date date = new Date();
			masterplace.setCreateDate(date);
			masterplace.setTrStatus(9);
			masterplaceService.save(masterplace); //roomreserved , saveplace

		} catch (SequenceException e) {
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {
			modelmap.addAttribute("addPlace", new MasterPlace());
		}

		return "redirect:/place/";
	}


	private List<MasterPlace> getListMasterPlace() throws SequenceException {
		List<MasterPlace> placeList = null;
		MasterPlace masterplaceDesc = null;
		Query query = null;
		try {
			query = new Query();
			query.addCriteria(Criteria.where("trStatus").lt(9));
			query.with(new Sort(Sort.Direction.DESC, "id"));
			placeList = masterplaceService.findByCriteria(query); //roomreserved , Criteriaplace

			for (int i = 0; i < placeList.size(); i++) {
				masterplaceDesc = placeList.get(i);

				if (masterplaceDesc.getTrStatus() == 1) {
					masterplaceDesc.setTrStatusDesc("Online");
				} else if (masterplaceDesc.getTrStatus() == 0) {
					masterplaceDesc.setTrStatusDesc("Offline");
				}
			}
			return placeList;
		} finally {
			placeList = null;
			masterplaceDesc = null;
			query = null;
		}
	}

}
