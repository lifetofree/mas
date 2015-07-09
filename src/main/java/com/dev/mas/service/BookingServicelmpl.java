package com.dev.mas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.mas.dao.BookingDao;
import com.dev.mas.dao.SequenceDao;
import com.dev.mas.exception.SequenceException;
import com.dev.mas.model.Booking;



@Service
public class BookingServicelmpl implements BookingService {

	private static final String BOOKING_SEQ_KEY = "booking";
	@Autowired
	private SequenceDao sequenceDao;
 
	@Autowired
	private BookingDao bookingDao;
 
	@Override
	public void save(Booking booking) throws SequenceException {
		booking.setId(sequenceDao.getNextSequenceId(BOOKING_SEQ_KEY));
		booking.setName(booking.getName());
		booking.setDomain(booking.getDomain());
		bookingDao.save(booking);
 
 
		System.out.println(booking);
 
	}
	
	@Override
	public List<Booking> list() throws SequenceException {

		return bookingDao.list();
 
	}
	
}
