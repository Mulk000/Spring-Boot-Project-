package com.codeline.ccsb.requestObject;

import com.codeline.ccsb.Entity.Department;
import com.codeline.ccsb.Entity.Instructor;
import com.codeline.ccsb.helper.Constants;
import com.codeline.ccsb.helper.HelperUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstructorCreateRequest {
    private String instructorName;


    public static Instructor ConvertToInstructor(InstructorCreateRequest request)  {
        Instructor instructor = new Instructor();
        instructor.setInstructorName(request.getInstructorName());
        return instructor;
    }

    public static void validCreatesInstructorRequestObject(InstructorCreateRequest request) throws Exception {
        if(HelperUtils.isNull(request.instructorName)|| request.getInstructorName().isBlank() || request.getInstructorName().isEmpty()) {
            throw new Exception(Constants.INSTRUCTOR_CREATE_REQUEST_INSTRUCTOR_NAME_NOT_VALID);
        }
    }
}
