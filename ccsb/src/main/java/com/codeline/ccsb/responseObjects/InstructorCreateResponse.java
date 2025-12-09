package com.codeline.ccsb.responseObjects;

import com.codeline.ccsb.Entity.Department;
import com.codeline.ccsb.Entity.Instructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class InstructorCreateResponse {
    private Integer id;
    private String instructorName;
    private Integer courseId;
    private Integer departmentId;

    public static InstructorCreateResponse convertToInstructorResponse(Instructor entity){
        return   InstructorCreateResponse.builder()
                .id(entity.getId())
                .instructorName(entity.getInstructorName())
                .departmentId(entity.getDepartment().getId())
                .courseId(entity.getCourse().getId())
                .build();
}
}
