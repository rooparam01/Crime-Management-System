package com.masai.dao;

import java.sql.Date;
import java.util.List;

import com.masai.entities.Criminal;
import com.masai.entities.PsArea;
import com.masai.exception.RecordNotFoundException;
import com.masai.exception.SomethingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class CriminalDaoImpl implements CriminalDao {

	@Override
	public void addCriminal(Criminal criminal) throws SomethingWentWrongException {
		EntityManager em = null;
		
		try {
			em =EMUtils.getEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(criminal);
			et.commit();
		} catch (PersistenceException e) {
			throw new SomethingWentWrongException("Not able to add Criminal Please try again");
		}finally {
			em.close();
		}
	}

	@Override
	public List<Criminal> getAllCriminal() throws RecordNotFoundException {
	EntityManager em = null;
		List<Criminal> list=null;
		try {
			em =EMUtils.getEntityManager();
			String que = "SELECT C FROM Criminal C";
			Query query = em.createQuery(que);
			list = query.getResultList();
			return list;
		} catch (PersistenceException e) {
			throw new RecordNotFoundException("Not able to Fetch Criminal Please try again");
		}finally {
			em.close();
		}
	}

	@Override
	public void updateCriminalName(int criminalid, String name) throws SomethingWentWrongException {
		EntityManager em = null;
		try {
			em =EMUtils.getEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			Criminal criminal = em.find(Criminal.class, criminalid);
			criminal.setName(name);
			et.commit();
		} catch (PersistenceException e) {
			throw new SomethingWentWrongException("Not updated Please Try Again");
		}finally {
			em.close();
		}
		
	}

	@Override
	public void updateCriminalDob(int criminalid, Date dob) throws SomethingWentWrongException {
		EntityManager em = null;
		try {
			em =EMUtils.getEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			Criminal criminal = em.find(Criminal.class, criminalid);
			criminal.setDob(dob);
			et.commit();
		} catch (PersistenceException e) {
			throw new SomethingWentWrongException("Not updated Please Try Again");
		}finally {
			em.close();
		}
		
	}

	@Override
	public void updateCriminalGender(int criminalid, String gender) throws SomethingWentWrongException {
		EntityManager em = null;
		try {
			em =EMUtils.getEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			Criminal criminal = em.find(Criminal.class, criminalid);
			criminal.setGender(gender);
			et.commit();
		} catch (PersistenceException e) {
			throw new SomethingWentWrongException("Not updated Please Try Again");
		}finally {
			em.close();
		}
		
	}

	@Override
	public void updateCriminalIMark(int criminalid, String mark) throws SomethingWentWrongException {
		EntityManager em = null;
		try {
			em =EMUtils.getEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			Criminal criminal = em.find(Criminal.class, criminalid);
			criminal.setIdentifyingMark(mark);
			et.commit();
		} catch (PersistenceException e) {
			throw new SomethingWentWrongException("Not updated Please Try Again");
		}finally {
			em.close();
		}
		
	}

	@Override
	public void updateCriminalArrestDate(int criminalid, Date arrestDate) throws SomethingWentWrongException {
		EntityManager em = null;
		try {
			em =EMUtils.getEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			Criminal criminal = em.find(Criminal.class, criminalid);
			criminal.setFirstArrestDate(arrestDate);
			et.commit();
		} catch (PersistenceException e) {
			throw new SomethingWentWrongException("Not updated Please Try Again");
		}finally {
			em.close();
		}
		
	}

	@Override
	public void updateCriminalPsArea(int criminalid, PsArea psarea) throws SomethingWentWrongException {
		EntityManager em = null;
		try {
			em =EMUtils.getEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			Criminal criminal = em.find(Criminal.class, criminalid);
			criminal.setArrestedFromPsArea(psarea);
			et.commit();
		} catch (PersistenceException e) {
			throw new SomethingWentWrongException("Not updated Please Try Again");
		}finally {
			em.close();
		}
		
	}

	@Override
	public void deleteCriminalById(int criminalId) throws SomethingWentWrongException {
		EntityManager em = EMUtils.getEntityManager();;
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			String que = "DELETE FROM Criminal c WHERE c.criminalId = :cId";
			Query query = em.createQuery(que);
			query.setParameter("cId", criminalId);
			query.executeUpdate();
			et.commit();
		}catch(PersistenceException e) {
			throw new SomethingWentWrongException("Unable to process your request please try again");
		}finally {
			em.close();
		}
		
	}

	@Override
	public Criminal getCriminalByName(String name) throws SomethingWentWrongException {
		
		EntityManager em = EMUtils.getEntityManager();;
		try {
			String que = "SELECT C FROM Criminal C WHERE C.name LIKE :name ";
			Query query = em.createQuery(que);
			query.setParameter("name", "%"+name+"%");
			return (Criminal) query.getSingleResult();
		}catch(PersistenceException e) {
			throw new SomethingWentWrongException("Unable to process your request please try again");
		}finally {
			em.close();
		}
	}

}
