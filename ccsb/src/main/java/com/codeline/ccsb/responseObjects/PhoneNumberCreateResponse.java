package com.codeline.ccsb.responseObjects;

import com.codeline.ccsb.Entity.Course;
import com.codeline.ccsb.Entity.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNumberCreateResponse {
    private Integer id;
    private Integer number;
    private String countryCode;
    private Boolean isLandLine;


    public static PhoneNumberCreateResponse convertToPhoneNumberResponse(PhoneNumber entity){
        return   PhoneNumberCreateResponse.builder()
                .id(entity.getId())
                .number(entity.getNumber())
                .countryCode (entity.getCountryCode())
                .isLandLine(entity.getIsLandLine())
                .build();
    }


}
