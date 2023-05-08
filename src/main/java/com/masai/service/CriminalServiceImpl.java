package com.masai.service;

import java.sql.Date;
import java.util.List;

import com.masai.dao.CriminalDao;
import com.masai.dao.CriminalDaoImpl;
import com.masai.entities.Criminal;
import com.masai.entities.PsArea;
import com.masai.exception.RecordNotFoundException;
import com.masai.exception.SomethingWentWrongException;

public class CriminalServiceImpl implements CriminalService {

	@Override
	public void addCriminal(Criminal criminal) throws SomethingWentWrongException {
		CriminalDao cd = new CriminalDaoImpl();
		cd.addCriminal(criminal);
	}

	@Override
	public List<Criminal> getAllCriminal() throws RecordNotFoundException {
		CriminalDao cd = new CriminalDaoImpl();
		return cd.getAllCriminal();
	}

	@Override
	public void updateCriminalName(int criminalid, String name) throws SomethingWentWrongException {
		CriminalDao cd = new CriminalDaoImpl();
		cd.updateCriminalName(criminalid,name);
	}

	@Override
	public void updateCriminalDob(int criminalid, Date dob) throws SomethingWentWrongException {
		CriminalDao cd = new CriminalDaoImpl();
		cd.updateCriminalDob(criminalid,dob);
		
	}

	@Override
	public void updateCriminalGender(int criminalid, String gender) throws SomethingWentWrongException {
		CriminalDao cd = new CriminalDaoImpl();
		cd.updateCriminalGender(criminalid,gender);
	}

	@Override
	public void updateCriminalImark(int criminalid, String mark) throws SomethingWentWrongException {
		CriminalDao cd = new CriminalDaoImpl();
		cd.updateCriminalIMark(criminalid,mark);
	}

	@Override
	public void updateCriminalArrestDate(int criminalid, Date arrestDate) throws SomethingWentWrongException {
		CriminalDao cd = new CriminalDaoImpl();
		cd.updateCriminalArrestDate(criminalid,arrestDate);
		
	}

	@Override
	public void updateCriminalPsArea(int criminalid, PsArea psarea) throws SomethingWentWrongException {
		CriminalDao cd = new CriminalDaoImpl();
		cd.updateCriminalPsArea(criminalid,psarea);
		
	}

	@Override
	public void deleteCriminalById(int criminalId) throws SomethingWentWrongException {
		CriminalDao cd = new CriminalDaoImpl();
		cd.deleteCriminalById(criminalId);
		
	}

	@Override
	public Criminal getCriminalByName(String name) throws SomethingWentWrongException {
		CriminalDao cd = new CriminalDaoImpl();
		return cd.getCriminalByName(name);
	}

}
