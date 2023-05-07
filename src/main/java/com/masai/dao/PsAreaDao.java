package com.masai.dao;

import java.util.List;

import com.masai.entities.PsArea;
import com.masai.exception.RecordNotFoundException;

public interface PsAreaDao {

	public List<PsArea> getPsAreaList() throws RecordNotFoundException;

}
