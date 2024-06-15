package com.example.rest_api.patient;

import com.example.rest_api.address.AddressEntity;
import com.example.rest_api.doctor.DoctorDTO;
import com.example.rest_api.doctor.DoctorUpdateDTO;
import com.example.rest_api.doctor.Specialization;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "patients")
@Entity(name = "patient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String identification;
    private Boolean active;
    @Embedded
    private AddressEntity address;

    public PatientEntity(PatientDTO patientDTO) {
        this.name = patientDTO.name();
        this.email = patientDTO.email();
        this.phone = patientDTO.phone();
        this.identification = patientDTO.identification();
        this.active = true;
        this.address = new AddressEntity(patientDTO.address());
    }

    public void updateData(PatientUpdateDTO patientUpdateDTO) {
        if (patientUpdateDTO.name() != null) {
            this.name = patientUpdateDTO.name();
        }
        if (patientUpdateDTO.phone() != null) {
            this.phone = patientUpdateDTO.phone();
        }
        if (patientUpdateDTO.identification() != null) {
            this.identification = patientUpdateDTO.identification();
        }
        if (patientUpdateDTO.address() != null) {
            this.address = address.updateData(patientUpdateDTO.address());
        }
    }

    public void inactive() {
        this.active = false;
    }
}
