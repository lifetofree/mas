package com.dev.mas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.dev.mas.dao.CarBookingDao;
import com.dev.mas.dao.SequenceDao;
import com.dev.mas.exception.SequenceException;
import com.dev.mas.model.CarBooking;
import com.dev.mas.model.MasterBrand;
import com.dev.mas.model.MasterPlace;
import com.dev.mas.model.MasterStatus;
import com.dev.mas.model.MasterTypeCar;
import com.dev.mas.model.MasterTypeRent;
import com.dev.mas.model.MasterDataCar;
import com.dev.mas.model.Problem;

@Service
public class CarBookingServicelmpl implements CarBookingService {
	@Autowired
	private SequenceDao sequenceDao;

	@Autowired
	private CarBookingDao carbookingDao;

	// MasterTypeCar
	private static final String MasterTypeCar_SEQ_KEY = "M0_TbTypeCar";

	@Override
	public void save(MasterTypeCar mastertypecar) throws SequenceException {

		if (mastertypecar.getId() == 0) {
			mastertypecar.setId(sequenceDao
					.getNextSequenceId(MasterTypeCar_SEQ_KEY));
		} else {
			mastertypecar.setId(mastertypecar.getId());
		}
		mastertypecar.setTypeCarTH(mastertypecar.getTypeCarTH());
		mastertypecar.setTypeCarEN(mastertypecar.getTypeCarEN());
		mastertypecar.setCEmpIDX(mastertypecar.getCEmpIDX());
		mastertypecar.setCreateDate(mastertypecar.getCreateDate());
		mastertypecar.setAdEmpIDX(mastertypecar.getAdEmpIDX());
		mastertypecar.setUpdateDate(mastertypecar.getUpdateDate());
		mastertypecar.setTcStatus(mastertypecar.getTcStatus());
		carbookingDao.save(mastertypecar);
	}

	@Override
	public List<MasterTypeCar> listtypecar() throws SequenceException {

		return carbookingDao.listtypecar();
	}

	@Override
	public MasterTypeCar listById(int id) throws SequenceException {

		return carbookingDao.listById(id);
	}

	@Override
	public List<MasterTypeCar> findByCriteria(Query query)
			throws SequenceException {

		return carbookingDao.findByCriteria(query);
	}

	// MasterBrand
	private static final String MasterBrand_SEQ_KEY = "M0_TbBrand";

	@Override
	public void savebrand(MasterBrand masterbrand) throws SequenceException {

		if (masterbrand.getId() == 0) {
			masterbrand.setId(sequenceDao
					.getNextSequenceId(MasterBrand_SEQ_KEY));
		} else {
			masterbrand.setId(masterbrand.getId());
		}
		masterbrand.setBrandTH(masterbrand.getBrandTH());
		masterbrand.setBrandEN(masterbrand.getBrandEN());
		masterbrand.setCEmpIDX(masterbrand.getCEmpIDX());
		masterbrand.setCreateDate(masterbrand.getCreateDate());
		masterbrand.setAdEmpIDX(masterbrand.getAdEmpIDX());
		masterbrand.setUpdateDate(masterbrand.getUpdateDate());
		masterbrand.setTcStatus(masterbrand.getTcStatus());
		carbookingDao.savebrand(masterbrand);
	}

	@Override
	public List<MasterBrand> listbrand() throws SequenceException {

		return carbookingDao.listbrand();
	}

	@Override
	public MasterBrand listByIdbrand(int id) throws SequenceException {

		return carbookingDao.listByIdbrand(id);
	}

	@Override
	public List<MasterBrand> findByCriteriabrand(Query query)
			throws SequenceException {
		return carbookingDao.findByCriteriabrand(query);
	}

	// MasterPlace
	private static final String MasterPlace_SEQ_KEY = "M0_TbPlace";

	@Override
	public void saveplace(MasterPlace masterplace) throws SequenceException {

		if (masterplace.getId() == 0) {
			masterplace.setId(sequenceDao
					.getNextSequenceId(MasterPlace_SEQ_KEY));
		} else {
			masterplace.setId(masterplace.getId());
		}
		masterplace.setPlaceTH(masterplace.getPlaceTH());
		masterplace.setPlaceEN(masterplace.getPlaceEN());
		masterplace.setCEmpIDX(masterplace.getCEmpIDX());
		masterplace.setCreateDate(masterplace.getCreateDate());
		masterplace.setAdEmpIDX(masterplace.getAdEmpIDX());
		masterplace.setUpdateDate(masterplace.getUpdateDate());
		masterplace.setTcStatus(masterplace.getTcStatus());
		carbookingDao.saveplace(masterplace);
	}

