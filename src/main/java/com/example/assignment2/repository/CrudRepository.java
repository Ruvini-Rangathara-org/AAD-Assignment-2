package com.example.assignment2.repository;

import com.example.assignment2.entity.SuperEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrudRepository<T extends SuperEntity> extends JpaRepository<T , Integer> {
    @Override
    List<T> findAll();

    @Override
    T getById(Integer integer);

    @Override
    <S extends T> S save(S entity);

    @Override
    long count();

    @Override
    void deleteById(Integer code);


}
