package com.example.rest_api.controller;

import com.example.rest_api.doctor.DoctorEntity;
import com.example.rest_api.doctor.DoctorUpdateDTO;
import com.example.rest_api.patient.PatientDTO;
import com.example.rest_api.patient.PatientEntity;
import com.example.rest_api.patient.PatientRepository;
import com.example.rest_api.patient.PatientUpdateDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<PatientEntity> patients() {
        return patientRepository.findAll();
    }

    /*@GetMapping
    public Page<PatientsDTO> patients(@PageableDefault(page = 0, size = 10, sort = {"name"})Pageable pageable){
        return patientRepository.findAll(pageable).map(PatientsDTO::new);
    }*/

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid PatientUpdateDTO patientUpdateDTO) {
        PatientEntity patientEntity = patientRepository.getReferenceById(patientUpdateDTO.id());
        patientEntity.updateData(patientUpdateDTO);
    }

    // real delete
    /*@DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        //System.out.println("id = " + id);
        PatientEntity patientEntity = patientRepository.getReferenceById(id);
        patientRepository.delete(patientEntity);
    }*/

    // logical delete
    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        PatientEntity patientEntity = patientRepository.getReferenceById(id);
        patientEntity.inactive();
    }
}
