package com.dev.mas.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev.mas.exception.SequenceException;
import com.dev.mas.model.MasterBrand;
import com.dev.mas.model.MasterDataCar;
import com.dev.mas.model.MasterTypeCar;
import com.dev.mas.service.CarBookingService;

@Controller
@RequestMapping(value = "/datacar")
public class MasterDataCarController {

	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private CarBookingService carbookingService;

	private MasterDataCar masterdatacar = new MasterDataCar();

	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap modelmap) {
		List<MasterDataCar> datacarList = null;
		List<MasterTypeCar> typecarList = null;
		List<MasterBrand> brandList = null;
		Query query = null;
		
		try {
			
			typecarList = carbookingService.listtypecar();
			brandList = carbookingService.listbrand();
			
			
			typecarList = carbookingService.listtypecar();
			 brandList = carbookingService.listbrand();
			
			query = new Query();
			query.addCriteria(Criteria.where("tcStatus").lt(9));
			
			//datacarList = carbookingService.findByCriteriadatacar(query);
			typecarList = carbookingService.findByCriteria(query);
			brandList = carbookingService.findByCriteriabrand(query);

			
			
			datacarList = getListMasterDataCar();
			modelmap.addAttribute("addDataCar", new MasterDataCar());
			modelmap.addAttribute("retSampleList", datacarList);
			modelmap.addAttribute("typecar", typecarList);
			modelmap.addAttribute("brand", brandList);
			
		} catch (SequenceException e) {
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {
			//datacarList = null;
		}

		return "MasterDataCar";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String processEdit(ModelMap modelmap, @PathVariable int id) {
		List<MasterDataCar> datacarList = null;
		Query query = null;
		
		try {
			

			// show form
			masterdatacar = carbookingService.listByIddatacar(id);
			
			List<MasterTypeCar> typecarList = carbookingService.listtypecar();
			List<MasterBrand> brandList = carbookingService.listbrand();
			
			query = new Query();
			query.addCriteria(Criteria.where("tcStatus").lt(9));
			
			
			typecarList = carbookingService.findByCriteria(query);
			brandList = carbookingService.findByCriteriabrand(query);
			
			datacarList = getListMasterDataCar();
			modelmap.addAttribute("addDataCar", new MasterDataCar());
			modelmap.addAttribute("retSampleList", datacarList);
			modelmap.addAttribute("retSamples", "---");
			modelmap.addAttribute("typecar", typecarList);
			modelmap.addAttribute("brand", brandList);
			modelmap.addAttribute("addDataCar", masterdatacar);

		} catch (SequenceException e) {
			System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "MasterDataCar";
	}

	@RequestMapping(value = { "/edit" }, params = { "btnedit" }, method = RequestMethod.POST)
	public String processUpsertPost(ModelMap modelmap,
			@RequestParam String btnedit, MasterDataCar masterdatacar) {

		if (btnedit.equals("savedatacar")) {
			try {
				Date date = new Date();
				masterdatacar.setCreateDate(date);
				carbookingService.savedatacar(masterdatacar);
			} catch (SequenceException e) {
				modelmap.addAttribute("retSamples", e.getErrMsg());
			} finally {
				modelmap.addAttribute("addDataCar", new MasterDataCar());
			}
		} else if (btnedit.equals("cancel")) {
			modelmap.addAttribute("addDataCar", new MasterDataCar());
		}

		return "redirect:/datacar/";
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String processDelete(ModelMap modelmap, @PathVariable int id) {
		try {
			masterdatacar = carbookingService.listByIddatacar(id);

			Date date = new Date();
			masterdatacar.setCreateDate(date);
			masterdatacar.setTcStatus(9);
			carbookingService.savedatacar(masterdatacar);

		} catch (SequenceException e) {
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {
			modelmap.addAttribute("addDataCar", new MasterDataCar());
		}

		return "redirect:/datacar/";
	}
	
	
	private List<MasterDataCar> getListMasterDataCar() throws SequenceException {
		
		List<MasterDataCar> datacarList = null;
		MasterDataCar masterdatacarDesc = null;
		MasterTypeCar mastertypecar = null;
		MasterBrand masterbrand = null;
		List<MasterTypeCar> typecarList = null;
		List<MasterBrand> brandList = null;
		Query query = null;
		try {
			typecarList = carbookingService.listtypecar();
			brandList = carbookingService.listbrand();
			
			
			query = new Query();
			query.addCriteria(Criteria.where("tcStatus").lt(9));
			//query.with(new Sort(Sort.Direction.DESC, "id"));
			
			
			datacarList = carbookingService.findByCriteriadatacar(query);
			typecarList = carbookingService.findByCriteria(query);
			brandList = carbookingService.findByCriteriabrand(query);

				
			
			for (int i = 0; i < datacarList.size(); i++) {
				masterdatacarDesc = datacarList.get(i);
				
				
				mastertypecar = carbookingService.listById(masterdatacarDesc.getTcidx());
				if (mastertypecar != null) {
					masterdatacarDesc.setTcidxDesc(mastertypecar.getTypeCarTH());
				} else {
					masterdatacarDesc.setTcidxDesc("รายการที่ไม่มีคือ " + masterdatacarDesc.getTcidx());
				}
			
				masterbrand = carbookingService.listByIdbrand(masterdatacarDesc.getTbidx());
				if (masterbrand != null) {
					masterdatacarDesc.setTbidxDesc(masterbrand.getBrandTH());
				} else {
					masterdatacarDesc.setTbidxDesc("รายการที่ไม่มีคือ " + masterdatacarDesc.getTbidx());
				}
			}
			
			
			
			
			for (int i = 0; i < datacarList.size(); i++) {
				masterdatacarDesc = datacarList.get(i);

				if (masterdatacarDesc.getTcStatus() == 1) {
					masterdatacarDesc.setTcStatusDesc("Online");
				} else if (masterdatacarDesc.getTcStatus() == 0) {
					masterdatacarDesc.setTcStatusDesc("Offline");
				}
			}
			
			return datacarList;
		} finally {
			datacarList = null;
			brandList = null;
			typecarList = null;
			masterdatacarDesc = null;
			query = null;
		}
	}
}
