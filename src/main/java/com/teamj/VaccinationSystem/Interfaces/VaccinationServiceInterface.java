package com.teamj.VaccinationSystem.Interfaces;

import com.teamj.VaccinationSystem.Models.Vaccination;

import java.util.List;

public interface VaccinationServiceInterface {
    Vaccination recordVaccination(Vaccination vaccination);
    List<Vaccination> fetchVaccinationByPatientId(long patientID);
    boolean deleteVaccinationRecords(long vaccinationID);
    List<Vaccination> findByAssociateNumber(long associateNumber);
    List<Vaccination> findByFacilityName(String facilityName);
}
