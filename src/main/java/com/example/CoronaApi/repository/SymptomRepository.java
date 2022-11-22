package com.example.CoronaApi.repository;

import com.example.CoronaApi.model.CovidSymptoms;
import com.example.CoronaApi.model.GeneralResponse;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class SymptomRepository {

    private final static Map<String, CovidSymptoms> covidSymptomsMap = new HashMap<>();
    private int covidSymptomsId = 0;

    public CovidSymptoms getPatientSymptomById(String patientId) {
        return covidSymptomsMap.get(patientId);
    }

    public Collection<CovidSymptoms> getAllPatientSymptom() {
        return covidSymptomsMap.values();
    }

    public GeneralResponse addPatientSymptom(CovidSymptoms patientSymptoms) {
        GeneralResponse generalResponse = new GeneralResponse();
        try {
            covidSymptomsId++;
            patientSymptoms.setId("s" + covidSymptomsId);
            covidSymptomsMap.put(patientSymptoms.getPatientId(), patientSymptoms);
            generalResponse.setId("s" + covidSymptomsId);
            generalResponse.setResult("Success");
        } catch (Exception e) {
            System.out.println("Failure " + e.getMessage());
            generalResponse.setId(String.valueOf(-1));
            generalResponse.setResult("Failure");
        }
        return generalResponse;
    }

    public GeneralResponse deletePatientSymptom(String patientId) {
        covidSymptomsMap.remove(patientId);
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setId(patientId);
        generalResponse.setResult("Success");
        return generalResponse;    }
}
