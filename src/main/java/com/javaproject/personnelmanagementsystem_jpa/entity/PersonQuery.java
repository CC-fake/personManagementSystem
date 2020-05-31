package com.javaproject.personnelmanagementsystem_jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "personquery")
public class PersonQuery
{
    @Id
    private Integer personID;
    private String name;
    private String birth;
    private String nat;
    private String address;
    private String b_Dept;
    private String s_Dept;
}
