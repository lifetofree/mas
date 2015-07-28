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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev.mas.exception.SequenceException;
import com.dev.mas.model.CarBooking;
import com.dev.mas.model.MasterPlace;
import com.dev.mas.model.MasterStatus;
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

	// หน้าแรกแสดงรายการ tab 1
	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public String rentpage(ModelMap modelmap) {

		Query query = null;
		modelmap.addAttribute("addCarBooking", carbooking);
		CarBooking carbookingDesc = null;
		MasterPlace masterplace = null;
		MasterStatus masterstatus = null;
		String timestart = null;

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
			if (masterplace != null) {
					carbookingDesc.setTpidxDesc(masterplace.getPlaceTH());
				} else {
					carbookingDesc.setTpidxDesc("รายการที่ไม่มีคือ " + carbookingDesc.getTpidx());
				}

				masterstatus = carbookingService.listByIdstatus(carbookingDesc.getTsidx());
				if (masterstatus != null) {
					carbookingDesc.setTsidxDesc(masterstatus.getStatusTH());
				} else {
					carbookingDesc.setTsidxDesc("รายการที่ไม่มีคือ " + carbookingDesc.getTsidx());
				}

				if (carbookingDesc.getTimestart() != null) {
					timestart = carbookingDesc.getTimestart();
					timestart = timestart.substring(0, 2) + ":"
							+ timestart.substring(2, 4);
					carbookingDesc.setTimestartDisplay(timestart);
				} else {
					carbookingDesc.setTimestartDisplay("ไม่มีข้อมูล");
				}
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

	//ปุ่ม save ทำรายการจองรายการ tab3
	@RequestMapping(value = { "/save" }, params = { "btnsave" }, method = RequestMethod.POST)
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
				modelmap.addAttribute("addCarBooking", new CarBooking());

			} catch (SequenceException e) {
				// modelmap.addAttribute("retSamples", e.getErrMsg());
			} finally {
				modelmap.addAttribute("addCarBooking", new CarBooking());
			}
		} else if (btnsave.equals("cancel")) {
			modelmap.addAttribute("addCarBooking", new CarBooking());
		}

		return "redirect:/carbookings/";

	}

	//ปุ่ม view ใช้ดูรายละเอียดข้อมูล
	@RequestMapping(value = { "/view/{id}" }, method = RequestMethod.GET)
	public String processView(ModelMap modelmap, @PathVariable int id) {
		// List<CarBooking> carbookingList = null;
		Query query = null;
		//CarBooking carbookingDesc = null;
		MasterTypeCar mastertypecar = null;
		MasterTypeRent mastertyperent = null;
		MasterPlace masterplace = null;
		MasterStatus masterstatus = null;
		String timestart = null;
		String timeend = null;
		
		try {			
		//	System.out.println("id ==> " + id);		

 			
			List<CarBooking> carbookingList = carbookingService.listcarbooking();
			List<MasterTypeRent> typerentList = carbookingService.listtyperent();
			List<MasterTypeCar> typecarList = carbookingService.listtypecar();
			List<MasterPlace> placeList = carbookingService.listplace();
			List<MasterStatus> statusList = carbookingService.liststatus();

			query = new Query();
			query.addCriteria(Criteria.where("tcStatus").lt(9));

			typerentList = carbookingService.findByCriteriatyperent(query);
			typecarList = carbookingService.findByCriteria(query);
			placeList = carbookingService.findByCriteriaplace(query);
			carbookingList = carbookingService.findByCriteriacarbooking(query);

			// show form
			carbooking    = carbookingService.listByIdcarbooking(id);

//System.out.println("carbooking.getTcidx() ==> " + carbooking.getTcidx());			
			mastertypecar = carbookingService.listById(carbooking.getTcidx());
			carbooking.setTcidxDesc(mastertypecar.getTypeCarTH());
//System.out.println("carbooking.getTcidxDesc() ==> " + carbooking.getTcidxDesc());			
			
			mastertyperent = carbookingService.listByIdtyperent(carbooking.getTridx());
			carbooking.setTridxDesc(mastertyperent.getTyperentTH());
			
			masterplace = carbookingService.listByIdplace(carbooking.getTpidx());
			carbooking.setTpidxDesc(masterplace.getPlaceTH());

			masterstatus = carbookingService.listByIdstatus(carbooking.getTsidx());
			carbooking.setTsidxDesc(masterstatus.getStatusTH());

			timestart = carbooking.getTimestart();
			timestart = timestart.substring(0, 2) + ":"	+ timestart.substring(2, 4);
			carbooking.setTimestartDisplay(timestart);
			
			timeend = carbooking.getTimeend();
			timeend = timeend.substring(0, 2) + ":"	+ timeend.substring(2, 4);
			carbooking.setTimeendDisplay(timeend);

			modelmap.addAttribute("addCarBooking", carbooking); // ส่วนอันนี้นะ tab อื่นเมิงใช้ พอมันไม่รู้จักเลย error
			modelmap.addAttribute("carbooking", carbooking); // ใช้บรรทักนี้นะ สำหรับแสดงบนหน้าจอ (Label)
			modelmap.addAttribute("retSampleList", carbookingList);
			modelmap.addAttribute("typerent", typerentList);
			modelmap.addAttribute("typecar", typecarList);
			modelmap.addAttribute("place", placeList);
			modelmap.addAttribute("status", statusList);

		} catch (SequenceException e) {
			System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "CarBooking";
	}
	
	//ปุ่ม save statusเลือกสถานะอนุมัติ
	@RequestMapping(value = { "/savestatus" }, params = { "btnsavestatus" }, method = RequestMethod.POST)
	public String processSavestatus(ModelMap modelmap, @RequestParam String btnsavestatus,
			@ModelAttribute(value = "addCarBooking") CarBooking carbooking,
			BindingResult result) {
		// list data
		if (btnsavestatus.equals("savestatus")) {
			CarBooking newCarbooking    = null;
			try {
//System.out.println("carbooking.id ==> " + carbooking.getId());
				newCarbooking    = carbookingService.listByIdcarbooking(Integer.parseInt(String.valueOf(carbooking.getId())));
				Date date = new Date();
				newCarbooking.setAdCreateDate(date);
				newCarbooking.setTsidx(carbooking.getTsidx());
				
				carbookingService.savecarbooking(newCarbooking);
			
				
			} catch (SequenceException e) {
				// modelmap.addAttribute("retSamples", e.getErrMsg());
			} finally {
				modelmap.addAttribute("addCarBooking", new CarBooking());
			}
		} else if (btnsavestatus.equals("back")) {
			modelmap.addAttribute("addCarBooking", new CarBooking());
		}

		return "redirect:/carbookings/";

	}
	
	
	//ดึงค่ามาแสดง edit
	@RequestMapping(value = { "/savestatus/{id}" }, method = RequestMethod.GET)
	public String processEdit(ModelMap modelmap, @PathVariable int id) {
		//List<CarBooking> carbookingList = null;
		Query query = null;
		//CarBooking carbookingDesc = null;
		MasterTypeCar mastertypecar = null;
		MasterTypeRent mastertyperent = null;
		MasterPlace masterplace = null;
		MasterStatus masterstatus = null;
		String timestart = null;
		String timeend = null;
		
		try {			
		//	System.out.println("id ==> " + id);		

 			
			List<CarBooking> carbookingList = carbookingService.listcarbooking();
			List<MasterTypeRent> typerentList = carbookingService.listtyperent();
			List<MasterTypeCar> typecarList = carbookingService.listtypecar();
			List<MasterPlace> placeList = carbookingService.listplace();
			List<MasterStatus> statusList = carbookingService.liststatus();

			query = new Query();
			query.addCriteria(Criteria.where("tcStatus").lt(9));

			typerentList = carbookingService.findByCriteriatyperent(query);
			typecarList = carbookingService.findByCriteria(query);
			placeList = carbookingService.findByCriteriaplace(query);
			carbookingList = carbookingService.findByCriteriacarbooking(query);

			// show form
			carbooking    = carbookingService.listByIdcarbooking(id);

//System.out.println("carbooking.getTcidx() ==> " + carbooking.getTcidx());			
			mastertypecar = carbookingService.listById(carbooking.getTcidx());
			carbooking.setTcidxDesc(mastertypecar.getTypeCarTH());
//System.out.println("carbooking.getTcidxDesc() ==> " + carbooking.getTcidxDesc());			
			
			mastertyperent = carbookingService.listByIdtyperent(carbooking.getTridx());
			carbooking.setTridxDesc(mastertyperent.getTyperentTH());
			
			masterplace = carbookingService.listByIdplace(carbooking.getTpidx());
			carbooking.setTpidxDesc(masterplace.getPlaceTH());

			masterstatus = carbookingService.listByIdstatus(carbooking.getTsidx());
			carbooking.setTsidxDesc(masterstatus.getStatusTH());

			timestart = carbooking.getTimestart();
			timestart = timestart.substring(0, 2) + ":"	+ timestart.substring(2, 4);
			carbooking.setTimestartDisplay(timestart);
			
			timeend = carbooking.getTimeend();
			timeend = timeend.substring(0, 2) + ":"	+ timeend.substring(2, 4);
			carbooking.setTimeendDisplay(timeend);

			modelmap.addAttribute("addCarBooking", carbooking); // ส่วนอันนี้นะ tab อื่นเมิงใช้ พอมันไม่รู้จักเลย error >>> ใช้สำหรับดึงมาโชว์ในรายกาdropdownlist tab3
			modelmap.addAttribute("carbooking", carbooking); // ใช้บรรทักนี้นะ สำหรับแสดงบนหน้าจอ (Label)
			modelmap.addAttribute("retSampleList", carbookingList);
			modelmap.addAttribute("typerent", typerentList);
			modelmap.addAttribute("typecar", typecarList);
			modelmap.addAttribute("place", placeList);
			modelmap.addAttribute("status", statusList);

		} catch (SequenceException e) {
			System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "CarBooking";
	}
	
	//ปุ่มแก้ไขข้อมูลบันทึก
	@RequestMapping(value = { "/editdata" }, params = { "btnedit" }, method = RequestMethod.POST)
	public String processEditdata(ModelMap modelmap, @RequestParam String btnedit,
			@ModelAttribute(value = "addCarBooking") CarBooking carbooking,
			BindingResult result) {
		// list data
		if (btnedit.equals("edit")) {
			CarBooking newCarbooking    = null;
			try {
				
				newCarbooking    = carbookingService.listByIdcarbooking(Integer.parseInt(String.valueOf(carbooking.getId())));
			    Date date = new Date();
				newCarbooking.setUpdateDate(date);
				carbookingService.savecarbooking(newCarbooking);
				
				
				
				//ไปเพิ่มค่าอันใหม่เลย แต่เข้าใน loop if
				/*//CarBooking newCarbooking    = null;
				//newCarbooking    = carbookingService.listByIdcarbooking(Integer.parseInt(String.valueOf(carbooking.getId())));
				Date date = new Date();
				carbooking.setUpdateDate(date);
				carbookingService.savecarbooking(carbooking);*/ 
				
				
				
			} catch (SequenceException e) {
				// modelmap.addAttribute("retSamples", e.getErrMsg());
			} finally {
				modelmap.addAttribute("addCarBooking", new CarBooking());
			}
		} 
		else if (btnedit.equals("main")) {
			modelmap.addAttribute("addCarBooking", new CarBooking());
		}
		return "redirect:/carbookings/";

	}
	
	
	//tab problem ปุ่มsend user
	/*@RequestMapping(value = { "/problem" }, params = { "btnproblem" }, method = RequestMethod.POST)
	public String processProblem(ModelMap modelmap, @RequestParam String btnproblem,
			@ModelAttribute(value = "addCarBooking") Problem problem,
			BindingResult result) {
		// list data
		if (btnproblem.equals("saveproblem")) {
			try {

				// add data
				Date date = new Date();
				problem.setCreateDate(date);
				problem.setTsidx(2);
				carbookingService.saveproblem(problem);
				List<Problem> problemList = carbookingService.listproblem();
				modelmap.addAttribute("addCarBooking", new Problem());
				modelmap.addAttribute("problemList", problemList);

			} catch (SequenceException e) {
				// modelmap.addAttribute("retSamples", e.getErrMsg());
			} finally {
				modelmap.addAttribute("addCarBooking", new Problem());
			}
		} else if (btnproblem.equals("cancel")) {
			modelmap.addAttribute("addCarBooking", new Problem());
		}

		return "redirect:/carbookings/";

	}*/
}