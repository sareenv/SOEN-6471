package com.teamj.VaccinationSystem.Interfaces;

import com.teamj.VaccinationSystem.Models.Appointment;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentServiceInterface {
    Appointment bookAppointment(Appointment appointmentDetails);
    boolean cancelAppointment(Long appointmentID);
    Appointment rescheduleAppointment(Long appointmentID, LocalDateTime newDateTime);
    List<Appointment> fetchAppointmentByPatientID(long patientID);
    List<Appointment> fetchAppointmentBefore(LocalDateTime dateTime);
}
