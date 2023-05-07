package com.masai.dao;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.masai.entities.Crime;
import com.masai.entities.Criminal;
import com.masai.entities.PoliceStation;
import com.masai.exception.RecordNotFoundException;
import com.masai.exception.SomethingWentWrongException;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class CrimeDaoImpl implements CrimeDao  {

	public void addCrime(Crime crime) throws SomethingWentWrongException {
		EntityManager em = EMUtils.getEntityManager();;
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(crime);
			et.commit();
		}catch(PersistenceException e) {
			throw new SomethingWentWrongException("Unable to process your request please try again");
		}finally {
			em.close();
		}
	}

	@Override
	public void updateCrimeType(int id, String crimeType) throws SomethingWentWrongException  {
		EntityManager em = EMUtils.getEntityManager();;
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			Crime cri = em.find(Crime.class,id);
			if(cri==null) {
				throw new SomethingWentWrongException("No record Found");
			}
			cri.setType(crimeType);
			et.commit();
		}catch(PersistenceException e) {
			throw new SomethingWentWrongException("Unable to process your request please try again");
		}finally {
			em.close();
		}
		
	}

	@Override
	public void updateCrimeDesc(int id, String desc) throws SomethingWentWrongException {
		EntityManager em = EMUtils.getEntityManager();;
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			Crime cri = em.find(Crime.class,id);
			if(cri==null) {
				throw new SomethingWentWrongException("No record Found");
			}
			cri.setDescription(desc);
			et.commit();
		}catch(PersistenceException e) {
			throw new SomethingWentWrongException("Unable to process your request please try again");
		}finally {
			em.close();
		}
		
	}

	@Override
	public void updateCrimePsArea(int id, String psarea) throws SomethingWentWrongException {
		EntityManager em = EMUtils.getEntityManager();;
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			Crime cri = em.find(Crime.class,id);
			if(cri==null) {
				throw new SomethingWentWrongException("No record Found");
			}
			cri.getPsarea().setAreaName(psarea);
			et.commit();
		}catch(PersistenceException e) {
			throw new SomethingWentWrongException("Unable to process your request please try again");
		}finally {
			em.close();
		}
		
	}

	@Override
	public void updateCrimeDate(int id, Date date) throws SomethingWentWrongException {
		EntityManager em = EMUtils.getEntityManager();;
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			Crime cri = em.find(Crime.class,id);
			if(cri==null) {
				throw new SomethingWentWrongException("No record Found");
			}
			cri.setDate(date);
			et.commit();
		}catch(PersistenceException e) {
			throw new SomethingWentWrongException("Unable to process your request please try again");
		}finally {
			em.close();
		}
		
	}

	@Override
	public void updateCrimeVictim(int id, String victim) throws SomethingWentWrongException {
		EntityManager em = EMUtils.getEntityManager();;
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			Crime cri = em.find(Crime.class,id);
			if(cri==null) {
				throw new SomethingWentWrongException("No record Found");
			}
			cri.setNameOfVictim(victim);
			et.commit();
		}catch(PersistenceException e) {
			throw new SomethingWentWrongException("Unable to process your request please try again");
		}finally {
			em.close();
		}
		
	}

	@Override
	public List<Crime> getAllCrime() throws SomethingWentWrongException {
		EntityManager em = EMUtils.getEntityManager();;
		try {
			String que = "SELECT C FROM Crime C";
			Query query = em.createQuery(que);
			List<Crime> list = query.getResultList();
			return list;
			
		}catch(PersistenceException e) {
			throw new SomethingWentWrongException("Unable to process your request please try again");
		}finally {
			em.close();
		}
	}

	@Override
	public void assignCriminal(int crimeid, Criminal criminal) throws SomethingWentWrongException, RecordNotFoundException {
		EntityManager em = EMUtils.getEntityManager();;
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			Crime cri = em.find(Crime.class,crimeid);
			if(cri==null) {
				throw new RecordNotFoundException("No record Found");
			}
			if(cri.getCriminals()==null) {
				Set<Criminal> criminalSet = new HashSet();
				criminalSet.add(criminal);
				cri.setCriminals(criminalSet);
			}else {
				cri.getCriminals().add(criminal);	
			}
			et.commit();
		}catch(PersistenceException e) {
			throw new SomethingWentWrongException("Unable to process your request please try again");
		}finally {
			em.close();
		}
		
	}

	@Override
	public void removeCriminalFromCrime(Crime crime, Criminal criminal) throws RecordNotFoundException, SomethingWentWrongException {
		EntityManager em = EMUtils.getEntityManager();;
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			Crime cri = em.find(Crime.class,crime.getCrimeId());
			if(cri==null) {
				throw new RecordNotFoundException("No record Found");
			}
			cri.getCriminals().removeIf(el->el.getCriminalId()==criminal.getCriminalId());
			et.commit();
		}catch(PersistenceException e) {
			throw new SomethingWentWrongException("Unable to process your request please try again");
		}finally {
			em.close();
		}
		
	}

	@Override
	public void deleteCrimeById(int crimeid) throws SomethingWentWrongException {
		EntityManager em = EMUtils.getEntityManager();;
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			String que = "DELETE FROM Crime c WHERE c.crimeId = :crimeId";
			Query query = em.createQuery(que);
			query.setParameter("crimeId", crimeid);
			query.executeUpdate();
			et.commit();
		}catch(PersistenceException e) {
			throw new SomethingWentWrongException("Unable to process your request please try again");
		}finally {
			em.close();
		}
		
	}

	
}
