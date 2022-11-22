package com.example.CoronaApi.controller;

import com.example.CoronaApi.model.GeneralResponse;
import com.example.CoronaApi.model.Patient;
import com.example.CoronaApi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/patients")
public class PatientsController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/")
    public Collection<Patient> getPatientList(){
        return patientRepository.getPatientList();
    }

    @GetMapping("/{patientId}")
    public Patient getPatientById(@PathVariable("patientId") String patientId){
        return patientRepository.getPatientById(patientId);
    }

    @PostMapping("/addPatient")
    public GeneralResponse addPatient(@RequestBody Patient patient){
        return patientRepository.addPatient(patient);
    }

    @PutMapping("/updatePatient")
    public GeneralResponse updatePatient(@RequestBody Patient patient){
        return patientRepository.updatePatient(patient);
    }

    @DeleteMapping("delete/{patientId}")
    public GeneralResponse deletePatientById(@PathVariable("patientId") String patientId){
        return patientRepository.deletePatientById(patientId);
    }


}

