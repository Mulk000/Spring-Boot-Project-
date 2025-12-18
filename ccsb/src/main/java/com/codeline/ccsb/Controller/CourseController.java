package com.codeline.ccsb.Controller;

import com.codeline.ccsb.Entity.Course;
import com.codeline.ccsb.Services.CourseServices;
import com.codeline.ccsb.requestObject.CourseCreateRequest;
import com.codeline.ccsb.responseObjects.CourseCreateResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseServices courseServices;



    @PostMapping("create")
    public CourseCreateResponse createCourse(@RequestBody CourseCreateRequest requestedObj) throws Exception {
        CourseCreateRequest.validCreatesCourseRequestObject(requestedObj);
        return courseServices.saveCourse(requestedObj);

    }
    @GetMapping("getAll")
    public List<Course> getAllCourses() {
        List<Course> courseList=courseServices.getAllCourses();
        return courseList;
       }

    @GetMapping("getById")
    public Course grtCourseById(@RequestParam int id)throws Exception {
        return courseServices.getCourseById(id);
    }

    @PutMapping("update")
    public Course updateCourse(@RequestBody Course updateObjectFromUser) throws Exception {
        return courseServices.updateCourse(updateObjectFromUser);


}
@DeleteMapping("delete/{id}")
    public String deleteCourse(@PathVariable int id) throws Exception {
        courseServices.deleteCourse(id);
        return "Success";

}

}

