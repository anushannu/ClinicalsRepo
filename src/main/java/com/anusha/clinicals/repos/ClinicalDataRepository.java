package com.anusha.clinicals.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anusha.clinicals.model.ClinicalData;

public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Integer> {

}
