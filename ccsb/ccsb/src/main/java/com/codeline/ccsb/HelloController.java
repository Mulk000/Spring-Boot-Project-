package com.codeline.ccsb;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.DataLine;
import javax.sound.sampled.Line;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class HelloController {

    private Map<Integer, String> Courses = new HashMap<>();
    private int idCounter = 1;


@PostMapping("Create")
    public String CreateCourse(@RequestParam String name) {
    Courses.put(idCounter, name);
    return "Course Created with ID: " + idCounter++;

}
@GetMapping("getAll")
    public Map<Integer, String> GetAllCourses() {
    return Courses;

}
@GetMapping("getById")
     public String grtCourseById(@RequestParam int id) {
    return Courses.getOrDefault(id, "Course Not Found");
}
@PutMapping("Update")
    public String UpdateCourse(@RequestParam int id, @RequestParam String name) {
    if (Courses.containsKey(id)){
        Courses.put(id, name);
        return "Course Updated successfully";
    }
    return "Course not found";
}
@DeleteMapping("DeleteCourse/{id}")
    public String DeleteCourse(@PathVariable int id) {
    if (Courses.remove(id)!=null){
        return "Course Deleted successfully";
    }
        return "Course not found";
    }
}

