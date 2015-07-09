package com.dev.mas.dao;


import java.util.List;
import com.dev.mas.model.CarBooking;



public interface CarBookingDao {
	
	public void save(CarBooking carbooking);
	public List<CarBooking> list();
	


}
