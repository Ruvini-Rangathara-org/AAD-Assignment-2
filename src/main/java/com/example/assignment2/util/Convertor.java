package com.example.assignment2.util;

import com.example.assignment2.dto.ProjectDto;
import com.example.assignment2.dto.TechLeadDto;
import com.example.assignment2.entity.ProjectEntity;
import com.example.assignment2.entity.TechLeadEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Convertor {

    private final ModelMapper modelMapper;
    Convertor(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public ProjectDto toProjectDto(ProjectEntity projectEntity){
        return modelMapper.map(projectEntity, ProjectDto.class);
    }
    public ProjectEntity toProjectEntity(ProjectDto projectDto){
        return modelMapper.map(projectDto,ProjectEntity.class);
    }
    public TechLeadDto toTechLeadDto(TechLeadEntity techLeadEntity){
        return modelMapper.map(techLeadEntity, TechLeadDto.class);
    }
    public TechLeadEntity toTechLeadEntity(TechLeadDto techLeadDto){
        return modelMapper.map(techLeadDto,TechLeadEntity.class);
    }

}
