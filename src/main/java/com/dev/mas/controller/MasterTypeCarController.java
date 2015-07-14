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
import com.dev.mas.model.MasterTypeCar;
import com.dev.mas.service.CarBookingService;

@Controller
@RequestMapping(value = "/typecar")
public class MasterTypeCarController {

	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private CarBookingService carbookingService;

	private MasterTypeCar mastertypecar = new MasterTypeCar();

	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap modelmap) {
		List<MasterTypeCar> typecarList = null;
		try {
			typecarList = getListMasterTypeCar();
			modelmap.addAttribute("addTypeCar", new MasterTypeCar());
			modelmap.addAttribute("retSampleList", typecarList);
			modelmap.addAttribute("retSamples", "---");
		} catch (SequenceException e) {
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {
			typecarList = null;
		}

		return "MasterTypeCar";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String processEdit(ModelMap modelmap, @PathVariable int id) {
		List<MasterTypeCar> typecarList = null;
		try {

			// show form
			mastertypecar = carbookingService.listById(id);
			modelmap.addAttribute("addTypeCar", mastertypecar);

			// all list
			typecarList = getListMasterTypeCar();
			modelmap.addAttribute("retSampleList", typecarList);
			modelmap.addAttribute("retSamples", "---");
		} catch (SequenceException e) {
			System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "MasterTypeCar";
	}

	@RequestMapping(value = { "/edit" }, params = { "btnedit" }, method = RequestMethod.POST)
	public String processUpsertPost(ModelMap modelmap,
			@RequestParam String btnedit, MasterTypeCar mastertypecar) {

		if (btnedit.equals("save")) {
			try {
				Date date = new Date();
				mastertypecar.setCreateDate(date);
				carbookingService.save(mastertypecar);
			} catch (SequenceException e) {
				modelmap.addAttribute("retSamples", e.getErrMsg());
			} finally {
				modelmap.addAttribute("addTypeCar", new MasterTypeCar());
			}
		} else if (btnedit.equals("cancel")) {
			modelmap.addAttribute("addTypeCar", new MasterTypeCar());
		}

		return "redirect:/typecar/";

	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String processDelete(ModelMap modelmap, @PathVariable int id) {
		try {
			mastertypecar = carbookingService.listById(id);

			Date date = new Date();
			mastertypecar.setCreateDate(date);
			mastertypecar.setTcStatus(9);
			carbookingService.save(mastertypecar);

		} catch (SequenceException e) {
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {
			modelmap.addAttribute("addTypeCar", new MasterTypeCar());
		}

		return "redirect:/typecar/";
	}

	private List<MasterTypeCar> getListMasterTypeCar() throws SequenceException {
		List<MasterTypeCar> typecarList = null;
		MasterTypeCar mastertypecarDesc = null;
		Query query = null;
		try {
			query = new Query();
			query.addCriteria(Criteria.where("tcStatus").lt(9));
			query.with(new Sort(Sort.Direction.DESC, "id"));
			typecarList = carbookingService.findByCriteria(query);

			for (int i = 0; i < typecarList.size(); i++) {
				mastertypecarDesc = typecarList.get(i);

				if (mastertypecarDesc.getTcStatus() == 1) {
					mastertypecarDesc.setTcStatusDesc("Online");
				} else if (mastertypecarDesc.getTcStatus() == 0) {
					mastertypecarDesc.setTcStatusDesc("Offline");
				}
			}
			return typecarList;
		} finally {
			typecarList = null;
			mastertypecarDesc = null;
			query = null;
		}
	}
}