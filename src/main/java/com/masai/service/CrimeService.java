package com.masai.service;

import com.masai.entities.Crime;
import com.masai.exception.SomethingWentWrongException;

public interface CrimeService {
	void addCrime(Crime crime) throws SomethingWentWrongException;
}
