package com.example.assignment2.service.custom.impl;

import com.example.assignment2.dto.ProjectDto;
import com.example.assignment2.entity.ProjectEntity;
import com.example.assignment2.repository.ProjectRepository;
import com.example.assignment2.service.custom.ProjectService;
import com.example.assignment2.util.Convertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    Convertor convertor;

    @Override
    public List<ProjectDto> findAll() {
        List<ProjectDto> list = new ArrayList<>();

        for (ProjectEntity projectEntity : projectRepository.findAll()) {
            list.add(convertor.toProjectDto(projectEntity));
        }
        return list;
    }

    @Override
    public ProjectDto getById(Integer code) {
        return convertor.toProjectDto(projectRepository.getById(code));
    }

    @Override
    public <S extends ProjectDto> S save(S entity) {
        return (S) convertor.toProjectDto(projectRepository.save(convertor.toProjectEntity(entity)));
    }

    @Override
    public long count() {
        return projectRepository.count();
    }

    @Override
    public void deleteById(Integer code) {
        projectRepository.deleteById(code);
    }

    @Override
    public void updateProject(Integer code, String title, String description) {
        projectRepository.updateProjectById(code,title,description);
    }
}
