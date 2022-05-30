package com.teamj.VaccinationSystem.Interfaces;

import com.teamj.VaccinationSystem.Models.Patient;

import java.util.List;

public interface PatientServiceInterface {
    Patient registerPatient(Patient patient);
    Patient fetchPatientById(String id);
    List<Patient> fetchAllPatient();
    boolean deletePatient();
}
