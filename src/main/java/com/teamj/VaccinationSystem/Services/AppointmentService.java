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

    private final AppointmentRepository appointmentRepository;

    @Autowired
    AppointmentService(AppointmentRepository repository) {
        this.appointmentRepository = repository;
    }


    @Override
    public Appointment bookAppointment(Appointment appointmentDetails) {
        return this.appointmentRepository.save(appointmentDetails);
    }

    @Override
    public boolean cancelAppointment(Long appointmentID) {
        try {
            this.appointmentRepository.deleteById(appointmentID);
            return false;
        } catch (Exception exception) {
            return true;
        }

    }

    @Override
    public Appointment rescheduleAppointment(Long appointmentID, LocalDateTime newDateTime) {
        Appointment appointment =
                this.appointmentRepository.findById(appointmentID).get();
        appointment.setDateTime(newDateTime);
        this.appointmentRepository.deleteById(appointmentID);
        return this.appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> fetchAppointmentByPatientID(long patientID) {
        return this.appointmentRepository.findAllByPatPatientID(patientID);
    }

    @Override
    public List<Appointment> fetchAppointmentBefore(LocalDateTime dateTime) {
        LocalDateTime pastAppointments = LocalDateTime.now();
        List<Appointment> appointments =
                this.appointmentRepository.findAllByDateTimeBefore(pastAppointments);
        return appointments;
    }
}
