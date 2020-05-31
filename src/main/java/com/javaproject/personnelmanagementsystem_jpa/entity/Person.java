package com.javaproject.personnelmanagementsystem_jpa.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Person
{
    @Id
    private Integer personID;
    private String name;
    private String sex;
    private String birth;
    private String nat;
    private String address;
    private Integer deptID;
    private String salary;
    private String assess;
    private String other;
}
