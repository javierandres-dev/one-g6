package com.example.rest_api.controller;

import com.example.rest_api.doctor.DoctorDTO;
import com.example.rest_api.doctor.DoctorEntity;
import com.example.rest_api.doctor.DoctorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    public void signUp(@RequestBody @Valid DoctorDTO doctorDTO) {
        //System.out.println("doctorDTO = " + doctorDTO);
        doctorRepository.save(new DoctorEntity(doctorDTO));
    }
}
