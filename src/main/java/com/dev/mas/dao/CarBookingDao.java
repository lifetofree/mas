package com.dev.mas.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.dev.mas.model.MasterBrand;
import com.dev.mas.model.MasterPlace;
import com.dev.mas.model.MasterTypeRent;
import com.dev.mas.model.MasterTypeCar;

public interface CarBookingDao {

	// MasterTypeCar
	public List<MasterTypeCar> listtypecar();
	public MasterTypeCar listById(int id);
	public List<MasterTypeCar> findByCriteria(Query query);
	public void save(MasterTypeCar mastertypecar);

	// MasterBrand
	public List<MasterBrand> listbrand();
	public MasterBrand listByIdbrand(int id);
	public List<MasterBrand> findByCriteriabrand(Query query);
	public void savebrand(MasterBrand masterbrand);

	// MasterPlace
	public List<MasterPlace> listplace();
	public MasterPlace listByIdplace(int id);
	public List<MasterPlace> findByCriteriaplace(Query query);
	public void saveplace(MasterPlace masterplace);

	// MasterTypeRent
	public List<MasterTypeRent> listtyperent();
	public MasterTypeRent listByIdtyperent(int id);
	public List<MasterTypeRent> findByCriteriatyperent(Query query);
	public void savetyperent(MasterTypeRent mastertyperent);
}
