package com.anusha.clinicals.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anusha.clinicals.dto.ClinicalDataRequest;
import com.anusha.clinicals.model.ClinicalData;
import com.anusha.clinicals.model.Patient;
import com.anusha.clinicals.repos.ClinicalDataRepository;
import com.anusha.clinicals.repos.PatientRepository;

@RestController
@RequestMapping("/api")
public class ClinicalDataController {

	private ClinicalDataRepository clinicalRepo;

	private PatientRepository patientRepo;

	ClinicalDataController(ClinicalDataRepository clinicalRepo, PatientRepository patientRepo) {
		this.clinicalRepo = clinicalRepo;
		this.patientRepo = patientRepo;
	}

	@RequestMapping(value = "/clinicals", method = RequestMethod.POST)
	public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest clinicalDataRequest) {
		Patient patient = patientRepo.findById(clinicalDataRequest.getPatientId()).get();
		System.out.println("Patient details are::"+patient.getFirstName());
		ClinicalData clinicalData = new ClinicalData();
		clinicalData.setComponentName(clinicalDataRequest.getComponentName());
		clinicalData.setComponentValue(clinicalDataRequest.getComponentValue());
		clinicalData.setPatient(patient);
		System.out.println("Clinical details are::"+clinicalData.getComponentName()+":::"+clinicalData.getPatient().getFirstName());
		return clinicalRepo.save(clinicalData);

	}

}
