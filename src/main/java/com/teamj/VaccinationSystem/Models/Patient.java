package com.teamj.VaccinationSystem.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long patientID;
    private String firstName;
    private String lastName;
    private String address;
    private LocalDateTime dob;
}
