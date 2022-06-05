package com.teamj.VaccinationSystem.Models;

import javax.persistence.*;
import javax.swing.text.Document;
import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long patientID;
    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private int age;
    @Column(unique = true)
    private String email;
    private String password;
    private String ethnicity;
    private boolean consent;
    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "Infections")
    private List<Disease> infections;
    @OneToOne(cascade = CascadeType.ALL)
    private Identification identification;

    public Identification getIdentification() {
        return identification;
    }

    public void setIdentification(Identification identification) {
        this.identification = identification;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public boolean isConsent() {
        return consent;
    }

    public void setConsent(boolean consent) {
        this.consent = consent;
    }

    public long getPatientID() {
        return patientID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Disease> getInfections() {
        return infections;
    }

    public void setInfections(List<Disease> infections) {
        this.infections = infections;
    }

    public List<Disease> getDisease() {
        return infections;
    }

    public void setDisease(List<Disease> disease) {
        this.infections = disease;
    }

    public void setPatientID(long patientID) {
        this.patientID = patientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientID=" + patientID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", ethnicity='" + ethnicity + '\'' +
                ", consent=" + consent +
                ", infections=" + infections +
                ", identification=" + identification +
                '}';
    }
}
