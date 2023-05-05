package com.masai.dao;

import com.masai.entities.Crime;
import com.masai.exception.SomethingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

public class CrimeDaoImpl implements CrimeDao  {

	public void addCrime(Crime crime) throws SomethingWentWrongException {
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			EntityTransaction et= em.getTransaction();
			et.begin();
			em.persist(crime);
			et.commit();
		}catch(PersistenceException e) {
			throw new SomethingWentWrongException("Unable to process your request please try again");
		}finally {
			em.close();
		}
	}
}
