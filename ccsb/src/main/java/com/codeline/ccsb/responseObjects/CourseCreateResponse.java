package com.codeline.ccsb.responseObjects;

import com.codeline.ccsb.Entity.Course;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseCreateResponse {
    private Integer id;
    private String courseName;
    private Integer duration;
    private String category;
    private Integer instructorId;
    private List<Integer> markId;

    public static CourseCreateResponse convertToCourseResponse(Course entity){
        return   CourseCreateResponse.builder()
                 .id(entity.getId())
                .courseName(entity.getCourseName())
                .duration (entity.getDuration())
                .category(entity.getCategory())
                .instructorId(entity.getInstructor().getId())
                .markId(entity.getMarks().stream().map(Mark->Mark.getId()).collect(Collectors.toList()))
                .build();
    }

}
