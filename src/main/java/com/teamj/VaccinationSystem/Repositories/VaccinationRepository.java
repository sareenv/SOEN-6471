package com.teamj.VaccinationSystem.Repositories;

import com.teamj.VaccinationSystem.Models.Vaccination;
import org.springframework.data.repository.CrudRepository;

public interface VaccinationRepository extends CrudRepository<Vaccination, Long> {
    public Iterable<Vaccination> findAllByPatientID(long patientID);
    public Iterable<Vaccination> findAllByAssociateIdentificationNumber(long associateNumber);

    public Iterable<Vaccination> findAllByFacilityName(String facilityName);
}
