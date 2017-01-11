package com.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springrest.model.Patient;
import com.springrest.repository.patientDAO;

@Service("service")
@Transactional
public class RestPatientServiceImpl implements RestPatientService {
	@Autowired
	private patientDAO dao;
	@Override
	public Patient findById(int pid) {
		// TODO Auto-generated method stub
		return dao.findById(pid);
	}

	@Override
	public void savePatient(Patient patient) {
		// TODO Auto-generated method stub
		dao.savePatient(patient);
	}

	@Override
	public Patient updatePatient(Patient patient,int pid) {
		// TODO Auto-generated method stub
		return dao.updatePatient(patient,pid);
	}

	@Override
	public void deletePatientById(Patient patient) {
		// TODO Auto-generated method stub
		dao.deletePatientById(patient);
	}

	@Override
	public List<Patient> findAllPatients() {
		// TODO Auto-generated method stub
		return dao.findAllPatients();
	}
	
}
