package com.codeline.ccsb.requestObject;

import com.codeline.ccsb.Entity.PhoneNumber;
import com.codeline.ccsb.Entity.Student;
import com.codeline.ccsb.helper.Constants;
import com.codeline.ccsb.helper.HelperUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCreateRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private Date dateOfBirth;
    private List<Integer> phoneNumbersId;
    private Integer addressId;

    public static Student convertToStudent(StudentCreateRequest request){
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setGender(request.getGender());
        student.setDateOfBirth(request.getDateOfBirth());
        return student;
    }

    public static void validCreateStudentRequestObject(StudentCreateRequest request) throws Exception {
        if (HelperUtils.isNull(request.getFirstName()) || request.getFirstName().isEmpty() || request.getFirstName().isBlank()) {
            throw new Exception(Constants.STUDENT_CREATE_REQUEST_FIRST_NAME_NOT_VALID);
        } else if (HelperUtils.isNull(request.getLastName()) || request.getLastName().isEmpty() || request.getLastName().isBlank()) {
            throw new Exception(Constants.STUDENT_CREATE_REQUEST_LAST_NAME_NOT_VALID);
        } else if (HelperUtils.isNull(request.getEmail()) || request.getEmail().isEmpty() || request.getEmail().isBlank()) {
            throw new Exception(Constants.STUDENT_CREATE_REQUEST_EMAIL_NOT_VALID);
        } else if (HelperUtils.isNull(request.getGender()) || request.getGender().isEmpty() || request.getGender().isBlank()) {
            throw new Exception(Constants.STUDENT_CREATE_REQUEST_GENDER_NOT_VALID);
        } else if (HelperUtils.isNull(request.dateOfBirth) || request.dateOfBirth.after(new Date())){
            throw new Exception(Constants.STUDENT_CREATE_REQUEST_DATE_OF_BIRTH_NOT_VALID);
        }else if (HelperUtils.isNull(request.getPhoneNumbersId()) || HelperUtils.isListEmpty(request.getPhoneNumbersId())) {
            throw new Exception(Constants.STUDENT_CREATE_REQUEST_PHONE_NUMBER_ID_NOT_VALID);
        }else if (HelperUtils.isNull(request.getAddressId()) || request.getAddressId()<=0) {

        }
    }

}
