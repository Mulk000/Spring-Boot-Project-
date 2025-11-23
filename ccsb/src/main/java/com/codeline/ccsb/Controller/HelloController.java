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


    @PostMapping("Create")
    public Course CreateCourse(@RequestBody Course requestedObj) {
        Course course =courseServices.saveCourse(requestedObj);
        return course;
    }
    @GetMapping("getAll")
    public List<Course> GetAllCourses() {
        List<Course> courseList=courseServices.GetAllCourses();
        return courseList;
       }

    @GetMapping("getById")
    public Course grtCourseById(@RequestParam int id)throws Exception {
        return courseServices.getCourseById(id);
    }

    @PutMapping("Update")
    public Course UpdateCourse(@RequestBody Course updateObjectFromUser) throws Exception {
        return courseServices.updateCourse(updateObjectFromUser);


}
@DeleteMapping("Delete/{id}")
    public String DeleteCourse(@PathVariable int id) throws Exception {
        courseServices.deleteCourse(id);
        return "Success";

}

}

