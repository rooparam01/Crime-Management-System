package com.masai.service;

import java.sql.Date;
import java.util.List;

import com.masai.entities.Criminal;
import com.masai.entities.PsArea;
import com.masai.exception.RecordNotFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface CriminalService {
void addCriminal(Criminal criminal) throws SomethingWentWrongException;
List<Criminal> getAllCriminal() throws RecordNotFoundException;
void updateCriminalName(int criminalid, String name) throws SomethingWentWrongException;
void updateCriminalDob(int criminalid, Date dob) throws SomethingWentWrongException;
void updateCriminalGender(int criminalid, String gender) throws SomethingWentWrongException;
void updateCriminalImark(int criminalid, String mark) throws SomethingWentWrongException;
void updateCriminalArrestDate(int criminalid, Date arrestDate) throws SomethingWentWrongException;
void updateCriminalPsArea(int criminalid, PsArea psarea) throws SomethingWentWrongException;
void deleteCriminalById(int criminalId) throws SomethingWentWrongException;
Criminal getCriminalByName(String name) throws SomethingWentWrongException;
}
