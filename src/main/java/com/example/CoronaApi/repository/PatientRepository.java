package com.example.CoronaApi.repository;

import com.example.CoronaApi.model.GeneralResponse;
import com.example.CoronaApi.model.Patient;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class PatientRepository {

    private final static Map<String, Patient> patientMap = new HashMap<>();
    private int patientId = 0;
    public Collection<Patient> getPatientList() {
        return patientMap.values();
    }

    public Patient getPatientById(String patientId) {
        return patientMap.get(patientId);
    }

    public GeneralResponse deletePatientById(String patientId) {
        patientMap.remove(patientId);
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setId(patientId);
        generalResponse.setResult("Success");
        return generalResponse;    }

    public GeneralResponse addPatient(Patient patient) {
        GeneralResponse generalResponse = new GeneralResponse();
        try {
            patientId++;
            patient.setPatientId("p"+patientId);
            patientMap.put("p"+patientId, patient);
            generalResponse.setId("p"+patientId);
            generalResponse.setResult("Success");
        } catch (Exception e) {
            System.out.println("Failure " + e.getMessage());
            generalResponse.setId(String.valueOf(-1));
            generalResponse.setResult("Failure");
        }
        return generalResponse;
    }

    public GeneralResponse updatePatient(Patient patient) {
        GeneralResponse generalResponse = new GeneralResponse();
        try {
            patientMap.replace(patient.getPatientId(), patient);
            generalResponse.setId(patient.getPatientId());
            generalResponse.setResult("Success");
        } catch (Exception e) {
            System.out.println("Failure " + e.getMessage());
            generalResponse.setId(String.valueOf(-1));
            generalResponse.setResult("Failure");
        }
        return generalResponse;
    }
}
