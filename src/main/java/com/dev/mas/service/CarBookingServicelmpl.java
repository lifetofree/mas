package com.dev.mas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.mas.dao.CarBookingDao;
import com.dev.mas.dao.SequenceDao;
import com.dev.mas.exception.SequenceException;
import com.dev.mas.model.MasterTypeCar;



@Service
public class CarBookingServicelmpl implements CarBookingService {
	private static final String MasterTypeCar_SEQ_KEY = "M0_TbTypeCar";
	@Autowired
	private SequenceDao sequenceDao;
 
	@Autowired
	private CarBookingDao carbookingDao;
 
	@Override
	public void save(MasterTypeCar mastertypecar) throws SequenceException {
		mastertypecar.setId(sequenceDao.getNextSequenceId(MasterTypeCar_SEQ_KEY));
		mastertypecar.setTypeCarTH(mastertypecar.getTypeCarTH());
		mastertypecar.setTypeCarEN(mastertypecar.getTypeCarEN());
		mastertypecar.setCEmpIDX(mastertypecar.getCEmpIDX());
		mastertypecar.setCreateDate(mastertypecar.getCreateDate());
		mastertypecar.setAdEmpIDX(mastertypecar.getAdEmpIDX());
		mastertypecar.setUpdateDate(mastertypecar.getUpdateDate());
		mastertypecar.setChange(mastertypecar.getChange());
		mastertypecar.setTcStatus(mastertypecar.getTcStatus());
		carbookingDao.save(mastertypecar);
 
 
		System.out.println(mastertypecar);
 
	}
	
	@Override
	public List<MasterTypeCar> listtypecar() throws SequenceException {

		return carbookingDao.list();
 
	}
	
	@Override
	public MasterTypeCar listById(int id) throws SequenceException {

		return carbookingDao.listById(id);
 
	}
}