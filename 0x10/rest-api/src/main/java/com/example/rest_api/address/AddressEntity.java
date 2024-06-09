package com.example.rest_api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {
    private String country;
    private String city;
    private String complement;

    public AddressEntity(AddressDTO address) {
        this.country = address.country();
        this.city = address.city();
        this.complement = address.complement();
    }
}
