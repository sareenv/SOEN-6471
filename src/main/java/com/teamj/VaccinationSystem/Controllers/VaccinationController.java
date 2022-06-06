package com.teamj.VaccinationSystem.Controllers;

import com.teamj.VaccinationSystem.Models.Vaccination;
import com.teamj.VaccinationSystem.Services.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VaccinationController {
    private final VaccinationService service;

    @Autowired
    VaccinationController(VaccinationService service) {
        this.service = service;
    }

    @PostMapping("/api/v1/record-vaccination")
    Vaccination recordVaccination(@RequestBody Vaccination vaccination) {
        return this.service.recordVaccination(vaccination);
    }

    @GetMapping("/api/v1/Vaccinations-ByFacilityName")
    List<Vaccination> getVaccinationRecords(@RequestParam String facilityName) {
        return this.service.findByFacilityName(facilityName);
    }

    @GetMapping("/api/v1/Vaccinations-ByPatientID")
    List<Vaccination> getVaccinationRecordsByPatientID(@RequestParam long patientID) {
        return this.service.fetchVaccinationByPatientId(patientID);
    }

    @GetMapping("/api/v1/Vaccination-ByAssociateID")
    List<Vaccination> getVaccinationRecordsByAssociateID(@RequestParam long associateID) {
        return this.service.findByAssociateNumber(associateID);
    }
}
