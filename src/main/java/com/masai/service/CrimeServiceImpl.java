package com.masai.service;

import com.masai.dao.CrimeDao;
import com.masai.dao.CrimeDaoImpl;
import com.masai.entities.Crime;
import com.masai.exception.SomethingWentWrongException;

public class CrimeServiceImpl implements CrimeService {

	public void addCrime(Crime crime) throws SomethingWentWrongException {
		CrimeDao cd = new CrimeDaoImpl();
		cd.addCrime(crime);	
	}

}
