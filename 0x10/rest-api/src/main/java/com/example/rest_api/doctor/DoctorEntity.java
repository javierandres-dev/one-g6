package com.example.rest_api.doctor;

import com.example.rest_api.address.AddressEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "doctors")
@Entity(name = "doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String identification;
    @Enumerated(EnumType.STRING)
    private Specialization specialization;
    @Embedded
    private AddressEntity address;

    public DoctorEntity(DoctorDTO doctorDTO) {
        this.name = doctorDTO.name();
        this.email = doctorDTO.email();
        this.phone = doctorDTO.phone();
        this.identification = doctorDTO.identification();
        this.specialization = doctorDTO.specialization();
        this.address = new AddressEntity(doctorDTO.address());
    }
}
