package com.codeline.ccsb.Controller;

import com.codeline.ccsb.Entity.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@CrossOrigin(origins = "*")
@RestController
public class HelloController {

    private List<Course> courseList = new ArrayList<>();
    private int idCounter = 1;


    @PostMapping("Create")
    public String CreateCourse(@RequestBody Course requestedObj) {
        requestedObj.setId(idCounter);
        requestedObj.setIsActive(true);
        requestedObj.setCreateddate(new Date());
        courseList.add(requestedObj);

        return "course created with ID: " + idCounter++;
    }

    @GetMapping("getAll")
    public List<Course> GetAllCourses() {
        List<Course> responseList = new ArrayList<>();
        for (Course course : courseList) {
            if (course.getIsActive()) {
                responseList.add(course);
            }
        }
        return responseList;
    }

    @GetMapping("getById")
    public Course grtCourseById(@RequestParam int id) {
        for (Course course : courseList) {
            if (course.getId() == id && course.getIsActive()) {
                return course;
            }
        }
        return Course.builder().build();
    }

    @PutMapping("Update")
    public String UpdateCourse(@RequestBody Course updateObjectFromUser) {
        if (updateObjectFromUser != null && updateObjectFromUser.getId() != null) {
            Course existingCourseToUpdate = findCourseById(updateObjectFromUser.getId());
            courseList.remove(existingCourseToUpdate);

            existingCourseToUpdate.setName(updateObjectFromUser.getName());
            existingCourseToUpdate.setDuration(updateObjectFromUser.getDuration());
            existingCourseToUpdate.setUpdateddate(updateObjectFromUser.getUpdateddate());
            courseList.add(existingCourseToUpdate);

            return "course updated Successfully";
        }
        return "course not found";

}
@DeleteMapping("Delete/{id}")
    public String DeleteCourse(@PathVariable int id) {
    Course existingCourseToUpdate = findCourseById(id);
    if (existingCourseToUpdate.getId() > 0) {
        courseList.remove(existingCourseToUpdate);

        existingCourseToUpdate.setIsActive(false);
        existingCourseToUpdate.setUpdateddate(new Date());
        courseList.add(existingCourseToUpdate);

        return "course deleted Successfully";
    } else {
        return "invalid course id";
    }
}
    public Course findCourseById(int id) {
        for (Course course : courseList) {
            if (course.getId() == id && course.getIsActive()) {
                return course;
            }

        }

    return Course.builder().id(-1).build();
    }


}

