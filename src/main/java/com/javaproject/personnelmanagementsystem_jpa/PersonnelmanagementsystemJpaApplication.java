package com.javaproject.personnelmanagementsystem_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;

@EntityScan
@SpringBootApplication
public class PersonnelmanagementsystemJpaApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(PersonnelmanagementsystemJpaApplication.class, args);
    }

}
