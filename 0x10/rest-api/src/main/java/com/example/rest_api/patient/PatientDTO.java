package com.example.rest_api.patient;

import com.example.rest_api.address.AddressDTO;

public record PatientDTO(String name, String email, String phone, String identification, AddressDTO address) {
}
