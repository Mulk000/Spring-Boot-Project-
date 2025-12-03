package com.codeline.ccsb.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    Date updatedDate;
    Date createdDate;
    String instructorName;
    Boolean isActive;

@OneToOne
    @JoinColumn(name="course")
    Course course;

@ManyToOne(cascade = CascadeType.ALL)
  Department department;

}
