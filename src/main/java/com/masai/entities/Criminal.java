package com.masai.entities;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Criminal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int criminal_id;
	private String name;
	private Date dob;
	private String Gender;
	private String identifying_mark;
	private Date first_arrest_date;
	private String arrested_from_ps_area;
	
	@ManyToMany(mappedBy = "criminals")
	private Set<Crime> crimes;

	public Criminal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Criminal(String name, Date dob, String gender, String identifying_mark, Date first_arrest_date,
			String arrested_from_ps_area, Set<Crime> crimes) {
		super();
		this.name = name;
		this.dob = dob;
		Gender = gender;
		this.identifying_mark = identifying_mark;
		this.first_arrest_date = first_arrest_date;
		this.arrested_from_ps_area = arrested_from_ps_area;
		this.crimes = crimes;
	}

	public int getCriminal_id() {
		return criminal_id;
	}

	public void setCriminal_id(int criminal_id) {
		this.criminal_id = criminal_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getIdentifying_mark() {
		return identifying_mark;
	}

	public void setIdentifying_mark(String identifying_mark) {
		this.identifying_mark = identifying_mark;
	}

	public Date getFirst_arrest_date() {
		return first_arrest_date;
	}

	public void setFirst_arrest_date(Date first_arrest_date) {
		this.first_arrest_date = first_arrest_date;
	}

	public String getArrested_from_ps_area() {
		return arrested_from_ps_area;
	}

	public void setArrested_from_ps_area(String arrested_from_ps_area) {
		this.arrested_from_ps_area = arrested_from_ps_area;
	}

	public Set<Crime> getCrimes() {
		return crimes;
	}

	public void setCrimes(Set<Crime> crimes) {
		this.crimes = crimes;
	}

	@Override
	public String toString() {
		return "Criminal [criminal_id=" + criminal_id + ", name=" + name + ", dob=" + dob + ", Gender=" + Gender
				+ ", identifying_mark=" + identifying_mark + ", first_arrest_date=" + first_arrest_date
				+ ", arrested_from_ps_area=" + arrested_from_ps_area + ", crimes=" + crimes + "]";
	}
	
	

}
