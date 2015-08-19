package com.dev.mas.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
//import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev.mas.exception.SequenceException;
import com.dev.mas.model.MasterTypeRent;
import com.dev.mas.service.CarBookingService;

@Controller
@RequestMapping(value = "/typerent")
public class MasterTypeRentController {

	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private CarBookingService carbookingService;

	private MasterTypeRent mastertyperent = new MasterTypeRent();

	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap modelmap) {
		List<MasterTypeRent> typerentList = null;
		try {
			typerentList = getListMasterTypeRent();
			modelmap.addAttribute("addTypeRent", new MasterTypeRent());
			modelmap.addAttribute("retSampleList", typerentList);
			modelmap.addAttribute("retSamples", "---");
		} catch (SequenceException e) {
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {
			typerentList = null;
		}

		return "MasterTypeRent";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String processEdit(ModelMap modelmap, @PathVariable int id) {
		List<MasterTypeRent> typerentList = null;
		try {

			// show form
			mastertyperent = carbookingService.listByIdtyperent(id);
			modelmap.addAttribute("addTypeRent", mastertyperent);

			// all list
			typerentList = getListMasterTypeRent();
			modelmap.addAttribute("retSampleList", typerentList);
			modelmap.addAttribute("retSamples", "---");
		} catch (SequenceException e) {
			System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "MasterTypeRent";
	}

	@RequestMapping(value = { "/edit" }, params = { "btnedit" }, method = RequestMethod.POST)
	public String processUpsertPost(ModelMap modelmap,
			@RequestParam String btnedit, MasterTypeRent mastertyperent) {

		if (btnedit.equals("savetyperent")) {
			try {
				Date date = new Date();
				mastertyperent.setCreateDate(date);
				carbookingService.savetyperent(mastertyperent);
			} catch (SequenceException e) {
				modelmap.addAttribute("retSamples", e.getErrMsg());
			} finally {
				modelmap.addAttribute("addTypeRent", new MasterTypeRent());
			}
		} else if (btnedit.equals("cancel")) {
			modelmap.addAttribute("addTypeRent", new MasterTypeRent());
		}

		return "redirect:/typerent/";
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String processDelete(ModelMap modelmap, @PathVariable int id) {
		try {
			mastertyperent = carbookingService.listByIdtyperent(id);

			Date date = new Date();
			mastertyperent.setCreateDate(date);
			mastertyperent.setTcStatus(9);
			carbookingService.savetyperent(mastertyperent);

		} catch (SequenceException e) {
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {
			modelmap.addAttribute("addTypeRent", new MasterTypeRent());
		}

		return "redirect:/typerent/";
	}
	
	
	private List<MasterTypeRent> getListMasterTypeRent() throws SequenceException {
		List<MasterTypeRent> typerentList = null;
		MasterTypeRent mastertyperentDesc = null;
		Query query = null;
		try {
			query = new Query();
			query.addCriteria(Criteria.where("tcStatus").lt(9));
			//query.with(new Sort(Sort.Direction.DESC, "id"));
			typerentList = carbookingService.findByCriteriatyperent(query);

			for (int i = 0; i < typerentList.size(); i++) {
				mastertyperentDesc = typerentList.get(i);

				if (mastertyperentDesc.getTcStatus() == 1) {
					mastertyperentDesc.setTcStatusDesc("Online");
				} else if (mastertyperentDesc.getTcStatus() == 0) {
					mastertyperentDesc.setTcStatusDesc("Offline");
				}
			}
			return typerentList;
		} finally {
			typerentList = null;
			mastertyperentDesc = null;
			query = null;
		}
	}
}
