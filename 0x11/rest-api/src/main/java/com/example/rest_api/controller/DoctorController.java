package com.example.rest_api.controller;

import com.example.rest_api.doctor.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    public void signUp(@RequestBody @Valid DoctorDTO doctorDTO) {
        doctorRepository.save(new DoctorEntity(doctorDTO));
    }

    @GetMapping
    public List<DoctorEntity> doctors() {
        return doctorRepository.findByActiveTrue();
    }

    /*@GetMapping
    public List<DoctorsDTO> doctors(){
        return doctorRepository.findAll().stream().map(DoctorsDTO::new).toList();
    }*/

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DoctorUpdateDTO doctorUpdateDTO) {
        DoctorEntity doctorEntity = doctorRepository.getReferenceById(doctorUpdateDTO.id());
        doctorEntity.updateData(doctorUpdateDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        DoctorEntity doctorEntity = doctorRepository.getReferenceById(id);
        doctorEntity.inactive();
        return ResponseEntity.noContent().build();
    }

    /*@GetMapping("/{id}")
    public ResponseEntity doctor(@PathVariable Long id) {
        DoctorEntity doctorEntity = doctorRepository.getReferenceById(id);
        return ResponseEntity.ok(doctorEntity);
    }*/
}
