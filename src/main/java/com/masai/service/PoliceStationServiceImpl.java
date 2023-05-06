package com.masai.service;

import java.util.List;
import java.util.Set;

import com.masai.dao.PoliceStationDao;
import com.masai.dao.PoliceStationDaoImpl;
import com.masai.entities.PoliceStation;
import com.masai.exception.RecordNotFoundException;
import com.masai.exception.SomethingWentWrongException;

public class PoliceStationServiceImpl implements PoliceStationService {

	public List<PoliceStation> getAllPoliceStation() throws RecordNotFoundException {
		PoliceStationDao psd = new PoliceStationDaoImpl();
		return psd.getAllPoliceStation();
	}



	@Override
	public void addPoliceStation(PoliceStation ps) throws SomethingWentWrongException {
		PoliceStationDao psd = new PoliceStationDaoImpl();
		psd.addPoliceStation(ps);
		
	}

}
