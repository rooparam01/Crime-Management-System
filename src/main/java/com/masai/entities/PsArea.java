package com.masai.entities;

import java.util.Set;

import org.hibernate.annotations.Generated;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

@OneToMany(mappedBy = "psArea",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
private Set<Crime> crimes;

@OneToMany(mappedBy = "arrestedFromPsArea",cascade = CascadeType.ALL)
private Set<Criminal> criminal;

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

public Set<Criminal> getCriminal() {
	return criminal;
}

public void setCriminal(Set<Criminal> criminal) {
	this.criminal = criminal;
}



//@Override
//public String toString() {
//	//return "PsArea [id=" + id + ", areaName=" + areaName + ", policeS=" + policeS + ", crimes=" + crimes + "]";
//}



}
