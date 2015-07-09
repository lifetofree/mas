package com.dev.mas.service;

import java.util.List;
import com.dev.mas.exception.SequenceException;
import com.dev.mas.model.CarBooking;



public interface CarBookingService {
	
	public void save(CarBooking carbooking) throws SequenceException;
	public List<CarBooking> list() throws SequenceException;
}
