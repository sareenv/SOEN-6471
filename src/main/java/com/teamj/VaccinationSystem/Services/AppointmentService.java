package com.teamj.VaccinationSystem.Services;

import com.teamj.VaccinationSystem.Interfaces.AppointmentServiceInterface;
import com.teamj.VaccinationSystem.Models.Appointment;
import com.teamj.VaccinationSystem.Repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService implements AppointmentServiceInterface {
    private final AppointmentRepository repository;
    @Autowired
    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }


    @Override
    public Appointment bookAppointment(Appointment appointmentDetails) {
        return this.repository.save(appointmentDetails);
    }

    @Override
    public boolean cancelAppointment(Long appointmentID) {
        try {
            this.repository.deleteById(appointmentID);
            return false;
        } catch (Exception exception) {
            return true;
        }

    }

    @Override
    public Appointment rescheduleAppointment(Long appointmentID, LocalDateTime newDateTime) {
        Appointment appointment =
                this.repository.findById(appointmentID).get();
        appointment.setDateTime(newDateTime);
        this.repository.deleteById(appointmentID);
        return this.repository.save(appointment);
    }

    @Override
    public List<Appointment> fetchAppointmentByPatientID(long patientID) {
        return this.repository.findAllByPatientID(patientID);
    }

    @Override
    public List<Appointment> fetchAppointmentBefore(LocalDateTime dateTime) {
        LocalDateTime pastAppointments = LocalDateTime.now();
        List<Appointment> appointments =
                this.repository.findAllByDateTimeBefore(pastAppointments);
        return appointments;
    }
}
