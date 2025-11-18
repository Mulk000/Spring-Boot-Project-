package com.codeline.ccsb.Entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
public class Course {
    Integer id;
    String name;
    Integer duration;
    String category;
    Date updateddate;
     Date createddate;
    Boolean isActive;
}
