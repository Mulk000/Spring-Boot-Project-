package com.codeline.ccsb.Services;

import com.codeline.ccsb.Entity.Course;
import com.codeline.ccsb.Entity.Department;
import com.codeline.ccsb.Entity.Instructor;
import com.codeline.ccsb.Entity.Mark;
import com.codeline.ccsb.helper.Constants;
import com.codeline.ccsb.helper.HelperUtils;
import com.codeline.ccsb.repositories.CourseRepository;
import com.codeline.ccsb.repositories.DepartmentRepository;
import com.codeline.ccsb.repositories.InstructorRepository;
import com.codeline.ccsb.repositories.MarkRepository;
import com.codeline.ccsb.requestObject.CourseCreateRequest;
import com.codeline.ccsb.responseObjects.CourseCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CourseServices {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    MarkRepository markRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public CourseCreateResponse saveCourse(CourseCreateRequest request)throws Exception {
        Course course = CourseCreateRequest.converToCourse(request);
        course.setCreateddate(new Date());
        course.setIsActive(Boolean.TRUE);

        Instructor instructor = instructorRepository.getInstructorById(request.getInstructorId());
        if (HelperUtils.isNotNull(instructor)) {
            course.setInstructor(instructor);
        }else{
            throw new Exception(Constants.COURSE_CREATE_REQUEST_INSTRUCTOR_ID_NOT_VALID);
        }

        List<Mark> mark =markRepository.getMarkByMarkId(request.getMarkId());
        if(HelperUtils.isNotNull(mark) && HelperUtils.isListNotEmpty(mark)){
            course.setMarks(mark);
        }else{
            throw new Exception(Constants.COURSE_CREATE_REQUEST_MARK_ID_NOT_VALID);
        }

        return CourseCreateResponse.convertToCourseResponse(courseRepository.save(course));



    }

    public Course updateCourse(Course course) throws Exception {
        Course existingCourse = courseRepository.findById(course.getId()).get();
        if (existingCourse != null && existingCourse.getIsActive()) {
            course.setUpdateddate(new Date());
            return courseRepository.save(course);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public void deleteCourse(Integer id) throws Exception {
        Course existingCourse = courseRepository.findById(id).get();
        if (existingCourse != null && existingCourse.getIsActive()) {
            existingCourse.setUpdateddate(new Date());
            existingCourse.setIsActive(Boolean.FALSE);
            courseRepository.save(existingCourse);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public Course getCourseById(Integer id) throws Exception {
        Course existingCourse = courseRepository.findById(id).get();
        if (existingCourse != null && existingCourse.getIsActive()) {
            return existingCourse;
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

}
