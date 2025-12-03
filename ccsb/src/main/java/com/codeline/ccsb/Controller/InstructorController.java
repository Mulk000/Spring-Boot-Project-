package com.codeline.ccsb.Controller;

import com.codeline.ccsb.Entity.Instructor;
import com.codeline.ccsb.Services.InstructorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/instructor")
public class InstructorController {

    @Autowired
    InstructorServices instructorServices;

    @PostMapping("/create")
    public Instructor createInstructor(@RequestBody Instructor requestedObj){
        Instructor instructor = instructorServices.saveInstructor(requestedObj);
        return instructor;

    }
    @GetMapping("/getAll")
    public List<Instructor> getAllInstructors(){
        List<Instructor> instructorList=instructorServices.getAllInstructors();
        return instructorList;
    }
    @GetMapping("/getById")
    public Instructor getInstructorById(@RequestParam int id) throws Exception {
        return instructorServices.getInstructorById(id);
    }

    @PutMapping("/update")
    public Instructor updateInstructor(@RequestBody Instructor updatedObjFromUser) throws Exception {
        return instructorServices.updateInstructor(updatedObjFromUser);

    }
@DeleteMapping("/delete/{id}")
    public String deleteInstructorById(@PathVariable int id) throws Exception {
        instructorServices.deleteInstructor(id);
                return "Successfully deleted instructor";
}

}
