package com.masai.entities;

import java.util.Set;

import org.hibernate.annotations.Generated;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class PsArea {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String areaName;
@ManyToOne(cascade = CascadeType.MERGE)
@JoinColumn(name = "ps_id")
private PoliceStation policeS;

@OneToMany(mappedBy = "psArea",cascade = CascadeType.ALL)
private Set<Crime> crimes;

public PsArea() {
	super();
	// TODO Auto-generated constructor stub
}

public PsArea(String areaName, PoliceStation policeS, Set<Crime> crimes) {
	super();
	this.areaName = areaName;
	this.policeS = policeS;
	this.crimes = crimes;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getAreaName() {
	return areaName;
}

public void setAreaName(String areaName) {
	this.areaName = areaName;
}

public PoliceStation getPoliceS() {
	return policeS;
}

public void setPoliceS(PoliceStation policeS) {
	this.policeS = policeS;
}

public Set<Crime> getCrimes() {
	return crimes;
}

public void setCrimes(Set<Crime> crimes) {
	this.crimes = crimes;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((areaName == null) ? 0 : areaName.hashCode());
	result = prime * result + ((crimes == null) ? 0 : crimes.hashCode());
	result = prime * result + id;
	result = prime * result + ((policeS == null) ? 0 : policeS.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	PsArea other = (PsArea) obj;
	if (areaName == null) {
		if (other.areaName != null)
			return false;
	} else if (!areaName.equals(other.areaName))
		return false;
	if (crimes == null) {
		if (other.crimes != null)
			return false;
	} else if (!crimes.equals(other.crimes))
		return false;
	if (id != other.id)
		return false;
	if (policeS == null) {
		if (other.policeS != null)
			return false;
	} else if (!policeS.equals(other.policeS))
		return false;
	return true;
}

@Override
public String toString() {
	return "PsArea [id=" + id + ", areaName=" + areaName + ", policeS=" + policeS + ", crimes=" + crimes + "]";
}



}
