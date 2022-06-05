package com.teamj.VaccinationSystem.Interfaces;

import com.teamj.VaccinationSystem.Models.Disease;
import com.teamj.VaccinationSystem.Models.Patient;

import java.util.List;

public interface PatientServiceInterface {
    Patient registerPatient(Patient patient) throws Exception;
    Patient fetchPatientById(String id) throws Exception;
    List<Patient> fetchAllPatient();
    boolean deletePatient(String email);
    List<Disease> fetchPatientDisease(String email);
}
