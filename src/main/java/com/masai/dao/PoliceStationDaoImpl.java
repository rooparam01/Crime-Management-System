package com.masai.dao;

import java.util.List;
import java.util.Set;

import com.masai.entities.PoliceStation;
import com.masai.exception.RecordNotFoundException;
import com.masai.exception.SomethingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class PoliceStationDaoImpl implements PoliceStationDao {

	public List<PoliceStation> getAllPoliceStation() throws RecordNotFoundException {
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			String que = "SELECT PS FROM PoliceStation PS";
			Query query = em.createQuery(que);
			List<PoliceStation> list = query.getResultList();
			return list;
		}catch(PersistenceException e) {
			throw new RecordNotFoundException("No record found");
		}finally {
			em.close();
		}
	}

	@Override
	public void addPoliceStation(PoliceStation ps) throws SomethingWentWrongException {
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(ps);
			et.commit();
		}catch(PersistenceException e) {
			throw new SomethingWentWrongException("Not added please try again");
		}finally {
			em.close();
		}
		
	}

}
