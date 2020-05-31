package com.javaproject.personnelmanagementsystem_jpa.repository;

import com.javaproject.personnelmanagementsystem_jpa.entity.TransferHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransferHistoryResponsitory extends JpaRepository<TransferHistory,Integer>
{
    @Query(value = "select MAX(chgTime) " +
            "FROM TransferHistory " +
            "WHERE name = :name and fromAcc = :fromAcc",nativeQuery = true)
    List<Integer> findFrequency(@Param("name") String name, @Param("fromAcc") String fromAcc);

    @Query(value = "select * from TransferHistory where fromAcc = :fromAcc",nativeQuery = true)
    Page<TransferHistory> findAllByFromAcc(@Param("fromAcc") String fromAcc,Pageable pageable);
}
