package com.masai.entities;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Criminal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int criminalId;
	private String name;
	private Date dob;
	private String gender;
	
	private String identifyingMark;
	
	private Date firstArrestDate;
	
	private String arrestedFromPsArea;
	
	@ManyToMany(mappedBy = "criminals",cascade = CascadeType.ALL)
	private Set<Crime> crimes;

	public Criminal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Criminal(String name, Date dob, String gender, String identifyingMark, Date firstArrestDate,
			String arrestedFromPsArea, Set<Crime> crimes) {
		super();
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

	public String getArrestedFromPsArea() {
		return arrestedFromPsArea;
	}

	public void setArrestedFromPsArea(String arrestedFromPsArea) {
		this.arrestedFromPsArea = arrestedFromPsArea;
	}

	public Set<Crime> getCrimes() {
		return crimes;
	}

	public void setCrimes(Set<Crime> crimes) {
		this.crimes = crimes;
	}

	@Override
	public String toString() {
		return "Criminal [criminalId=" + criminalId + ", name=" + name + ", dob=" + dob + ", gender=" + gender
				+ ", identifyingMark=" + identifyingMark + ", firstArrestDate=" + firstArrestDate
				+ ", arrestedFromPsArea=" + arrestedFromPsArea + ", crimes=" + crimes + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrestedFromPsArea == null) ? 0 : arrestedFromPsArea.hashCode());
		result = prime * result + ((crimes == null) ? 0 : crimes.hashCode());
		result = prime * result + criminalId;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((firstArrestDate == null) ? 0 : firstArrestDate.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((identifyingMark == null) ? 0 : identifyingMark.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Criminal other = (Criminal) obj;
		if (arrestedFromPsArea == null) {
			if (other.arrestedFromPsArea != null)
				return false;
		} else if (!arrestedFromPsArea.equals(other.arrestedFromPsArea))
			return false;
		if (crimes == null) {
			if (other.crimes != null)
				return false;
		} else if (!crimes.equals(other.crimes))
			return false;
		if (criminalId != other.criminalId)
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (firstArrestDate == null) {
			if (other.firstArrestDate != null)
				return false;
		} else if (!firstArrestDate.equals(other.firstArrestDate))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (identifyingMark == null) {
			if (other.identifyingMark != null)
				return false;
		} else if (!identifyingMark.equals(other.identifyingMark))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
