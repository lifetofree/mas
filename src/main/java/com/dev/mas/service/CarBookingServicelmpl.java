package com.dev.mas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.mas.dao.CarBookingDao;
import com.dev.mas.dao.SequenceDao;
import com.dev.mas.exception.SequenceException;
import com.dev.mas.model.CarBooking;



@Service
public class CarBookingServicelmpl implements CarBookingService {
	private static final String CarBooking_SEQ_KEY = "M0_TbTypeCar";
	@Autowired
	private SequenceDao sequenceDao;
 
	@Autowired
	private CarBookingDao carbookingDao;
 
	@Override
	public void save(CarBooking carbooking) throws SequenceException {
		carbooking.setId(sequenceDao.getNextSequenceId(CarBooking_SEQ_KEY));
		carbooking.setTypeCarTH(carbooking.getTypeCarTH());
		carbooking.setTypeCarEN(carbooking.getTypeCarEN());
		carbooking.setCEmpIDX(carbooking.getCEmpIDX());
		carbooking.setCreateDate(carbooking.getCreateDate());
		carbooking.setAdEmpIDX(carbooking.getAdEmpIDX());
		carbooking.setUpdateDate(carbooking.getUpdateDate());
		carbooking.setChange(carbooking.getChange());
		carbooking.setTcStatus(carbooking.getTcStatus());
		carbookingDao.save(carbooking);
 
 
		System.out.println(carbooking);
 
	}
	
	@Override
	public List<CarBooking> list() throws SequenceException {

		return carbookingDao.list();
 
	}
}