package com.codeline.ccsb.repositories;

import com.codeline.ccsb.Entity.Course;
import com.codeline.ccsb.Entity.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber,Integer> {
    @Query("SELECT p FROM PhoneNumber p WHERE p.isActive AND p.id IN (:id)")
    List<PhoneNumber> getPhoneNumberById(List<Integer> id);




}
