package com.masai.dao;

import java.util.List;

import com.masai.entities.PoliceStation;
import com.masai.entities.PsArea;
import com.masai.exception.RecordNotFoundException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class PsAreaDaoImpl implements PsAreaDao {

	@Override
	public List<PsArea> getPsAreaList() throws RecordNotFoundException {
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			String que = "SELECT PS FROM PsArea PS";
			Query query = em.createQuery(que);
			List<PsArea> list = query.getResultList();
			return list;
		}catch(PersistenceException e) {
			throw new RecordNotFoundException("No record found");
		}finally {
			em.close();
		}
	}

}
