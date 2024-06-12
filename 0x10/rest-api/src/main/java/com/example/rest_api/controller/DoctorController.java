package com.example.rest_api.controller;

import com.example.rest_api.doctor.DoctorDTO;
import com.example.rest_api.doctor.DoctorEntity;
import com.example.rest_api.doctor.DoctorRepository;
import com.example.rest_api.doctor.DoctorsDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<DoctorEntity> doctors(){
        return doctorRepository.findAll();
    }

    /*@GetMapping
    public List<DoctorsDTO> doctors(){
        return doctorRepository.findAll().stream().map(DoctorsDTO::new).toList();
    }*/
}
