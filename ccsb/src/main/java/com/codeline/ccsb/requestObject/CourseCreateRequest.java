package com.codeline.ccsb.requestObject;

import com.codeline.ccsb.Entity.Course;
import com.codeline.ccsb.helper.Constants;
import com.codeline.ccsb.helper.HelperUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseCreateRequest {
   private String courseName;
   private Integer duration;
   private String category;
    private Integer instructorId;
    private List<Integer> markId;
    private Integer DepartmentId;

    public static Course ConverToCourse(CourseCreateRequest request){
        Course course = new Course();
        course.setCourseName(request.getCourseName());
        course.setDuration(request.getDuration());
        course.setCategory(request.getCategory());
        return course;
    }

    public static void validCreatesCourseRequestObject(CourseCreateRequest request)throws Exception{
        if (HelperUtils.isNull(request.getCourseName())==null || request.getCourseName().isBlank() || request.getCourseName().isEmpty()) {
            throw new Exception(Constants.COURSE_CREATE_REQUEST_COURSE_NAME_NOT_VALID);
        }else if (HelperUtils.isNull(request.getCategory())|| request.getCategory().isBlank() || request.getCategory().isEmpty()) {
            throw new Exception(Constants.COURSE_CREATE_REQUEST_CATEGORY_NOT_VALID);
        }else if (HelperUtils.isNull(request.getDuration()) || request.getDuration()<=Constants.LOWER_DURATION_RANGE ||
                request.getDuration()< Constants.UPPER_DURATION_RANGE ) {
            throw new Exception(Constants.COURSE_CREATE_REQUEST_DURATION_NOT_VALID);

        } else if (HelperUtils.isNull(request.getInstructorId()) || request.getInstructorId()<=0 ) {
            throw new Exception(Constants.COURSE_CREATE_REQUEST_INSTRUCTOR_ID_NOT_VALID);
        }else if  (HelperUtils.isNull(request.getMarkId()) ||HelperUtils.isListEmpty(request.getMarkId()) ) {
                throw new Exception(Constants.COURSE_CREATE_REQUEST_MARK_ID_NOT_VALID);
    }else if (HelperUtils.isNull(request.getDepartmentId()) || request.getDepartmentId()<=0 ) {
            throw new Exception(Constants.COURSE_CREATE_REQUEST_DEPARTMENT_ID_NOT_VALID);
        }



    }
}
