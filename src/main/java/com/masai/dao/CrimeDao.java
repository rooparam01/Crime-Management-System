package com.masai.dao;

import java.sql.Date;

import com.masai.entities.Crime;
import com.masai.exception.SomethingWentWrongException;


public interface CrimeDao {
	public void addCrime(Crime crime) throws SomethingWentWrongException;

	public void updateCrimeType(int id, String crimeType) throws SomethingWentWrongException;

	public void updateCrimeDesc(int id, String desc)throws SomethingWentWrongException;

	public void updateCrimePsArea(int id, String psarea)throws SomethingWentWrongException;

	public void updateCrimeDate(int id, Date date)throws SomethingWentWrongException;

	public void updateCrimeVictim(int id, String victim)throws SomethingWentWrongException;


	
}
