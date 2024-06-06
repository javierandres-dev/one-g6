package com.example.rest_api.address;

public record AddressDTO(String country, String city, String streetName, String streetNumber, String placeNumber,
                         String complement) {
}
