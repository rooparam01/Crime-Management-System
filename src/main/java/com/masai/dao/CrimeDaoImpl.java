package com.masai.dao;

import java.sql.Date;

import com.masai.entities.Crime;
import com.masai.entities.PoliceStation;
import com.masai.exception.SomethingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

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

	
}
