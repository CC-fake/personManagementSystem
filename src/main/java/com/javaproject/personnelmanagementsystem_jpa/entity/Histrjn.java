package com.javaproject.personnelmanagementsystem_jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Histrjn
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "journo")
    private Integer jourNo;
    @Column(name = "fromacc")
    private String fromAcc;
    @Column(name = "oldinfo")
    private String oldInfo;
    @Column(name = "newinfo")
    private String newInfo;
    @Column(name = "chgtime")
    private String chgTime;
    @Column(name = "regdate")
    private String regDate;
    @Column(name = "personid")
    private String personID;
}
