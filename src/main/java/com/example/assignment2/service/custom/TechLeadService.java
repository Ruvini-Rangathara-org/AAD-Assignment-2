package com.example.assignment2.service.custom;

import com.example.assignment2.dto.TechLeadDto;
import com.example.assignment2.service.SuperService;

public interface TechLeadService extends SuperService<TechLeadDto> {
    void updateTechLead(Integer id, String name, String contactNo, byte[] photo);
}
