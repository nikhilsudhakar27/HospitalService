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

import com.springrest.model.Doctor;
import com.springrest.service.RestDoctorService;

@RestController
public class RestDoctorController {
	@Autowired
	private RestDoctorService Doctorservice;

	@RequestMapping(value = { "/listDoctor/" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Doctor>> listAllDoctors() {
		List<Doctor> doctor = Doctorservice.findAllDoctors();
		if (doctor.isEmpty()) {
			return new ResponseEntity<List<Doctor>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Doctor>>(doctor, HttpStatus.OK);
	}

	@RequestMapping(value = { "/listDoctor/{docId}" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Doctor> findById(@PathVariable("docId") int id) {
		Doctor doctor = Doctorservice.findById(id);
		if (doctor == null) {
			System.out.println("Doctor with id " + id + " not found");
			return new ResponseEntity<Doctor>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
	}
	
	@RequestMapping(value = { "/updateDoctor/{docId}" }, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor,@PathVariable("docId") int id) {
		Doctor newDoctor = Doctorservice.updateDoctor(doctor,id);
		if (newDoctor == null) {
			System.out.println("Doctor with id " + doctor.getDocId() + " not found");
			return new ResponseEntity<Doctor>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Doctor>(newDoctor, HttpStatus.OK);
	}
	
	@RequestMapping(value = { "/deleteDoctor/{docId}" }, method = RequestMethod.DELETE)
	public ResponseEntity<Doctor> deleteDoctor(@PathVariable("docId") int id) {
		Doctor doctor = Doctorservice.findById(id);
		Doctorservice.deleteDoctorById(doctor);
		return new ResponseEntity<Doctor>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/saveDoctor/", method = RequestMethod.POST)
	public ResponseEntity<Void> createDoctor(@RequestBody Doctor doctor,
			UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User : " + doctor.getFirstName()+" "+doctor.getLastName());

		Doctorservice.saveDoctor(doctor);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/listDoctor/{id}")
				.buildAndExpand(doctor.getDocId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}
