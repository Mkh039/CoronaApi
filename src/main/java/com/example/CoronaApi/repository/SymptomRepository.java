package com.example.CoronaApi.repository;

import com.example.CoronaApi.model.response.GeneralResponse;
import com.example.CoronaApi.model.request.CovidSymptomsRequest;
import com.example.CoronaApi.model.response.CovidSymptoms;
import com.example.CoronaApi.utils.ObjectConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/**
 * Symptom Repository used to retrieve,update and delete data
 */
@Component
public class SymptomRepository {

    private final static Map<String, CovidSymptoms> covidSymptomsMap = new HashMap<>();

    @Autowired
    private ObjectConverter objectConverter;
    private int covidSymptomsId = 0;

    public CovidSymptoms getSymptomPatientById(String patientId) {
        return covidSymptomsMap.get(patientId);
    }

    public Collection<CovidSymptoms> getAllPatientSymptom() {
        return covidSymptomsMap.values();
    }

    public GeneralResponse addPatientSymptom(CovidSymptomsRequest patientSymptoms) {
        GeneralResponse generalResponse = new GeneralResponse();
        try {
            covidSymptomsId++;
            patientSymptoms.setSymptomId("s" + covidSymptomsId);
            covidSymptomsMap.put(patientSymptoms.getPatientId(), objectConverter.from(objectConverter.toJson(patientSymptoms), CovidSymptoms.class));
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
        return generalResponse;
    }
}