	@Override
	public List<MasterPlace> listplace() throws SequenceException {
		return carbookingDao.listplace();
	}

	@Override
	public MasterPlace listByIdplace(int id) throws SequenceException {
		return carbookingDao.listByIdplace(id);
	}

	@Override
	public List<MasterPlace> findByCriteriaplace(Query query)
			throws SequenceException {
		return carbookingDao.findByCriteriaplace(query);
	}

	// MasterTypeRent
	private static final String MasterTypeRent_SEQ_KEY = "M0_TbTypeRent";

	@Override
	public void savetyperent(MasterTypeRent mastertyperent)
			throws SequenceException {

		if (mastertyperent.getId() == 0) {
			mastertyperent.setId(sequenceDao
					.getNextSequenceId(MasterTypeRent_SEQ_KEY));
		} else {
			mastertyperent.setId(mastertyperent.getId());
		}
		mastertyperent.setTyperentTH(mastertyperent.getTyperentTH());
		mastertyperent.setTyperentEN(mastertyperent.getTyperentEN());
		mastertyperent.setCEmpIDX(mastertyperent.getCEmpIDX());
		mastertyperent.setCreateDate(mastertyperent.getCreateDate());
		mastertyperent.setAdEmpIDX(mastertyperent.getAdEmpIDX());
		mastertyperent.setUpdateDate(mastertyperent.getUpdateDate());
		mastertyperent.setTcStatus(mastertyperent.getTcStatus());
		carbookingDao.savetyperent(mastertyperent);
	}

	@Override
	public List<MasterTypeRent> listtyperent() throws SequenceException {
		return carbookingDao.listtyperent();
	}

	@Override
	public MasterTypeRent listByIdtyperent(int id) throws SequenceException {
		return carbookingDao.listByIdtyperent(id);
	}

	@Override
	public List<MasterTypeRent> findByCriteriatyperent(Query query)
			throws SequenceException {
		return carbookingDao.findByCriteriatyperent(query);
	}

	// MasterDataCar
	private static final String MasterDataCar_SEQ_KEY = "M0_TbDataCar";

	@Override
	public void savedatacar(MasterDataCar masterdatacar)
			throws SequenceException {
		if (masterdatacar.getId() == 0) {
			masterdatacar.setId(sequenceDao
					.getNextSequenceId(MasterDataCar_SEQ_KEY));
		} else {
			masterdatacar.setId(masterdatacar.getId());
		}
		masterdatacar.setTcidx(masterdatacar.getTcidx());
		masterdatacar.setTbidx(masterdatacar.getTbidx());
		masterdatacar.setColor(masterdatacar.getColor());
		masterdatacar.setCarli(masterdatacar.getCarli());
		masterdatacar.setQty(masterdatacar.getQty());
		masterdatacar.setCempIDX(masterdatacar.getCempIDX());
		masterdatacar.setCreateDate(masterdatacar.getCreateDate());
		masterdatacar.setAdEmpIDX(masterdatacar.getAdEmpIDX());
		masterdatacar.setUpdateDate(masterdatacar.getUpdateDate());
		masterdatacar.setTcStatus(masterdatacar.getTcStatus());
		carbookingDao.savedatacar(masterdatacar);
	}

	@Override
	public List<MasterDataCar> listdatacar() throws SequenceException {
		return carbookingDao.listdatacar();
	}

	@Override
	public MasterDataCar listByIddatacar(int id) throws SequenceException {
		return carbookingDao.listByIddatacar(id);
	}

	@Override
	public List<MasterDataCar> findByCriteriadatacar(Query query)
			throws SequenceException {
		return carbookingDao.findByCriteriadatacar(query);
	}

	// MasterStatus
	private static final String MasterStatus_SEQ_KEY = "M0_TbStatus";

