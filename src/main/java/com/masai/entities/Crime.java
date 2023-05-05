package com.masai.entities;

import java.sql.Date;
import java.util.Set;

import org.hibernate.annotations.FilterJoinTable;

import jakarta.persistence.CascadeType;
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
private int crime_id;
private String type;
private String description;
private String ps_area;
private Date date;
private String name_of_victim;

@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(name = "crime_criminal",joinColumns = {@JoinColumn(referencedColumnName = "crime_id")},inverseJoinColumns = {@JoinColumn(referencedColumnName = "criminal_id")})
private Set<Criminal> criminals;

public Crime() {
	super();
	// TODO Auto-generated constructor stub
}

public Crime(String type, String description, String ps_area, Date date, String name_of_victim,
		Set<Criminal> criminals) {
	super();
	this.type = type;
	this.description = description;
	this.ps_area = ps_area;
	this.date = date;
	this.name_of_victim = name_of_victim;
	this.criminals = criminals;
}

public int getCrime_id() {
	return crime_id;
}

public void setCrime_id(int crime_id) {
	this.crime_id = crime_id;
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

public String getPs_area() {
	return ps_area;
}

public void setPs_area(String ps_area) {
	this.ps_area = ps_area;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public String getName_of_victim() {
	return name_of_victim;
}

public void setName_of_victim(String name_of_victim) {
	this.name_of_victim = name_of_victim;
}

public Set<Criminal> getCriminals() {
	return criminals;
}

public void setCriminals(Set<Criminal> criminals) {
	this.criminals = criminals;
}

@Override
public String toString() {
	return "Crime [crime_id=" + crime_id + ", type=" + type + ", description=" + description + ", ps_area=" + ps_area
			+ ", date=" + date + ", name_of_victim=" + name_of_victim + ", criminals=" + criminals + "]";
}


}
