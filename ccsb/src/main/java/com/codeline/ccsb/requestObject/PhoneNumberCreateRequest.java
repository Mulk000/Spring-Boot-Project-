package com.codeline.ccsb.requestObject;

import com.codeline.ccsb.Entity.Course;
import com.codeline.ccsb.Entity.PhoneNumber;
import com.codeline.ccsb.helper.Constants;
import com.codeline.ccsb.helper.HelperUtils;
import com.codeline.ccsb.responseObjects.PhoneNumberCreateResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNumberCreateRequest {
    private Integer number;
    private String countryCode;
    private Boolean isLandLine;


    public static PhoneNumber converToPhoneNumber(PhoneNumberCreateRequest request){
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setNumber(request.getNumber());
        phoneNumber.setCountryCode(request.getCountryCode());
        phoneNumber.setIsLandLine(request.getIsLandLine());
        return phoneNumber;
    }

    public static void validCreatesPhoneNumberRequestObject(PhoneNumberCreateRequest request)throws Exception {
        if (HelperUtils.isNull(request.getNumber())) {
            throw new Exception(Constants.PHON_NUMBER_CREATE_REQUEST_NUMBER_NOT_VALID);
        } else if (HelperUtils.isNull(request.getCountryCode()) || request.getCountryCode().isBlank() || request.getCountryCode().isEmpty()) {
            throw new Exception(Constants.PHON_NUMBER_CREATE_REQUEST_COUNTRY_CODE_NOT_VALID);
        } else if (HelperUtils.isNull(request.getIsLandLine())){
            throw new Exception(Constants.PHON_NUMBER_CREATE_REQUEST_IS_LAND_LINE_NOT_VALID);

        }
    }

}
