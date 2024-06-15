package com.example.rest_api.patient;

import com.example.rest_api.address.AddressDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PatientDTO(
        @NotBlank String name,
        @NotBlank String email,
        @NotBlank String phone,
        @NotBlank @Pattern(regexp = "\\d{5,10}") String identification,
        @NotNull @Valid AddressDTO address) {
}
