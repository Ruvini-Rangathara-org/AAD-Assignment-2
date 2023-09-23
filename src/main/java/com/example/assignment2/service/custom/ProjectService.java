package com.example.assignment2.service.custom;
import com.example.assignment2.dto.ProjectDto;
import com.example.assignment2.service.SuperService;

public interface ProjectService extends SuperService<ProjectDto> {
    void updateProject(Integer code, String title, String description);
}
