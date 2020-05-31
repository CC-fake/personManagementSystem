package com.javaproject.personnelmanagementsystem_jpa.repository;

import com.javaproject.personnelmanagementsystem_jpa.entity.PersonQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonQueryResponsity extends JpaRepository<PersonQuery,Integer>
{
}
