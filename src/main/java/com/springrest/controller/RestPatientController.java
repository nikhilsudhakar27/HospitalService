package com.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.springrest.model.Patient;
import com.springrest.service.RestPatientService;

@RestController
public class RestPatientController {
	@Autowired
	private RestPatientService service;

	@RequestMapping(value = { "/", "/list/" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Patient>> listAllPatients() {
		List<Patient> patient = service.findAllPatients();
		if (patient.isEmpty()) {
			return new ResponseEntity<List<Patient>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Patient>>(patient, HttpStatus.OK);
	}

	@RequestMapping(value = { "/list/{id}" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Patient> findById(@PathVariable("id") int id) {
		Patient patient = service.findById(id);
		if (patient == null) {
			System.out.println("Patient with id " + id + " not found");
			return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}
	
	@RequestMapping(value = { "/update/{id}" }, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient,@PathVariable("id") int id) {
		Patient newpatient = service.updatePatient(patient,id);
		if (newpatient == null) {
			System.out.println("Patient with id " + patient.getPid() + " not found");
			return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Patient>(newpatient, HttpStatus.OK);
	}
	
	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.DELETE)
	public ResponseEntity<Patient> deletePatient(@PathVariable("id") int id) {
		Patient patient = service.findById(id);
		service.deletePatientById(patient);
		return new ResponseEntity<Patient>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save/", method = RequestMethod.POST)
	public ResponseEntity<Void> createPatient(@RequestBody Patient patient,
			UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User : " + patient.getFirstName()+" "+patient.getLastName());

		service.savePatient(patient);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/list/{id}")
				.buildAndExpand(patient.getPid()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}
