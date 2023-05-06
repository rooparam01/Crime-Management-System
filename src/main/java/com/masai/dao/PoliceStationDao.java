package com.masai.dao;

import java.util.List;
import java.util.Set;

import com.masai.entities.PoliceStation;
import com.masai.exception.RecordNotFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface PoliceStationDao {
	public List<PoliceStation> getAllPoliceStation() throws RecordNotFoundException;
	public void addPoliceStation(PoliceStation ps) throws SomethingWentWrongException;
}
