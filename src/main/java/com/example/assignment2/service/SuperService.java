package com.example.assignment2.service;

import com.example.assignment2.dto.SuperDto;

import java.util.List;

public interface SuperService<T extends SuperDto> {
    List<T> findAll();

    T getById(Integer code);

    <S extends T> S save(S entity);

    long count();

    void deleteById(Integer integer);
}
