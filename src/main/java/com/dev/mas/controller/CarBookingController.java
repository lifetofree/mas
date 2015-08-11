package com.dev.mas.controller;

import java.util.ArrayList;
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
import com.dev.mas.model.MasterBrand;
import com.dev.mas.model.MasterDataCar;
import com.dev.mas.model.MasterPlace;
import com.dev.mas.model.MasterStatus;
import com.dev.mas.model.MasterTypeCar;
import com.dev.mas.model.MasterTypeRent;
import com.dev.mas.model.Problem;
import com.dev.mas.model.StaticRef;
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

		List<MasterTypeCar> typecarList = null;
		List<MasterTypeRent> typerentList = null;
		List<MasterPlace> placeList = null;
		List<CarBooking> carbookingList = null;
		List<MasterDataCar> datacarList = null;
		List<Problem> problemList = null;

		try {
			carbookingList = getListCarBooking();
			datacarList  = getListMasterDataCar();
			typecarList  = getListMasterTypeCar();
			typerentList = getListMasterTypeRent();
			placeList	 = getListMasterPlace();
			problemList	 = getListProblem();
			modelmap.addAttribute("addCarBooking", carbooking);

			
			// สำหรับ tab1 โชว์ข้อมูล
			modelmap.addAttribute("retSampleList", carbookingList);
			// สำหรับ dropdownlist
			modelmap.addAttribute("typerent", typerentList);
			modelmap.addAttribute("typecar", typecarList);
			modelmap.addAttribute("place", placeList);
			// สำหรับ tab2 ดึงข้อมูลแสดง
			modelmap.addAttribute("datacarList", datacarList);
			// สำหรับดึงค่ามาแสดง tab5
			modelmap.addAttribute("problemList", problemList);

		} catch (SequenceException e) {
			// System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "CarBooking";
	}

	// ปุ่ม save ทำรายการจองรายการ tab3
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
				carbooking.setTcStatus(1);
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

	// ปุ่ม view ใช้ดูรายละเอียดข้อมูล
	@RequestMapping(value = { "/view/{id}" }, method = RequestMethod.GET)
	public String processView(ModelMap modelmap, @PathVariable int id) {
		List<MasterTypeCar> typecarList = null;
		List<MasterTypeRent> typerentList = null;
		List<MasterPlace> placeList = null;
		List<CarBooking> carbookingList = null;
		List<MasterDataCar> datacarList = null;
		List<Problem> problemList = null;
		MasterStatus masterstatus = null;
		MasterTypeCar mastertypecar = null;
		MasterTypeRent mastertyperent = null;
		MasterPlace masterplace = null;
		String timestart = null;
		String timeend = null;
		try {
			
			
			List<MasterStatus> statusList = carbookingService.liststatus();
			carbookingList = getListCarBooking();
			datacarList  = getListMasterDataCar();
			typecarList  = getListMasterTypeCar();
			typerentList = getListMasterTypeRent();
			placeList	 = getListMasterPlace();
			problemList	 = getListProblem();

			
			// show form
			carbooking = carbookingService.listByIdcarbooking(id);

			mastertypecar = carbookingService.listById(carbooking.getTcidx());
			carbooking.setTcidxDesc(mastertypecar.getTypeCarTH());

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
			timeend = timeend.substring(0, 2) + ":" + timeend.substring(2, 4);
			carbooking.setTimeendDisplay(timeend);

			
			modelmap.addAttribute("addCarBooking", carbooking); // ส่วนอันนี้นะtabอื่นในการโชว์dropdownlist
			modelmap.addAttribute("carbooking", carbooking); // ใช้บรรทักนี้นะสำหรับแสดงบนหน้าจอ(Label)
			modelmap.addAttribute("retSampleList", carbookingList);
			// dropdown tab3
			modelmap.addAttribute("typerent", typerentList);
			modelmap.addAttribute("typecar", typecarList);
			modelmap.addAttribute("place", placeList);
			modelmap.addAttribute("status", statusList);
			// สำหรับดึงค่ามาแสดง tab2
			modelmap.addAttribute("datacarList", datacarList);
			// สำหรับดึงค่ามาแสดง tab5
			modelmap.addAttribute("problemList", problemList);

		} catch (SequenceException e) {
			System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "CarBooking";
	}

	// ปุ่ม save statusเลือกสถานะอนุมัติ
	@RequestMapping(value = { "/savestatus" }, params = { "btnsavestatus" }, method = RequestMethod.POST)
	public String processSavestatus(ModelMap modelmap,
			@RequestParam String btnsavestatus,
			@ModelAttribute(value = "addCarBooking") CarBooking carbooking,
			BindingResult result) {
		// list data
		if (btnsavestatus.equals("savestatus")) {
			CarBooking newCarbooking = null;
			try {
				// System.out.println("carbooking.id ==> " +
				// carbooking.getId());
				newCarbooking = carbookingService.listByIdcarbooking(Integer.parseInt(String.valueOf(carbooking.getId())));
				Date date = new Date();
				newCarbooking.setAdCreateDate(date);
				newCarbooking.setCarli(carbooking.getCarli());
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

	// ดึงค่ามาแสดง edit
	@RequestMapping(value = { "/savestatus/{id}" }, method = RequestMethod.GET)
	public String processEdit(ModelMap modelmap, @PathVariable int id) {
		MasterTypeCar mastertypecar = null;
		MasterTypeRent mastertyperent = null;
		MasterPlace masterplace = null;
		MasterStatus masterstatus = null;
		/*MasterBrand masterbrand = null;
		Problem problemDesc = null;
		MasterDataCar masterdatacarDesc = null;*/
		
		List<StaticRef> listTime = null;
		List<StaticRef> listQty = null;
		List<MasterTypeCar> typecarList = null;
		List<MasterTypeRent> typerentList = null;
		List<MasterPlace> placeList = null;
		List<CarBooking> carbookingList = null;
		List<MasterDataCar> datacarList = null;
		List<Problem> problemList = null;

		try {
			carbookingList = getListCarBooking();
			datacarList  = getListMasterDataCar();
			typecarList  = getListMasterTypeCar();
			typerentList = getListMasterTypeRent();
			placeList	 = getListMasterPlace();
			problemList	 = getListProblem();
			// show form
			carbooking = carbookingService.listByIdcarbooking(id);
			List<MasterStatus> statusList = carbookingService.liststatus();
			

			listTime = setListTime(); // Add Time
			listQty = setListQty(); // Add Qty

			

			mastertypecar = carbookingService.listById(carbooking.getTcidx());
			carbooking.setTcidxDesc(mastertypecar.getTypeCarTH());

			mastertyperent = carbookingService.listByIdtyperent(carbooking.getTridx());
			carbooking.setTridxDesc(mastertyperent.getTyperentTH());

			masterplace = carbookingService.listByIdplace(carbooking.getTpidx());
			carbooking.setTpidxDesc(masterplace.getPlaceTH());

			masterstatus = carbookingService.listByIdstatus(carbooking.getTsidx());
			carbooking.setTsidxDesc(masterstatus.getStatusTH());

			
			modelmap.addAttribute("addCarBooking", carbooking); // ใช้สำหรับดึงมาโชว์ในรายกาdropdownlist
																// tab3
			modelmap.addAttribute("carbooking", carbooking); // ใช้บรรทักนี้นะสำหรับแสดงบนหน้าจอ(Label)
			modelmap.addAttribute("retSampleList", carbookingList);
			modelmap.addAttribute("typerent", typerentList);
			modelmap.addAttribute("typecar", typecarList);
			modelmap.addAttribute("place", placeList);
			modelmap.addAttribute("status", statusList);

			// dropdown time&qty
			modelmap.addAttribute("listTime", listTime);
			modelmap.addAttribute("listQty", listQty);

			// สำหรับดึงค่ามาแสดง tab2
			modelmap.addAttribute("datacarList", datacarList);
			// สำหรับดึงค่ามาแสดง tab5
			modelmap.addAttribute("problemList", problemList);
		} catch (SequenceException e) {
			System.out.println(e.getErrMsg());
			modelmap.addAttribute("retSamples", e.getErrMsg());
		} finally {

		}

		return "CarBooking";
	}

	// สำหรับเก็บรายละเอียดเวลา
	private List<StaticRef> setListTime() {
		List<StaticRef> listTime = null;

		try {
			listTime = new ArrayList<StaticRef>();

			listTime.add(setDataStaticRef("0000", "00:00"));
			listTime.add(setDataStaticRef("0030", "00:30"));
			listTime.add(setDataStaticRef("0100", "01:00"));
			listTime.add(setDataStaticRef("0130", "01:30"));
			listTime.add(setDataStaticRef("0200", "02:00"));
			listTime.add(setDataStaticRef("0230", "02:30"));
			listTime.add(setDataStaticRef("0300", "03:00"));
			listTime.add(setDataStaticRef("0330", "03:30"));
			listTime.add(setDataStaticRef("0400", "04:00"));
			listTime.add(setDataStaticRef("0430", "04:30"));
			listTime.add(setDataStaticRef("0500", "05:00"));
			listTime.add(setDataStaticRef("0530", "05:30"));
			listTime.add(setDataStaticRef("0600", "06:00"));
			listTime.add(setDataStaticRef("0630", "06:30"));
			listTime.add(setDataStaticRef("0700", "07:00"));
			listTime.add(setDataStaticRef("0730", "07:30"));
			listTime.add(setDataStaticRef("0800", "08:00"));
			listTime.add(setDataStaticRef("0830", "08:30"));
			listTime.add(setDataStaticRef("0900", "09:00"));
			listTime.add(setDataStaticRef("0930", "09:30"));
			listTime.add(setDataStaticRef("1000", "10:00"));
			listTime.add(setDataStaticRef("1030", "10:30"));
			listTime.add(setDataStaticRef("1100", "11:00"));
			listTime.add(setDataStaticRef("1130", "11:30"));
			listTime.add(setDataStaticRef("1200", "12:00"));
			listTime.add(setDataStaticRef("1230", "12:30"));
			listTime.add(setDataStaticRef("1300", "13:00"));
			listTime.add(setDataStaticRef("1330", "13:30"));
			listTime.add(setDataStaticRef("1400", "14:00"));
			listTime.add(setDataStaticRef("1430", "14:30"));
			listTime.add(setDataStaticRef("1500", "15:00"));
			listTime.add(setDataStaticRef("1530", "15:30"));
			listTime.add(setDataStaticRef("1600", "16:00"));
			listTime.add(setDataStaticRef("1630", "16:30"));
			listTime.add(setDataStaticRef("1700", "17:00"));
			listTime.add(setDataStaticRef("1730", "17:30"));
			listTime.add(setDataStaticRef("1800", "18:00"));
			listTime.add(setDataStaticRef("1830", "18:30"));
			listTime.add(setDataStaticRef("1900", "19:00"));
			listTime.add(setDataStaticRef("1930", "19:30"));
			listTime.add(setDataStaticRef("2000", "20:00"));
			listTime.add(setDataStaticRef("2030", "20:30"));
			listTime.add(setDataStaticRef("2100", "21:00"));
			listTime.add(setDataStaticRef("2130", "21:30"));
			listTime.add(setDataStaticRef("2200", "22:00"));
			listTime.add(setDataStaticRef("2230", "22:30"));
			listTime.add(setDataStaticRef("2300", "23:00"));
			listTime.add(setDataStaticRef("2330", "23:30"));

			return listTime;
		} finally {
			listTime = null;
		}
	}

	// สำหรับเก็บรายละเอียดคนที่ขึ้น
	private List<StaticRef> setListQty() {
		List<StaticRef> listQty = null;

		try {
			listQty = new ArrayList<StaticRef>();
			listQty.add(setDataStaticRef("0", "0"));
			listQty.add(setDataStaticRef("1", "1"));
			listQty.add(setDataStaticRef("2", "2"));
			listQty.add(setDataStaticRef("3", "3"));
			listQty.add(setDataStaticRef("4", "4"));
			listQty.add(setDataStaticRef("5", "5"));
			listQty.add(setDataStaticRef("6", "6"));
			listQty.add(setDataStaticRef("7", "7"));
			listQty.add(setDataStaticRef("8", "8"));
			listQty.add(setDataStaticRef("9", "9"));
			listQty.add(setDataStaticRef("10", "10"));
			listQty.add(setDataStaticRef("11", "11"));
			listQty.add(setDataStaticRef("12", "12"));
			listQty.add(setDataStaticRef("13", "13"));
			listQty.add(setDataStaticRef("14", "14"));
			listQty.add(setDataStaticRef("15", "15"));

			return listQty;
		} finally {
			listQty = null;
		}
	}

	private StaticRef setDataStaticRef(String id, String name) {
		StaticRef staticRef = new StaticRef();
		staticRef.setDataRef(id, name);
		return staticRef;
	}

	// ปุ่มแก้ไขข้อมูลบันทึก
	@RequestMapping(value = { "/editdata" }, params = { "btnedit" }, method = RequestMethod.POST)
	public String processEditdata(ModelMap modelmap,
			@RequestParam String btnedit,
			@ModelAttribute(value = "addCarBooking") CarBooking carbooking,
			BindingResult result) {
		// list data
		if (btnedit.equals("edit")) {
			try {

				Date date = new Date();
				carbooking.setUpdateDate(date);
				carbookingService.savecarbooking(carbooking);

			} catch (SequenceException e) {
				// modelmap.addAttribute("retSamples", e.getErrMsg());
			} finally {
				modelmap.addAttribute("addCarBooking", new CarBooking());
			}
		} else if (btnedit.equals("main")) {
			modelmap.addAttribute("addCarBooking", new CarBooking());
		}
		return "redirect:/carbookings/";

	}

	// tab problem ปุ่มsend user
	@RequestMapping(value = { "/problem" }, params = { "btnproblem" }, method = RequestMethod.POST)
	public String processForm(ModelMap modelmap,
			@RequestParam String btnproblem,
			@ModelAttribute(value = "addCarBooking") Problem problem,
			BindingResult result) {
		// list data
		if (btnproblem.equals("saveproblem")) {
			try {

				// add data
				Date date = new Date();
				problem.setCreateDate(date);
				problem.setTspidx(1);
				problem.setTcStatus(1);
				carbookingService.saveproblem(problem);
				modelmap.addAttribute("addCarBooking", new Problem());

			} catch (SequenceException e) {
				// modelmap.addAttribute("retSamples", e.getErrMsg());
			} finally {
				modelmap.addAttribute("addCarBooking", new Problem());
			}
		} else if (btnproblem.equals("cancel")) {
			modelmap.addAttribute("addCarBooking", new Problem());
		}
		return "redirect:/carbookings/";
	}

	// tab problem ปุ่ม view มาแสดงดูรายละเอียดของ admin
	@RequestMapping(value = { "/viewproblem/{id}" }, method = RequestMethod.GET)
	public String processProblemView(ModelMap modelmap, @PathVariable int id) {
		List<MasterTypeCar> typecarList = null;
		List<MasterTypeRent> typerentList = null;
		List<MasterPlace> placeList = null;
		List<CarBooking> carbookingList = null;
		List<MasterDataCar> datacarList = null;
		//List<Problem> problemList = null;
		Problem problem = null;
		try {
			carbookingList = getListCarBooking();
			datacarList  = getListMasterDataCar();
			typecarList  = getListMasterTypeCar();
			typerentList = getListMasterTypeRent();
			placeList	 = getListMasterPlace();
		 	//problemList	 = getListProblem();
			problem = carbookingService.listByIdproblem(id);
			modelmap.addAttribute("addCarBooking", carbooking);
			modelmap.addAttribute("problem", problem); // ใช้บรรทักนี้นะสำหรับแสดงบนหน้าจอ(Label)
			// สำหรับ tab1 โชว์ข้อมูล
			modelmap.addAttribute("retSampleList", carbookingList);
			// สำหรับ dropdownlist
			modelmap.addAttribute("typerent", typerentList);
			modelmap.addAttribute("typecar", typecarList);
			modelmap.addAttribute("place", placeList);
			// สำหรับ tab2 ดึงข้อมูลแสดง
			modelmap.addAttribute("datacarList", datacarList);

		} catch (SequenceException e) {
			System.out.println(e.getErrMsg());
			// modelmap.addAttribute("problemList", e.getErrMsg());
		} finally {

		}

		return "CarBooking";
	}

	private List<CarBooking> getListCarBooking() throws SequenceException {
		Query query = null;
		MasterPlace masterplace = null;
		MasterStatus masterstatus = null;
		String timestart = null;
		List<CarBooking> carbookingList = null;
		CarBooking carbookingDesc = null;

		try {
			carbookingList = carbookingService.listcarbooking();
			query = new Query();
			query.addCriteria(Criteria.where("tcStatus").lt(9));

			// สำหรับ tab1 ดึงขึ้นมารายการที่แสดง
			for (int i = 0; i < carbookingList.size(); i++) {
				carbookingDesc = carbookingList.get(i);
				masterplace = carbookingService.listByIdplace(carbookingDesc
						.getTpidx());
				if (masterplace != null) {
					carbookingDesc.setTpidxDesc(masterplace.getPlaceTH());
				} else {
					carbookingDesc.setTpidxDesc("รายการที่ไม่มีคือ "
							+ carbookingDesc.getTpidx());
				}

				masterstatus = carbookingService.listByIdstatus(carbookingDesc
						.getTsidx());
				if (masterstatus != null) {
					carbookingDesc.setTsidxDesc(masterstatus.getStatusTH());
				} else {
					carbookingDesc.setTsidxDesc("รายการที่ไม่มีคือ "
							+ carbookingDesc.getTsidx());
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

			

			return carbookingList;

		} finally {
			carbookingList = null;
			query = null;

		}
	}

	private List<MasterDataCar> getListMasterDataCar() throws SequenceException {
		Query query = null;
		MasterTypeCar mastertypecar = null;
		MasterBrand masterbrand = null;
		MasterDataCar masterdatacarDesc = null;
		List<MasterDataCar> datacarList = null; 
		try {
			query = new Query();
			query.addCriteria(Criteria.where("tcStatus").lt(9));
			datacarList = carbookingService.findByCriteriadatacar(query);
			query = new Query();
			
			//กท.รถ
			// query.addCriteria(Criteria.where("carli").is(carbooking.getTcidx()));
			// .and("tcStatus").lt(9));
			datacarList = carbookingService.findByCriteriadatacar(query);
			// ดึงข้อมูลมาโ๙ว์ใน tab2
			for (int i = 0; i < datacarList.size(); i++) {
				masterdatacarDesc = datacarList.get(i);

				mastertypecar = carbookingService.listById(masterdatacarDesc.getTcidx());
				if (mastertypecar != null) {
					masterdatacarDesc
							.setTcidxDesc(mastertypecar.getTypeCarTH());
				} else {
					masterdatacarDesc.setTcidxDesc("รายการที่ไม่มีคือ "+ masterdatacarDesc.getTcidx());
				}
				masterbrand = carbookingService.listByIdbrand(masterdatacarDesc.getTbidx());
				if (masterbrand != null) {
					masterdatacarDesc.setTbidxDesc(masterbrand.getBrandTH());
				} else {
					masterdatacarDesc.setTbidxDesc("รายการที่ไม่มีคือ "+ masterdatacarDesc.getTbidx());
				}
			}

			// ดึงข้อมูลมาโชว์ใน tab2 ในส่วนของ ออนไลน์ ออฟไลน์
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
			query = null;
		}

	}
	
	private List<MasterTypeCar> getListMasterTypeCar() throws SequenceException {
		Query query = null;
		List<MasterTypeCar> typecarList = null;
		try{
			query = new Query();
			query.addCriteria(Criteria.where("tcStatus").lt(9));
			typecarList = carbookingService.findByCriteria(query);
			return typecarList;
		}
	 finally {
		typecarList = null;
		query = null;
	}
}
	
	
	private List<MasterTypeRent> getListMasterTypeRent() throws SequenceException {
		Query query = null;
		List<MasterTypeRent> typerentList = null;
		try{
			query = new Query();
			query.addCriteria(Criteria.where("tcStatus").lt(9));
			typerentList = carbookingService.findByCriteriatyperent(query);
			return typerentList;
		}
	 finally {
		 typerentList = null;
		query = null;
	}
}
	
	private List<MasterPlace> getListMasterPlace() throws SequenceException {
		Query query = null;
		List<MasterPlace> placeList = null;
		try{
			query = new Query();
			query.addCriteria(Criteria.where("tcStatus").lt(9));
			placeList = carbookingService.findByCriteriaplace(query);
			return placeList;
		}
	 finally {
		 placeList = null;
		query = null;
	}
}
	
	private List<Problem> getListProblem() throws SequenceException {
		Query query = null;
		List<Problem> problemList = null;
		Problem problemDesc = null;
		try{
			query = new Query();
			query.addCriteria(Criteria.where("tcStatus").lt(9));
			problemList = carbookingService.findByCriteriaproblem(query);
			// ส่วนแสดงสถานะของแจ้งปัญหา Tab5
						for (int i = 0; i < problemList.size(); i++) {
							problemDesc = problemList.get(i);
							if (problemDesc.getTspidx() == 1) {
								problemDesc.setTspidxDesc("รอการตรวจสอบ");
							} else if (problemDesc.getTspidx() == 2) {
								problemDesc.setTspidxDesc("รับทราบ");
							}
						}
			
			return problemList;
		}
	 finally {
		 problemList = null;
		query = null;
	}
}
	
}
