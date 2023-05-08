package com.masai.service;

import java.util.List;

import com.masai.entities.PsArea;
import com.masai.exception.RecordNotFoundException;

public interface PsAreaService {
public List<PsArea> getPsAreaList() throws RecordNotFoundException;
}
