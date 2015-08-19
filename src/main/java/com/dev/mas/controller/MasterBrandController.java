package com.dev.mas.controller;

//import java.util.ArrayList;
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
import com.dev.mas.model.MasterBrand;
//import com.dev.mas.model.StaticRef;
import com.dev.mas.service.CarBookingService;

@Controller
@RequestMapping(value = "/brand")
public class MasterBrandController {

	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private CarBookingService carbookingService;

	private MasterBrand masterbrand = new MasterBrand();

	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap modelmap) {
		List<MasterBrand> brandList = null;
		
		try {
		
			
			brandList = getListMasterBrand();
			modelmap.addAttribute("addBrand", new MasterBrand());
			modelmap.addAttribute("retSampleList", brandList);
			modelmap.addAttribute("retSamples", "---");
			
		} catch (SequenceException e) {
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {
			brandList = null;
		}

		return "MasterBrand";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String processEdit(ModelMap modelmap, @PathVariable int id) {
		List<MasterBrand> brandList = null;
		//List<StaticRef>	listStatus  	= null;

		try {

			// show form
			masterbrand = carbookingService.listByIdbrand(id);
			modelmap.addAttribute("addBrand", masterbrand);
			//listStatus	    = setListStatus();   // Add Status
			
			// all list
			brandList = getListMasterBrand();
			modelmap.addAttribute("retSampleList", brandList);
			//modelmap.addAttribute("listStatus", listStatus);
			modelmap.addAttribute("retSamples", "---");
		} catch (SequenceException e) {
			System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "MasterBrand";
	}
	
	
	@RequestMapping(value = { "/edit" }, params = { "btnedit" }, method = RequestMethod.POST)
	public String processUpsertPost(ModelMap modelmap,
			@RequestParam String btnedit, MasterBrand masterbrand) {

		if (btnedit.equals("savebrand")) {
			try {
				//if (masterbrand.getBrandTH() != null) {
					Date date = new Date();
					masterbrand.setCreateDate(date);
					carbookingService.savebrand(masterbrand);

			} catch (SequenceException e) {
				modelmap.addAttribute("retSamples", e.getErrMsg());
			} finally {
				modelmap.addAttribute("addBrand", new MasterBrand());
			}
		} else if (btnedit.equals("cancel")) {
			modelmap.addAttribute("addBrand", new MasterBrand());
		}

		return "redirect:/brand/";
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String processDelete(ModelMap modelmap, @PathVariable int id) {
		try {
			masterbrand = carbookingService.listByIdbrand(id);

			Date date = new Date();
			masterbrand.setCreateDate(date);
			masterbrand.setTcStatus(9);
			carbookingService.savebrand(masterbrand);

		} catch (SequenceException e) {
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {
			modelmap.addAttribute("addBrand", new MasterBrand());
		}

		return "redirect:/brand/";
	}

	private List<MasterBrand> getListMasterBrand() throws SequenceException {
		List<MasterBrand> brandList = null;
		MasterBrand masterbrandDesc = null;
		Query query = null;
		try {
			query = new Query();
			query.addCriteria(Criteria.where("tcStatus").lt(9));
			//query.with(new Sort(Sort.Direction.DESC, "id"));
			brandList = carbookingService.findByCriteriabrand(query);

			for (int i = 0; i < brandList.size(); i++) {
				masterbrandDesc = brandList.get(i);

				if (masterbrandDesc.getTcStatus() == 1) {
					masterbrandDesc.setTcStatusDesc("Online");
				} else if (masterbrandDesc.getTcStatus() == 0) {
					masterbrandDesc.setTcStatusDesc("Offline");
				}
			}
			return brandList;
		} finally {
			brandList = null;
			masterbrandDesc = null;
			query = null;
		}
	}
	
	/*private List<StaticRef> setListStatus() {
		List<StaticRef>	listStatus  	= null;
				
		try {
			listStatus 	= new ArrayList<StaticRef>();
			listStatus.add(setDataStaticRef("0", "Offline"));
			listStatus.add(setDataStaticRef("1", "Online"));
			
			
			return listStatus;
		} finally {
			listStatus  	= null;
		}
	}

	private StaticRef setDataStaticRef(String id, String name) {
		StaticRef		staticRef	= new StaticRef();
		staticRef.setDataRef(id, name);
		return staticRef;
	}*/
}
