package com.codeline.ccsb.requestObject;

import com.codeline.ccsb.Entity.Mark;
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
public class MarkCreateRequest {
    private String studentName;
    private String grade;
    private Integer courseId;

    public static Mark ConvertToMark(MarkCreateRequest request) {
        Mark mark = new Mark();
        mark.setStudentName(request.getStudentName());
        mark.setGrade(request.getGrade());
        return mark;
    }

    public static void validCreatesMarkRequestObject(MarkCreateRequest request) throws Exception {
        if (HelperUtils.isNull(request.studentName) || request.getStudentName().isBlank() || request.getStudentName().isEmpty()) {
            throw new Exception(Constants.MARK_CREATE_REQUEST_STUDENT_NAME_NOT_VALID);
        }else if  (HelperUtils.isNull(request.grade) || request.getGrade().isBlank()) {
            throw new Exception(Constants.MARK_CREATE_REQUEST_GRADE_NOT_VALID);
        } else if (HelperUtils.isNull(request.getCourseId()) || request.getCourseId() <= 0) {
            throw new Exception(Constants.MARK_CREATE_REQUEST_COURSE_ID_NOT_VALID);

        }
    }
}
