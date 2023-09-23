package com.example.assignment2.service.custom.impl;

import com.example.assignment2.dto.TechLeadDto;
import com.example.assignment2.entity.TechLeadEntity;
import com.example.assignment2.repository.TechLeadRepository;
import com.example.assignment2.service.custom.TechLeadService;
import com.example.assignment2.util.Convertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TechLeadServiceImpl implements TechLeadService {

    @Autowired
    TechLeadRepository techLeadRepository;

    @Autowired
    Convertor convertor;

    @Override
    public List<TechLeadDto> findAll() {
        List<TechLeadDto> list = new ArrayList<>();
        for (TechLeadEntity techLeadEntity : techLeadRepository.findAll()) {
            list.add(convertor.toTechLeadDto(techLeadEntity));
        }

        return list;
    }

    @Override
    public TechLeadDto getById(Integer id) {
        return convertor.toTechLeadDto(techLeadRepository.getById(id));
    }

    @Override
    public <S extends TechLeadDto> S save(S entity) {
        return (S) convertor.toTechLeadDto(techLeadRepository.save(convertor.toTechLeadEntity(entity)));

    }

    @Override
    public long count() {
        return techLeadRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        techLeadRepository.deleteById(id);
    }

    @Override
    public void updateTechLead(Integer id, String name, String contactNo, byte[] photo) {
        techLeadRepository.updateTechLeadById(id,name,contactNo,photo);
    }
}
