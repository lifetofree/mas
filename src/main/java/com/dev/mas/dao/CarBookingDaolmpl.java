package com.dev.mas.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.dev.mas.model.MasterTypeCar;

@Service
public class CarBookingDaolmpl implements CarBookingDao {

	@Autowired
	private MongoOperations mongoOperation;

	private MasterTypeCar mastertypecar = new MasterTypeCar();

	@Override
	public List<MasterTypeCar> listtypecar() {

		List<MasterTypeCar> TypeCarList = mongoOperation.findAll(MasterTypeCar.class);
		return TypeCarList;

	}

	public MasterTypeCar listById(int id) {

		mastertypecar = mongoOperation.findById(id, MasterTypeCar.class);
		return mastertypecar;

	}

	@Override
	public List<MasterTypeCar> findByCriteria(Query query) {

		List<MasterTypeCar> TypeCarList = mongoOperation.find(query,MasterTypeCar.class);
		return TypeCarList;

	}

	@Override
	public void save(MasterTypeCar mastertypecar) {

		mongoOperation.save(mastertypecar);

	}
}
