package com.masai.service;

import java.sql.Date;

import com.masai.dao.CrimeDao;
import com.masai.dao.CrimeDaoImpl;
import com.masai.entities.Crime;
import com.masai.exception.SomethingWentWrongException;

public class CrimeServiceImpl implements CrimeService {

	public void addCrime(Crime crime) throws SomethingWentWrongException {
		CrimeDao cd = new CrimeDaoImpl();
		cd.addCrime(crime);	
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



}
