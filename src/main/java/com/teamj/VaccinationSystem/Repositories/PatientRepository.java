package com.teamj.VaccinationSystem.Repositories;

import com.teamj.VaccinationSystem.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
