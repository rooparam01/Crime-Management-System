package com.masai.dao;

import java.sql.Date;
import java.util.List;

import com.masai.entities.Crime;
import com.masai.entities.Criminal;
import com.masai.exception.RecordNotFoundException;
import com.masai.exception.SomethingWentWrongException;


public interface CrimeDao {
	public void addCrime(Crime crime) throws SomethingWentWrongException;

	public void updateCrimeType(int id, String crimeType) throws SomethingWentWrongException;

	public void updateCrimeDesc(int id, String desc)throws SomethingWentWrongException;

	public void updateCrimePsArea(int id, String psarea)throws SomethingWentWrongException;

	public void updateCrimeDate(int id, Date date)throws SomethingWentWrongException;

	public void updateCrimeVictim(int id, String victim)throws SomethingWentWrongException;

	public List<Crime> getAllCrime() throws SomethingWentWrongException;

	public void assignCriminal(int crimeid, Criminal criminal) throws SomethingWentWrongException, RecordNotFoundException;

	public void removeCriminalFromCrime(Crime crime, Criminal criminal) throws RecordNotFoundException, SomethingWentWrongException;

	public void deleteCrimeById(int crimeid) throws SomethingWentWrongException;

	public Crime getCrimeByDes(String des) throws SomethingWentWrongException;


	
}
