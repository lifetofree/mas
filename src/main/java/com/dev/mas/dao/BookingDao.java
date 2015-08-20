package com.dev.mas.dao;

import java.util.List;

import com.dev.mas.model.Booking;

public interface BookingDao {

	public void save(Booking booking);
	public List<Booking> list();
}
