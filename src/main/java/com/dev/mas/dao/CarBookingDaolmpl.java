package com.dev.mas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.dev.mas.model.CarBooking;
import com.dev.mas.model.MasterBrand;
import com.dev.mas.model.MasterPlace;
import com.dev.mas.model.MasterDataCar;
import com.dev.mas.model.MasterStatus;
import com.dev.mas.model.MasterTypeCar;
import com.dev.mas.model.MasterTypeRent;

@Service
public class CarBookingDaolmpl implements CarBookingDao {

	// MasterTypeCar
	@Autowired
	private MongoOperations mongoOperation;

	private MasterTypeCar mastertypecar = new MasterTypeCar();

	@Override
	public List<MasterTypeCar> listtypecar() {

		List<MasterTypeCar> TypeCarList = mongoOperation
				.findAll(MasterTypeCar.class);
		return TypeCarList;
	}
	public MasterTypeCar listById(int id) {

		mastertypecar = mongoOperation.findById(id, MasterTypeCar.class);
		return mastertypecar;
	}
	@Override
	public List<MasterTypeCar> findByCriteria(Query query) {
		List<MasterTypeCar> TypeCarList = mongoOperation.find(query,
				MasterTypeCar.class);
		return TypeCarList;
	}
	@Override
	public void save(MasterTypeCar mastertypecar) {
		mongoOperation.save(mastertypecar);
	}

	
	// MasterBrand
	private MasterBrand masterbrand = new MasterBrand();
	@Override
	public List<MasterBrand> listbrand() {
		List<MasterBrand> BrandList = mongoOperation.findAll(MasterBrand.class);
		return BrandList;
	}
	public MasterBrand listByIdbrand(int id) {
		masterbrand = mongoOperation.findById(id, MasterBrand.class);
		return masterbrand;
	}
	@Override
	public List<MasterBrand> findByCriteriabrand(Query query) {
		List<MasterBrand> BrandList = mongoOperation.find(query,
				MasterBrand.class);
		return BrandList;
	}
	@Override
	public void savebrand(MasterBrand masterbrand) {
		mongoOperation.save(masterbrand);
	}

	// MasterPlace
	private MasterPlace masterplace = new MasterPlace();
	@Override
	public List<MasterPlace> listplace() {
		List<MasterPlace> PlaceList = mongoOperation.findAll(MasterPlace.class);
		return PlaceList;
	}
	public MasterPlace listByIdplace(int id) {
		masterplace = mongoOperation.findById(id, MasterPlace.class);
		return masterplace;
	}
	@Override
	public List<MasterPlace> findByCriteriaplace(Query query) {
		List<MasterPlace> BrandList = mongoOperation.find(query,
				MasterPlace.class);
		return BrandList;
	}

	@Override
	public void saveplace(MasterPlace masterplace) {
		mongoOperation.save(masterplace);
	}

	
	// MasterTypeRent
	private MasterTypeRent mastertyperent = new MasterTypeRent();
	@Override
	public List<MasterTypeRent> listtyperent() {
		List<MasterTypeRent> TypeRentList = mongoOperation.findAll(MasterTypeRent.class);
		return TypeRentList;
	}

	public MasterTypeRent listByIdtyperent(int id) {
		mastertyperent = mongoOperation.findById(id, MasterTypeRent.class);
		return mastertyperent;
	}
	@Override
	public List<MasterTypeRent> findByCriteriatyperent(Query query) {
		List<MasterTypeRent> TypeRentList = mongoOperation.find(query,MasterTypeRent.class);
		return TypeRentList;
	}
	@Override
	public void savetyperent(MasterTypeRent mastertyperent) {
		mongoOperation.save(mastertyperent);
	}

	
	// MasterDataCar
		private MasterDataCar masterdatacar = new MasterDataCar();
		@Override
		public List<MasterDataCar> listdatacar() {
			List<MasterDataCar> DatacarList = mongoOperation.findAll(MasterDataCar.class);
			return DatacarList;
		}
		public MasterDataCar listByIddatacar(int id) {
			masterdatacar = mongoOperation.findById(id, MasterDataCar.class);
			return masterdatacar;
		}
		@Override
		public List<MasterDataCar> findByCriteriadatacar(Query query) {
			List<MasterDataCar> DatacarList = mongoOperation.find(query,MasterDataCar.class);
			return DatacarList;
		}
		@Override
		public void savedatacar(MasterDataCar masterdatacar) {
			mongoOperation.save(masterdatacar);
		}
		
		
		// MasterStatus
				private MasterStatus masterstatus = new MasterStatus();
				@Override
				public List<MasterStatus> liststatus() {
					List<MasterStatus> StatusList = mongoOperation.findAll(MasterStatus.class);
					return StatusList;
				}
				public MasterStatus listByIdstatus(int id) {
					masterstatus = mongoOperation.findById(id, MasterStatus.class);
					return masterstatus;
				}
				@Override
				public List<MasterStatus> findByCriteriastatus(Query query) {
					List<MasterStatus> StatusList = mongoOperation.find(query,MasterStatus.class);
					return StatusList;
				}
				@Override
				public void savestatus(MasterStatus masterstatus) {
					mongoOperation.save(masterstatus);
				}
		
		
		
				
		// CarBooking
		private CarBooking carbooking = new CarBooking();
		@Override
		public List<CarBooking> listcarbooking() {
			List<CarBooking> carbookingList = mongoOperation.findAll(CarBooking.class);
		return carbookingList;
		}
		public CarBooking listByIdcarbooking(int id) {
			carbooking = mongoOperation.findById(id, CarBooking.class);
		return carbooking;
		}
		@Override
		public List<CarBooking> findByCriteriacarbooking(Query query) {
			List<CarBooking> carbookingList = mongoOperation.find(query,CarBooking.class);
		return carbookingList;
		}
		@Override
		public void savecarbooking(CarBooking carbooking) {
				mongoOperation.save(carbooking);
		}
}
