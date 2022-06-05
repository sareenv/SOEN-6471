package com.teamj.VaccinationSystem.Repositories;

import com.teamj.VaccinationSystem.Models.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {
    public Patient findByEmail(String email);
}
