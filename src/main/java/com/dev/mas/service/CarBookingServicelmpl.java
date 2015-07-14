package com.dev.mas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.dev.mas.dao.CarBookingDao;
import com.dev.mas.dao.SequenceDao;
import com.dev.mas.exception.SequenceException;
import com.dev.mas.model.MasterBrand;
import com.dev.mas.model.MasterPlace;
import com.dev.mas.model.MasterTypeCar;
import com.dev.mas.model.MasterTypeRent;
import com.dev.mas.model.MasterStatus;

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
		masterstatus.setCEmpIDX(masterstatus.getCEmpIDX());
		masterstatus.setCreateDate(masterstatus.getCreateDate());
		masterstatus.setAdEmpIDX(masterstatus.getAdEmpIDX());
		masterstatus.setUpdateDate(masterstatus.getUpdateDate());
		masterstatus.setTcStatus(masterstatus.getTcStatus());
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
	
}