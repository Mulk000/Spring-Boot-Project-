package com.codeline.ccsb.Controller;

import com.codeline.ccsb.Entity.Department;
import com.codeline.ccsb.Services.DepartmentServices;
import com.codeline.ccsb.requestObject.CourseCreateRequest;
import com.codeline.ccsb.requestObject.DepartmentCreateRequest;
import com.codeline.ccsb.responseObjects.DepartmentCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentServices departementServices;

    @PostMapping("/create")
    public DepartmentCreateResponse createDepartment(@RequestBody DepartmentCreateRequest requestedObj)throws Exception{
        DepartmentCreateRequest.validateDepartmentCreateRequest(requestedObj);
        return departementServices.saveDepartment(requestedObj);

    }

    @GetMapping("/getAll")
    public List<Department> getAllDepartments(){
        List<Department> departmentList=departementServices.getAllDepartments();
                return departmentList;
    }
    @GetMapping("/getDepartmentById")
    public Department getDepartmentById(@RequestParam Integer id)throws Exception {
        return departementServices.getDepartmentById(id);
    }
    @PutMapping("/update")
    public Department updateDepartment(@RequestBody Department updatedObjFromUser)throws Exception {
        return departementServices.updateDepartment(updatedObjFromUser);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable Integer id)throws Exception {
           departementServices.deleteDepartment(id);
           return "Department deleted successfully";
    }



}
