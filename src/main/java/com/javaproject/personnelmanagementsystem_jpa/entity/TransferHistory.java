package com.javaproject.personnelmanagementsystem_jpa.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "transferhistory")
public class TransferHistory
{
    @Id
    @Column(name = "journo")
    private Integer JourNo;
    @Column(name = "name")
    private String name;
    @Column(name = "oldinfo")
    private String oldInfo;
    @Column(name = "newinfo")
    private String newInfo;
    @Column(name = "chgtime")
    private String chgTime;
    @Column(name = "regdate")
    private String regDate;
    @Column(name = "fromacc")
    private String fromAcc;
}
