package com.dev.mas.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	private Query query = new Query();


	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap modelmap) {
		// add

		modelmap.addAttribute("addTypeCar", new MasterTypeCar());

		try {
			MasterTypeCar mastertypecarDesc = null;
		//	List<MasterTypeCar> typecarList = carbookingService.listtypecar();
			query.with(new Sort(Sort.Direction.DESC, "id"));
			List<MasterTypeCar> typecarList = carbookingService.findByCriteria(query);
			
			
			for (int i = 0; i < typecarList.size(); i++) {
				mastertypecarDesc = typecarList.get(i);
				
				if (mastertypecarDesc.getTcStatus() == 1) {
					mastertypecarDesc.setTcStatusDesc("Online");
				} else if (mastertypecarDesc.getTcStatus() == 0) {
					mastertypecarDesc.setTcStatusDesc("Offline");
				}
			}
			
			modelmap.addAttribute("retSampleList", typecarList);
			modelmap.addAttribute("retSamples", "---");
		} catch (SequenceException e) {
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "MasterTypeCar";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String processEdit(ModelMap modelmap, @PathVariable int id) {

		try {

			// show form
			mastertypecar = carbookingService.listById(id);
			modelmap.addAttribute("addTypeCar", mastertypecar);

			MasterTypeCar mastertypecarDesc = null;

			//List<MasterTypeCar> typecarList = carbookingService.listtypecar();
			
			query.with(new Sort(Sort.Direction.DESC, "id"));
			List<MasterTypeCar> typecarList = carbookingService.findByCriteria(query);
			for (int i = 0; i < typecarList.size(); i++) {
				mastertypecarDesc = typecarList.get(i);
				if (mastertypecarDesc.getTcStatus() == 1) {
					mastertypecarDesc.setTcStatusDesc("Online");
				} else if (mastertypecarDesc.getTcStatus() == 0) {
					mastertypecarDesc.setTcStatusDesc("Offline");
				}
			}
			// all list
			modelmap.addAttribute("retSampleList", typecarList);
			modelmap.addAttribute("retSamples", "---");

		} catch (SequenceException e) {
			System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "MasterTypeCar";
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.POST)
	public String processUpdateForm(ModelMap modelmap,
			MasterTypeCar mastertypecar) {
		try {

			Date date = new Date();
			mastertypecar.setCreateDate(date);
			carbookingService.save(mastertypecar);

		} catch (SequenceException e) {
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {
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
			//List<MasterTypeCar> typecarList = carbookingService.findByCriteria(query);
			//modelmap.addAttribute("retSampleList", typecarList);
			//modelmap.addAttribute("retSamples", "---");
			
		} catch (SequenceException e) {
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {
			modelmap.addAttribute("addTypeCar", new MasterTypeCar());
		}

		return "redirect:/typecar/";
	}
	
	
}