package com.dev.mas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import com.dev.mas.model.MasterTypeCar;


@Service
public class CarBookingDaolmpl implements CarBookingDao{
	
	@Autowired
	private MongoOperations mongoOperation;
	
	@Override
	public void save(MasterTypeCar mastertypecar) {

		mongoOperation.save(mastertypecar);

	}

	@Override
	public List<MasterTypeCar> list() {
		
		List<MasterTypeCar> TypeCarList = mongoOperation.findAll(MasterTypeCar.class);
		return TypeCarList;
		
	}
	@Override
	public MasterTypeCar listById(int id) {
		
		MasterTypeCar mastertypecar = mongoOperation.findById(id, MasterTypeCar.class);
		return mastertypecar;
		
	}

}
