package com.teamj.VaccinationSystem.Models;

import javax.persistence.Entity;
import java.time.LocalDateTime;


public class Rescheduled {
    private long appointmentID;
    private LocalDateTime newDateTime;

    public Rescheduled(long appointmentID, LocalDateTime newDateTime) {
        this.appointmentID = appointmentID;
        this.newDateTime = newDateTime;
    }

    public long getAppointmentID() {
        return appointmentID;
    }

    public LocalDateTime getNewDateTime() {
        return newDateTime;
    }

    @Override
    public String toString() {
        return "Rescheduled{" +
                "appointmentID=" + appointmentID +
                ", newDateTime=" + newDateTime +
                '}';
    }
}
