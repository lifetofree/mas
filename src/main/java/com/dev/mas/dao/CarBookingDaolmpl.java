package com.dev.mas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import com.dev.mas.model.CarBooking;


@Service
public class CarBookingDaolmpl implements CarBookingDao{
	
	@Autowired
	private MongoOperations mongoOperation;
	
	@Override
	public void save(CarBooking carbooking) {

		mongoOperation.save(carbooking);

	}

	@Override
	public List<CarBooking> list() {
		
		List<CarBooking> TypeCarList = mongoOperation.findAll(CarBooking.class);
		return TypeCarList;
		
	}
		
}
