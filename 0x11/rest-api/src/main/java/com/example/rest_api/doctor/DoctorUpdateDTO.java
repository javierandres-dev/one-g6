package com.example.rest_api.doctor;

import com.example.rest_api.address.AddressDTO;
import jakarta.validation.constraints.NotNull;

public record DoctorUpdateDTO(
        @NotNull Long id,
        String name,
        String phone,
        String identification,
        AddressDTO address
) {
}
