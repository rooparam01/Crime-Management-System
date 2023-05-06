package com.masai.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class PoliceStation {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String name;
private String address;
private int pinCode;

@OneToMany(mappedBy = "policeS",cascade = CascadeType.ALL)
private Set<PsArea> psArea;

public PoliceStation() {
	super();
	// TODO Auto-generated constructor stub
}
public PoliceStation(String name, String address, int pinCode, Set<PsArea> psArea) {
	super();
	this.name = name;
	this.address = address;
	this.pinCode = pinCode;
	this.psArea = psArea;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getPinCode() {
	return pinCode;
}
public void setPinCode(int pinCode) {
	this.pinCode = pinCode;
}
public Set<PsArea> getPsArea() {
	return psArea;
}
public void setPsArea(Set<PsArea> psArea) {
	this.psArea = psArea;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	result = prime * result + id;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + pinCode;
	result = prime * result + ((psArea == null) ? 0 : psArea.hashCode());
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
	PoliceStation other = (PoliceStation) obj;
	if (address == null) {
		if (other.address != null)
			return false;
	} else if (!address.equals(other.address))
		return false;
	if (id != other.id)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (pinCode != other.pinCode)
		return false;
	if (psArea == null) {
		if (other.psArea != null)
			return false;
	} else if (!psArea.equals(other.psArea))
		return false;
	return true;
}
@Override
public String toString() {
	return "PoliceStation [id=" + id + ", name=" + name + ", address=" + address + ", pinCode=" + pinCode + ", psArea="
			+ psArea + "]";
}
}
