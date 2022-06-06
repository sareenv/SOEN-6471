package com.teamj.VaccinationSystem.Services;

import com.teamj.VaccinationSystem.Interfaces.VaccinationServiceInterface;
import com.teamj.VaccinationSystem.Models.Vaccination;
import com.teamj.VaccinationSystem.Repositories.VaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VaccinationService implements VaccinationServiceInterface {

    private final VaccinationRepository repository;

    @Autowired
    public VaccinationService(VaccinationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vaccination recordVaccination(Vaccination vaccination) {
        return this.repository.save(vaccination);
    }

    @Override
    public List<Vaccination> fetchVaccinationByPatientId(long patientID) {
        List<Vaccination> result = new ArrayList<>();
        Iterable<Vaccination> vaccinations = this.repository.
                findAllByPatientID(patientID);
        for(Vaccination vaccination: vaccinations) {
            result.add(vaccination);
        }
        return result;
    }

    @Override
    public boolean deleteVaccinationRecords(long vaccinationID) {
        try {
            repository.deleteById(vaccinationID);
            return true;
        } catch (Exception exception) { return false; }
    }

    @Override
    public List<Vaccination> findByAssociateNumber(long associateNumber) {
        List<Vaccination> result = new ArrayList<>();
        Iterable<Vaccination> vaccinations =
                this.repository.
                        findAllByAssociateIdentificationNumber(associateNumber);
        for(Vaccination vaccination: vaccinations) {
            result.add(vaccination);
        }
        return result;
    }

    @Override
    public List<Vaccination> findByFacilityName(String facilityName) {
        List<Vaccination> result = new ArrayList<>();
        Iterable<Vaccination> vaccinations = this.repository.findAllByFacilityName(facilityName);
        System.out.println(vaccinations);
        for(Vaccination vaccination: vaccinations) {
            result.add(vaccination);
        }
        return result;
    }
}
