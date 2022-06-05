package com.teamj.VaccinationSystem.Repositories;

import com.teamj.VaccinationSystem.Models.Appointment;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    public List<Appointment> findAllByDateTimeBefore(LocalDateTime dateTime);
    public List<Appointment> findAllByFacilityName(String facilityName);
    public List<Appointment> findAllByPatPatientID(Long patientID);
}
