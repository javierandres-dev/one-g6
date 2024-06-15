package com.example.rest_api.doctor;

import com.example.rest_api.address.AddressDTO;

public record DoctorResponseDTO(
        Long id,
        String name,
        String phone,
        String identification,
        AddressDTO address) {
}
