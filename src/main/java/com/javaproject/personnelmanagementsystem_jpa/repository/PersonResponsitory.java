package com.javaproject.personnelmanagementsystem_jpa.repository;

import com.javaproject.personnelmanagementsystem_jpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


@Repository
public interface PersonResponsitory extends JpaRepository<Person,Integer>
{
    @Query("select max(p.personID) from Person p")
    long findMax();

}
