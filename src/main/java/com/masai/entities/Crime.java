package com.masai.entities;

import java.sql.Date;
import java.util.Set;

import org.hibernate.annotations.FilterJoinTable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
@Entity
public class Crime {
	//Robbery, Theft, Homicide),
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "crime_id")
private int crimeId;
private String type;
private String description;
@Column(name = "ps_area",nullable = false)
private String psArea;
@Column(nullable = false)
private Date date;
@Column(name = "name_of_victim")
private String nameOfVictim;

@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(name = "crime_criminal",joinColumns = {@JoinColumn(referencedColumnName = "crime_id")},inverseJoinColumns = {@JoinColumn(referencedColumnName = "criminal_id")})
private Set<Criminal> criminals;

public Crime() {
	super();
	// TODO Auto-generated constructor stub
}

public Crime(String type, String description, String psArea, Date date, String nameOfVictim, Set<Criminal> criminals) {
	super();
	this.type = type;
	this.description = description;
	this.psArea = psArea;
	this.date = date;
	this.nameOfVictim = nameOfVictim;
	this.criminals = criminals;
}

public int getCrimeId() {
	return crimeId;
}

public void setCrimeId(int crimeId) {
	this.crimeId = crimeId;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getPsArea() {
	return psArea;
}

public void setPsArea(String psArea) {
	this.psArea = psArea;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public String getNameOfVictim() {
	return nameOfVictim;
}

public void setNameOfVictim(String nameOfVictim) {
	this.nameOfVictim = nameOfVictim;
}

public Set<Criminal> getCriminals() {
	return criminals;
}

public void setCriminals(Set<Criminal> criminals) {
	this.criminals = criminals;
}

@Override
public String toString() {
	return "Crime [crimeId=" + crimeId + ", type=" + type + ", description=" + description + ", psArea=" + psArea
			+ ", date=" + date + ", nameOfVictim=" + nameOfVictim + ", criminals=" + criminals + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + crimeId;
	result = prime * result + ((criminals == null) ? 0 : criminals.hashCode());
	result = prime * result + ((date == null) ? 0 : date.hashCode());
	result = prime * result + ((description == null) ? 0 : description.hashCode());
	result = prime * result + ((nameOfVictim == null) ? 0 : nameOfVictim.hashCode());
	result = prime * result + ((psArea == null) ? 0 : psArea.hashCode());
	result = prime * result + ((type == null) ? 0 : type.hashCode());
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
	Crime other = (Crime) obj;
	if (crimeId != other.crimeId)
		return false;
	if (criminals == null) {
		if (other.criminals != null)
			return false;
	} else if (!criminals.equals(other.criminals))
		return false;
	if (date == null) {
		if (other.date != null)
			return false;
	} else if (!date.equals(other.date))
		return false;
	if (description == null) {
		if (other.description != null)
			return false;
	} else if (!description.equals(other.description))
		return false;
	if (nameOfVictim == null) {
		if (other.nameOfVictim != null)
			return false;
	} else if (!nameOfVictim.equals(other.nameOfVictim))
		return false;
	if (psArea == null) {
		if (other.psArea != null)
			return false;
	} else if (!psArea.equals(other.psArea))
		return false;
	if (type == null) {
		if (other.type != null)
			return false;
	} else if (!type.equals(other.type))
		return false;
	return true;
}





}
