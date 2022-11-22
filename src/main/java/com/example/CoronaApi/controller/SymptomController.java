package com.example.CoronaApi.controller;

import com.example.CoronaApi.model.CovidSymptoms;
import com.example.CoronaApi.model.GeneralResponse;
import com.example.CoronaApi.repository.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/symptoms")
public class SymptomController {
    @Autowired
    private SymptomRepository symptomRepository;

    @GetMapping("/")
    public Collection<CovidSymptoms> getAllPatientSymptom() {
        return symptomRepository.getAllPatientSymptom();
    }

    @GetMapping("/{patientId}")
    public CovidSymptoms getPatientSymptomById(@PathVariable("patientId") String patientId) {
        return symptomRepository.getPatientSymptomById(patientId);
    }

    @PostMapping("/addSymptoms")
    public GeneralResponse addPatientSymptom(@RequestBody CovidSymptoms symptoms) {
        return symptomRepository.addPatientSymptom(symptoms);
    }

    @DeleteMapping("delete/{patientId}")
    public GeneralResponse deletePatientSymptom(@PathVariable("patientId") String patientId){
        return symptomRepository.deletePatientSymptom(patientId);
    }

}
