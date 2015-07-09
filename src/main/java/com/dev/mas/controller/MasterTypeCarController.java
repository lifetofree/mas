package com.dev.mas.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = { "", "/show" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap modelmap) {
		// add

		modelmap.addAttribute("addTypeCar", new MasterTypeCar());

		try {
			MasterTypeCar mastertypecarDesc = null;
			List<MasterTypeCar> typecarList = carbookingService.listtypecar();

			for (int i = 0; i < typecarList.size(); i++) {
				mastertypecarDesc = typecarList.get(i);
				if (mastertypecarDesc.getTcStatus() == 1) {
					mastertypecarDesc.setTcStatusDesc("Online");
				} else {
					mastertypecarDesc.setTcStatusDesc("Offline");
				}
			}
			modelmap.addAttribute("retSampleList", typecarList);
			modelmap.addAttribute("retSamples", "---");

		} catch (SequenceException e) {
			// System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "MasterTypeCar";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(ModelMap modelmap,
			@ModelAttribute(value = "addTypeCar") MasterTypeCar mastertypecar,
			BindingResult result) {

		try {

			Date date = new Date();
			mastertypecar.setCreateDate(date);
			carbookingService.save(mastertypecar);
			modelmap.addAttribute("addTypeCar", new MasterTypeCar());

			MasterTypeCar mastertypecarDesc = null;

			List<MasterTypeCar> typecarList = carbookingService.listtypecar();

			for (int i = 0; i < typecarList.size(); i++) {
				mastertypecarDesc = typecarList.get(i);
				if (mastertypecarDesc.getTcStatus() == 1) {
					mastertypecarDesc.setTcStatusDesc("Online");
				} else {
					mastertypecarDesc.setTcStatusDesc("Offline");
				}
			}
			modelmap.addAttribute("retSampleList", typecarList);
			modelmap.addAttribute("retSamples", "---");

		} catch (SequenceException e) {
			System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}
		return "MasterTypeCar";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String processEdit(ModelMap modelmap, @PathVariable int id) {

		// list data
		try {

			// add data
			mastertypecar = carbookingService.listById(id);
			modelmap.addAttribute("addTypeCar", mastertypecar);

			List<MasterTypeCar> typecarList = carbookingService.listtypecar();
			modelmap.addAttribute("retSampleList", typecarList);
			modelmap.addAttribute("retSamples", "---");

		} catch (SequenceException e) {
			System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "MasterTypeCar";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
	public String processUpdateForm(ModelMap modelmap, @PathVariable int id,
			@ModelAttribute(value = "addTypeCar") MasterTypeCar mastertypecar,
			BindingResult result) {

		// list data
		try {

			// add data
			carbookingService.save(mastertypecar);
			modelmap.addAttribute("addTypeCar", new MasterTypeCar());

			// List<Hosting> hostingList = hostingService.list();
			// modelmap.addAttribute("retSampleList", hostingList);
			// modelmap.addAttribute("retSamples", "---");

		} catch (SequenceException e) {
			// System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		// return "sample";
		return "redirect:/typecar/";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String processFormUPdate(ModelMap modelmap,
			@ModelAttribute(value = "addTypeCar") MasterTypeCar mastertypecar,
			BindingResult result) {

		// list data
		try {

			// add data
			carbookingService.save(mastertypecar);
			modelmap.addAttribute("addTypeCar", new MasterTypeCar());

			// List<Hosting> hostingList = hostingService.list();
			// modelmap.addAttribute("retSampleList", hostingList);
			// modelmap.addAttribute("retSamples", "---");

		} catch (SequenceException e) {
			// System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		// return "sample";
		return "redirect:/typecar/";
	}

}