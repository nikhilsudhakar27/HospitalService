package com.springrest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.springrest.model.Patient;

@Repository("patientDAO")
public class patientDAOImpl implements patientDAO {
	@PersistenceContext
	EntityManager em;
	@Override
	public Patient findById(int pid) {
		// TODO Auto-generated method stub
		return em.find(Patient.class, pid);
	}

	@Override
	public void savePatient(Patient patient) {
		// TODO Auto-generated method stub
		em.persist(patient);
	}

	@Override
	public void deletePatientById(Patient patient) {
		// TODO Auto-generated method stub
		Patient p = em.merge(patient);
		em.remove(p);
	}

	@Override
	public List<Patient> findAllPatients() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Patient> list = em.createQuery("SELECT p FROM Patient p").getResultList();
		return list;
	}

	@Override
	public Patient updatePatient(Patient patient,int pid) {
		// TODO Auto-generated method stub
		return em.merge(patient);
	}

}
