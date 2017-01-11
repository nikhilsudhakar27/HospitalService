package com.springrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="DoctorHiber")
public class Doctor {
	@Id
	private int docId;
	@Size(min=1, max=50)
	@Column(name = "firstName", nullable = false)
	private String firstName;
	@Size(min=1, max=50)
	@Column(name = "lastName", nullable = false)
	private String lastName;
	@Size(min=1, max=50)
	@Column(name = "address", nullable = false)
	private String address;
	@Size(min=1, max=50)
	@Column(name = "speciality", nullable = false)
	private String speciality;
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
}
