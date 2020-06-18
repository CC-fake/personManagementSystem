package com.javaproject.personnelmanagementsystem_jpa.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "persontransfer")
public class PersonTransfer
{
    @Id
    @Column(name = "PersonID")
    private Integer personID;
    @Column(name = "Name")
    private String name;
    @Column(name = "Sex")
    private String sex;
    @Column(name = "DeptID")
    private Integer deptID;
    @Column(name = "B_Dept")
    private String b_Dept;
    @Column(name = "S_Dept")
    private String s_Dept;
    @Column(name = "Salary")
    private String salary;
    @Column(name = "Assess")
    private String assess;
    @Column(name = "Birth")
    private String birth;
    @Column(name = "Nat")
    private String nat;
    @Column(name = "Address")
    private String address;
    @Column(name = "Other")
    private String other;
}
