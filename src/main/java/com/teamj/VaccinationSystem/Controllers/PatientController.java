package com.teamj.VaccinationSystem.Controllers;
import com.teamj.VaccinationSystem.Models.Patient;
import com.teamj.VaccinationSystem.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    private final PatientService service;

    @Autowired
    PatientController(PatientService service) {
        this.service = service;
    }

}
