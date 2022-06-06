package com.teamj.VaccinationSystem.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vaccination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Vaccine> vaccine;
    private long patientID;
    private long appointmentID;
    private long associateIdentificationNumber;
    private String associateName;
    private String facilityName;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<Vaccine> getVaccine() {
        return vaccine;
    }
    public void setVaccine(List<Vaccine> vaccine) {
        this.vaccine = vaccine;
    }
    public long getPatientID() { return patientID;}
    public void setPatientID(long patientID) { this.patientID = patientID;}

    public long getAppointmentID() {
        return appointmentID;
    }
    public void setAppointmentID(long appointmentID) {
        this.appointmentID = appointmentID;
    }
    public long getAssociateIdentificationNumber() {
        return associateIdentificationNumber;
    }
    public void setAssociateIdentificationNumber(long associateIdentificationNumber) {
        this.associateIdentificationNumber = associateIdentificationNumber;
    }
    public String getAssociateName() {
        return associateName;
    }
    public void setAssociateName(String associateName) {
        this.associateName = associateName;
    }
    public String getFacilityName() {
        return facilityName;
    }
    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }
}
