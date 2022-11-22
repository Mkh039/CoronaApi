package com.example.CoronaApi.model;

public class Patient {

    public Patient(String patientId, String created, String patientName, String modified, String symptoms, String description) {
        this.patientId = patientId;
        this.created = created;
        this.patientName = patientName;
        this.modified = modified;
        this.symptoms = symptoms;
        this.description = description;
    }

    private String patientId;
    private String created;
    private String patientName;
    private String modified;
    private String symptoms;
    private String description;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
