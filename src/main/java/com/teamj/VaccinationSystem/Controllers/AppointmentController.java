package com.teamj.VaccinationSystem.Controllers;

import com.teamj.VaccinationSystem.Models.Appointment;
import com.teamj.VaccinationSystem.Services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class AppointmentController {

    private final AppointmentService service;

    @Autowired
    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @PostMapping("/api/v1/register-appointment")
    public Appointment bookAppointment(@RequestBody Appointment appointment) {
        return service.bookAppointment(appointment);
    }

    @DeleteMapping("/api/v1/cancel-appointment")
    public boolean cancelAppointment(@RequestParam long appointmentID) {
       return service.cancelAppointment(appointmentID);
    }

    @GetMapping("/api/v1/fetch-past-appointments")
    public List<Appointment> fetchPastAppointment() {
        LocalDateTime currentTime = LocalDateTime.now();
        return this.service.fetchAppointmentBefore(currentTime);
    }

    @GetMapping("/api/v1/fetch-patient-appointment")
    public List<Appointment> fetchAppointmentByPatient(@RequestParam Long patientID) {
        return this.service.fetchAppointmentByPatientID(patientID);
    }

    @PostMapping("/api/v1/reschedule-appointment")
    public Appointment rescheduledAppointment(@RequestBody Long patientID,
                                              @RequestBody LocalDateTime dateTime) {
        return this.service.rescheduleAppointment(patientID, dateTime);
    }

}
