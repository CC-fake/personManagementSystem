package com.javaproject.personnelmanagementsystem_jpa.repository;

import com.javaproject.personnelmanagementsystem_jpa.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptResponsitory extends JpaRepository<Dept,Integer>
{
    @Query("select max(d.deptID) from Dept d")
    long findMax();
}
