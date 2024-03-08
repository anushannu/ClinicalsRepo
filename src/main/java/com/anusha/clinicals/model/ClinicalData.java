package com.anusha.clinicals.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clinicaldata") // since no underscore given in table name.
@JsonIgnoreProperties({ "patient" }) // we dont want Patient object to be fetched thru clinical data. either by
										// making it Transient or by informing Jackson provider to ignore that element
										// when the clinicaldata is serialized.
public class ClinicalData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String componentName;
	private String componentValue;
	private Timestamp measuredDateTime;
	@ManyToOne(fetch = FetchType.LAZY) // LAzy because we're not goin to load Patient data thru clinicaql data. Its the
										// other way around.
	@JoinColumn(name = "patient_id", nullable = false)
	@JsonIgnore
	private Patient patient;// if we want to fetch patient data with help of clinical data. This is optional

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getComponentValue() {
		return componentValue;
	}

	public void setComponentValue(String componentValue) {
		this.componentValue = componentValue;
	}

	public Timestamp getMeasuredDateTime() {
		return measuredDateTime;
	}

	public void setMeasuredDateTime(Timestamp measuredDateTime) {
		this.measuredDateTime = measuredDateTime;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
