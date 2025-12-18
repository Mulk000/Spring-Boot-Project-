package com.codeline.ccsb.responseObjects;

import com.codeline.ccsb.Entity.PhoneNumber;
import com.codeline.ccsb.Entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCreateResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private Date dateOfBirth;
    private List<Integer> phoneNumbersId;
    private Integer addressId;

    public static StudentCreateResponse ConvertToStudentResponse(Student entity){
    return StudentCreateResponse.builder()
            .id(entity.getId())
            .firstName(entity.getFirstName())
            .lastName(entity.getLastName())
            .email(entity.getEmail())
            .gender(entity.getGender())
            .dateOfBirth(entity.getDateOfBirth())
            .addressId(entity.getAddress().getId())
            .phoneNumbersId(entity.getPhoneNumbers().stream().map(PhoneNumber->PhoneNumber.getId()).collect(Collectors.toList()))
                    .build();

    }

}
