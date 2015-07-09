package com.dev.mas.dao;


import java.util.List;
import com.dev.mas.model.MasterTypeCar;



public interface CarBookingDao {
	
	public void save(MasterTypeCar mastertypecar);
	public List<MasterTypeCar> list();
	public MasterTypeCar listById(int id);



}
