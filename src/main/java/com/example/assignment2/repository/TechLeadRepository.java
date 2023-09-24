package com.example.assignment2.repository;


import com.example.assignment2.entity.ProjectEntity;
import com.example.assignment2.entity.TechLeadEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TechLeadRepository extends org.springframework.data.jpa.repository.JpaRepository<TechLeadEntity, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE techLead p SET p.name = :name, p.contactNo = :contactNo, p.photo = :photo WHERE p.id = :id")
    void updateTechLeadById(@Param("id") Integer id,
                            @Param("name") String name,
                            @Param("contactNo") String contactNo,
                            @Param("photo") byte[] photo);

    List<TechLeadEntity> findAll();

    TechLeadEntity getById(Integer integer);

    TechLeadEntity save(TechLeadEntity entity);

    long count();

    void deleteById(Integer code);
}
