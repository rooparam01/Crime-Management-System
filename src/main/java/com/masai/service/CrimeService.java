package com.masai.service;

import java.sql.Date;

import com.masai.entities.Crime;
import com.masai.exception.SomethingWentWrongException;

public interface CrimeService {
	void addCrime(Crime crime) throws SomethingWentWrongException;

	void updateCrimeType(int id,String crimeType) throws SomethingWentWrongException;
	void updateCrimeDescription(int id,String desc) throws SomethingWentWrongException;

	void updateCrimePsArea(int id, String psarea)throws SomethingWentWrongException;

	void updateCrimeDate(int id, Date date)throws SomethingWentWrongException;

	void updateCrimeVictim(int id, String victim)throws SomethingWentWrongException;

}
