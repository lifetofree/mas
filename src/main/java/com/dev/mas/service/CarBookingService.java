package com.dev.mas.service;

import java.util.List;

import com.dev.mas.exception.SequenceException;
import com.dev.mas.model.MasterTypeCar;



public interface CarBookingService {
	
	public void save(MasterTypeCar mastertypecar) throws SequenceException;
	public List<MasterTypeCar> listtypecar() throws SequenceException;
	public MasterTypeCar listById(int id) throws SequenceException;
}
