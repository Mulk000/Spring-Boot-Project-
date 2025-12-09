package com.codeline.ccsb.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class  Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String courseName;
    Integer duration;
    String category;
    Date updateddate;
     Date createddate;
    Boolean isActive;

    @OneToOne(mappedBy = "course",cascade = CascadeType.ALL)
    Instructor instructor;

    @OneToMany(mappedBy ="course", cascade=CascadeType.ALL)
    List<Mark> marks;

    @ManyToOne
    Department department;
}
