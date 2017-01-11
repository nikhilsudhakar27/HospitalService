package com.springrest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.springrest.model.Doctor;
@Repository("doctorDAO")
public class doctorDAOImpl implements doctorDAO {
	@PersistenceContext
	EntityManager emd;
	@Override
	public Doctor findById(int docId) {
		// TODO Auto-generated method stub
		return emd.find(Doctor.class, docId);
	}

	@Override
	public void saveDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		emd.persist(doctor);
	}

	@Override
	public Doctor updateDoctor(Doctor doctor, int docid) {
		// TODO Auto-generated method stub
		
		return emd.merge(doctor);
	}

	@Override
	public void deleteDoctorById(Doctor doctor) {
		// TODO Auto-generated method stub
		Doctor d = emd.merge(doctor);
		emd.remove(d);
	}

	@Override
	public List<Doctor> findAllDoctors() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Doctor> list = emd.createQuery("SELECT d FROM Doctor d").getResultList();
		return list;
	}

}
