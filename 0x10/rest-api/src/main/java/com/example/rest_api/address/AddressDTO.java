package com.example.rest_api.address;

import jakarta.validation.constraints.NotBlank;

public record AddressDTO(
        @NotBlank String country,
        @NotBlank String city,
        @NotBlank String complement) {
}
