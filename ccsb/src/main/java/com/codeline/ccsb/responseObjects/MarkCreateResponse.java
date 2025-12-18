package com.codeline.ccsb.responseObjects;

import com.codeline.ccsb.Entity.Instructor;
import com.codeline.ccsb.Entity.Mark;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarkCreateResponse {
    private Integer id;
    private String studentName;
    private String grade;

    public static MarkCreateResponse convertToMarkResponse(Mark entity){
        return   MarkCreateResponse.builder()
                .id(entity.getId())
                .studentName(entity.getStudentName())
                .grade(entity.getGrade())
                .build();
    }

}
