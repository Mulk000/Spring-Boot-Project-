package com.codeline.ccsb.Services;

import com.codeline.ccsb.Entity.Course;
import com.codeline.ccsb.Entity.Department;
import com.codeline.ccsb.Entity.Instructor;
import com.codeline.ccsb.helper.Constants;
import com.codeline.ccsb.helper.HelperUtils;
import com.codeline.ccsb.repositories.CourseRepository;
import com.codeline.ccsb.repositories.DepartmentRepository;
import com.codeline.ccsb.repositories.InstructorRepository;
import com.codeline.ccsb.requestObject.DepartmentCreateRequest;
import com.codeline.ccsb.responseObjects.DepartmentCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DepartmentServices {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    CourseRepository courseRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public DepartmentCreateResponse saveDepartment(DepartmentCreateRequest request) throws Exception {
        Department department = DepartmentCreateRequest.ConvertToDepartment(request);
        department.setCreateDate(new Date());
        department.setIsActive(Boolean.TRUE);

        List<Instructor> instructors =instructorRepository.getInstructorById(request.getInstructorsId());
        if(HelperUtils.isNotNull(instructors) && !HelperUtils.isListNotEmpty(instructors)) {
            department.setInstructors(instructors);
        }else{
            throw new Exception(Constants.DEPARTMENT_CREATE_REQUEST_INSTRUCTOR_ID_NOT_VALID);
        }
        List<Course> courses =courseRepository.getCourseById(request.getCourseId());
        if(HelperUtils.isNotNull(courses) && !HelperUtils.isListNotEmpty(courses)) {
            department.setCourses(courses);
        }else{
            throw new Exception(Constants.DEPARTMENT_CREATE_REQUEST_COURSE_ID_NOT_VALID);
        }

        return DepartmentCreateResponse.convertToDepartmentResponse(departmentRepository.save(department));


    }
    public Department getDepartmentById(Integer id) throws Exception {
        Department existingDepartment = departmentRepository.findById(id).get();
        if (existingDepartment != null && existingDepartment.getIsActive()) {
            return existingDepartment;
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public Department updateDepartment(Department department) throws Exception {
        Department existingDepartment = departmentRepository.findById(department.getId()).get();
        if (existingDepartment != null && existingDepartment.getIsActive()) {
            existingDepartment.setUpdateDate(new Date());
            return departmentRepository.save(existingDepartment);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public void deleteDepartment(Integer id) throws Exception {
        Department existingDepartment = departmentRepository.findById(id).get();
        if (existingDepartment != null && existingDepartment.getIsActive()) {
            existingDepartment.setIsActive(false);
            existingDepartment.setUpdateDate(new Date());
            departmentRepository.save(existingDepartment);
        } else {
            throw new Exception("BAD REQUEST");

        }
    }
}
