package com.example.rest_api.controller;

import com.example.rest_api.doctor.DoctorDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @PostMapping
    public void signUp(@RequestBody DoctorDTO doctorDTO) {
        System.out.println("doctorDTO = " + doctorDTO);
    }
}