	@Override
	public void savestatus(MasterStatus masterstatus) throws SequenceException {
		if (masterstatus.getId() == 0) {
			masterstatus.setId(sequenceDao
					.getNextSequenceId(MasterStatus_SEQ_KEY));
		} else {
			masterstatus.setId(masterstatus.getId());
		}
		masterstatus.setStatusTH(masterstatus.getStatusTH());
		masterstatus.setStatusEN(masterstatus.getStatusEN());
		carbookingDao.savestatus(masterstatus);
	}

	@Override
	public List<MasterStatus> liststatus() throws SequenceException {
		return carbookingDao.liststatus();
	}

	@Override
	public MasterStatus listByIdstatus(int id) throws SequenceException {
		return carbookingDao.listByIdstatus(id);
	}

	@Override
	public List<MasterStatus> findByCriteriastatus(Query query)
			throws SequenceException {
		return carbookingDao.findByCriteriastatus(query);
	}

	// CarBooking
	private static final String CarBooking_SEQ_KEY = "U0_TbDetailRent";

	@Override
	public void savecarbooking(CarBooking carbooking) throws SequenceException {
		if (carbooking.getId() == 0) {
			carbooking.setId(sequenceDao.getNextSequenceId(CarBooking_SEQ_KEY));
		} else {
			carbooking.setId(carbooking.getId());
		}
		carbooking.setEmpidx(carbooking.getEmpidx());
		carbooking.setTridx(carbooking.getTridx());
		carbooking.setTcidx(carbooking.getTcidx());
		carbooking.setTpidx(carbooking.getTpidx());
		carbooking.setDatestart(carbooking.getDatestart());
		carbooking.setDateend(carbooking.getDateend());
		carbooking.setTimestart(carbooking.getTimestart());
		carbooking.setTimeend(carbooking.getTimeend());
		carbooking.setResponsible(carbooking.getResponsible());
		carbooking.setQty(carbooking.getQty());
		carbooking.setObjective(carbooking.getObjective());
		carbooking.setTsidx(carbooking.getTsidx());
		carbooking.setcEmpIDX(carbooking.getcEmpIDX());
		carbooking.setCreateDate(carbooking.getCreateDate());
		carbooking.setAdEmpIDX(carbooking.getAdEmpIDX());
		carbooking.setUpdateDate(carbooking.getUpdateDate());
		carbooking.setTcStatus(carbooking.getTcStatus());
		carbooking.setChange(carbooking.getChange());
		carbookingDao.savecarbooking(carbooking);
	}

	@Override
	public List<CarBooking> listcarbooking() throws SequenceException {
		return carbookingDao.listcarbooking();
	}

	@Override
	public CarBooking listByIdcarbooking(int id) throws SequenceException {
		return carbookingDao.listByIdcarbooking(id);
	}

	@Override
	public List<CarBooking> findByCriteriacarbooking(Query query)
			throws SequenceException {
		return carbookingDao.findByCriteriacarbooking(query);
	}

	// Problem
	private static final String Problem_SEQ_KEY = "U1_TbProblem";

	@Override
	public void saveproblem(Problem problem) throws SequenceException {
		if (problem.getId() == 0) {
			problem.setId(sequenceDao.getNextSequenceId(Problem_SEQ_KEY));
		} else {
			problem.setId(problem.getId());
		}
		problem.setEmpidx(problem.getEmpidx());
		problem.setTopic(problem.getTopic());
		problem.setContext(problem.getContext());
		problem.setTel(problem.getTel());
		problem.setTsidx(problem.getTsidx());
		problem.setcEmpIDX(problem.getcEmpIDX());
		problem.setCreateDate(problem.getCreateDate());
		problem.setAdEmpIDX(problem.getAdEmpIDX());
		problem.setUpdateDate(problem.getUpdateDate());
		problem.setTcStatus(problem.getTcStatus());
		carbookingDao.saveproblem(problem);
	}

	@Override
	public List<Problem> listproblem() throws SequenceException {
		return carbookingDao.listproblem();
	}

	@Override
	public Problem listByIdproblem(int id) throws SequenceException {
		return carbookingDao.listByIdproblem(id);
	}

	@Override
	public List<Problem> findByCriteriaproblem(Query query) throws SequenceException {
		return carbookingDao.findByCriteriaproblem(query);
	}
}