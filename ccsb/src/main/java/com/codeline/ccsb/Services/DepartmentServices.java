package com.codeline.ccsb.Services;

import com.codeline.ccsb.Entity.Department;
import com.codeline.ccsb.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DepartmentServices {

    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department saveDepartment(Department department) {
        department.setCreateDate(new Date());
        department.setIsActive(Boolean.TRUE);
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Integer id) throws Exception {
        Department existingDepartment = departmentRepository.findById(id).get();
        if (existingDepartment != null && existingDepartment.getIsActive()) {
            return existingDepartment;
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public Department updateDepartment(Department department)throws Exception {
        Department existingDepartment = departmentRepository.findById(department.getId()).get();
        if (existingDepartment != null && existingDepartment.getIsActive()) {
            existingDepartment.setUpdateDate(new Date());
            return departmentRepository.save(existingDepartment);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }
     public Department deleteDepartment(Integer id)throws Exception {
        Department existingDepartment = departmentRepository.findById(id).get();
        if (existingDepartment != null && existingDepartment.getIsActive()) {
            existingDepartment.setIsActive(false);
            existingDepartment.setUpdateDate(new Date());
            return departmentRepository.save(existingDepartment);
        }else{
            throw new Exception("BAD REQUEST");

        }
    }
}
