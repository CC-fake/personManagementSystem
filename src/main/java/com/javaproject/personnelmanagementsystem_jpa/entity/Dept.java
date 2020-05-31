package com.javaproject.personnelmanagementsystem_jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Dept
{
    @Id
    private Integer deptID;
    private String b_Dept;
    private String s_Dept;
}
