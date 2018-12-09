package com.clinicmanagementsystem.cms.model;

import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;

public class Appointment extends Auditable{
    Date date;

    @DBRef
    Doctor doctor;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @DBRef
    Patient patient;
}
