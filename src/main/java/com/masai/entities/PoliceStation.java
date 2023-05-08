package com.masai.entities;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

@OneToMany(mappedBy = "policeS",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
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
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	PoliceStation other = (PoliceStation) obj;
	return Objects.equals(address, other.address) && id == other.id && Objects.equals(name, other.name)
			&& pinCode == other.pinCode && Objects.equals(psArea, other.psArea);
}
@Override
public String toString() {
	return "PoliceStation [id=" + id + ", name=" + name + ", address=" + address + ", pinCode=" + pinCode + ", psArea="
			+ psArea + "]";
}
}
