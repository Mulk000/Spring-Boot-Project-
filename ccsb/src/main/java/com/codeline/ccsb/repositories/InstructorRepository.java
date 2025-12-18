package com.codeline.ccsb.repositories;

import com.codeline.ccsb.Entity.Instructor;
import com.codeline.ccsb.Entity.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Integer> {

       @Query("SELECT i FROM Instructor i WHERE i.id=:id AND i.isActive=true")
    Instructor getInstructorById(Integer id);

    @Query("SELECT i FROM Instructor i WHERE i.isActive=true AND i.id IN (:id) ")
    List<Instructor> getInstructorById(List<Integer> id);

       @Query("SELECT COUNT (i) FROM Instructor i WHERE i.isActive=true")
    Integer getCountOfAllInstructors();
}
