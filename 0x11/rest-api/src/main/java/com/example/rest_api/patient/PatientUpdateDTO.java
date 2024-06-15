package com.example.rest_api.patient;

import com.example.rest_api.address.AddressDTO;
import jakarta.validation.constraints.NotNull;

public record PatientUpdateDTO(
        @NotNull Long id,
        String name,
        String phone,
        String identification,
        AddressDTO address
) {
}
