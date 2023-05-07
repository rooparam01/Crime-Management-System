package com.masai.service;

import java.sql.Date;
import java.util.List;

import com.masai.dao.CrimeDao;
import com.masai.dao.CrimeDaoImpl;
import com.masai.entities.Crime;
import com.masai.entities.Criminal;
import com.masai.exception.RecordNotFoundException;
import com.masai.exception.SomethingWentWrongException;

public class CrimeServiceImpl implements CrimeService {

	public void addCrime(Crime crime) throws SomethingWentWrongException {
		CrimeDao cd = new CrimeDaoImpl();
		cd.addCrime(crime);	
	}
	
	public List<Crime> getAllCrime() throws SomethingWentWrongException  {
		CrimeDao cd = new CrimeDaoImpl();
		return cd.getAllCrime();	
	}

	@Override
	public void updateCrimeType(int id,String crimeType) throws SomethingWentWrongException {
		CrimeDao cd = new CrimeDaoImpl();
		cd.updateCrimeType(id,crimeType);
		
	}

	@Override
	public void updateCrimeDescription(int id, String desc) throws SomethingWentWrongException {
		CrimeDao cd = new CrimeDaoImpl();
		cd.updateCrimeDesc(id,desc);
		
	}

	@Override
	public void updateCrimePsArea(int id, String psarea) throws SomethingWentWrongException {
		CrimeDao cd = new CrimeDaoImpl();
		cd.updateCrimePsArea(id,psarea);
		
	}

	@Override
	public void updateCrimeDate(int id, Date date) throws SomethingWentWrongException {
		CrimeDao cd = new CrimeDaoImpl();
		cd.updateCrimeDate(id, date);
		
	}

	@Override
	public void updateCrimeVictim(int id, String victim) throws SomethingWentWrongException {
		CrimeDao cd = new CrimeDaoImpl();
		cd.updateCrimeVictim(id, victim);
		
	}

	@Override
	public void assingCriminal(int crimeid, Criminal criminal) throws SomethingWentWrongException, RecordNotFoundException {
		CrimeDao cd = new CrimeDaoImpl();
		cd.assignCriminal(crimeid, criminal);
		
	}

	@Override
	public void removeCriminalFromCrime(Crime crime, Criminal criminal) throws RecordNotFoundException, SomethingWentWrongException {
		CrimeDao cd = new CrimeDaoImpl();
		cd.removeCriminalFromCrime(crime, criminal);
		
	}

	@Override
	public void deleteCrimeById(int crimeid) throws SomethingWentWrongException {
		CrimeDao cd = new CrimeDaoImpl();
		cd.deleteCrimeById(crimeid);
	}



}
