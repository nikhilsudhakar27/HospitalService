package com.springrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="PatientHiber")
public class Patient {
	@Id
	private int pid;
	@Size(min=1, max=50)
	@Column(name = "firstName", nullable = false)
	private String firstName;
	@Size(min=1, max=50)
	@Column(name = "lastName", nullable = false)
	private String lastName;
	@Size(min=1, max=50)
	@Column(name = "address", nullable = false)
	private String address;
	
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
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public Patient() {
		
	}
	public Patient(int pid,String firstName,String lastName,String address) {
		this.pid=pid;
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
	}
}
