package com.example.rest_api.controller;

import com.example.rest_api.patient.PatientDTO;
import com.example.rest_api.patient.PatientEntity;
import com.example.rest_api.patient.PatientRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    @Transactional
    public void signUp(@RequestBody @Valid PatientDTO patientDTO) {
        //System.out.println("patientDTO = " + patientDTO);
        patientRepository.save(new PatientEntity(patientDTO));
    }
}
