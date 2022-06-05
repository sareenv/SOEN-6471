package com.teamj.VaccinationSystem.Services;

import com.teamj.VaccinationSystem.Interfaces.PatientServiceInterface;
import com.teamj.VaccinationSystem.Models.Disease;
import com.teamj.VaccinationSystem.Models.Patient;
import com.teamj.VaccinationSystem.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService implements PatientServiceInterface {

    private final PatientRepository repository;

    @Autowired
    PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Patient registerPatient(Patient patient) throws Exception {
        try {
            Patient patientResult = repository.save(patient);
            return patientResult;
        } catch (Exception exception) {
            System.out.println("Exception occurred");
            throw new Exception("Exception saving the record");
        }
    }

    @Override
    public Patient fetchPatientById(String id) throws Exception {
        try {
            Long longId = Long.parseLong(id);
            return repository.findById(longId).get();
        }catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    @Override
    public List<Patient> fetchAllPatient() {
        List<Patient> patients = new ArrayList<>();
        for(Patient patient: repository.findAll()) {
            patient.setPassword("");
            patients.add(patient);
        }
        return patients;
    }

    @Override
    public boolean deletePatient(String email) {
        try {
            Patient patient = repository.findByEmail(email);
            repository.delete(patient);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public List<Disease> fetchPatientDisease(String email) {
        Patient patient = repository.findByEmail(email);
        if (patient != null) {
            List<Disease> disease = patient.getDisease();
            return disease;
        } else {
            return null;
        }
    }
}
