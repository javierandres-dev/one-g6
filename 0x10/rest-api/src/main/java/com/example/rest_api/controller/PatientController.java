package com.example.rest_api.controller;

import com.example.rest_api.patient.PatientDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @PostMapping
    public void signUp(@RequestBody PatientDTO patientDTO) {
        System.out.println("patientDTO = " + patientDTO);
    }
}
