package com.dev.mas.service;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.dev.mas.exception.SequenceException;
import com.dev.mas.model.MasterBrand;
import com.dev.mas.model.MasterPlace;
import com.dev.mas.model.MasterStatus;
import com.dev.mas.model.MasterTypeCar;
import com.dev.mas.model.MasterTypeRent;

public interface CarBookingService {
	// MasterTypeCar
	public void save(MasterTypeCar mastertypecar) throws SequenceException;
	public List<MasterTypeCar> listtypecar() throws SequenceException;
	public MasterTypeCar listById(int id) throws SequenceException;
	public List<MasterTypeCar> findByCriteria(Query query)	throws SequenceException;

	// MasterBrand
	public void savebrand(MasterBrand masterbrand) throws SequenceException;
	public List<MasterBrand> listbrand() throws SequenceException;
	public MasterBrand listByIdbrand(int id) throws SequenceException;
	public List<MasterBrand> findByCriteriabrand(Query query)	throws SequenceException;

	// MasterPlace
	public void saveplace(MasterPlace masterplace) throws SequenceException;
	public List<MasterPlace> listplace() throws SequenceException;
	public MasterPlace listByIdplace(int id) throws SequenceException;
	public List<MasterPlace> findByCriteriaplace(Query query) throws SequenceException;

	// MasterTypeRent
	public void savetyperent(MasterTypeRent mastertypecar) throws SequenceException;
	public List<MasterTypeRent> listtyperent() throws SequenceException;
	public MasterTypeRent listByIdtyperent(int id) throws SequenceException;
	public List<MasterTypeRent> findByCriteriatyperent(Query query) throws SequenceException;
	
	
	// MasterStatus
	public void savestatus(MasterStatus masterstatus) throws SequenceException;
	public List<MasterStatus> liststatus() throws SequenceException;
	public MasterStatus listByIdstatus(int id) throws SequenceException;
	public List<MasterStatus> findByCriteriastatus(Query query) throws SequenceException;
}
