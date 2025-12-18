package com.codeline.ccsb.responseObjects;

import com.codeline.ccsb.Entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressCreateResponse {
    Integer id;
    Integer houseNumber;
    String street;
    String city;
    String stateOrProvince;
    String country;
    Integer postalCode;


    public static AddressCreateResponse convertToAddressResponse(Address entity){
        return AddressCreateResponse.builder()
                .id(entity.getId())
                .houseNumber(entity.getHouseNumber())
                .street(entity.getStreet())
                .city(entity.getCity())
                .stateOrProvince(entity.getStateOrProvince())
                .country(entity.getCountry())
                .postalCode(entity.getPostalCode())
                .build();
    }
}
