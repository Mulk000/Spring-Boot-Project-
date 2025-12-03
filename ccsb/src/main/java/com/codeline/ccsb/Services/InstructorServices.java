package com.codeline.ccsb.Services;

import com.codeline.ccsb.Entity.Instructor;
import com.codeline.ccsb.repositories.InstructorRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InstructorServices {

    @Autowired
    InstructorRepository instructorRepository;

    public List<Instructor> getAllInstructors(){
        return instructorRepository.findAll();
    }

    public Instructor saveInstructor(Instructor instructor){
        instructor.setCreatedDate(new Date());
        instructor.setIsActive(Boolean.TRUE);
       return instructorRepository.save(instructor);
    }

    public Instructor updateInstructor(Instructor instructor)throws Exception {
        Instructor existingInstructor = instructorRepository.findById(instructor.getId()).get();
        if (existingInstructor != null && existingInstructor.getIsActive()) {
            existingInstructor.setUpdatedDate(new Date());
            return instructorRepository.save(existingInstructor);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }
        public Instructor deleteInstructor(Integer id)throws Exception {
        Instructor existingInstructor = instructorRepository.findById(id).get();
        if (existingInstructor != null&&existingInstructor.getIsActive()) {
            existingInstructor.setIsActive(Boolean.FALSE);
            existingInstructor.setUpdatedDate(new Date());
            return instructorRepository.save(existingInstructor);
        }else {
            throw new Exception("BAD REQUEST");


        }
        }

        public Instructor getInstructorById(Integer id)throws Exception {
        Instructor existingInstructor = instructorRepository.findById(id).get();
        if (existingInstructor != null&& existingInstructor.getIsActive()) {
            return existingInstructor;
        }else{
            throw new Exception("BAD REQUEST");
        }


    }
}
