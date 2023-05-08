package com.masai.service;

import java.sql.Date;
import java.util.List;

import com.masai.entities.Crime;
import com.masai.entities.Criminal;
import com.masai.exception.RecordNotFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface CrimeService {
	void addCrime(Crime crime) throws SomethingWentWrongException;

	void updateCrimeType(int id,String crimeType) throws SomethingWentWrongException;
	void updateCrimeDescription(int id,String desc) throws SomethingWentWrongException;

	void updateCrimePsArea(int id, String psarea)throws SomethingWentWrongException;

	void updateCrimeDate(int id, Date date)throws SomethingWentWrongException;

	void updateCrimeVictim(int id, String victim)throws SomethingWentWrongException;
	public List<Crime> getAllCrime() throws SomethingWentWrongException;

	void assingCriminal(int crimeid, Criminal criminal) throws SomethingWentWrongException, RecordNotFoundException;

	void removeCriminalFromCrime(Crime crime, Criminal criminal) throws RecordNotFoundException, SomethingWentWrongException;

	void deleteCrimeById(int crimeid) throws SomethingWentWrongException;

	Crime getCrimeByDes(String des) throws SomethingWentWrongException;

}
