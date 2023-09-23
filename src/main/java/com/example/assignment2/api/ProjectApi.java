package com.example.assignment2.api;


import com.example.assignment2.dto.ProjectDto;
import com.example.assignment2.service.custom.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/project")
public class ProjectApi {

    @Autowired
    ProjectService projectService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ProjectDto saveProject(@RequestPart String title, @RequestPart String description) {

        ProjectDto projectDto = new ProjectDto();
        projectDto.setTitle(title);
        projectDto.setDescription(description);
        projectDto.setCode(1234);

        return projectService.save(projectDto);

    }

    @DeleteMapping("{code}")
    void deleteProject(@PathVariable Integer code) {
        projectService.deleteById(code);
    }

    @PutMapping("{code}")
    void updateProject(@PathVariable Integer code, @RequestBody ProjectDto projectDto) {
        projectService.updateProject(code, projectDto.getTitle(), projectDto.getDescription());
    }

    @GetMapping(value = "{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    ProjectDto getSelectedProject(@PathVariable Integer code) {
        return projectService.getById(code);
    }
}
