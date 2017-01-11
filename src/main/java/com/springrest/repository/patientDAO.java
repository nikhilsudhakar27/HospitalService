package com.springrest.repository;

import java.util.List;



import com.springrest.model.Patient;


public interface patientDAO {
	Patient findById(int pid);

	void savePatient(Patient patient);
	
	Patient updatePatient(Patient patient,int pid);
	
	void deletePatientById(Patient patient);

	List<Patient> findAllPatients();

}
