package com.masai.dao;

import com.masai.entities.Crime;
import com.masai.exception.SomethingWentWrongException;


public interface CrimeDao {
	public void addCrime(Crime crime) throws SomethingWentWrongException;

	
}
