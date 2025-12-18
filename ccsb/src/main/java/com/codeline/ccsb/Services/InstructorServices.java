package com.codeline.ccsb.Services;

import com.codeline.ccsb.Entity.Course;
import com.codeline.ccsb.Entity.Department;
import com.codeline.ccsb.Entity.Instructor;
import com.codeline.ccsb.helper.Constants;
import com.codeline.ccsb.helper.HelperUtils;
import com.codeline.ccsb.repositories.CourseRepository;
import com.codeline.ccsb.repositories.DepartmentRepository;
import com.codeline.ccsb.repositories.InstructorRepository;
import com.codeline.ccsb.requestObject.InstructorCreateRequest;
import com.codeline.ccsb.responseObjects.InstructorCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InstructorServices {

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    CourseRepository courseRepository;


    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public InstructorCreateResponse saveInstructor(InstructorCreateRequest request) throws Exception {
        Instructor instructor = InstructorCreateRequest.ConvertToInstructor(request);
        instructor.setCreatedDate(new Date());
        instructor.setIsActive(Boolean.TRUE);

        return InstructorCreateResponse.convertToInstructorResponse(instructorRepository.save(instructor));
    }

    public Instructor updateInstructor(Instructor instructor)throws Exception {
        Instructor existingInstructor = instructorRepository.findById(instructor.getId()).get();
        if (existingInstructor != null && existingInstructor.getIsActive()) {
            existingInstructor.setUpdatedDate(new Date());
            return instructorRepository.save(existingInstructor);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }
        public void deleteInstructor(Integer id)throws Exception {
        Instructor existingInstructor = instructorRepository.findById(id).get();
        if (existingInstructor != null&&existingInstructor.getIsActive()) {
            existingInstructor.setIsActive(Boolean.FALSE);
            existingInstructor.setUpdatedDate(new Date());
             instructorRepository.save(existingInstructor);
        }else {
            throw new Exception("BAD REQUEST");


        }
        }

        public Instructor getInstructorById(Integer id)throws Exception {
        Instructor existingInstructor = instructorRepository.findById(id).get();
        if (existingInstructor != null&& existingInstructor.getIsActive()) {
            return existingInstructor;
        }else{
            throw new Exception("BAD REQUEST");
        }


    }
}
