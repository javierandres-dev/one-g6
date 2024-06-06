package com.example.rest_api.doctor;

import com.example.rest_api.address.AddressDTO;

public record DoctorDTO(
        String name, String email, String identification, Specialization specialization, AddressDTO address
) {
}
