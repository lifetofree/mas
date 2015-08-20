package com.dev.mas.service;

import java.util.List;

import com.dev.mas.exception.SequenceException;
import com.dev.mas.model.Booking;


public interface BookingService {

	public void save(Booking booking) throws SequenceException;
	public List<Booking> list() throws SequenceException;
	
}
