package com.masai.service;

import java.util.List;

import com.masai.dao.PsAreaDao;
import com.masai.dao.PsAreaDaoImpl;
import com.masai.entities.PsArea;
import com.masai.exception.RecordNotFoundException;

public class PsAreaServiceImpl implements PsAreaService {

	@Override
	public List<PsArea> getPsAreaList() throws RecordNotFoundException {
		PsAreaDao pad = new PsAreaDaoImpl();
		return pad.getPsAreaList();
	}

}
