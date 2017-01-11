package com.springrest.repository;

import java.util.List;

import com.springrest.model.Doctor;

public interface doctorDAO {
	Doctor findById(int docId);

	void saveDoctor(Doctor doctor);

	Doctor updateDoctor(Doctor doctor, int docid);

	void deleteDoctorById(Doctor doctor);

	List<Doctor> findAllDoctors();
}
