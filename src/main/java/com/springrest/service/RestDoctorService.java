package com.springrest.service;

import java.util.List;

import com.springrest.model.Doctor;


public interface RestDoctorService {
	Doctor findById(int docId);

	void saveDoctor(Doctor doctor);

	Doctor updateDoctor(Doctor doctor,int docid);

	void deleteDoctorById(Doctor doctor);

	List<Doctor> findAllDoctors();
}
