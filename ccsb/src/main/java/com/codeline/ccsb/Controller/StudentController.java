package com.codeline.ccsb.Controller;

import com.codeline.ccsb.Entity.Student;
import com.codeline.ccsb.Services.StudentServices;
import com.codeline.ccsb.requestObject.CourseCreateRequest;
import com.codeline.ccsb.requestObject.StudentCreateRequest;
import com.codeline.ccsb.responseObjects.CourseCreateResponse;
import com.codeline.ccsb.responseObjects.StudentCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentServices studentServices;

    @PostMapping("create")
    public StudentCreateResponse createStudent(@RequestBody StudentCreateRequest requestedObj) throws Exception {
        StudentCreateRequest.validCreateStudentRequestObject(requestedObj);
        return studentServices.saveStudent(requestedObj);

    }

    @GetMapping("getAll")
    public List<Student> getAllStudents(){
         List<Student> studentList=studentServices.getAllStudents();
                 return studentList;
    }
    @GetMapping("getById")
    public Student getStudentById(@RequestParam int id) throws Exception {
        return studentServices.getStudentById(id);

    }
    @PutMapping("update")
    public Student updateStudent(@RequestBody Student updateObjectFromUser) throws Exception {
        return studentServices.updateStudent(updateObjectFromUser);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable int id) throws Exception {
        studentServices.deleteStudent(id);
                return "Success";
    }
}
