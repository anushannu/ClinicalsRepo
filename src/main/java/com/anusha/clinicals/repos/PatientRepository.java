package com.anusha.clinicals.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anusha.clinicals.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
