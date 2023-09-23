package com.example.assignment2.repository;

import com.example.assignment2.entity.ProjectEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProjectRepository extends org.springframework.data.jpa.repository.JpaRepository<ProjectEntity, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE project p SET p.title = :title, p.description = :description WHERE p.code = :code")
    void updateProjectById(@Param("code") Integer code,
                       @Param("title") String title,
                       @Param("description") String description);
    List<ProjectEntity> findAll();

    ProjectEntity getById(Integer integer);

    ProjectEntity save(ProjectEntity entity);

    long count();

    void deleteById(Integer code);
}
