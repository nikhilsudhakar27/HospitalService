package com.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springrest.model.Doctor;
import com.springrest.repository.doctorDAO;

@Service("Doctorservice")
@Transactional
public class RestDoctorServiceImpl implements RestDoctorService {
	@Autowired
	private doctorDAO dao;
	@Override
	public Doctor findById(int docId) {
		// TODO Auto-generated method stub
		return dao.findById(docId);
	}

	@Override
	public void saveDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		dao.saveDoctor(doctor);
	}

	@Override
	public Doctor updateDoctor(Doctor doctor, int docid) {
		// TODO Auto-generated method stub
		return dao.updateDoctor(doctor,docid);
	}

	@Override
	public void deleteDoctorById(Doctor doctor) {
		// TODO Auto-generated method stub
		dao.deleteDoctorById(doctor);
	}

	@Override
	public List<Doctor> findAllDoctors() {
		// TODO Auto-generated method stub
		return dao.findAllDoctors();
	}

}
