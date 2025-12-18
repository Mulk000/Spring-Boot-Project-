package com.codeline.ccsb.repositories;

import com.codeline.ccsb.Entity.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository<Mark,Integer> {

    @Query("SELECT m FROM Mark m WHERE m.isActive=true AND m.id IN (:id) ")
    List<Mark> getMarkByMarkId(List<Integer> id);

}
