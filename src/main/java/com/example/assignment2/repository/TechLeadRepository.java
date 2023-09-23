package com.example.assignment2.repository;


import com.example.assignment2.entity.TechLeadEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TechLeadRepository extends CrudRepository<TechLeadEntity>{
    @Modifying
    @Transactional
    @Query("UPDATE techLead p SET p.name = :name, p.contactNo = :contactNo, p.photo = :photo WHERE p.id = :id")
    void updateTechLeadById(@Param("id") Integer id,
                       @Param("name") String name,
                       @Param("contactNo") String contactNo,
                       @Param("photo") byte[] photo);
}
