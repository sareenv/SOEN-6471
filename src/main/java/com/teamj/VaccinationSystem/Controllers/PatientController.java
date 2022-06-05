package com.teamj.VaccinationSystem.Controllers;
import com.teamj.VaccinationSystem.Models.Disease;
import com.teamj.VaccinationSystem.Models.Patient;
import com.teamj.VaccinationSystem.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    private final PatientService service;

    @Autowired
    PatientController(PatientService service) {
        this.service = service;
    }

    @GetMapping("/api/v1/get-patients")
    public List<Patient> getAllPatients() {
       return service.fetchAllPatient();
    }

    @GetMapping("/api/v1/get-patientByID")
    public Patient getPatientByID(@RequestParam String id) throws Exception {
        return service.fetchPatientById(id);
    }

    @DeleteMapping("/api/v1/delete-patient")
    public Boolean deletePatient(@RequestParam String email) {
        return service.deletePatient(email);
    }

    @PostMapping("/api/v1/register-patient")
    Patient registerPatient(@RequestBody Patient patient) throws Exception {
        try {
            return service.registerPatient(patient);
        } catch (Exception exception) {
            String message = exception.getMessage();
            System.out.println("message is " + message);
        }
        throw  new Exception("Record cannot be saved");
    }

    @GetMapping("/api/v1/get-patient-disease")
    List<Disease> getPatientDisease(@RequestParam String email) {
        List<Disease> diseases = service.fetchPatientDisease(email);
        System.out.println(diseases);
        return diseases;
    }
}
