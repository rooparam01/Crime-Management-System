package com.masai.service;

import java.util.List;
import java.util.Set;

import com.masai.entities.PoliceStation;
import com.masai.exception.RecordNotFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface PoliceStationService {
public List<PoliceStation> getAllPoliceStation() throws RecordNotFoundException;
public void addPoliceStation(PoliceStation ps) throws SomethingWentWrongException;

}
