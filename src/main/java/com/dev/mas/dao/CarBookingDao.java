package com.dev.mas.dao;

import java.util.List;
import org.springframework.data.mongodb.core.query.Query;
import com.dev.mas.model.MasterTypeCar;

public interface CarBookingDao {

	public List<MasterTypeCar> listtypecar();

	public MasterTypeCar listById(int id);

	public List<MasterTypeCar> findByCriteria(Query query);

//	public List<MasterTypeCar> find(Query query);
//
	public void save(MasterTypeCar mastertypecar);

}
