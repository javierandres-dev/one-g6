package com.example.rest_api.patient;

public record PatientsDTO(
        Long id,
        String name,
        String email,
        String identification) {
    /*public PatientsDTO(PatientEntity patientEntity){
        this(patientEntity.)
    }*/
}
