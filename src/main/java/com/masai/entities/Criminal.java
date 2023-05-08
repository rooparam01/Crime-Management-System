package com.masai.entities;

import java.sql.Date;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Criminal {
	@Id
	private int criminalId;
	private String name;
	private Date dob;
	private String gender;
	
	private String identifyingMark;
	
	private Date firstArrestDate;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "ps_areaid")
	private PsArea arrestedFromPsArea;
	
	@ManyToMany(mappedBy = "criminals",fetch = FetchType.EAGER)
	private Set<Crime> crimes;

	public Criminal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Criminal(int criminalId, String name, Date dob, String gender, String identifyingMark, Date firstArrestDate,
			PsArea arrestedFromPsArea, Set<Crime> crimes) {
		super();
		this.criminalId = criminalId;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.identifyingMark = identifyingMark;
		this.firstArrestDate = firstArrestDate;
		this.arrestedFromPsArea = arrestedFromPsArea;
		this.crimes = crimes;
	}

	public int getCriminalId() {
		return criminalId;
	}

	public void setCriminalId(int criminalId) {
		this.criminalId = criminalId;
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
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdentifyingMark() {
		return identifyingMark;
	}

	public void setIdentifyingMark(String identifyingMark) {
		this.identifyingMark = identifyingMark;
	}

	public Date getFirstArrestDate() {
		return firstArrestDate;
	}

	public void setFirstArrestDate(Date firstArrestDate) {
		this.firstArrestDate = firstArrestDate;
	}

	public PsArea getArrestedFromPsArea() {
		return arrestedFromPsArea;
	}

	public void setArrestedFromPsArea(PsArea arrestedFromPsArea) {
		this.arrestedFromPsArea = arrestedFromPsArea;
	}

	public Set<Crime> getCrimes() {
		return crimes;
	}

	public void setCrimes(Set<Crime> crimes) {
		this.crimes = crimes;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criminal other = (Criminal) obj;
		return Objects.equals(arrestedFromPsArea, other.arrestedFromPsArea) && Objects.equals(crimes, other.crimes)
				&& criminalId == other.criminalId && Objects.equals(dob, other.dob)
				&& Objects.equals(firstArrestDate, other.firstArrestDate) && Objects.equals(gender, other.gender)
				&& Objects.equals(identifyingMark, other.identifyingMark) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Criminal [criminalId=" + criminalId + ", name=" + name + ", dob=" + dob + ", gender=" + gender
				+ ", identifyingMark=" + identifyingMark + ", firstArrestDate=" + firstArrestDate
				+ ", arrestedFromPsArea=" + arrestedFromPsArea + ", crimes=" + crimes + "]";
	}

	

	
	
}
