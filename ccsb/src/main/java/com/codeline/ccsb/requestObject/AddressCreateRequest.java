package com.codeline.ccsb.requestObject;

import com.codeline.ccsb.Entity.Address;
import com.codeline.ccsb.Entity.Student;
import com.codeline.ccsb.helper.Constants;
import com.codeline.ccsb.helper.HelperUtils;
import com.codeline.ccsb.responseObjects.AddressCreateResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressCreateRequest {
    Integer houseNumber;
    String street;
    String city;
    String stateOrProvince;
    String country;
    Integer postalCode;


    public static Address convertToAddress(AddressCreateRequest request) {
        Address address = new Address();
        address.setHouseNumber(request.getHouseNumber());
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setStateOrProvince(request.getStateOrProvince());
        address.setCountry(request.getCountry());
        address.setPostalCode(request.getPostalCode());
        return address;
    }

    public static void validCreatesAddressRequestObject(AddressCreateRequest request) throws Exception {
        if (HelperUtils.isNull(request.getHouseNumber()) || request.getHouseNumber() <= 0) {
            throw new Exception(Constants.ADDRESS_CREATE_REQUEST_HOUSE_NUMBER_NOT_VALID);
        } else if (HelperUtils.isNull(request.getStreet()) || request.getStreet().isEmpty() || request.getStreet().isBlank()) {
            throw new Exception(Constants.ADDRESS_CREATE_REQUEST_STREET_NOT_VALID);
        } else if (HelperUtils.isNull(request.getCity()) || request.getCity().isEmpty() || request.getCity().isBlank()) {
            throw new Exception(Constants.ADDRESS_CREATE_REQUEST_CITY_NOT_VALID);
        } else if (HelperUtils.isNull(request.getStateOrProvince()) || request.getStateOrProvince().isEmpty() || request.getStateOrProvince().isBlank()) {
            throw new Exception(Constants.ADDRESS_CREATE_REQUEST_STATE_NOT_VALID);
        } else if (HelperUtils.isNull(request.getCountry()) || request.getCountry().isEmpty() || request.getCountry().isBlank()) {
            throw new Exception(Constants.ADDRESS_CREATE_REQUEST_COUNTRY_NOT_VALID);
        } else if (HelperUtils.isNull(request.postalCode)) {
            throw new Exception(Constants.ADDRESS_CREATE_REQUEST_POSTAL_CODE_NOT_VALID);

        }
    }
}
