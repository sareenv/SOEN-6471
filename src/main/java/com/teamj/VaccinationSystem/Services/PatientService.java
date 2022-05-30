package com.teamj.VaccinationSystem.Services;

import com.teamj.VaccinationSystem.Interfaces.PatientServiceInterface;
import com.teamj.VaccinationSystem.Models.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements PatientServiceInterface {
    
    @Override
    public Patient registerPatient(Patient patient) {
        return null;
    }

    @Override
    public Patient fetchPatientById(String id) {
        return null;
    }

    @Override
    public List<Patient> fetchAllPatient() {
        return null;
    }

    @Override
    public boolean deletePatient() {
        return false;
    }
}
