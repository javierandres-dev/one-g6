package com.example.rest_api.doctor;

public record DoctorsDTO(
        String name,
        String email,
        String identification,
        String specialization) {

    /*public DoctorsDTO(DoctorEntity doctorEntity) {
        this(doctorEntity);
        //this(doctorEntity.name(), doctorEntity.specialization().toString(), doctorEntity.identification(), doctorEntity.email());
    }*/
}
