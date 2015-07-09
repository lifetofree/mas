package com.dev.mas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.dev.mas.model.Booking;


@Service
public class BookingDaolmpl implements BookingDao {

	@Autowired
	private MongoOperations mongoOperation;

	@Override
	public void save(Booking booking) {

		mongoOperation.save(booking);

	}
	
	@Override
	public List<Booking> list() {
		
		List<Booking> bookingList = mongoOperation.findAll(Booking.class);
		return bookingList;
		
	}
	
}
