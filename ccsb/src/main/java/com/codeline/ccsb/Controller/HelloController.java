package com.codeline.ccsb.Controller;

import com.codeline.ccsb.Entity.Course;
import com.codeline.ccsb.Services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@CrossOrigin(origins = "*")
@RestController
public class HelloController {

    @Autowired
    CourseServices courseServices;


    @PostMapping("create")
    public Course createCourse(@RequestBody Course requestedObj) {
        Course course =courseServices.saveCourse(requestedObj);
        return course;
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

